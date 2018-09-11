package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(InstructorDetail.class)
			.addAnnotatedClass(Instructor.class)
			.addAnnotatedClass(Course.class)
			.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, 1);
			
			Course course1 = new Course("Java2");
			Course course2 = new Course("C2");
			
			instructor.addCourse(course1);
			instructor.addCourse(course2);
			
			session.save(course1);
			session.save(course2);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			session.close();
			
			factory.close();
		}
	}

}
