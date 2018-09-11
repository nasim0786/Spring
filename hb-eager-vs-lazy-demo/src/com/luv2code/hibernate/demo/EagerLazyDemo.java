package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

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
			
			/*for (Course course : instructor.getCourses()) {
				System.out.println(course);
			}*/
			
			System.out.println("instructor");
			System.out.println();
			
			System.out.println(instructor);
			
			
			System.out.println("courses");
			System.out.println();
			
			System.out.println(instructor.getCourses());
			
			session.getTransaction().commit();
			session.close();
			
			System.out.println("Session is closed");
			
			System.out.println("courses");
			System.out.println();
			
			
			System.out.println(instructor.getCourses());
			
			System.out.println("Done!");
		} finally {
			session.close();
			
			factory.close();
		}
	}

}
