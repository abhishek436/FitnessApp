package com.infy.model;

import java.util.List;

import com.infy.entity.Fabfitentity;

public class Trainer {
	private String name;
	private String email;
	private String gender;
	private String specialization;
	private Long contact;
	private String message;
	private String password;
	private List<Fabfit> fabfitusers1;
	
public List<Fabfit> getFabfitusers1() {
		return fabfitusers1;
	}
	public void setFabfitusers1(List<Fabfit> fabfitusers1) {
		this.fabfitusers1 = fabfitusers1;
	}
	//	public Fabfit getUser() {
//		return user;
//	}
//	public void setUser(Fabfit user) {
//		this.user = user;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}


