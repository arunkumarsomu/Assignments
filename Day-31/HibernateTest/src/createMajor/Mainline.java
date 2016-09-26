package createMajor;

public class Mainline {

	
	public static void main(String[] args)throws Exception{
		
		
		MajorMaintenance cr = new MajorMaintenance();
		try{
			cr.beginTran();
			cr.displayMajors();
			cr.insertMajor("Commerce",950);
			cr.displayMajors();
			cr.updateMajor("Commerce","New Commerce");
			cr.displayMajors();
			cr.deleteMajor("New Commerce");
			cr.displayMajors();
			cr.commitTran();
		}
		catch (Exception ex){
			ex.printStackTrace();
		}finally{
			cr.closeSession();
		}
		
	}
}
