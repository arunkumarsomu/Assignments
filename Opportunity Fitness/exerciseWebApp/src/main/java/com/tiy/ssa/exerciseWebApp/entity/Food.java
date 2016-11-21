package com.tiy.ssa.exerciseWebApp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="food")
public class Food implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id;
			
	@Column(name="description")
	String description;
	
	@Column(name="calories")
	Integer calories;
	
	@Column(name="protein")
	Integer protein;
			
	@Column(name="fat")
	Integer fat;
			
	@Column(name="carbs")
	Integer carbs;
			
	@Column(name="category_id")
	Integer category_id;

	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Food(String description, Integer calories, Integer protein, Integer fat, Integer carbs, Integer category_id) {
		super();
		this.description = description;
		this.calories = calories;
		this.protein = protein;
		this.fat = fat;
		this.carbs = carbs;
		this.category_id = category_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	public Integer getProtein() {
		return protein;
	}

	public void setProtein(Integer protein) {
		this.protein = protein;
	}

	public Integer getFat() {
		return fat;
	}

	public void setFat(Integer fat) {
		this.fat = fat;
	}

	public Integer getCarbs() {
		return carbs;
	}

	public void setCarbs(Integer carbs) {
		this.carbs = carbs;
	}

	public Integer getClient_id() {
		return category_id;
	}

	public void setClient_id(Integer client_id) {
		this.category_id = client_id;
	}
	
}
