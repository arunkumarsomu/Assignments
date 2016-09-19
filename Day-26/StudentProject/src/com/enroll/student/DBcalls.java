package com.enroll.student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBcalls {

	    static Connection myConn = null;
	    static PreparedStatement stmt = null;
	    static Statement mystmt= null;
	    static ResultSet rs = null;
	    
	    public DBcalls() throws Exception{
	    	makeConnection();
	    }
	    
	    public static void makeConnection() throws FileNotFoundException, IOException, SQLException {
	        Properties prop = new Properties();
	        prop.load(new FileInputStream("demo.properties"));
	        String theUser = prop.getProperty("user");
	        String thePass = prop.getProperty("password");
	        String theDburl = prop.getProperty("url");
	        myConn = (Connection) DriverManager.getConnection(theDburl, theUser, thePass);
	    }
	    public  void close() throws SQLException {
	        if (myConn != null)
	            myConn.close();
	        if (stmt != null)
	            stmt.close();
	        if (rs != null)
	            rs.close();
	    }
	    public  boolean selectMajor(Major maj) throws Exception{
	    	stmt = myConn.prepareStatement("select *  from major where id = ?");
	    	stmt.setInt(1, maj.getId());
	    	rs = stmt.executeQuery();
	    	if(rs.next()){
	    		setMajor(maj);
	    		return true;
			} 
			return false;
		}
	    
	    public  boolean selectMajorWithDesc(Major maj) throws Exception{
	    	stmt = myConn.prepareStatement("select *  from major where description = ?");
	    	stmt.setString(1, maj.description);
	    	rs = stmt.executeQuery();
	    	if(rs.next()){
	    		setMajor(maj);
	    		return true;
			} 
			return false;
		}
	    
	    public  boolean insertStudent(String fname, String lname, int sat, double gpa, int maj) throws Exception{
//	    	makeConnection();
	    	if (maj == -1)
	    		stmt = myConn.prepareStatement("insert into student(first_name,last_name,sat,gpa) values(?,?,?,?) ");
	    	else {
	    		stmt = myConn.prepareStatement("insert into student(first_name,last_name,sat,gpa,major_id) values(?,?,?,?,?) ");
	            stmt.setInt(5, maj);
	    	}
	    	stmt.setString(1, fname);
            stmt.setString(2, lname);
            stmt.setInt(3, sat);
            stmt.setDouble(4,gpa);
            int count = stmt.executeUpdate();
	    	if(count > 0){
	    		return true;
			} 
			return false;
		} 
	    
	    public  boolean insertStudent(String fname, String lname, int sat, double gpa) throws Exception{
	    	int maj = -1;
	    	return(insertStudent(fname,lname,sat,gpa,maj));
	   
		}
	    
	    public  boolean updateStudentMajor(Student stud, int major) throws Exception{
	    	stmt = myConn.prepareStatement("update student set major_id = ? where id = ? ");
            stmt.setInt(1, major);
            stmt.setInt(2, stud.id);
            int count = stmt.executeUpdate(); 
	    	if(count > 0){
	    		return true;
			}
	    	return false;
		}
	    
	    public  boolean selectStud(Student stud,boolean idYes) throws Exception{
	    	if(idYes){
	    		stmt = myConn.prepareStatement("select id, first_name,last_name, sat, gpa from student where id = ? ");
	    		stmt.setInt(1, stud.getId());
	    	}
	    	else{
	    		stmt = myConn.prepareStatement("select id,first_name,last_name, sat, gpa from student where first_name = ? and last_name = ? ");
	    		stmt.setString(1, stud.getFirst_name());
		    	stmt.setString(2, stud.getLast_name());
	    	}
	    	
	    	rs = stmt.executeQuery();
	    	if(rs.next()){
	    		setStudent(stud);
	    		return true;
			} 
			return false;
		}
	    
	    public static  void getAllMajors() throws Exception{
	    	stmt = myConn.prepareStatement("select * from major");
	    	rs = stmt.executeQuery();
	    	while(rs.next()){
	    		Major major = new Major();
	    		setMajor(major);
	    		Majors.allMajor.add(major);
			} 
		}
	    
	    
	    public void getClassesForStudent(Student stud, boolean reqOrEle)throws Exception{
	    	if (reqOrEle){
	    		stmt = myConn.prepareStatement(
	    									" select * from class where class.id in ( " + 
	    									"select major_class_relationship.class_id from student, major_class_relationship where " +
	    								   "student.id = ?  and " +
	    								   " major_class_relationship.class_id not in (  select  class_id  from student_class_relationship where student_id = ? ) " +
	    								   " and  major_class_relationship.major_id = (select  major_id from student where student.id = ?) )") ;
	    		stmt.setInt(3, stud.getId());
	    	}
	    	else{
		    	stmt = myConn.prepareStatement(
			    		"	  select * from class where class.id not in " 			+
			    		"	  ( select student_class_relationship.class_id "		+
			    		"	  from  student_class_relationship where "				+
			    		"		student_class_relationship.student_id = ? ) and "	+
			    		"	    class.id not in  "									+
			    		"	(select major_class_relationship.class_id "				+
			    		"	  from  major_class_relationship, student where "		+
			    		"	    major_class_relationship.major_id = student.major_id and student.id = ?) ") ;
	    	}
	    	stmt.setInt(1, stud.getId());
	    	stmt.setInt(2, stud.getId());
	    	rs = stmt.executeQuery();
	    	while(rs.next()){
	    		Classes aClass = new Classes();
	    		setClass(aClass);
	    		stud.allClass.add(aClass);
			} 
	    }
	    
	    public static void getAllStudents() throws Exception{
	    	stmt = myConn.prepareStatement("select *  from student ");
	    	rs = stmt.executeQuery();
	    	while(rs.next()){
	    		Student stud = new Student();
	    		setStudent(stud);
	    		Students.allStudents.add(stud);
			} 
	    }
	    
	    public static void setStudent(Student stud)throws Exception{
	    	stud.setId(rs.getInt("id"));
    		stud.setFirst_name(rs.getString("first_name"));
    		stud.setLast_name(rs.getString("last_name"));
    		stud.setSat(rs.getInt("sat"));
    		stud.setGpa(rs.getDouble("gpa"));
	    }
	    
	    public static void setMajor(Major maj) throws Exception{
	    	maj.setId(rs.getInt("id"));
    		maj.setDescription((rs.getString("description")));
    		maj.setReq_sat(rs.getInt("req_sat"));
	    }
	    
	    public static void setClass(Classes aClass) throws Exception{
	    	aClass.setId(rs.getInt("id"));
    		aClass.setSubject(rs.getString("subject"));
    		aClass.setSection(rs.getInt("section"));
    		aClass.setInstructor(rs.getInt("instructor_id"));
	    }
	    
	    public void select(String sql)throws Exception{
	    	 mystmt= myConn.createStatement();
	            rs = mystmt.executeQuery(sql);
	            while(rs.next()){
		    		Student stud = new Student();
		    		setStudent(stud);
		    		System.out.println(stud);
				} 
	    }
}
