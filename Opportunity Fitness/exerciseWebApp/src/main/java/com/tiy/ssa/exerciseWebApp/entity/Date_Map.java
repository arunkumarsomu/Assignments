package com.tiy.ssa.exerciseWebApp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="date_map")
public class Date_Map {
	

	 private static final long serialVersionUID = 1L;
	    @Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		Integer id;
	    
		@Column(name="user_id")
		String user_id;
		
		@Column(name="dayNo")
		String dayNo;
		
		@Column(name="date_val")
		Date date_val;

		public Date_Map(String user_id, String dayNo, Date date_val) {
			super();
			this.user_id = user_id;
			this.dayNo = dayNo;
			this.date_val = date_val;
		}
	    
		public Date_Map(){}

		public String getUser_id() {
			return user_id;
		}

		public String getDayNo() {
			return dayNo;
		}

		public Date getDate_val() {
			return date_val;
		}

		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}

		public void setDayNo(String dayNo) {
			this.dayNo = dayNo;
		}

		public void setDate_val(Date date_val) {
			this.date_val = date_val;
		}
		
		
	    
	    
}
