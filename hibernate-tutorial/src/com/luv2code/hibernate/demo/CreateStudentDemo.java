package com.luv2code.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new student");

			Student stu = new Student("Md", "Nasim", DateUtils.parseDate("15/02/1993"), "md.nasim@gmail.com");
			session.beginTransaction();
			System.out.println("Saving Student");
			
			session.save(stu);
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
