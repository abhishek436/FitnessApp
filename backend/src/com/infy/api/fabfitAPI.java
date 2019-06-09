package com.infy.api;

import java.util.ArrayList;
import java.util.List;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.infy.model.Admin;
import com.infy.model.Bmi;
import com.infy.model.Diet;
import com.infy.model.Fabfit;
import com.infy.model.Fitness;
import com.infy.model.Requests;
import com.infy.model.Trainer;
import com.infy.service.fabfitService;
import com.infy.service.fabfitServiceImpl;
import com.infy.utility.ContextFactory;

@RestController
@CrossOrigin
@RequestMapping(path="FABFITapi")
public class fabfitAPI {
	
//	@Autowired
	private static fabfitServiceImpl service;
	
	
    @RequestMapping(method = RequestMethod.POST,value = "updatedetails")
	public ResponseEntity<Fabfit> updatedetails(@RequestBody Fabfit fabfit){
		
		Environment environment= ContextFactory.getContext().getEnvironment();
		service = ContextFactory.getContext().getBean(fabfitServiceImpl.class);
		ResponseEntity<Fabfit> responseEntity;
		
		try {
			Fabfit fab = service.updatedetails(fabfit);
			fab.setMessage(environment.getProperty("FabfitAPI.SUCCESSFULL"));
			responseEntity = new ResponseEntity<Fabfit>(fab,HttpStatus.OK);
		}
		catch(Exception e) {
			//String errorMessage = environment.getProperty(e.getMessage());
		    Fabfit fb = new Fabfit();
			fb.setMessage(environment.getProperty("Service.INVALID_DETAILS"));
			responseEntity = new ResponseEntity<Fabfit>(fb,HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
		
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "addetails")
	public ResponseEntity<Bmi> addetails(@RequestBody Bmi bmi) {
		Environment environment= ContextFactory.getContext().getEnvironment();
		service = ContextFactory.getContext().getBean(fabfitServiceImpl.class);
		ResponseEntity<Bmi> responseEntity;
		
		try {
			Bmi bmi1 = service.addetails(bmi);
			bmi1.setMessage(environment.getProperty("FabfitAPI.SUCCESSFULL"));
			responseEntity = new ResponseEntity<Bmi>(bmi1,HttpStatus.OK);
		}
		catch(Exception e) {
			Bmi fb = new Bmi();
			fb.setMessage(environment.getProperty("Service.INVALID_DETAILS"));
			responseEntity = new ResponseEntity<Bmi>(fb,HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	@RequestMapping(method = RequestMethod.POST,value = "login")
	public ResponseEntity<Fabfit> verifydetails(@RequestBody Fabfit fabfit) {
		Environment environment = ContextFactory.getContext().getEnvironment();
		service =ContextFactory.getContext().getBean(fabfitServiceImpl.class);
		ResponseEntity<Fabfit> responseEntity=null;
		
		
		try {
			Fabfit fab = service.verifydetails(fabfit);
			//fab.setMessage(environment.getProperty("Login.SUCCESSFULL"));
			if(fab.getMessage().equals("Login Successfull")){
			responseEntity = new ResponseEntity<Fabfit>(fab,HttpStatus.OK);
			}
		}
		catch(Exception e) {
			Fabfit fb = new Fabfit();
			fb.setMessage(environment.getProperty("Login.INVALID_DETAILS"));
			responseEntity = new ResponseEntity<Fabfit>(fb,HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="profileupdate")
	public ResponseEntity<Fabfit> updateprofile(@RequestBody Fabfit fabfit){

		Environment environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<Fabfit> responseEntity=null;
		Fabfit profile = new Fabfit();
		service = ContextFactory.getContext().getBean(fabfitServiceImpl.class);
		
		try {
			Fabfit fab=service.updateprofile(fabfit);
			fab.setMessage(environment.getProperty("Profile.SUCCESSFULL_UPDATED"));
			responseEntity = new ResponseEntity<Fabfit>(fab,HttpStatus.OK);
		}
		catch(Exception exception) {
			String errorMessage = environment.getProperty(exception.getMessage());

			profile.setMessage(errorMessage);
			
			responseEntity = new ResponseEntity<Fabfit>(profile,HttpStatus.BAD_REQUEST);

		}

		return responseEntity;

	}
	
	
	@RequestMapping(method = RequestMethod.POST,value = "addtrainer")
	public ResponseEntity<Trainer> updatedetails(@RequestBody Trainer trainer){
		
		Environment environment= ContextFactory.getContext().getEnvironment();
		service =ContextFactory.getContext().getBean(fabfitServiceImpl.class);
		ResponseEntity<Trainer> responseEntity;
		
		try {
			Trainer fab = service.addtrainer(trainer);
			fab.setMessage(environment.getProperty("Trainer.SUCCESSFULL"));
			responseEntity = new ResponseEntity<Trainer>(fab,HttpStatus.OK);
		}
		catch(Exception e) {
			//String errorMessage = environment.getProperty(e.getMessage());
			Trainer fb = new Trainer();
			fb.setMessage(environment.getProperty("Trainer.INVALID_DETAILS"));
			responseEntity = new ResponseEntity<Trainer>(fb,HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
		
	}
	
	
	@RequestMapping(value="trainerlogin" , method=RequestMethod.POST)
	public ResponseEntity<Trainer> trainerlogin(@RequestBody Trainer trainer){
		
		Environment environment = ContextFactory.getContext().getEnvironment();
		service =ContextFactory.getContext().getBean(fabfitServiceImpl.class);
		ResponseEntity<Trainer> responseEntity=null;
		
		
		try {
			Trainer fab = service.Trainerlogin(trainer);
			//fab.setMessage(environment.getProperty("Login.SUCCESSFULL"));
			if(fab.getMessage().equals("Login Successfull")){
			responseEntity = new ResponseEntity<Trainer>(fab,HttpStatus.OK);
			}
		}
		catch(Exception e) {
			Trainer fb = new Trainer();
			fb.setMessage(environment.getProperty("Login.INVALID_DETAILS"));
			responseEntity = new ResponseEntity<Trainer>(fb,HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	@RequestMapping(value="adminlogin" , method=RequestMethod.POST)
	public ResponseEntity<Admin> adminLogin(@RequestBody Admin admin){
		Environment environment= ContextFactory.getContext().getEnvironment();
		service= ContextFactory.getContext().getBean(fabfitServiceImpl.class);
		
		ResponseEntity<Admin> responseEntity=null;
		Admin admin1 = new Admin();
		try{
			admin1 = service.adminLogin(admin);
			admin1.setMessage(environment.getProperty("Service.LoginSuccess"));
			responseEntity = new ResponseEntity<Admin> (admin1, HttpStatus.OK);
		}catch(Exception e){
			admin1.setMessage(environment.getProperty("Service.LoginFailed"));
			responseEntity = new ResponseEntity<Admin> (admin1, HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	@RequestMapping(method=RequestMethod.GET, value="receive")
	public ResponseEntity<List<Trainer>> getTrainer(){		
		Environment environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<List<Trainer>> responseEntity=null;
		List<Trainer> alltrainer = new ArrayList<Trainer>();
		service = ContextFactory.getContext().getBean(fabfitServiceImpl.class);
		
		try {
			alltrainer = service.getTrainer();
			responseEntity = new ResponseEntity<>(alltrainer,HttpStatus.OK);

		}
		catch(Exception exception) {
			String errorMessage = environment.getProperty(exception.getMessage());
			Trainer train = new Trainer();
			train.setMessage(errorMessage);			
			alltrainer.add(train);			
			responseEntity = new ResponseEntity<>(alltrainer,HttpStatus.BAD_REQUEST);
			
		}
		return responseEntity;
	}
	@RequestMapping(method=RequestMethod.POST, value="getDiet")
	public ResponseEntity<List<Diet>> getdiet(@RequestBody Diet diet) {

		Environment environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<List<Diet>> responseEntity=null;
		List<Diet> alldiet = new ArrayList<Diet>();
		service = ContextFactory.getContext().getBean(fabfitServiceImpl.class);
		
		try {
			alldiet = service.getdiet(diet);
			responseEntity = new ResponseEntity<List<Diet>>(alldiet,HttpStatus.OK);
		}
		catch(Exception exception) {
			String errorMessage = environment.getProperty(exception.getMessage());
			Diet train = new Diet();
			train.setMessage(errorMessage);						
			responseEntity = new ResponseEntity<>(alldiet,HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	@RequestMapping(method=RequestMethod.POST, value="updatediet")
	public ResponseEntity<Diet> updatediet(@RequestBody Diet diet) {
		Environment environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<Diet> responseEntity=null;
		List<Diet> alldiet = new ArrayList<Diet>();
		service = ContextFactory.getContext().getBean(fabfitServiceImpl.class);
		
		try {
			alldiet = service.updatediet(diet);
			
			diet.setMessage(environment.getProperty("Service.upDietSuccess"));
			responseEntity = new ResponseEntity<Diet>(diet,HttpStatus.OK);
		}
		catch(Exception exception) {
			String errorMessage = environment.getProperty(exception.getMessage());
			Diet train = new Diet();
			train.setMessage(errorMessage);						
			responseEntity = new ResponseEntity<>(train,HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	@RequestMapping(method=RequestMethod.GET, value="getdetails/{email}")
	public ResponseEntity<Fabfit> getdetails(@PathVariable String email){	
		email=email+"@gmail.com";
		Environment environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<Fabfit> responseEntity=null;
		Fabfit alltrainer = new Fabfit();
		service = ContextFactory.getContext().getBean(fabfitServiceImpl.class);
		
		try {
			alltrainer = service.getdetails(email);
			responseEntity = new ResponseEntity<>(alltrainer,HttpStatus.OK);

		}
		catch(Exception exception) {
			String errorMessage = environment.getProperty(exception.getMessage());
			Trainer train = new Trainer();
			train.setMessage(errorMessage);			
			responseEntity = new ResponseEntity<>(alltrainer,HttpStatus.BAD_REQUEST);
			
		}
		return responseEntity;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="booktrainer")
	public ResponseEntity<Fabfit> booktrainer(@RequestBody String combemail){	
		System.out.println(combemail);
		String[] parts=combemail.split("-");
		String temail=parts[0];
		String email=parts[1];
		Environment environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<Fabfit> responseEntity=null;
		Fabfit alltrainer = new Fabfit();
		
		service = ContextFactory.getContext().getBean(fabfitServiceImpl.class);
		
		try {
			alltrainer = service.booktrainer(temail,email);
			alltrainer.setMessage(environment.getProperty("Booktrainer_success"));
			responseEntity = new ResponseEntity<>(alltrainer,HttpStatus.OK);

		}
		catch(Exception exception) {
			String errorMessage = environment.getProperty(exception.getMessage());
			
			alltrainer.setMessage(environment.getProperty("Service.INVALID_BOOKING"));
			responseEntity = new ResponseEntity<>(alltrainer,HttpStatus.BAD_REQUEST);
			
		}
		return responseEntity;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="getinfo")
	public ResponseEntity<Trainer> getinfo(@RequestBody String temail){	
		
		System.out.println(temail);
		Environment environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<Trainer> responseEntity=null;
		Trainer alltrainer = new Trainer();
		service = ContextFactory.getContext().getBean(fabfitServiceImpl.class);
		
		try {
			alltrainer = service.getinfo(temail);
			responseEntity = new ResponseEntity<>(alltrainer,HttpStatus.OK);

		}
		catch(Exception exception) {
			String errorMessage = environment.getProperty(exception.getMessage());
			Trainer train = new Trainer();
			train.setMessage(errorMessage);			
		    
			responseEntity = new ResponseEntity<>(alltrainer,HttpStatus.BAD_REQUEST);
			
		}
		return responseEntity;
	}
	@RequestMapping(method = RequestMethod.POST,value = "suggestion")
	public ResponseEntity<Fabfit> setsuggestion(@RequestBody Fabfit fabfit){
		
		Environment environment= ContextFactory.getContext().getEnvironment();
		service =ContextFactory.getContext().getBean(fabfitServiceImpl.class);
		ResponseEntity<Fabfit> responseEntity;
		
		try {
			Fabfit fab = service.setsuggestion(fabfit);
			fab.setMessage(environment.getProperty("Suggestion.Details"));
			responseEntity = new ResponseEntity<Fabfit>(fab,HttpStatus.OK);
		}
		catch(Exception e) {
			//String errorMessage = environment.getProperty(e.getMessage());
		    Fabfit fb = new Fabfit();
			fb.setMessage(environment.getProperty("Suggest.Empty"));
			responseEntity = new ResponseEntity<Fabfit>(fb,HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
		
	}
	
	//Get suggestion
	
	@RequestMapping(method = RequestMethod.POST,value = "getsuggestion")
	public ResponseEntity<Fabfit> getsuggestion(@RequestBody String fabfit){
		
		Environment environment= ContextFactory.getContext().getEnvironment();
		service =ContextFactory.getContext().getBean(fabfitServiceImpl.class);
		ResponseEntity<Fabfit> responseEntity;
		
		try {
			Fabfit fab = service.getsuggestion(fabfit);
			fab.setMessage(environment.getProperty("Suggestion.Details"));
			responseEntity = new ResponseEntity<Fabfit>(fab,HttpStatus.OK);
		}
		catch(Exception e) {
			//String errorMessage = environment.getProperty(e.getMessage());
		    Fabfit fb = new Fabfit();
			fb.setMessage(environment.getProperty("Suggest.Empty"));
			responseEntity = new ResponseEntity<Fabfit>(fb,HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
		
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="getFit")
	public ResponseEntity<List<Fitness>> getFit(@RequestBody Fitness fitness) {

		Environment environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<List<Fitness>> responseEntity=null;
		List<Fitness> allFitness = new ArrayList<Fitness>();
		service = ContextFactory.getContext().getBean(fabfitServiceImpl.class);
		
		try {
			allFitness = service.getFit(fitness);
			responseEntity = new ResponseEntity<List<Fitness>>(allFitness,HttpStatus.OK);
		}
		catch(Exception exception) {
			String errorMessage = environment.getProperty(exception.getMessage());
			Fitness train = new Fitness();
			train.setMessage(errorMessage);						
			responseEntity = new ResponseEntity<>(allFitness,HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="updateFitness")
	public ResponseEntity<List<Fitness>> updateFitness(@RequestBody Fitness fitness) {
		Environment environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<List<Fitness>> responseEntity=null;
		List<Fitness> allFitness = new ArrayList<Fitness>();
		service = ContextFactory.getContext().getBean(fabfitServiceImpl.class);
		
		try {
			allFitness = service.updateFitness(fitness);
			fitness.setMessage(environment.getProperty("Service.upFitSuccess"));
			responseEntity = new ResponseEntity<List<Fitness>>(allFitness,HttpStatus.OK);
		}
		catch(Exception exception) {
			String errorMessage = environment.getProperty(exception.getMessage());
			Fitness train = new Fitness();
			train.setMessage(errorMessage);						
			responseEntity = new ResponseEntity<>(allFitness,HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "deletetrainer")
	public ResponseEntity<Trainer> deletetrainer(@RequestBody String email){
		
		Environment environment= ContextFactory.getContext().getEnvironment();
		service =ContextFactory.getContext().getBean(fabfitServiceImpl.class);
		ResponseEntity<Trainer> responseEntity;
		
		try {
			Trainer trainer = new Trainer();
			service.deletetrainer(email);
			trainer.setMessage(environment.getProperty("Trainer_delete"));
			responseEntity = new ResponseEntity<Trainer>(trainer,HttpStatus.OK);
		}
		catch(Exception e) {
			Trainer trainer = new Trainer(); 
			responseEntity = new ResponseEntity<Trainer>(trainer,HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "fetchdiet")
	public ResponseEntity<Diet> fetchdiet(@RequestBody Diet diet) {
		service =ContextFactory.getContext().getBean(fabfitServiceImpl.class);
		ResponseEntity<Diet> responseEntity;
		
		try {
			Diet d = new Diet();
			d=service.fetchdiet(diet);
			responseEntity = new ResponseEntity<Diet>(d,HttpStatus.OK);
		}
		catch(Exception e) {
			Diet diet1 = new Diet(); 
			responseEntity = new ResponseEntity<Diet>(diet1,HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	@RequestMapping(method = RequestMethod.POST,value = "fetchfitness")
	public ResponseEntity<Fitness> fetchdiet(@RequestBody Fitness fitness) {
		service =ContextFactory.getContext().getBean(fabfitServiceImpl.class);
		ResponseEntity<Fitness> responseEntity;
		
		try {
			Fitness fit = new Fitness();
			fit=service.fetchFitness(fitness);
			responseEntity = new ResponseEntity<Fitness>(fit,HttpStatus.OK);
		}
		catch(Exception e) {
			Fitness fit1 = new Fitness(); 
			responseEntity = new ResponseEntity<Fitness>(fit1,HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	
//	remove trainer from user
	
	@RequestMapping(method = RequestMethod.POST,value = "removetrainer")
	public ResponseEntity<Fabfit> removetrainer(@RequestBody String email){
		
		Environment environment= ContextFactory.getContext().getEnvironment();
		service =ContextFactory.getContext().getBean(fabfitServiceImpl.class);
		ResponseEntity<Fabfit> responseEntity;
		
		try {
			Fabfit trainer = new Fabfit();
			service.removetrainer(email);
			trainer.setMessage(environment.getProperty("Trainer_delete"));
			responseEntity = new ResponseEntity<Fabfit>(trainer,HttpStatus.OK);
		}
		catch(Exception e) {
			Fabfit trainer = new Fabfit(); 
			responseEntity = new ResponseEntity<Fabfit>(trainer,HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
//REQUEST TRAINER 
	
	@RequestMapping(method = RequestMethod.POST,value = "sendrequest")
	public ResponseEntity<Requests> sendrequest(@RequestBody Requests req1){
		
		Environment environment= ContextFactory.getContext().getEnvironment();
		service =ContextFactory.getContext().getBean(fabfitServiceImpl.class);
		ResponseEntity<Requests> responseEntity;
		
		try {
			Requests req = new Requests();
			Integer i=service.sendrequest(req1);
			req.setMessage(environment.getProperty("Trainer.Accepted"));
			req.setReqId(i);
			responseEntity = new ResponseEntity<Requests>(req,HttpStatus.OK);
		}
		catch(Exception e) {
			Requests req = new Requests();
			req.setMessage("ERROR");
			responseEntity = new ResponseEntity<Requests>(req,HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="getrequest")
	public ResponseEntity<List<Requests>> getrequest(){		
		Environment environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<List<Requests>> responseEntity=null;
		List<Requests> request = new ArrayList<Requests>();
		service = ContextFactory.getContext().getBean(fabfitServiceImpl.class);
		
		try {
			request = service.getrequest();
			responseEntity = new ResponseEntity<>(request,HttpStatus.OK);

		}
		catch(Exception exception) {
			String errorMessage = environment.getProperty(exception.getMessage());
			Requests req1 = new Requests();
			req1.setMessage(errorMessage);			
			request.add(req1);			
			responseEntity = new ResponseEntity<>(request,HttpStatus.BAD_REQUEST);
			
		}
		return responseEntity;
	}
	
	//ADDREQUEST
	
	@RequestMapping(method = RequestMethod.POST,value = "acceptrequest")
	public ResponseEntity<Requests> acceptrequest(@RequestBody Requests request){
		System.out.println("hi");
		Environment environment= ContextFactory.getContext().getEnvironment();
		service =ContextFactory.getContext().getBean(fabfitServiceImpl.class);
		ResponseEntity<Requests> responseEntity;
		
		try {
			Requests re1 = service.acceptrequest(request);
			re1.setMessage(environment.getProperty("Trainer.SUCCESSFULL"));
			responseEntity = new ResponseEntity<Requests>(re1,HttpStatus.OK);
		}
		catch(Exception e) {
			//String errorMessage = environment.getProperty(e.getMessage());
			Requests fb = new Requests();
			fb.setMessage(environment.getProperty("Trainer.Rejected"));
			responseEntity = new ResponseEntity<Requests>(fb,HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
		
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "rejectrequest")
	public ResponseEntity<Requests> rejectrequest(@RequestBody Requests request){
		System.out.println("hi");
		Environment environment= ContextFactory.getContext().getEnvironment();
		service =ContextFactory.getContext().getBean(fabfitServiceImpl.class);
		ResponseEntity<Requests> responseEntity;
		
		try {
			Requests re1 = service.rejectrequest(request);
			re1.setMessage(environment.getProperty("Trainer.SUCCESSFULL"));
			responseEntity = new ResponseEntity<Requests>(re1,HttpStatus.OK);
		}
		catch(Exception e) {
			//String errorMessage = environment.getProperty(e.getMessage());
			Requests fb = new Requests();
			fb.setMessage(environment.getProperty("Trainer.Rejected"));
			responseEntity = new ResponseEntity<Requests>(fb,HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
		
	}
	
	//
	@RequestMapping(method=RequestMethod.GET, value="getrequest/{id}")
	public ResponseEntity<Requests> getrequestbyId(@PathVariable String id){		
		Environment environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<Requests> responseEntity=null;
		Requests request = new Requests();
		service = ContextFactory.getContext().getBean(fabfitServiceImpl.class);
		
		try {
			request = service.getrequestbyId(id);
			responseEntity = new ResponseEntity<>(request,HttpStatus.OK);

		}
		catch(Exception exception) {
			String errorMessage = environment.getProperty(exception.getMessage());
			Requests req1 = new Requests();
			req1.setMessage(errorMessage);						
			responseEntity = new ResponseEntity<>(req1,HttpStatus.BAD_REQUEST);
			
		}
		return responseEntity;
	}
}
