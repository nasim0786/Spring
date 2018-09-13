package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(InstructorDetail.class)
			.addAnnotatedClass(Instructor.class)
			.addAnnotatedClass(Course.class)
			.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating the object");
			Instructor instructor = new Instructor("Md", "Nasim", "md.nasim@gmail.com");
			
			InstructorDetail detail = new InstructorDetail("http://youtube.com", "Luv 2 code");
			
			instructor.setInstructorDetail(detail);

			session.beginTransaction();
			System.out.println("saving instructor: " + instructor);
			
			session.save(instructor);
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			session.close();
			
			factory.close();
		}
	}

}