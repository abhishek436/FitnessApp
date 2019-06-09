package com.infy.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.infy.dao.FABFITDAO;
import com.infy.model.Admin;
import com.infy.model.Bmi;
import com.infy.model.Diet;
import com.infy.model.Fabfit;
import com.infy.model.Fitness;
import com.infy.model.Requests;
import com.infy.model.Trainer;


@Service("fabfitService")
@Transactional(readOnly = true)
public class fabfitServiceImpl implements fabfitService{
	
	@Autowired
	private FABFITDAO dao;
	
	@Transactional(readOnly = false , propagation = Propagation.REQUIRES_NEW)
	public Fabfit updatedetails(Fabfit fab) throws Exception {
		Fabfit fabi = dao.updatedetails(fab);
		
		if(fabi == null) {
			throw new Exception("Service.INVALID_DETAILS");
		}
		return fabi;
	}
	
	@Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
	public Fabfit verifydetails(Fabfit fab) throws Exception {
		Fabfit fabi = dao.verifydetails(fab);
		return fabi;
	}

@Override
@Transactional(readOnly = false , propagation = Propagation.REQUIRES_NEW)
public Bmi addetails(Bmi bmi) throws Exception {
	Bmi fabi = dao.addetails(bmi);
	
	return fabi;
}

@Override
@Transactional(readOnly=false, propagation  = Propagation.REQUIRES_NEW)
public Fabfit updateprofile(Fabfit fab) throws Exception {
	Fabfit profile = dao.updateprofile(fab);
	if(profile==null){
		throw new Exception("profile.NOT_UPDATE");
	}
	return profile;
}

@Override
@Transactional(readOnly = false , propagation = Propagation.REQUIRES_NEW)
public Trainer addtrainer(Trainer trainer) throws Exception {
	
		Trainer traini = dao.addtrainer(trainer);
		return traini;
	}
@Transactional(readOnly=false, propagation  = Propagation.REQUIRES_NEW)
public Trainer Trainerlogin(Trainer trainer) throws Exception {
    Trainer admin2= dao.Trainerlogin(trainer);
	if(admin2 == null){
		throw new Exception("Service.RegisterFailed");
	}
	return admin2;
}
public Admin adminLogin(Admin admin) throws Exception {
	Admin admin1 =dao.adminLogin(admin);
	if(admin1 == null)
		throw new Exception("Service.LoginFailed");
	return admin1;
}
public List<Trainer> getTrainer() throws Exception {
	List<Trainer> listOfItems= dao.getTrainer();
	if(listOfItems.size()<=0){
		throw new Exception("Service.NO_Trainer_AVAILABLE");
	}
	return listOfItems;
    }

@Override
public List<Diet> getdiet(Diet diet) throws Exception {
	List<Diet> listOfItems= dao.getdiet(diet);
	if(listOfItems == null){
		throw new Exception("Service.Diet_details");
	}
	return listOfItems;
    
   }

@Override
@Transactional(readOnly = false , propagation = Propagation.REQUIRES_NEW)
public List<Diet> updatediet(Diet diet) throws Exception {
	List<Diet> d = dao.updatediet(diet);
	return d;
}
@Override
public Fabfit getdetails(String email) throws Exception {
	Fabfit userDetails= dao.getdetails(email);
	
	return userDetails;
}

@Override
@Transactional(readOnly=false, propagation  = Propagation.REQUIRES_NEW)
public Fabfit booktrainer(String temail,String email) throws Exception {
	Fabfit book= dao.booktrainer(temail,email);
	if(book == null) {
		throw new Exception("Service.INVALID_BOOKING");
	}
	return book;
}

@Override
@Transactional(readOnly=false, propagation  = Propagation.REQUIRES_NEW)
public Trainer getinfo(String temail) throws Exception {
	Trainer listOfTrainers= dao.getinfo(temail);
	System.out.println(listOfTrainers.getEmail());
	System.out.println(listOfTrainers.getFabfitusers1());
	return listOfTrainers;
}

@Override
@Transactional(readOnly=false, propagation  = Propagation.REQUIRES_NEW)
public Fabfit setsuggestion(Fabfit fabfit) throws Exception {
	
	Fabfit fabi = dao.setsuggestion(fabfit);
	if(fabi==null)
	{
		throw new Exception ("Cannot be empty");
	}
	
	return fabi;
}


@Override
public List<Fitness> getFit(Fitness fitness) throws Exception {
	List<Fitness> listOfItems= dao.getFit(fitness);
	if(listOfItems == null){
		throw new Exception("Service.Diet_details");
	}
	return listOfItems;
    
   }

@Override
@Transactional(readOnly = false , propagation = Propagation.REQUIRES_NEW)
public List<Fitness> updateFitness(Fitness fitness) throws Exception {
	List<Fitness> d = dao.updateFitness(fitness);
	return d;
}

@Override
@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
public void deletetrainer(String email) throws Exception {
	
	if(dao.getTrainer() != null) {
		dao.deletetrainer(email);
	}
}

@Override
public Diet fetchdiet(Diet diet) throws Exception {
	Diet d2=dao.fetchdiet(diet);
		return d2;

}

@Override
public Fabfit getsuggestion(String fabfit) throws Exception{
	Fabfit f=dao.getsuggestion(fabfit);
	return f;
}

@Override
public Fitness fetchFitness(Fitness fitness) throws Exception {
	Fitness d2=dao.fetchFitness(fitness);
		return d2;

}
@Override
@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
public void removetrainer(String email) throws Exception{

	 {
		dao.removetrainer(email);
	}
}

@Override
@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
public Integer sendrequest(Requests req1) throws Exception{

	Integer id = null;
	 {
		id = dao.sendrequest(req1);
	}
	 return id;
}

@Override
@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
public List<Requests> getrequest() throws Exception{

	 {
		List<Requests> req=dao.getrequest();
		 return req;
	}
	
}

@Override
@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
public Requests acceptrequest(Requests req1) throws Exception{

	 {
		Requests re1=dao.acceptrequest(req1);
		return re1;
	}
	 
}

@Override
@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
public Requests rejectrequest(Requests req1) throws Exception{

	 {
		Requests re1=dao.rejectrequest(req1);
		return re1;
	}
	 
}

@Override
@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
public Requests getrequestbyId(String id) throws Exception{

	 {
		Requests req=dao.getrequestbyId(id);
		 return req;
	}
	
}
}




