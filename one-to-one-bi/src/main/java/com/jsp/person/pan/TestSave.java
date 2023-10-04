package com.jsp.person.pan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSave {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("tushar");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		
		//person object
		Person person=new Person();
		person.setName("Pratik");
		person.setEmail("pratik@mail.com");
		person.setCno(2454677890l);
		
		//pan object
		Pan pan=new Pan();
		pan.setAddress("UK");
		
		//setting pan with the specified person
		pan.setPerson(person);
		
		//setting person with the specified pan
		person.setPan(pan);
		
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(pan);
		entityTransaction.commit();

	}

}
