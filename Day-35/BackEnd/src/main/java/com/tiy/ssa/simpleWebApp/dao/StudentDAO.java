package com.tiy.ssa.simpleWebApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tiy.ssa.simpleWebApp.entity.Student;

@Transactional
@Repository
public class StudentDAO implements IStudentDAO {

    @Autowired
    private HibernateTemplate  hibernateTemplate;

    @SuppressWarnings("unchecked")
    @Override
    public List<Student> getAllStudents() {
        String hql = "FROM Student as s ORDER BY s.id";
        return (List<Student>) hibernateTemplate.find(hql);
    }
    
    @Override
    public Student getStudentById(int id) {
    	Student stud=(Student)hibernateTemplate.get(Student.class,id);  
    	System.out.println("sutdent name:"+stud.getFirst_name());
        return stud;  
    }

    @Override
    public boolean addStudent(Student student) {
    	hibernateTemplate.save(student);
        return true;
    }

    @Override
    public void updateStudent(Student student) {
    	hibernateTemplate.update(student);
    }

    @Override
    public void deleteStudent(int id) {
    	Student stud=(Student)hibernateTemplate.get(Student.class,id);  
    	hibernateTemplate.delete(stud);
        
    }
}