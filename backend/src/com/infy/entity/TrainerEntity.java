package com.infy.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "addtrainerprofile")
public class TrainerEntity {
	private String name;
	@Id
	private String temail;
	private String gender;
	private String specialization;
	private Long contact;
	private String password;
	@OneToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "fabtrainer", joinColumns = @JoinColumn(name = "temail", referencedColumnName = "temail"), inverseJoinColumns = @JoinColumn(name = "email", referencedColumnName = "email", unique = true))
	private List<Fabfitentity> fabfitusers;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getTemail() {
		return temail;
	}
	public void setTemail(String temail) {
		this.temail = temail;
	}
	public List<Fabfitentity> getFabfitusers() {
		return fabfitusers;
	}
	public void setFabfitusers(List<Fabfitentity> fabfitusers) {
		this.fabfitusers = fabfitusers;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}



