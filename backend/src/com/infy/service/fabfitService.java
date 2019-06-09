package com.infy.service;

import java.util.List;

import com.infy.model.Admin;
import com.infy.model.Bmi;
import com.infy.model.Diet;
import com.infy.model.Fabfit;
import com.infy.model.Fitness;
import com.infy.model.Requests;
import com.infy.model.Trainer;


public interface fabfitService {
	
	public  Fabfit updatedetails(Fabfit fab) throws Exception;
	public Fabfit verifydetails(Fabfit fab) throws Exception;
	public Bmi addetails(Bmi bmi) throws Exception;
	public Fabfit updateprofile(Fabfit fab) throws Exception;
	public Trainer addtrainer(Trainer trainer) throws Exception;
	public Trainer Trainerlogin(Trainer trainer) throws Exception;
	public Admin adminLogin(Admin admin) throws Exception;
	public List<Trainer> getTrainer() throws Exception;
	public List<Diet> getdiet(Diet diet) throws Exception;
	public List<Diet> updatediet(Diet diet) throws Exception;
	public Fabfit getdetails(String email) throws Exception;
	public Fabfit booktrainer(String temail,String email) throws Exception;
	public Trainer getinfo(String temail) throws Exception;
	public Fabfit setsuggestion(Fabfit fabfit) throws Exception;
	public Fabfit getsuggestion(String fabfit) throws Exception;
	public List<Fitness> getFit(Fitness fitness) throws Exception;
	public List<Fitness> updateFitness(Fitness fitness) throws Exception;
	public void deletetrainer(String email) throws Exception;
	public Integer sendrequest(Requests req1) throws Exception;
	public void removetrainer(String email) throws Exception;
	public Diet fetchdiet(Diet diet) throws Exception;
	public Fitness fetchFitness(Fitness fitness) throws Exception;
	public List<Requests> getrequest() throws Exception;
	public Requests getrequestbyId(String id) throws Exception;
	public Requests acceptrequest(Requests req1) throws Exception;
	public Requests rejectrequest(Requests req1) throws Exception;
}
