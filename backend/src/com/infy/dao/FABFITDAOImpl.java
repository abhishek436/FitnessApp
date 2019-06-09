package com.infy.dao;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.infy.entity.AdminEntity;
import com.infy.entity.Bmientity;
import com.infy.entity.DietEntity;
import com.infy.entity.Fabfitentity;
import com.infy.entity.FitnessEntity;
import com.infy.entity.RequestsEntity;
import com.infy.entity.TrainerEntity;
import com.infy.model.Admin;
import com.infy.model.Bmi;
import com.infy.model.Diet;
import com.infy.model.Fabfit;
import com.infy.model.Fitness;
import com.infy.model.Requests;
import com.infy.model.Trainer;


@Repository("dao")
public class FABFITDAOImpl implements FABFITDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
		public Fabfit updatedetails(Fabfit fab) {
			Session session = sessionFactory.getCurrentSession();
			Fabfitentity fabentity = new Fabfitentity();
			
			if(fab != null) {
				fabentity.setEmail(fab.getEmail());
				fabentity.setGender(fab.getGender());
				fabentity.setName(fab.getName());
				fabentity.setPassword(fab.getPassword());
				fabentity.setHeight(fab.getHeight());
				fabentity.setWeight(fab.getWeight());
				fabentity.setContact(fab.getContact());
				fabentity.setSuggestions(fab.getSuggestions());
				session.persist(fabentity);
			}
			return fab;
		}
		public String hashcode(String password) {
			int code;
		    String result = "";
		    for (int i = 0; i < password.length(); i++) {
		      code = Math.round((float) Math.random()*8+1);
		      result += code + Integer.toHexString( ((int) password.charAt(i) ) ^ code )+"-";
		    }
		    return result.substring(0, result.lastIndexOf("-"));
		}

		public Fabfit verifydetails(Fabfit fab) throws Exception {
			Session session = sessionFactory.getCurrentSession();
			Fabfitentity fabfitentity =session.get(Fabfitentity.class, fab.getEmail());
			String aa = fabfitentity.getPassword();
			if(fabfitentity != null && fab.getEmail().equals(fabfitentity.getEmail()) && aa.equals(fab.getPassword())){
				fab.setEmail(fabfitentity.getEmail());
				fab.setPassword(fabfitentity.getPassword());
				fab.setName(fabfitentity.getName());
				fab.setHeight(fabfitentity.getHeight());
				fab.setWeight(fabfitentity.getWeight());
				fab.setMessage("Login Successfull");
				
			}
			return fab;
		}
		 public String hashset1(String password) {
			 password = password.replace("-", "");
			    String result = "";
			    for (int i = 0; i < password.length(); i+=3) {
			      String hex =  password.substring(i+1, i+3);
			      result += (char) (Integer.parseInt(hex, 16) ^ (Integer.parseInt(String.valueOf(password.charAt(i)))));
			    }
			    return result;
		 }

		@Override
		public Bmi addetails(Bmi bmi) throws Exception {
			Session session = sessionFactory.getCurrentSession();
			Bmientity bmientity = new Bmientity();
			if(bmi != null) {
				bmientity.setBmid(bmi.getBmid());
				bmientity.setHeight(bmi.getHeight());
				bmientity.setWeight(bmi.getWeight());
				bmientity.setDob(bmi.getDob());
				session.persist(bmientity);
			}
			return bmi;
		}
		@Override
		public Fabfit updateprofile(Fabfit fab) throws Exception {
			Session session = sessionFactory.getCurrentSession();
			Fabfitentity fabfitentity = session.get(Fabfitentity.class, fab.getEmail());
			if (fabfitentity != null) {
				fabfitentity.setEmail(fab.getEmail());
				fabfitentity.setName(fab.getName());
				fabfitentity.setPassword(fab.getPassword());
				fabfitentity.setHeight(fab.getHeight());
				fabfitentity.setWeight(fab.getWeight());
				fabfitentity.setContact(fab.getContact());
				fabfitentity.setSuggestions(fab.getSuggestions());
				session.persist(fabfitentity);
				
				}
			return fab;
		}
		@Override
		public Trainer addtrainer(Trainer fab) throws Exception {
			
			Session session = sessionFactory.getCurrentSession();
			TrainerEntity trainentity = new TrainerEntity();
			
			if(fab != null) {
				trainentity.setTemail(fab.getEmail());
				trainentity.setGender(fab.getGender());
				trainentity.setName(fab.getName());
				trainentity.setSpecialization(fab.getSpecialization());
				trainentity.setContact(fab.getContact());
				trainentity.setPassword(fab.getPassword());
				session.persist(trainentity);
			}
			return fab;
	
		}
		@Override
		public Trainer Trainerlogin(Trainer trainer) throws Exception {
			Session session = sessionFactory.getCurrentSession();
			TrainerEntity trainerentity =session.get(TrainerEntity.class, trainer.getEmail());
			if(trainerentity != null && trainer.getEmail().equals(trainerentity.getTemail()) && trainerentity.getPassword().equals(trainer.getPassword())){
				trainer.setEmail(trainerentity.getTemail());
				trainer.setPassword(trainerentity.getPassword());
				trainer.setMessage("Login Successfull");
			}
			return trainer;
		}
		public Admin adminLogin(Admin admin) throws Exception {
			
			Session session = sessionFactory.getCurrentSession();
			AdminEntity adminEntity = (AdminEntity) session.get(AdminEntity.class, admin.getAdminId());
			
			if(adminEntity!=null && adminEntity.getPassword().equals(admin.getPassword())){
				return admin;	
			}
			return null;
		}
		@Override
		public List<Trainer> getTrainer() throws Exception {
			Session session = sessionFactory.getCurrentSession();
			List<Trainer> alltrainer = new ArrayList<Trainer>();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<TrainerEntity> criteriaQuery= builder.createQuery(TrainerEntity.class);
			Root<TrainerEntity> root = criteriaQuery.from(TrainerEntity.class);
			criteriaQuery.select(root);
			List<TrainerEntity> customerEntities = session.createQuery(criteriaQuery).list();
	        for(TrainerEntity t : customerEntities) {
	        	Trainer tr = new Trainer();
	        	tr.setName(t.getName());
	        	tr.setEmail(t.getTemail());
	        	tr.setGender(t.getGender());
	        	tr.setSpecialization(t.getSpecialization());
	        	tr.setContact(t.getContact());
	        	alltrainer.add(tr);
	        }
	        return alltrainer;
		}
		@Override
		public List<Diet> getdiet(Diet diet) throws Exception {
			Session session = sessionFactory.getCurrentSession();
			List<Diet> alldiet = null;
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<DietEntity> criteriaQuery= builder.createQuery(DietEntity.class);
			Root<DietEntity> root = criteriaQuery.from(DietEntity.class);
			criteriaQuery.select(root);
			criteriaQuery.where(builder.and(builder.equal(root.get("gender"),diet.getGender())
					,builder.equal(root.get("goals"),diet.getGoals()),builder.equal(root.get("level1"),diet.getLevel1())));
			List<DietEntity> dietentity = session.createQuery(criteriaQuery).getResultList();
			alldiet = new ArrayList<Diet>();
	        for(DietEntity t : dietentity) {
	        	Diet tr = new Diet();
	        	tr.setDietid(t.getDietid());
	        	tr.setCalories(t.getCalories());
	        	tr.setFruits(t.getFruits());
	        	tr.setVegetables(t.getVegetables());
	        	tr.setGrains(t.getGrains());
	        	tr.setProtein(t.getProtein());
	        	tr.setDairy(t.getDairy());
	        	tr.setBreakfast(t.getBreakfast());
	        	tr.setMidMsnack(t.getMidMsnack());
	        	tr.setLunch(t.getLunch());
	        	tr.setMidEsnack(t.getMidEsnack());
	        	tr.setDinner(t.getDinner());
	        	alldiet.add(tr);
	        }
	        return alldiet;
			
		}
		@Override
		public List<Diet> updatediet(Diet diet) throws Exception {
			Session session = sessionFactory.getCurrentSession();
			List<Diet> alldiet = null;
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<DietEntity> criteriaQuery= builder.createQuery(DietEntity.class);
			Root<DietEntity> root = criteriaQuery.from(DietEntity.class);
			criteriaQuery.select(root);
			criteriaQuery.where(builder.and(builder.equal(root.get("gender"),diet.getGender())
					,builder.equal(root.get("goals"),diet.getGoals()),builder.equal(root.get("level1"),diet.getLevel1())));
			List<DietEntity> dietentity = session.createQuery(criteriaQuery).getResultList();
			alldiet = new ArrayList<Diet>();
			for(DietEntity t : dietentity) {
				
				t.setCalories(diet.getCalories());
	        	if(diet.getUpdateColumns().equals("Fruits")){
	        		t.setFruits(diet.getUpdateValue());
	        	}
	        	if(diet.getUpdateColumns().equals("Vegetables")){
	        		t.setVegetables(diet.getUpdateValue());
	        	}
	        	if(diet.getUpdateColumns().equals("Grains")){
	        		t.setGrains(diet.getUpdateValue());
	        	}
	        	if(diet.getUpdateColumns().equals("Proteins")){
	        		t.setProtein(diet.getUpdateValue());
	        	}
	        	if(diet.getUpdateColumns().equals("Dairy")){
	        		t.setDairy(diet.getUpdateValue());
	        	}
	        	if(diet.getUpdateColumns().equals("Breakfast")){
	        		t.setBreakfast(diet.getUpdateValue());
	        	}
	        	if(diet.getUpdateColumns().equals("Mid Morning Snack")){
	        		t.setMidMsnack(diet.getUpdateValue());
	        	}
	        	if(diet.getUpdateColumns().equals("Lunch")){
	        		t.setLunch(diet.getUpdateValue());
	        	}
	        	if(diet.getUpdateColumns().equals("Mid Evening Snack")){
	        		t.setMidEsnack(diet.getUpdateValue());
	        	}
	        	if(diet.getUpdateColumns().equals("Dinner")){
	        		t.setDinner(diet.getUpdateValue());
	        	}
	        	
	        	session.persist(t);
	        }
			return alldiet;
		}
		@Override
		public Fabfit getdetails(String email) throws Exception {
			Session session = sessionFactory.getCurrentSession();
			Fabfit fab =new Fabfit();
			Fabfitentity fabfitentity =session.get(Fabfitentity.class, email);
			fab.setEmail(fabfitentity.getEmail());
			fab.setHeight(fabfitentity.getHeight());
			fab.setName(fabfitentity.getName());
			fab.setContact(fabfitentity.getContact());
			fab.setWeight(fabfitentity.getWeight());
			fab.setTemail(fabfitentity.getTrainerid());
			fab.setPassword(fabfitentity.getPassword());
			return fab;
			}
		@Override
		public Fabfit booktrainer(String temail,String email) throws Exception {
			Session session = sessionFactory.getCurrentSession();
			Fabfitentity fabfitentity =session.get(Fabfitentity.class,email);
			fabfitentity.setTrainerid(temail);
			session.persist(fabfitentity);
			List<Fabfitentity> flist=new ArrayList<>();
			flist.add(fabfitentity);
			TrainerEntity te=session.get(TrainerEntity.class,temail);
			if(te.getFabfitusers()!=null){
				List<Fabfitentity> flist1=te.getFabfitusers();
				flist1.add(fabfitentity);
				te.setFabfitusers(flist1);
				
			}
			else{
			te.setFabfitusers(flist);}
			session.persist(te);
			Fabfit fab=new Fabfit();
			fab.setMessage("success");
			return fab;
			}
		
		public Trainer getinfo(String temail) throws Exception {
			Session session = sessionFactory.getCurrentSession();
			TrainerEntity te=session.get(TrainerEntity.class,temail);
			List<Fabfit> flist1=new ArrayList<>();
			Trainer t=new Trainer();
			if(te!=null){

				t.setName(te.getName());
				t.setEmail(te.getTemail());
				if(te.getFabfitusers()!=null){
					for(Fabfitentity t1:te.getFabfitusers()){
						Fabfit f=new Fabfit();
						f.setName(t1.getName());
						f.setEmail(t1.getEmail());
						f.setContact(t1.getContact());
						f.setHeight(t1.getHeight());
						f.setWeight(t1.getWeight());
						f.setTemail(t1.getTrainerid());
						f.setSuggestions(t1.getSuggestions());
						
						flist1.add(f);

						System.out.println(flist1);
					}
					t.setFabfitusers1(flist1);
					System.out.println(t);
					
				}
				
			}
			return t;
		}
		@Override
		public Fabfit setsuggestion(Fabfit fabfit) throws Exception {
			Session session = sessionFactory.getCurrentSession();
			Fabfitentity te=session.get(Fabfitentity.class,fabfit.getEmail());
			if(te != null) {
				te.setSuggestions(fabfit.getSuggestions());
				session.persist(te);
				return fabfit;
		}
			return null;
  }
		
		
		@Override
		public List<Fitness> getFit(Fitness fitness) throws Exception {
			Session session = sessionFactory.getCurrentSession();
			List<Fitness> allfitness = null;
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<FitnessEntity> criteriaQuery= builder.createQuery(FitnessEntity.class);
			Root<FitnessEntity> root = criteriaQuery.from(FitnessEntity.class);
			criteriaQuery.select(root);
			criteriaQuery.where(builder.and(builder.equal(root.get("gender"),fitness.getGender())
					,builder.equal(root.get("goals"),fitness.getGoals()),builder.equal(root.get("level1"),fitness.getLevel1())));
			List<FitnessEntity> fitnessEntity = session.createQuery(criteriaQuery).getResultList();
			allfitness = new ArrayList<Fitness>();
	        for(FitnessEntity t : fitnessEntity) {
	        	Fitness tr = new Fitness();
	        	tr.setFitnessid(t.getFitnessid());
	        	tr.setDay1(t.getDay1());
	        	tr.setDay2(t.getDay2());
	        	tr.setDay3(t.getDay3());
	        	tr.setDay4(t.getDay4());
	        	tr.setDay5(t.getDay5());
	        	tr.setDay6(t.getDay6());
	        	tr.setDay7(t.getDay7());

	        	allfitness.add(tr);
	        }
	        return allfitness;
			
		}
		@Override
		public List<Fitness> updateFitness(Fitness fitness) throws Exception {
			Session session = sessionFactory.getCurrentSession();
			List<Fitness> allfitness = null;
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<FitnessEntity> criteriaQuery= builder.createQuery(FitnessEntity.class);
			Root<FitnessEntity> root = criteriaQuery.from(FitnessEntity.class);
			criteriaQuery.select(root);
			criteriaQuery.where(builder.and(builder.equal(root.get("gender"),fitness.getGender())
					,builder.equal(root.get("goals"),fitness.getGoals()),builder.equal(root.get("level1"),fitness.getLevel1())));
			List<FitnessEntity> fitnessEntity = session.createQuery(criteriaQuery).getResultList();
			allfitness = new ArrayList<Fitness>();
			for(FitnessEntity t : fitnessEntity) {
				
	        	if(fitness.getUpdateColumns().equals("Day 1")){
	        		t.setDay1(fitness.getUpdateValue());
	        	}
	        	if(fitness.getUpdateColumns().equals("Day 2")){
	        		t.setDay2(fitness.getUpdateValue());
	        	}
	        	if(fitness.getUpdateColumns().equals("Day 3")){
	        		t.setDay3(fitness.getUpdateValue());
	        	}
	        	if(fitness.getUpdateColumns().equals("Day 4")){
	        		t.setDay4(fitness.getUpdateValue());
	        	}
	        	if(fitness.getUpdateColumns().equals("Day 5")){
	        		t.setDay5(fitness.getUpdateValue());
	        	}
	        	if(fitness.getUpdateColumns().equals("Day 6")){
	        		t.setDay6(fitness.getUpdateValue());
	        	}
	        	if(fitness.getUpdateColumns().equals("Day 7")){
	        		t.setDay7(fitness.getUpdateValue());
	        	}
	        	
	        	
	        	session.persist(t);
	        }
			return allfitness;
		}
		@Override
		public void deletetrainer(String email) throws Exception {
			Session session = sessionFactory.getCurrentSession();
			List<Fabfitentity>list1= new ArrayList<Fabfitentity>();
			TrainerEntity trainerentity = session.get(TrainerEntity.class,email);
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Fabfitentity> criteriaQuery= builder.createQuery(Fabfitentity.class);
			Root<Fabfitentity> root = criteriaQuery.from(Fabfitentity.class);
			criteriaQuery.select(root);
			criteriaQuery.where(builder.and(builder.equal(root.get("trainerid"),email)));
			List<Fabfitentity> fabfitentity = session.createQuery(criteriaQuery).getResultList();
			for(Fabfitentity f1:fabfitentity){
				f1.setTrainerid(null);
				f1.setSuggestions(null);
				session.persist(f1);
			}
			for(Fabfitentity f1:trainerentity.getFabfitusers()){
				Fabfitentity s=new Fabfitentity();
				s.setTrainerid(null);
				s.setSuggestions(null);
				list1.add(s);	
			}
			trainerentity.setFabfitusers(list1);
			session.delete(trainerentity);

			
		}
		@Override
		public Diet fetchdiet(Diet diet) throws Exception {
			Session session = sessionFactory.getCurrentSession();
			 CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<DietEntity> criteriaQuery= builder.createQuery(DietEntity.class);
			Root<DietEntity> root = criteriaQuery.from(DietEntity.class);
			criteriaQuery.select(root);
			criteriaQuery.where(builder.and(builder.equal(root.get("gender"),diet.getGender())
					,builder.equal(root.get("goals"),diet.getGoals()),builder.equal(root.get("level1"),diet.getLevel1())));
			List<DietEntity> dietentity = session.createQuery(criteriaQuery).getResultList();
	
	        for(DietEntity t : dietentity) {
	        	Diet d = new Diet();
	        	if(diet.getUpdateColumns().equals("Fruits"))
	        	{
	        		d.setUpdateValue(t.getFruits());
	        		return d;
	        	}
	        	else if(diet.getUpdateColumns().equals("Vegetables")) {
	        		d.setUpdateValue(t.getVegetables());
	        		return d;
	        	}
	        	else if(diet.getUpdateColumns().equals("Grains")) {
	        		d.setUpdateValue(t.getGrains());
	        		return d;
	        	}
	        	else if(diet.getUpdateColumns().equals("Proteins")) {
	        		d.setUpdateValue(t.getProtein());
	        		return d;
	        	}
	        	else if(diet.getUpdateColumns().equals("Dairy")) {
	        		d.setUpdateValue(t.getDairy());
	        		return d;
	        	}
	        	else if(diet.getUpdateColumns().equals("Breakfast")) {
	        		d.setUpdateValue(t.getBreakfast());
	        		return d;
	        	}
	        	else if(diet.getUpdateColumns().equals("Mid Morning Snack")) {
	        		d.setUpdateValue(t.getMidMsnack());
	        		return d;
	        	}
	        	else if(diet.getUpdateColumns().equals("Lunch")) {
	        		d.setUpdateValue(t.getLunch());
	        		return d;
	        	}
	        	else if(diet.getUpdateColumns().equals("Mid Evening Snack")) {
	        		d.setUpdateValue(t.getMidEsnack());
	        		return d;
	        	}
	        	else if(diet.getUpdateColumns().equals("Dinner")) {
	        		d.setUpdateValue(t.getDinner());
	        		return d;
	        	}
	        	
	        }
	        return null;
			
		}
		@Override
		public Fitness fetchFitness(Fitness fitness) throws Exception {
			Session session = sessionFactory.getCurrentSession();
			 CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<FitnessEntity> criteriaQuery= builder.createQuery(FitnessEntity.class);
			Root<FitnessEntity> root = criteriaQuery.from(FitnessEntity.class);
			criteriaQuery.select(root);
			criteriaQuery.where(builder.and(builder.equal(root.get("gender"),fitness.getGender())
					,builder.equal(root.get("goals"),fitness.getGoals()),builder.equal(root.get("level1"),fitness.getLevel1())));
			List<FitnessEntity> fitnesentity = session.createQuery(criteriaQuery).getResultList();
			
			for(FitnessEntity f : fitnesentity) {
				Fitness fit = new Fitness();
				if(fitness.getUpdateColumns().equals("Day 1"))
	        	{
	        		fit.setUpdateValue(f.getDay1());
	        		return fit;
	        	}
				if(fitness.getUpdateColumns().equals("Day 2"))
	        	{
	        		fit.setUpdateValue(f.getDay2());
	        		return fit;
	        	}
				if(fitness.getUpdateColumns().equals("Day 3"))
	        	{
	        		fit.setUpdateValue(f.getDay3());
	        		return fit;
	        	}
				if(fitness.getUpdateColumns().equals("Day 4"))
	        	{
	        		fit.setUpdateValue(f.getDay4());
	        		return fit;
	        	}
				if(fitness.getUpdateColumns().equals("Day 5"))
	        	{
	        		fit.setUpdateValue(f.getDay5());
	        		return fit;
	        	}
				if(fitness.getUpdateColumns().equals("Day 6"))
	        	{
	        		fit.setUpdateValue(f.getDay6());
	        		return fit;
	        	}
				if(fitness.getUpdateColumns().equals("Day 7"))
	        	{
	        		fit.setUpdateValue(f.getDay7());
	        		return fit;
	        	}
			}
			return null;
		}
		
	
		
		@Override
		public Fabfit getsuggestion(String fabfit) throws Exception{
			Session session = sessionFactory.getCurrentSession();
			Fabfitentity fe=session.get(Fabfitentity.class,fabfit);
			Fabfit f1=new Fabfit();
			f1.setEmail(fe.getEmail());
			f1.setName(fe.getName());
			f1.setTrainerid(fe.getTrainerid());
			f1.setSuggestions(fe.getSuggestions());
			return f1;
		}
		
		public void removetrainer(String email) throws Exception{
			Session session = sessionFactory.getCurrentSession();
			Fabfitentity fe=session.get(Fabfitentity.class,email);
			String temail=fe.getTrainerid();
			List<Fabfitentity>fab1=new ArrayList<>();
			fe.setTrainerid(null);
			session.persist(fe);
			TrainerEntity te=session.get(TrainerEntity.class,temail);
			for(Fabfitentity f1:te.getFabfitusers()){
				Fabfitentity f2=new Fabfitentity();
				if(f1.getEmail()!=email){
					f2.setEmail(f1.getEmail());
					f2.setContact(f1.getContact());
					f2.setGender(f1.getGender());
					f2.setName(f1.getName());
					f2.setPassword(f1.getPassword());
					f2.setSuggestions(f1.getSuggestions());
					f2.setHeight(f1.getHeight());
					f2.setWeight(f1.getWeight());
					f2.setTrainerid(f1.getTrainerid());
					fab1.add(f2);
				}
			}
			te.setFabfitusers(fab1);
			session.persist(te);
		}
		public Integer sendrequest(Requests req1) throws Exception{

			Integer id = null;
			 {
				 
				 Session session = sessionFactory.getCurrentSession();
				 RequestsEntity re=new RequestsEntity();
				 re.setName(req1.getName());
				 re.setContact(req1.getContact());
				 re.setEmail(req1.getEmail());
				 re.setGender(req1.getGender());
				 re.setPassword(req1.getPassword());
				 re.setStatus("In progress");
				 re.setSpecialization(req1.getSpecialization());
				 id=(Integer)session.save(re);
				 re.setReqId(id);
				// System.out.println(re.getReqId());
			}
			 return id;
		}
		
		public List<Requests> getrequest() throws Exception{

			 {
				
				 	Session session = sessionFactory.getCurrentSession();
				 	CriteriaBuilder builder = session.getCriteriaBuilder();
					CriteriaQuery<RequestsEntity> criteriaQuery= builder.createQuery(RequestsEntity.class);
					Root<RequestsEntity> root = criteriaQuery.from(RequestsEntity.class);
					criteriaQuery.select(root);
					List<RequestsEntity> requestentity = session.createQuery(criteriaQuery).getResultList();
					List<Requests> req=new ArrayList<Requests>();
					
					for(RequestsEntity r:requestentity){
						if(r.getStatus().equals("In progress")){
						Requests re=new Requests();
						re.setReqId(r.getReqId());
						re.setContact(r.getContact());
						re.setEmail(r.getEmail());
						re.setGender(r.getGender());
						re.setName(r.getName());
						re.setPassword(r.getPassword());
						re.setSpecialization(r.getSpecialization());
						req.add(re);
					}}
					return req;
			}
			
		}
		
		public Requests acceptrequest(Requests req1) throws Exception{

			 {Session session = sessionFactory.getCurrentSession();
				 Requests r=new Requests();
				 TrainerEntity tr=new TrainerEntity();
				 tr.setContact(Long.parseLong(req1.getContact()));
				 tr.setGender(req1.getGender());
				 tr.setName(req1.getName());
				 tr.setPassword(req1.getPassword());
				 tr.setSpecialization(req1.getSpecialization());
				 tr.setTemail(req1.getEmail());
				 
				 tr.setFabfitusers(null);
				 session.persist(tr);
				 RequestsEntity re1=session.get(RequestsEntity.class,req1.getReqId());
				 re1.setStatus("Accepted");
				 
				 return r;
			}
		}
		
		@Override
		public Requests rejectrequest(Requests req1) throws Exception{

			 {Session session = sessionFactory.getCurrentSession();
			 Requests r=new Requests();
				 RequestsEntity re1=session.get(RequestsEntity.class,req1.getReqId());
				 re1.setStatus("Rejected");
				 return r;
			}
		}
		
		@Override
		@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
		public Requests getrequestbyId(String id) throws Exception{
			 {Session session = sessionFactory.getCurrentSession();
				 RequestsEntity re=session.get(RequestsEntity.class,Integer.parseInt(id));
				 Requests r=new Requests();
				 r.setStatus(re.getStatus());
				 return r;
			}
			
		}

		
		
}
