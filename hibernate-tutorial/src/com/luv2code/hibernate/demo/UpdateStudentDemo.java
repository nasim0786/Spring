package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 6;
			
			System.out.println("Steudent Id: " + studentId);
			
			session.beginTransaction();
			
			Student student = session.get(Student.class, studentId );
			
			student.setFirstName("Nasim");
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Update email of all students");
			session.createQuery("update Student set email='yahoo.com'").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			session.close();
		}
	}

}
