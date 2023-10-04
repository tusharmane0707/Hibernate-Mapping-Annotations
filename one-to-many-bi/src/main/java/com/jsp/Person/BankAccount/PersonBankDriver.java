package com.jsp.Person.BankAccount;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersonBankDriver {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("tushar");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		
		Person person=new Person();
		person.setName("Rohit");
		person.setEmail("rohit@mail.com");
		
		
		BankAccount bankAccount1=new BankAccount();
		bankAccount1.setBank_name("HDFC");
		//bankAccount1.setIfsc_code("HDFC8765");
		bankAccount1.setPerson(person);		//setting person to multiple banks
	
		BankAccount bankAccount2=new BankAccount();
		bankAccount2.setBank_name("SBI");
		//bankAccount2.setIfsc_code(98765);
		bankAccount2.setPerson(person);	//setting person to multiple banks
		
		
		BankAccount bankAccount3=new BankAccount();
		bankAccount3.setBank_name("BOI");
		//bankAccount3.setIfsc_code("BOI879765");
		bankAccount3.setPerson(person);	//setting person to multiple banks
		
		
		BankAccount bankAccount4=new BankAccount();
		bankAccount4.setBank_name("ICICI");
		//bankAccount4.setIfsc_code("ICICI348765");
		bankAccount4.setPerson(person);	//setting person to multiple banks
		
		List<BankAccount> accounts=new ArrayList<BankAccount>();
		accounts.add(bankAccount4);
		accounts.add(bankAccount3);
		accounts.add(bankAccount2);
		accounts.add(bankAccount1);
		
		person.setAccounts(accounts);	//set branches to bank
		
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
		
		

	}

}
