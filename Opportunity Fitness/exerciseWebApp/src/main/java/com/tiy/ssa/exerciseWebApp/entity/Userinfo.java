package com.tiy.ssa.exerciseWebApp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="userinfo")
public class Userinfo implements Serializable {

	 private static final long serialVersionUID = 1L;
	    @Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		int id;
		
		@Column(name="firstname")
		String firstname;
		
		@Column(name="lastname")
		String lastname;
		
		@Column(name="username")
		String username;
		
		@Column(name="password")
		String password;
		
		@Column(name="start_date")
		Date start_date;
		
		@Column(name="routine_created")
		Boolean routine_created;
		
		@Column(name="caloriesPerDay")
		Integer caloriesPerDay;
		


		public Date getStart_date() {
			return start_date;
		}


		public Boolean getRoutine_created() {
			return routine_created;
		}


		public Integer getCaloriesPerDay() {
			return caloriesPerDay;
		}


		public void setStart_date(Date start_date) {
			this.start_date = start_date;
		}


		public void setRoutine_created(Boolean routine_created) {
			this.routine_created = routine_created;
		}


		public void setCaloriesPerDay(Integer caloriesPerDay) {
			this.caloriesPerDay = caloriesPerDay;
		}


		public int getId() {
			return id;
		}


		public String getFirstname() {
			return firstname;
		}


		public String getLastname() {
			return lastname;
		}


		public String getUsername() {
			return username;
		}


		public String getPassword() {
			return password;
		}


		public void setId(int id) {
			this.id = id;
		}


		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}


		public void setLastname(String lastname) {
			this.lastname = lastname;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public Userinfo() {
		
		}


		public Userinfo(String firstname, String lastname, String username, String password) {
			super();
			this.firstname = firstname;
			this.lastname = lastname;
			this.username = username;
			this.password = password;
		}

		
}
