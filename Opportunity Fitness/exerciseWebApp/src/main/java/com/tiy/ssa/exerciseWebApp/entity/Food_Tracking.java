package com.tiy.ssa.exerciseWebApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="food_tracking")
public class Food_Tracking {

	 private static final long serialVersionUID = 1L;
	 
	 	@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
	 	int id;
	 	
		@Column(name="user_id")
		String user_id;
		
		@Column(name="dayNo")
		String dayNo;
		
		@Column(name="food_desc")
		String food_desc;
		
		@Column(name="food_cat_id")
		Integer food_cat_id;
		
		@Column(name="protein")
		Integer protein;
		
		@Column(name="fat")
		Integer fat;
		
		@Column(name="carbs")
		Integer carbs;
		
		@Column(name="calories")
		Integer calories;


		
	public Food_Tracking(String user_id, String dayNo, String food_desc, Integer food_cat_id, Integer protein,
				Integer fat, Integer carbs, Integer calories) {
			super();
			this.user_id = user_id;
			this.dayNo = dayNo;
			this.food_desc = food_desc;
			this.food_cat_id = food_cat_id;
			this.protein = protein;
			this.fat = fat;
			this.carbs = carbs;
			this.calories = calories;
		}

	public Food_Tracking(){}

	public String getUser_id() {
		return user_id;
	}

	public String getDayNo() {
		return dayNo;
	}

	public String getFood_desc() {
		return food_desc;
	}

	
	public Integer getProtein() {
		return protein;
	}

	public Integer getFat() {
		return fat;
	}

	public Integer getCarbs() {
		return carbs;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public void setDayNo(String dayNo) {
		this.dayNo = dayNo;
	}

	public void setFood_desc(String food_desc) {
		this.food_desc = food_desc;
	}

	
	public void setProtein(Integer protein) {
		this.protein = protein;
	}

	public void setFat(Integer fat) {
		this.fat = fat;
	}

	public void setCarbs(Integer carbs) {
		this.carbs = carbs;
	}

	public Integer getFood_cat_id() {
		return food_cat_id;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setFood_cat_id(Integer food_cat_id) {
		this.food_cat_id = food_cat_id;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}
	
	
	
	
}
