package org.ssa.tiy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Major")
public class Major {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	@Column(name="description")
	String description;
	
	@Column(name="req_sat")
	int req_sat;

	public Major(){
		
	}
	public Major(String description, int req_sat) {
		this.description = description;
		this.req_sat = req_sat;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public int getReq_sat() {
		return req_sat;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setReq_sat(int req_sat) {
		this.req_sat = req_sat;
	}
	
	
}
