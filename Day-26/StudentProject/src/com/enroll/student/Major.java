package com.enroll.student;

import java.util.ArrayList;

public class Major {

		int id;
		String description;
		int req_sat;
		ArrayList<Classes> reqClass = new ArrayList<>();
		
		DBcalls db = new DBcalls();
		
		public int getId() {
			return id;
		}
		public String getDescription() {
			return this.description;
		}
		public int getReq_sat() {
			return req_sat;
		}
		 void setId(int id) {
			this.id = id;
		}
		 void setDescription(String description) {
			this.description = description;
		}
		 void setReq_sat(int req_sat) {
			this.req_sat = req_sat;
		}
		public Major() throws Exception {
			
		}
		public Major(int id, String description, int req_sat) throws Exception  {
			this.id = id;
			this.description = description;
			this.req_sat = req_sat;
		}
		
		public boolean validateMajor(Major maj) throws Exception {
			return(db.selectMajor(maj));
		}
		public boolean getMajorDetails(Major maj) throws Exception {
			if(db.selectMajorWithDesc(maj))
				return true;
			return false;
		}
		
		public void getMajorById(int id)throws Exception {
			Major maj = new Major();
			maj.setId(id);
			if (validateMajor(maj))
				maj.print(maj);
			else throw new MyException (" Major ID : "+maj.getId()+" not present in the system ");
		}
		public void print(Major major){
			System.out.printf("\n %5d %-20s %6d ", major.getId(), major.getDescription(), major.getReq_sat() );
		}
		
		
}
