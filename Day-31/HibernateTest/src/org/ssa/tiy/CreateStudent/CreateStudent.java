package org.ssa.tiy.CreateStudent;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ssa.tiy.entity.Student;

 
public class CreateStudent{
	
	public static SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();

	Session session = factory.getCurrentSession();
	
	public final void insertStudent() throws Exception{
	try{
		Student stud = new Student("Riki3","Test3",1500,3.8,2);
		
		session.beginTransaction();
		
		session.save(stud);
				
//		session.getTransaction().commit();
		
	}catch (Exception ex){
		ex.printStackTrace();
	}finally{
		factory.close();
	}
}

	public final void updateStudent() throws Exception{
	try{
		session.beginTransaction();
		if (session.isOpen())
			System.out.println(" session open ");
		
		Query query = session.createQuery("from Student where first_name = :fname");
		query.setParameter("fname", "kiki");
//		List<Student> list = query.list();
//		Student stud = (Student)list.get(0);
		
		Student stud = (Student)query.list().get(0);
		System.out.println(" 3 Here ");
		stud.setLast_name("Newone3");
		
		session.update(stud);
				
		session.getTransaction().commit();
		
	}catch (Exception ex){
		ex.printStackTrace();
	}finally{
		factory.close();
	}
}

	
	public static void main(String[] args)throws Exception{
	
		CreateStudent cr = new CreateStudent();
		cr.insertStudent();
//		cr.updateStudent();
	
		
	}
}
