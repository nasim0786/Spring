package com.luv2code.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating 3 new students");
			Student stu1 = new Student("Nasim", "Md", DateUtils.parseDate("15/02/1993"), "nasim.md@gmail.com");
			Student stu2 = new Student("Md", "Md", DateUtils.parseDate("15/02/1993"), "md.md@gmail.com");
			Student stu3 = new Student("Nasim", "Nasim", DateUtils.parseDate("15/02/1993"), "nasim.nasim@gmail.com");
			
			session.beginTransaction();
			System.out.println("Saving Students");
			
			session.save(stu1);
			session.save(stu2);
			session.save(stu3);
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
