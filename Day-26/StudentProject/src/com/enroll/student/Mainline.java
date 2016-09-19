package com.enroll.student;

import java.util.ArrayList;

public class Mainline {
	
	public static void main(String[] args) throws Exception{
		try{
			
			 Student stud = new Student();
		
			 stud.select("select * from student ", "gpa > 3.3 ", "last_name");
			 
			 stud.select("select * from student ", null, null);
			 
			 stud.getMajorListForStudent(100); // Get all Major possible for this student
			 stud.assignMajor(100, "Finance"); // assigns major if sat is eligible
			 stud.classesForStudent(100,true); // Lists all Required classes for this student's Major 
			 stud.classesForStudent(100,false); // Lists all Elective classes for this student's Major 
			 
			 System.out.println(stud.getStudentById(100)); //Print one student by id 
			 
			 //Prints all students 
			 ArrayList<Student> allStudents = Students.getAll();
			 for(Student student : allStudents) {
				 System.out.println(student);
//			        student.print(student);
			    }
			 
			 
			 // Prints all Majors
			 Majors.getAllMajors();
			 
			 for(Major major : Majors.allMajor) {
			        major.print(major);
			 }
			 
			 Major m = new Major();
			 m.getMajorById(11); // Prints major by id
			 
		 
		}
		catch(Exception ex){
			System.out.println("\n"+ ex.getMessage());
//			ex.printStackTrace();
		}
	}
	
}
