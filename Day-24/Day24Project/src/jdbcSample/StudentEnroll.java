package jdbcSample;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class StudentEnroll {
    static Connection myConn = null;
    static PreparedStatement stmt = null;
    static Statement mystmt= null;
    static ResultSet rs = null;
    static ArrayList<Integer> classes = new ArrayList<>();
    static ArrayList<String> className = new ArrayList<>();
    static ArrayList<String> classType = new ArrayList<>();
    static int class_count =0;
    static int major_id_global =0;
    
    public static void main(String[] args) throws Exception {
    	
    	  deleteStudent(210);
          deleteStudent(220);
          deleteStudent(230);
          deleteStudent(240);
          deleteStudent(250);
          
    	
    	enrollStudent(210,"Adam","Zapel",1200,3.0,0);
    	getMajorId("Finance");
    	updateMajor(210,major_id_global);
    	getReqClass(210,major_id_global);
      	getEleClass(210,major_id_global);
    	
    	enrollStudent(220,"Graham","Krakir",500,2.5,0);
    	getMajorId("General Studies");
    	updateMajor(220, major_id_global);
    	getReqClass(220,major_id_global);
      	getEleClass(220,major_id_global);
      	
    	enrollStudent(230,"Ella","Vader",800,3.0,0);
    	getMajorId("Accounting");
    	updateMajor(230, major_id_global);
    	getReqClass(230,major_id_global);
      	getEleClass(230,major_id_global);
    	
    	enrollStudent(240,"Stanley","Kupp",1350,3.3,0);
    	getMajorId("Engineering");
    	updateMajor(240, major_id_global);
    	getReqClass(240,major_id_global);
      	getEleClass(240,major_id_global);
    	
    	enrollStudent(250,"Lou","Zar",950,3.0,0);
    	getMajorId("Education");
    	updateMajor(250,major_id_global);
    	getReqClass(250,major_id_global);
      	getEleClass(250,major_id_global);
    	
   
    }
    
    private static String getStudentName(int id) throws Exception {
    	String name = "";
        try {
            makeConnection();
            stmt = myConn.prepareStatement("select first_name, last_name  from student where id = ?");
            stmt.setInt(1, id);
             rs = stmt.executeQuery();
             
             if(rs.next())
             name = rs.getString("first_name") + " " + rs.getString("last_name") ;
             
   //          System.out.println(" Name is:"+name);
   //          return name;
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
        	 close();
            return name;
        }
    }
    private static int getStudentSat(int id) throws Exception {
    	int sat=0;
        try {
            makeConnection();
            stmt = myConn.prepareStatement("select sat from student where id = ?");
            stmt.setInt(1, id);
             rs = stmt.executeQuery();
             
             if(rs.next())
             sat = rs.getInt("sat");
             

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
        	 close();
            return sat;
        }
    }
    private static int getStudentMaj(int id) throws Exception {
    	int major_id=0;
        try {
            makeConnection();
            stmt = myConn.prepareStatement("select major_id from student where id = ?");
            stmt.setInt(1, id);
             rs = stmt.executeQuery();
             
             if(rs.next())
            	 major_id = rs.getInt("major_id");
            
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
        	 close();
            return major_id;
        }
    }
    private static void getMajorId(String desc) throws Exception {
    
      try {
            makeConnection();
            stmt = myConn.prepareStatement("select id from major where description = ?");
            stmt.setString(1, desc);
             rs = stmt.executeQuery();
             
             if(rs.next())
            	 major_id_global = rs.getInt("id");
           } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
        	 close();
         
        }
    }
    
    private static String getMajorDesc(int major_id) throws Exception {
    	String desc=" ";
        try {
            makeConnection();
            stmt = myConn.prepareStatement("select description from major where id = ?");
            stmt.setInt(1, major_id);
             rs = stmt.executeQuery();
             
             if(rs.next())
             desc = rs.getString("description");

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
        	 close();
            return desc;
        }
    }
    
    private static void getEleClass(int student_id, int major_id) throws Exception {
    	boolean classPresent = false;
        try {
            makeConnection();
            String sql = "select id from class order by RAND() LIMIT 10 ";
            mystmt= myConn.createStatement();
            rs = mystmt.executeQuery(sql);
           while(rs.next() && class_count < 4 ){
      //  	 System.out.println("class "+rs.getInt("id"));
        	   for (int i=0;i<classes.size();i++){
        		   if (classes.get(i) == rs.getInt("id"))
        			   classPresent = true; 
        	   }
        	   if(!classPresent ){
            	 classes.add(rs.getInt("id"));
            	 classType.add(" elective (not required for major)");
        	   	 class_count++;
        	    }
        		classPresent = false;
           }
           getClassName();
           assignClass(student_id, major_id);
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
        	 close();
            
        }
    }
    
    private static void getReqClass(int student_id, int major_id) throws Exception {
    	int counter;
        try {
        	Integer val = (int) getStudentMaj(student_id);
        	//System.out.println("val = "+val);
        	if (val != 0){
	            makeConnection();
	            stmt = myConn.prepareStatement("select class_id from major_class_relationship where major_id = ?");
	            stmt.setInt(1, major_id);
	             
	            rs = stmt.executeQuery();
	            
	             while(rs.next() && class_count<2){
	            	 
	            	 classes.add(rs.getInt("class_id"));
	            	 classType.add(" required for major");
	            	 class_count++;
	             }
            
        	}
           
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
        	 close();
            
        }
    }
    
    private static void getClassName() throws Exception {
    	String name = "";
        try {
            makeConnection();
            stmt = myConn.prepareStatement("select subject, section  from class where id = ?");
            
            for (int i=0;i<classes.size();i++){
            	stmt.setInt(1, classes.get(i));
            	 rs = stmt.executeQuery();
            	 if(rs.next())
                    className.add(rs.getString("subject") + " " + rs.getInt("section")) ;
            }         
                         
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
        	 close();
           
        }
    }
    private static void getAllMajor(int sat) throws Exception {
    	
        try {
            makeConnection();
            stmt = myConn.prepareStatement("select description from major where req_sat <= ?");
            stmt.setInt(1, sat);
             rs = stmt.executeQuery();
             
             while(rs.next())
            	 System.out.println("* "+ rs.getString("description"));
           
       //      return sat;
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
        	 close();
            
        }
    }
    
    private static int getMajorSat(int major_id) throws Exception {
    	int sat=0;
        try {
            makeConnection();
            stmt = myConn.prepareStatement("select req_sat from major where id = ?");
            stmt.setInt(1, major_id);
             rs = stmt.executeQuery();
             
             if(rs.next())
             sat = rs.getInt("req_sat");
             
//             System.out.println(" maj sat is:"+sat);
       //      return sat;
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
        	 close();
            return sat;
        }
    }
    private static void deleteStudent(int id) throws SQLException {
        try {
            makeConnection();
                
            stmt = myConn.prepareStatement("delete from student_class_relationship where student_id= ? ");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
            stmt = myConn.prepareStatement("delete from student where id= ? ");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
    }
    
    private static void updateMajor(int student_id, int major_id) throws SQLException {
        try {
            
            int major_sat = getMajorSat(major_id);
            String majorDesc = getMajorDesc(major_id);
            int student_sat = getStudentSat(student_id);
            String student_name =  getStudentName(student_id);
            
            makeConnection();
            stmt = myConn.prepareStatement("update student set major_id = ? where id = ?");
            
            if (student_sat >= major_sat){
	            stmt.setInt(1, major_id);
	            stmt.setInt(2, student_id);
	            stmt.executeUpdate();
	            
	            System.out.printf("Assigned %-15s to the %-18s which requires a SAT score of %d \n",student_name,majorDesc,major_sat);
            }else{
            	System.out.printf("Sorry, but a %-18s major requires a SAT of %d \n",majorDesc,major_sat);
            	System.out.printf(" With a SAT of %d, you may choose from the following majors: \n",student_sat);
            	close();
            	getAllMajor(student_sat);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
    }
    
    private static void enrollStudent(int id, String fname, String lname, int sat, double gpa,  int major) throws SQLException {
        try {
            makeConnection();
            stmt = myConn.prepareStatement("insert into student (id,first_name,last_name,sat, gpa, major_id) values(?,?,?,?,?,?)");
            stmt.setInt(1, id);
            stmt.setString(2, fname);
            stmt.setString(3, lname);
            stmt.setInt(4, sat);
            stmt.setDouble(5,gpa);
            if (major == 0)
            	stmt.setNull(6,Types.NULL);
            else
            	stmt.setInt(6, major);
            
            stmt.executeUpdate();
            
        	System.out.println("\nEducation System - Enrollment Process");
    		System.out.println("=====================================");
    		System.out.printf("\nEnrolled %-20s as a new student ",fname+" "+lname);
    		System.out.printf("\n%-15s has a SAT score of %4d \n",fname+" "+lname,sat);
    		
    		
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
    }
    
    private static void assignClass(int student_id, int major_id) throws SQLException {
        try {
        	
        	makeConnection();
            stmt = myConn.prepareStatement("insert into student_class_relationship(student_id,class_id) values(?,?)");
            stmt.setInt(1, student_id);
            
            for (int i=0;i < classes.size(); i++){
            	 stmt.setInt(2, classes.get(i));
            	 stmt.executeUpdate();
            	 System.out.printf(" %d. %15s %s \n",i+1,className.get(i),classType.get(i));
            	 
            }
                     
             class_count = 0;
             classes.clear();
             className.clear(); 
        	 classType.clear();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
    }
    public static void close() throws SQLException {
        if (myConn != null)
            myConn.close();
        if (stmt != null)
            stmt.close();
        if (rs != null)
            rs.close();
    }
    
    private static void makeConnection() throws FileNotFoundException, IOException, SQLException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("demo.properties"));
        String theUser = prop.getProperty("user");
        String thePass = prop.getProperty("password");
        String theDburl = prop.getProperty("url");
        myConn = (Connection) DriverManager.getConnection(theDburl, theUser, thePass);
    }
}