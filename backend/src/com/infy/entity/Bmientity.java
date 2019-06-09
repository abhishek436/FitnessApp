package com.infy.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "BMI")
@GenericGenerator(name="idGen" , strategy="increment")
public class Bmientity {
	@Id
	@GeneratedValue(generator="idGen")
	private Integer bmid;
	private Integer height;
	private Integer weight;
	private LocalDate dob;
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
