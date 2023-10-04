package com.jsp.Student.course;

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
		
		Student student1=new Student();
		student1.setName("Rahul");
		student1.setEmail("rahul@mail.com");
		
		Student student2=new Student();
		student2.setName("Ram");
		student2.setEmail("ram@mail.com");
		
		Student student3=new Student();
		student3.setName("Sachin");
		student3.setEmail("sachin@mail.com");
		
		Student student4=new Student();
		student4.setName("Shubham");
		student4.setEmail("shubham@mail.com");
		
		
		Course course1=new Course();
		course1.setName("JAVA");
		course1.setDuration("2 Months");
		
		Course course2=new Course();
		course2.setName("SQL");
		course2.setDuration("2 Months");
		
		Course course3=new Course();
		course3.setName("WEB TECH");
		course3.setDuration("1 Months");
		
		Course course4=new Course();
		course4.setName("Advance JAVA");
		course4.setDuration("2 Months");
		
		ArrayList<Course> courses=new ArrayList<Course>();
		courses.add(course4);
		courses.add(course3);
		courses.add(course2);
		courses.add(course1);
		
		ArrayList<Student> students=new ArrayList<Student>();
		students.add(student3);
		students.add(student2);
		students.add(student1);
		students.add(student4);
		
		student1.setCourses(courses);
		student2.setCourses(courses);
		student3.setCourses(courses);
		student4.setCourses(courses);
		
		course1.setStudents(students);
		course2.setStudents(students);
		course3.setStudents(students);
		course4.setStudents(students);
		
		entityTransaction.begin();
//		entityManager.persist(course4);
//		entityManager.persist(course3);
//		entityManager.persist(course2);
//		entityManager.persist(course1);
		entityManager.persist(student4);
		entityManager.persist(student3);
		entityManager.persist(student2);
		entityManager.persist(student1);
		entityTransaction.commit();
		
	}
}


/*
1	2 Months	Advance JAVA
2	1 Months	WEB TECH
3	2 Months	SQL
4	2 Months	JAVA
		


st_id   c_id
1	1
1	2
1	3
1	4
2	1
2	2
2	3
2	4
3	1
3	2
3	3
3	4
4	1
4	2
4	3
4	4


1	shubham@mail.com	Shubham
2	sachin@mail.com	Sachin
3	ram@mail.com	Ram
4	rahul@mail.com	Rahul
		
stid  co_id		
1	1
1	2
1	3
1	4
2	1
2	2
2	3
2	4
3	1
3	2
3	3
3	4
4	1
4	2
4	3
4	4

*/