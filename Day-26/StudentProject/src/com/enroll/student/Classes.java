package com.enroll.student;

import java.util.ArrayList;

public class Classes {

	int id;
	String subject;
	int section;
	int instructor;
	ArrayList<Student> allStudent = new ArrayList<>();
	
	public Classes(){
		
	}
	public Classes(int id, String subject, int instructor) {
	
		this.setId(id);
		this.setSubject(subject);
		this.setInstructor(instructor);
	}

	public int getId() {
		return id;
	}

	public String getSubject() {
		return subject;
	}

	public int getSection() {
		return section;
	}
	public int getInstructor() {
		return instructor;
	}

	void setId(int id) {
		this.id = id;
	}

	void setSubject(String subject) {
		this.subject = subject;
	}

	void setSection(int section) {
		this.section = section;
	}
	void setInstructor(int instructor) {
		this.instructor = instructor;
	}
	
	
}
