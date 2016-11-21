package com.tiy.ssa.exerciseWebApp.entity;

import java.util.Date;


public class Exercise_Tracking_Data {

	String dayNo;
	String ex_name;
	Integer numberOfSets;
	Integer numberOfReps;
	Integer timeInMins;
	Date todays_date;
	boolean complete;
	
	public Exercise_Tracking_Data(String dayNo, String ex_name, Integer numberOfSets, Integer numberOfReps,
			Integer timeInMins, Date todays_date, boolean complete) {
		super();
		this.dayNo = dayNo;
		this.ex_name = ex_name;
		this.numberOfSets = numberOfSets;
		this.numberOfReps = numberOfReps;
		this.timeInMins = timeInMins;
		this.todays_date = todays_date;
		this.complete = complete;
	}
	public String getDayNo() {
		return dayNo;
	}
	public String getEx_name() {
		return ex_name;
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
	public boolean isComplete() {
		return complete;
	}
	public void setDayNo(String dayNo) {
		this.dayNo = dayNo;
	}
	public void setEx_name(String ex_name) {
		this.ex_name = ex_name;
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
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	
}
