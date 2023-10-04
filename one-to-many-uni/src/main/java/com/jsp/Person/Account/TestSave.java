package com.jsp.Person.Account;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSave {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("tushar");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		//person data save
		Person person=new Person();
		person.setName("Mayur");
		person.setEmail("mayur@mail.com");
		person.setCno(1234567890);
		person.setGender("Male");
		
		//Account data object1 save
		Account account1=new Account();
		account1.setAcc_no(234567876);
		account1.setBank_name("SBI");
		account1.setIfsc_code("SBI1234456");
		
		//Account data object2 save
		Account account2=new Account();
		account2.setAcc_no(98765434);
		account2.setBank_name("HDFC");
		account2.setIfsc_code("HDFC71234456");
		
		//Account data object3 save
		Account account3=new Account();
		account3.setAcc_no(123498765);
		account3.setBank_name("ICICI");
		account3.setIfsc_code("ICICI245676709");
		
		//accounts objects are stored in list
		ArrayList<Account> accounts=new ArrayList<Account>();
		accounts.add(account3);
		accounts.add(account2);
		accounts.add(account1);
		
		//set a person with multiple bank accounts
		person.setAccount(accounts);
		
		entityTransaction.begin();
		entityManager.persist(person);		//person data save
		entityManager.persist(account1);	//account 1 data save
		entityManager.persist(account2);	//account 2 data save
		entityManager.persist(account3);	//account 3 data save
		entityTransaction.commit();	
	}

}

/*
 
id  acc_no      bank_name	ifsc_code 
1	234567876	SBI			SBI1234456
2	98765434	HDFC		HDFC71234456
3	123498765	ICICI		ICICI245676709
			

id  cno         email           gender  name
1	1234567890	mayur@mail.com	Male	Mayur
				

//primary key both tables 
person_id	account_id
1			1
1			2
1			3
	
 */
