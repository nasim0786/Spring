package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(InstructorDetail.class)
			.addAnnotatedClass(Instructor.class)
			.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Deleting the object");
			session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, 1);

			System.out.println("Found instructor: " + instructor);
			
			if (instructor != null) {
				session.delete(instructor);
			}
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			session.close();
		}
	}

}
