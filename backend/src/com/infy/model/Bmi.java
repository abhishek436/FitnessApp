package com.infy.model;

import java.time.LocalDate;

public class Bmi {
	private Integer bmid;
	private Integer height;
	private Integer weight;
	private LocalDate dob;
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getBmid() {
		return bmid;
	}
	public void setBmid(Integer bmid) {
		this.bmid = bmid;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

}
