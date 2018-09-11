package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(InstructorDetail.class)
			.addAnnotatedClass(Instructor.class)
			.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Get the object");
			session.beginTransaction();

			InstructorDetail detail = session.get(InstructorDetail.class, 5);
			
			System.out.println("detail: " + detail);
			
			System.out.println("instructor: " + detail.getInstructor());
			
			System.out.println("deleting instructor details: : " + detail);
			
			detail.getInstructor().setInstructorDetail(null); // breaking bi-directional link. instructor -> detail
			session.delete(detail);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}
