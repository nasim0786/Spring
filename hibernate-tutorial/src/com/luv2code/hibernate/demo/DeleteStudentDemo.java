package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 7;
			
			System.out.println("Steudent Id: " + studentId);
			
			session.beginTransaction();
			
			Student student = session.get(Student.class, studentId );
			session.delete(student);
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Delete email of all students");
			session.createQuery("delete Student where id = 8").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			session.close();
		}
	}

}
