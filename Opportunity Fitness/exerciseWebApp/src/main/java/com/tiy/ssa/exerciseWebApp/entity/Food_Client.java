package com.tiy.ssa.exerciseWebApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="food_client")
public class Food_Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id;
			
	@Column(name="food_id")
	Integer food_id;
	
	@Column(name="client_id")
	Integer client_id;

	public Food_Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Food_Client(Integer food_id, Integer client_id) {
		super();
		this.food_id = food_id;
		this.client_id = client_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getFood_id() {
		return food_id;
	}

	public void setFood_id(Integer food_id) {
		this.food_id = food_id;
	}

	public Integer getClient_id() {
		return client_id;
	}

	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}
	
}
