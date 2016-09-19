package com.enroll.student;

import java.util.ArrayList;

public class Majors {

	static ArrayList<Major> allMajor = new ArrayList<>();
	
//	public static  ArrayList<Major> getAllMajors() throws Exception{
	public static void  getAllMajors() throws Exception{
		DBcalls.getAllMajors();
//		return allMajor;
	}
	
}
