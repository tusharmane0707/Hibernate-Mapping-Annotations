package com.jsp.vehicle.registration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CarTestSave {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("tushar");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Vehicle vehicle=new Vehicle();
		vehicle.setBrand("BMW");
		vehicle.setName("X7");
		vehicle.setPrice(2345678324.00);
		vehicle.setColor("Black");
	
		
		Registration registration=new Registration();
		registration.setRegistration_no("DL01BH5678");
		registration.setCity("Delhi");
		registration.setVehicle(vehicle);
		
		entityTransaction.begin();
		entityManager.persist(vehicle);
		entityManager.persist(registration);
		entityTransaction.commit();
	}

}
