package com.tiy.ssa.simpleWebApp.dao;

import java.util.List;

import com.tiy.ssa.simpleWebApp.entity.Student;

public interface IStudentDAO {

	List<Student> getAllStudents();
	Student getStudentById(int studentId);
	boolean addStudent(Student student);
	void updateStudent(Student student);
	void deleteStudent(int studentId);
	
}
