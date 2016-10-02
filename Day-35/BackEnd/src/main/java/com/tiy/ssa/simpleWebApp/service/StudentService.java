package com.tiy.ssa.simpleWebApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiy.ssa.simpleWebApp.dao.IStudentDAO;
import com.tiy.ssa.simpleWebApp.entity.Student;

@Service
public class StudentService implements IStudentService {

	@Autowired
	private IStudentDAO studentDAO;
	
	@Override
	public List<Student> getAllStudents() {
		return studentDAO.getAllStudents();
	}

	@Override
	public Student getStudentById(int id) {
		return studentDAO.getStudentById(id);
	}

	@Override
	public boolean addStudent(Student student) {
		return studentDAO.addStudent(student);
	}

	@Override
	public void updateStudent(Student student) {
		studentDAO.updateStudent(student);
		
	}

	@Override
	public void deleteStudent(int id) {
		studentDAO.deleteStudent(id);
		
	}

}
