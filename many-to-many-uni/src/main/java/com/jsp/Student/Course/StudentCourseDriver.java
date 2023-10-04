package com.jsp.Student.Course;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentCourseDriver {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("tushar");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Student student=new Student();
		student.setName("Rohit");
		student.setEmail("rohit@mail.com");
		
		
		Courses courses1=new Courses();
		courses1.setName("JAVA");
		courses1.setDuration("2 Months");
		
		Courses courses2=new Courses();
		courses2.setName("WEB TECH");
		courses2.setDuration("1 Months");
		
		Courses courses3=new Courses();
		courses3.setName("SQL");
		courses3.setDuration("2 Months");
		
		Courses courses4=new Courses();
		courses4.setName("Advance JAVA");
		courses4.setDuration("3 Months");
		
		ArrayList<Courses> courses=new ArrayList<Courses>();
		courses.add(courses4);
		courses.add(courses3);
		courses.add(courses2);
		courses.add(courses1);
		
		
		student.setCourses(courses);
		
		
		entityTransaction.begin();
		entityManager.persist(student);
		entityManager.persist(courses4);
		entityManager.persist(courses3);
		entityManager.persist(courses2);
		entityManager.persist(courses1);
		entityTransaction.commit();
	}

}
