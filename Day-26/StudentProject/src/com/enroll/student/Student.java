package com.enroll.student;

import java.util.*;

public class Student {
	
	int id;
	String first_name;
	String last_name;
	int sat;
	double gpa;
	int major_id;
	ArrayList<Classes> allClass = new ArrayList<>();
	DBcalls dbcall = new DBcalls();
	public int getId() {
		return id;
	}

	 void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	 void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	 void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getSat() {
		return sat;
	}

	 void setSat(int sat) throws Exception {
		 if ( sat >= 0 && sat <= 1600 )
			 this.sat = sat;
		 else 
				throw new MyException("Invalid SAT score for student  "+this.first_name+" "+this.last_name);
	}

	public double getGpa() {
		return gpa;
	}

	 void setGpa(double gpa) throws Exception  {
		if ( gpa >= 0.0 && gpa < 4.0)
			this.gpa = gpa;
		else 
			throw new MyException("Invalid GPA  for student  "+this.first_name+" "+this.last_name);
	}

	public int getMajor_id() {
		return major_id;
	}

	 void setMajor_id(int major_id) throws Exception {
		Major maj = new Major();
		maj.setId(major_id);
		if(maj.validateMajor(maj))
			this.major_id = major_id;
		else
			throw new MyException ("Invalid Major for student  "+this.first_name+" "+this.last_name);
	}
	
	public Student()throws Exception{
	}

	public Student( String first_name, String last_name, int sat, double gpa, int major_id) throws Exception {
		this.setFirst_name(first_name);
		this.setLast_name(last_name);
		this.setSat(sat);
		this.setGpa(gpa);
		this.setMajor_id(major_id);
		try{
			if(dbcall.insertStudent(this.first_name,this.last_name,this.sat,this.gpa,this.major_id))
				System.out.println("Student record created for "+this.first_name+ " "+this.last_name);
			else
				throw new MyException("Student record creation failed for "+this.first_name+ " "+this.last_name);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}	
	}
	
	public Student( String first_name, String last_name, int sat, double gpa) throws Exception {
		this.setFirst_name(first_name);
		this.setLast_name(last_name);
		this.setSat(sat);
		this.setGpa(gpa);
		try{
			if(dbcall.insertStudent(this.first_name,this.last_name,this.sat,this.gpa))
				System.out.println("Student record created for "+this.first_name+ " "+this.last_name);
			else
				throw new MyException("Student record creation failed for "+this.first_name+ " "+this.last_name);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}

	public void assignMajor(String fname, String lname,String majDesc)throws Exception{
		Student stud = validateAndSelectStudent(fname,lname);
		assignMajor(stud.getId(),majDesc);
	}
	
	public void assignMajor(int id, String majDesc) throws Exception{
		Major maj = new Major();
		maj.setDescription(majDesc);
		Student stud = validateAndSelectStudent(id);
		try{
		if(maj.getMajorDetails(maj)){
			
			if(stud.getSat() >= maj.getReq_sat()){
				if (dbcall.updateStudentMajor(stud,maj.id)) 
					System.out.println("Student ID : "+stud.getId() +" Name : " + stud.getFirst_name()+" "+stud.getLast_name() + " has been assigned Major of "+ maj.getDescription() );
				else
					throw new MyException("Major assignment failed for student "+stud.getFirst_name()+" "+stud.getLast_name());
			}
			else {
				System.out.println("Student ID : "+stud.getId() +" Name : "+stud.getFirst_name()+" "+stud.getLast_name() + " has a SAT score of "+ stud.getSat() + 
			   " but major "+ maj.getDescription()+ " requires SAT of "+maj.getReq_sat());
				getMajorListForStudent(stud.getId());
			}
		}else throw new MyException("Entered major "+majDesc+ " is not present in the system");
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public void classesForStudent(String fname, String lname, boolean reqOrEle) throws Exception{
		Student stud = validateAndSelectStudent(fname,lname);
		classesForStudent(stud.getId(),reqOrEle);
	}
	
	public void classesForStudent(int id, boolean reqOrEle) throws Exception{
		Student stud = validateAndSelectStudent(id);
		dbcall.getClassesForStudent(stud,reqOrEle);
		if(reqOrEle)
			System.out.println("\n All required Classes for your major : ");
		else
			System.out.println("\n All elective Classes for your major : ");
		for (int i=0;i<stud.allClass.size();i++)
			System.out.println(" * "+ stud.allClass.get(i).getSubject()+ " "+ stud.allClass.get(i).getSection());
	}
	public void getMajorListForStudent(String fname, String lname)throws Exception{
		Student stud = validateAndSelectStudent(fname,lname);
		getMajorListForStudent(stud.getId());
	}
	
	public void getMajorListForStudent(int id)throws Exception{
		Student stud = validateAndSelectStudent(id);
		System.out.println(" \nAvailable majors for your SAT score : "+stud.getSat());
		 Majors.getAllMajors();
		for (int i=0; i <Majors.allMajor.size();i++){
			if (Majors.allMajor.get(i).getReq_sat() <= stud.getSat())
				System.out.println(" * "+ Majors.allMajor.get(i).getDescription()+ " SAT req is :"+ Majors.allMajor.get(i).getReq_sat());
		}
		Majors.allMajor.clear();
	}
	public Student validateAndSelectStudent(String fname, String lname)throws Exception{
		Student stud = new Student();
		boolean idYes = false;
		stud.setFirst_name(fname);
		stud.setLast_name(lname);
		
		if (!dbcall.selectStud(stud,idYes))
					throw new MyException("Student "+fname+" "+lname + " is not present in the system");
		
		return stud;
	}
	public Student validateAndSelectStudent(int id)throws Exception{
		Student stud = new Student();
		stud.setId(id);
		if (!dbcall.selectStud(stud,true))
					throw new MyException("Student ID "+id+ " is not present in the system");
		
		return stud;
	}
	public Student getStudentById(int id)throws Exception{
		Student stud = validateAndSelectStudent(id);
//		stud.print(stud);
		return(stud);
	}
	
	public void print(Student stud){
		System.out.printf("\n %5d %-15s %-15s %4.2f %4d", stud.getId() , stud.getFirst_name(), stud.getLast_name(), stud.getGpa() , stud.getSat() );
	}
	
	@Override 
	public String toString(){
		return (String.format(" %4d %-30s %4.2f %4d",this.getId(), this.getFirst_name() + " " + this.getLast_name(),this.getGpa(),this.getSat()));
	}
	
	public void select(String sql,String where, String orderBy) throws Exception{
		String SQL = sql;
		
		if (where != null)
			if (!where.isEmpty())
				SQL +=  "where " + where;
		
		if (orderBy != null)
			if (!orderBy.isEmpty())
				SQL +=  "order by " + orderBy;
		
		dbcall.select(SQL);
		
	}

}