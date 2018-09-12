package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(InstructorDetail.class)
			.addAnnotatedClass(Instructor.class)
			.addAnnotatedClass(Course.class)
			.addAnnotatedClass(Review.class)
			.addAnnotatedClass(Student.class)
			.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();

			Course course = new Course("Java");			
			
			System.out.println("Saving Course");
			
			session.save(course);
			
			System.out.println("Saved the course");
			
			Student student1 = new Student("Md", "Nasim", "md.nasim@gmail.com");
			Student student2 = new Student("Nasim", "Md", "nasim.md@gmail.com");
			
			System.out.println("Saving students");
			course.addStudent(student1);
			course.addStudent(student2);
			System.out.println("Saved the students: " + course.getStudents());
			
			session.save(student1);
			session.save(student2);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			session.close();
			
			factory.close();
		}
	}

}
