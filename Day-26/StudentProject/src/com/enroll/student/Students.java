package com.enroll.student;

import java.util.ArrayList;

public class Students {

	static ArrayList<Student> allStudents = new ArrayList<>();
	
	
	public static ArrayList<Student> getAll() throws Exception{
		DBcalls.getAllStudents();
		return allStudents;
	}
}
