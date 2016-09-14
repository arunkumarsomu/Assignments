package JdbcProject;

import java.util.*;
import java.sql.*;
import java.io.FileInputStream;

public class JdbcStudent {

	public static String userName ;
	public static String passWord ;
	static String url ; 
	static Connection myConn=null;
	static Statement stmt= null;
	static ResultSet rs=null;
			
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
	
	public static void selectAllStudent() throws SQLException {
		
		String sql = "select * from tiy.student" ;
		rs= stmt.executeQuery(sql);
				
		while(rs.next()){
			printStudent();
		
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
		
		System.out.println("Select All Before Insert ");
		System.out.println("************************ ");
		selectAllStudent();
		
		sql = "(160, 'George', 'Washington','2016-09-14',4.0,1600,null)";
		
		insertStudent(sql);
		
		System.out.println("\nSelect One After Insert ");
		System.out.println("************************ ");
		selectOneStudent(160); 
		
		updateStudent("major_id", "id", 160, "1");
		updateStudent("gpa", "id", 160, "3.5");
		updateStudent("sat", "id", 160, "1450");
		
		System.out.println("\nSelect One After Update ");
		System.out.println("************************ ");
		selectOneStudent(160); 
		
		deleteOneStudent(160);
		
		System.out.println("\nSelect One After Delete ");
		System.out.println("************************ ");
		selectOneStudent(160);
					
		
		}catch(Exception exc){
			
			exc.printStackTrace();
		}finally{
			
			myClose(myConn, stmt, rs);
			
		}
			
					
	}
	
	
	
	
	
}

