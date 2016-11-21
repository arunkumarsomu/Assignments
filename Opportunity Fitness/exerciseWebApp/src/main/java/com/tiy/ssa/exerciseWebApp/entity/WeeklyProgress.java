package com.tiy.ssa.exerciseWebApp.entity;

public class WeeklyProgress {

	Integer day1;
	Integer day1fd[] = {0,0,0,0};
	Integer day2;
	Integer day2fd[] = {0,0,0,0};
	Integer day3;
	Integer day3fd[] = {0,0,0,0};
	Integer day4;
	Integer day4fd[] = {0,0,0,0};
	Integer day5;
	Integer day5fd[] = {0,0,0,0};
	Integer day6;
	Integer day6fd[] = {0,0,0,0};
	Integer day7;
	Integer day7fd[] = {0,0,0,0};
	
	


	public WeeklyProgress(Integer day1, Integer[] day1fd, Integer day2, Integer[] day2fd, Integer day3,
			Integer[] day3fd, Integer day4, Integer[] day4fd, Integer day5, Integer[] day5fd, Integer day6,
			Integer[] day6fd, Integer day7, Integer[] day7fd) {
		super();
		this.day1 = day1;
		this.day1fd = day1fd;
		this.day2 = day2;
		this.day2fd = day2fd;
		this.day3 = day3;
		this.day3fd = day3fd;
		this.day4 = day4;
		this.day4fd = day4fd;
		this.day5 = day5;
		this.day5fd = day5fd;
		this.day6 = day6;
		this.day6fd = day6fd;
		this.day7 = day7;
		this.day7fd = day7fd;
	}




	public WeeklyProgress() {
	
	}




	public Integer getDay1() {
		return day1;
	}




	public Integer[] getDay1fd() {
		return day1fd;
	}




	public Integer getDay2() {
		return day2;
	}




	public Integer[] getDay2fd() {
		return day2fd;
	}




	public Integer getDay3() {
		return day3;
	}



	public Integer[] getDay3fd() {
		return day3fd;
	}




	public Integer getDay4() {
		return day4;
	}




	public Integer[] getDay4fd() {
		return day4fd;
	}




	public Integer getDay5() {
		return day5;
	}




	public Integer[] getDay5fd() {
		return day5fd;
	}




	public Integer getDay6() {
		return day6;
	}




	public Integer[] getDay6fd() {
		return day6fd;
	}




	public Integer getDay7() {
		return day7;
	}




	public Integer[] getDay7fd() {
		return day7fd;
	}




	public void setDay1(Integer day1) {
		this.day1 = day1;
	}




	public void setDay1fd(Integer[] day1fd) {
		this.day1fd = day1fd;
	}




	public void setDay2(Integer day2) {
		this.day2 = day2;
	}




	public void setDay2fd(Integer[] day2fd) {
		this.day2fd = day2fd;
	}




	public void setDay3(Integer day3) {
		this.day3 = day3;
	}




	public void setDay3fd(Integer[] day3fd) {
		this.day3fd = day3fd;
	}




	public void setDay4(Integer day4) {
		this.day4 = day4;
	}




	public void setDay4fd(Integer[] day4fd) {
		this.day4fd = day4fd;
	}




	public void setDay5(Integer day5) {
		this.day5 = day5;
	}




	public void setDay5fd(Integer[] day5fd) {
		this.day5fd = day5fd;
	}




	public void setDay6(Integer day6) {
		this.day6 = day6;
	}




	public void setDay6fd(Integer[] day6fd) {
		this.day6fd = day6fd;
	}




	public void setDay7(Integer day7) {
		this.day7 = day7;
	}




	public void setDay7fd(Integer[] day7fd) {
		this.day7fd = day7fd;
	}


	
	
	
}
