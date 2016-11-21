package com.tiy.ssa.exerciseWebApp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="exercise_tracking")
public class Exercise_Tracking {

	 private static final long serialVersionUID = 1L;
	 
	 	@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
	 	int id;
	 	
		@Column(name="user_id")
		String user_id;
		
		@Column(name="dayNo")
		String dayNo;
		
		@Column(name="exercise_id")
		Integer exercise_id;
		
		@Column(name="numberOfSets")
		Integer numberOfSets;
		
		@Column(name="numberOfReps")
		Integer numberOfReps;
		
		@Column(name="timeInMins")
		Integer timeInMins;
		
		@Column(name="todays_date")
		Date todays_date;
		
		@Column(name="complete")
		boolean complete;

		public Exercise_Tracking(String user_id, String dayNo, Integer exercise_id, Integer numberOfSets,
				Integer numberOfReps) {
			this.user_id = user_id;
			this.dayNo = dayNo;
			this.exercise_id = exercise_id;
			this.numberOfSets = numberOfSets;
			this.numberOfReps = numberOfReps;
		}
		
		public Exercise_Tracking() {
		}

		public String getUser_id() {
			return user_id;
		}

		public String getDayNo() {
			return dayNo;
		}

		public Integer getExercise_id() {
			return exercise_id;
		}

		public Integer getNumberOfSets() {
			return numberOfSets;
		}

		public Integer getNumberOfReps() {
			return numberOfReps;
		}

		public Integer getTimeInMins() {
			return timeInMins;
		}

		public Date getTodays_date() {
			return todays_date;
		}

		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}

		public void setDayNo(String dayNo) {
			this.dayNo = dayNo;
		}

		public void setExercise_id(Integer exercise_id) {
			this.exercise_id = exercise_id;
		}

		public void setNumberOfSets(Integer numberOfSets) {
			this.numberOfSets = numberOfSets;
		}

		public void setNumberOfReps(Integer numberOfReps) {
			this.numberOfReps = numberOfReps;
		}

		public void setTimeInMins(Integer timeInMins) {
			this.timeInMins = timeInMins;
		}

		public void setTodays_date(Date todays_date) {
			this.todays_date = todays_date;
		}

		public boolean isComplete() {
			return complete;
		}

		public void setComplete(boolean complete) {
			this.complete = complete;
		}
		
		
}
