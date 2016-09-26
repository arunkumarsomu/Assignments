package createMajor;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ssa.tiy.entity.Major;

public class MajorMaintenance {
		
		public static SessionFactory factory = new Configuration()
	            .configure("hibernate.cfg.xml")
	            .addAnnotatedClass(Major.class)
	            .buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		public final void displayMajors() throws Exception{
				session.beginTransaction();
				
				Query query = session.createQuery("from Major ");
				List<Major> majors = query.list();
				System.out.println("Major Id        Description       Required SAT");
				System.out.println("********************************************** ");
				for (Major maj : majors ){
					System.out.printf("%2d\t", maj.getId());
					System.out.printf("%20s \t\t", maj.getDescription());
					System.out.printf("%4d\n", maj.getReq_sat());
				}
				
		}
		
		public final void insertMajor(String desc, int reqSat) throws Exception{
			Major maj = new Major(desc,reqSat);
			
//			session.beginTransaction();
			
			session.save(maj);
					
//			session.getTransaction().commit();
			
	}

		public final void updateMajor(String oldDesc, String newDesc) throws Exception{
//			session.beginTransaction();
			
			Query query = session.createQuery("from Major where description = :desc");
			query.setParameter("desc", oldDesc);
//			List<Student> list = query.list();
//			Student stud = (Student)list.get(0);
			
			Major maj = (Major)query.list().get(0);
			maj.setDescription(newDesc);
			
			session.update(maj);
					
//			session.getTransaction().commit();
	}
		
		public final void deleteMajor(String desc) throws Exception{
//				session.beginTransaction();
				
				Query query = session.createQuery("from Major where description = :desc");
				query.setParameter("desc", desc);
				Major maj = (Major)query.list().get(0);
				
				session.delete(maj);
						
//				session.getTransaction().commit();
			
		}
		public final void beginTran() throws Exception {
			
			session.beginTransaction();	
		
		}
		public final void commitTran() throws Exception {
					
			session.getTransaction().commit();	
				
		}
		public final void closeSession() throws Exception {
			
			factory.close();
			
		}


}
