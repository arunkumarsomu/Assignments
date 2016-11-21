package com.tiy.ssa.exerciseWebApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="food_category")
public class Food_Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	@Column(name="description")
	String description;

	public Food_Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Food_Category(Integer food_id, String description) {
		super();
		this.id = food_id;
		this.description= description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String  getClient_id() {
		return description;
	}

	public void setClient_id(String description) {
		this.description = description;
	}
	
}
