package org.ssa.tiy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	@Column(name="first_name")
	String first_name;
	
	@Column(name="last_name")
	String last_name;
	
	@Column(name="sat")
	int sat;
	
	@Column(name="gpa")
	double gpa;
	
	@Column(name="major_id")
	int major_id;

	public Student(String first_name, String last_name, int sat, double gpa, int major_id) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.sat = sat;
		this.gpa = gpa;
		this.major_id = major_id;
	}
	public Student() {
	
	}

	public int getId() {
		return id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public int getSat() {
		return sat;
	}

	public double getGpa() {
		return gpa;
	}

	public int getMajor_id() {
		return major_id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setSat(int sat) {
		this.sat = sat;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public void setMajor_id(int major_id) {
		this.major_id = major_id;
	}
	
	
	
	
	
}
