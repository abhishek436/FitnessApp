package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "diet")
public class DietEntity {
	@Id
	private Integer dietid;
	private Integer calories;
	private String fruits;
	private String vegetables;
	private String grains;
	private String protein ;
	private String dairy;
	private String breakfast ;
	private String midMsnack;
	private String lunch;
	private String midEsnack; 
	private String dinner ;
	private String gender;
	private String goals;
	private String level1;


	public Integer getCalories() {
		return calories;
	}
	public String getProtein() {
		return protein;
	}
	public void setProtein(String protein) {
		this.protein = protein;
	}
	public String getDairy() {
		return dairy;
	}
	public void setDairy(String dairy) {
		this.dairy = dairy;
	}
	public String getBreakfast() {
		return breakfast;
	}
	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}
	public String getMidMsnack() {
		return midMsnack;
	}
	public void setMidMsnack(String midMsnack) {
		this.midMsnack = midMsnack;
	}
	public String getLunch() {
		return lunch;
	}
	public void setLunch(String lunch) {
		this.lunch = lunch;
	}
	public String getMidEsnack() {
		return midEsnack;
	}
	public void setMidEsnack(String midEsnack) {
		this.midEsnack = midEsnack;
	}
	public String getDinner() {
		return dinner;
	}
	public void setDinner(String dinner) {
		this.dinner = dinner;
	}
	public void setCalories(Integer calories) {
		this.calories = calories;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGoals() {
		return goals;
	}
	public void setGoals(String goals) {
		this.goals = goals;
	}
	public String getLevel1() {
		return level1;
	}
	public void setLevel1(String level1) {
		this.level1 = level1;
	}
	public Integer getDietid() {
		return dietid;
	}
	public void setDietid(Integer dietid) {
		this.dietid = dietid;
	}
	public String getFruits() {
		return fruits;
	}
	public void setFruits(String fruits) {
		this.fruits = fruits;
	}
	public String getVegetables() {
		return vegetables;
	}
	public void setVegetables(String vegetables) {
		this.vegetables = vegetables;
	}
	public String getGrains() {
		return grains;
	}
	public void setGrains(String grains) {
		this.grains = grains;
	}
}
