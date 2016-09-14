package JdbcProject;

import java.util.*;
import java.sql.*;
import java.io.FileInputStream;

public class Jdbc2 {

	public static String userName ;
	public static String passWord ;
	static String url ; 
	static Connection myConn=null;
	static Statement stmt= null;
	static ResultSet rs=null;
	static ArrayList<String> sqlData = new ArrayList<>();
			
	public static void myClose(Connection con, Statement tsmt, ResultSet rs) throws SQLException{
		 if(con != null)
			 con.close();
		 if(stmt != null)
			 stmt.close();
		 if(rs != null)
			 rs.close();
	}
	
	public static void printStudent() throws SQLException {
		
		System.out.print("FirstName :" + rs.getString("first_name") + "   Last Name :" + rs.getString("last_name") );
		System.out.print("   Start Date  :" + rs.getString("start_date") + "   GPA  :" + rs.getDouble("gpa"));
		System.out.print("   SAT  :" + rs.getInt("sat") + "   Major  :" + rs.getInt("major_id") + "\n");
	}
	
	public static void storeStudent() throws SQLException {
		String tempData;
		
		tempData =  "(" + rs.getInt("id") + ", '" + rs.getString("first_name") + "' ,  '" + rs.getString("last_name") +"' , '" + rs.getString("start_date") + "' , " +  
				rs.getDouble("gpa") + " , "+  rs.getInt("sat") +  " , " + rs.getInt("major_id") + ") ;" ;
	//	System.out.println(tempData);
		sqlData.add(tempData);
		
	}
	
	public static void storeMajor() throws SQLException {
		String tempData;
		String sql = "select * from tiy.major" ;
		
		rs= stmt.executeQuery(sql);
				
		while(rs.next()){
		
			tempData =  "(" + rs.getInt("id") + ", '" + rs.getString("name") + "' ,  " + rs.getInt("sat_score") +") ;"; 
			sqlData.add(tempData);
		}
		
	}
	public static void storeClass() throws SQLException {
		String tempData;
		String sql = "select * from tiy.class" ;
		
		rs= stmt.executeQuery(sql);
				
		while(rs.next()){
		
			tempData =  "(" + rs.getInt("id") + ", '" + rs.getString("name") + "' ,  " + rs.getInt("instructor_id") +") ;"; 
			sqlData.add(tempData);
		}
		
	}
	
	public static void storeGrade() throws SQLException {
		String tempData;
		String sql = "select * from tiy.grade" ;
		
		rs= stmt.executeQuery(sql);
				
		while(rs.next()){
		
			tempData =  "(" + rs.getInt("grade_id") + ", '" + rs.getString("grade_value") +"') ;"; 
			sqlData.add(tempData);
		}
		
	}
	public static void storeStudentClassXref() throws SQLException {
		String tempData;
		String sql = "select * from tiy.student_class_xref" ;
		
		rs= stmt.executeQuery(sql);
				
		while(rs.next()){
		
			tempData =  "(" + rs.getInt("id") + ", " + rs.getInt("student_id") + ", "+ rs.getInt("class_id")  +") ;"; 
			sqlData.add(tempData);
		}
		
	}
	public static void storeMajorClassXref() throws SQLException {
		String tempData;
		String sql = "select * from tiy.major_class_xref" ;
		
		rs= stmt.executeQuery(sql);
				
		while(rs.next()){
		
			tempData =  "(" + rs.getInt("id") + ", "+ rs.getInt("major_id") + ", " + rs.getInt("class_id")  +") ;"; 
			sqlData.add(tempData);
		}
		
	}
	public static void selectAllStudent() throws SQLException {
		
		String sql = "select * from tiy.student" ;
		rs= stmt.executeQuery(sql);
				
		while(rs.next()){
			printStudent();
			storeStudent();
		
		}
		
	}	
	
	public static void selectOneStudent(int id) throws SQLException {
		
		String sql = "select * from student where id = " + id;
		rs= stmt.executeQuery(sql);
		
		if (!rs.isBeforeFirst()){
			System.out.println("Selected Student with ID "+ id + " is not present in the Student table \n");
		}
		else
		while(rs.next()){
			printStudent();
		}
		
	}
	
	public static void insertStudent(String input) throws SQLException{
		String sql = " insert into student values "+ input ;
	//	System.out.println(" \n Sql is "+ sql);
		stmt.executeUpdate(sql);
		
	}
	
	public static void updateStudent(String field,  String key, int keyVal, String input) throws SQLException{
		String sql = " update student set " + field + " = " + input + " where " + key + " = " + keyVal;
	//	System.out.println(" \n Sql is "+ sql);
		
		stmt.executeUpdate(sql);
	}
	
	public static void deleteOneStudent(int input) throws SQLException{
		String sql = " delete from student where  id = "+ input ;
	//	System.out.println(" \n Sql is "+ sql);
		stmt.executeUpdate(sql);
		
	}
	
	public static void deleteOneStudent(String lastname, int sat) throws SQLException{
		String sql = " delete from student where  last_name  = "+ "'"+lastname + "' and  sat = " + sat ;
	//	System.out.println(" \n Sql is "+ sql);
		stmt.executeUpdate(sql);
		
	}
	
	
	public static void backup()  throws SQLException  {
		
		System.out.println("/*Student Backup file */ ");
		System.out.println("/*******************/ ");
		String sql = " insert into student( id , first_name , last_name , start_date , gpa , sat , major_id ) values " ;
		for(int i=0; i < sqlData.size(); i++){
			String sqlPrint = sql + sqlData.get(i) ;
			System.out.println(sqlPrint);
		}
		sqlData.clear(); 
		storeMajor();
		System.out.println("/*Major Backup file */ ");
		System.out.println("/*******************/ ");
		
		sql = " insert into major ( id , name , sat_score ) values " ;
		for(int i=0; i < sqlData.size(); i++){
			String sqlPrint = sql + sqlData.get(i) ;
			System.out.println(sqlPrint);
		}
		
		sqlData.clear(); 
		storeClass();
		System.out.println("/*Class Backup file */ ");
		System.out.println("/*******************/ ");
		
		sql = " insert into class ( id , name , instructor_id ) values " ;
		for(int i=0; i < sqlData.size(); i++){
			String sqlPrint = sql + sqlData.get(i) ;
			System.out.println(sqlPrint);
		}				
			
		sqlData.clear(); 
		storeGrade();
		System.out.println("/*Grade Backup file */ ");
		System.out.println("/*******************/ ");
		
		sql = " insert into class ( grade_id , grade_value ) values " ;
		for(int i=0; i < sqlData.size(); i++){
			String sqlPrint = sql + sqlData.get(i) ;
			System.out.println(sqlPrint);
		}
		
			
		sqlData.clear(); 
		storeStudentClassXref();
		System.out.println("/*StudentClassXref Backup file */ ");
		System.out.println("/******************************/ ");
		
		sql = " insert into class ( id , student_id, class_id ) values " ;
		for(int i=0; i < sqlData.size(); i++){
			String sqlPrint = sql + sqlData.get(i) ;
			System.out.println(sqlPrint);
		}
		
		sqlData.clear(); 
		storeMajorClassXref();
		System.out.println("/*MajorClassXref Backup file */");
		System.out.println("/****************************/ ");
		
		sql = " insert into class ( id , major_id, class_id ) values " ;
		for(int i=0; i < sqlData.size(); i++){
			String sqlPrint = sql + sqlData.get(i) ;
			System.out.println(sqlPrint);
		}
		
	}
	public static void main(String[] args) throws SQLException {
		String sql;
		
		try{
			
		Properties props = new Properties();
		props.load(new FileInputStream("demo.properties"));
		
		userName = props.getProperty("user");
		passWord = props.getProperty("password");
		url = props.getProperty("url");
			
		myConn = (Connection) DriverManager.getConnection(url, userName, passWord);
		
		stmt= myConn.createStatement();
		
		System.out.println("/*Select All Before Insert */");
		System.out.println("/***************************/ ");
		selectAllStudent();
		
		sql = "(160, 'George', 'Washington','2016-09-14',4.0,1600,null)";
		
		insertStudent(sql);
		
		System.out.println("\n/*Select One After Insert*/");
		System.out.println("/************************/ ");
		selectOneStudent(160); 
		
		updateStudent("major_id", "id", 160, "1");
		updateStudent("gpa", "id", 160, "3.5");
		updateStudent("sat", "id", 160, "1450");
		
		System.out.println("\n/*Select One After Update*/ ");
		System.out.println("/************************/ ");
		selectOneStudent(160); 
		
	//	deleteOneStudent(160);
		deleteOneStudent("Washington",1450);
		
		System.out.println("\n/*Select One After Delete*/ ");
		System.out.println("/************************/ ");
		selectOneStudent(160);
					
		backup();	
		
		
		}catch(Exception exc){
			
			exc.printStackTrace();
		}finally{
			
			myClose(myConn, stmt, rs);
			
		}
			
					
	}
	
		
	
	
}

