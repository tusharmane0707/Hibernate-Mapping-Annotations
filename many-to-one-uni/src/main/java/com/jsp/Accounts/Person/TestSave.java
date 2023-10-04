package com.jsp.Accounts.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSave {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("tushar");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		//person data
		Person person=new Person();
		person.setName("Rohit");
		person.setEmail("rohit@mail.com");
		person.setCno(1234567890);
		person.setGender("Male");
		
		//account1 object data
		Account account1=new Account();
		account1.setBank_name("HDFC");
		account1.setIfsc_code("HDFC345689");
		account1.setAcc_no(23465766709l);
		account1.setPerson(person);	//multiple accounts has a one person
		
		//account2 object data
		Account account2=new Account();
		account2.setBank_name("SBI");
		account2.setIfsc_code("SBI348956");
		account2.setAcc_no(87764567l);
		account2.setPerson(person);	//multiple accounts has a one person
		
		//account3 object data
		Account account3=new Account();
		account3.setBank_name("PNB");
		account3.setIfsc_code("PNB35846756O");
		account3.setAcc_no(898473567687l);
		account3.setPerson(person);	//multiple accounts has a one person
		
		
		entityTransaction.begin();
		entityManager.persist(account3);	//account3 object save data
		entityManager.persist(account2);	//account2 object save data
		entityManager.persist(account1);	//account1 object save data
		entityManager.persist(person);		//person save data
		entityTransaction.commit();

	}
}
/*

id  cno         email           gender  name
1	1234567890	rohit@mail.com	Male	Rohit				

id  cno             bank_name 	ifsc_code		person_code
1	898473567687	PNB			PNB35846756O	1
2	87764567		SBI			SBI348956		1
3	23465766709		HDFC		HDFC345689		1
				
*/