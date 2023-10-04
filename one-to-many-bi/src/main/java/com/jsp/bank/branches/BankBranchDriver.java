package com.jsp.bank.branches;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BankBranchDriver {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("tushar");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Bank bank=new Bank();
		bank.setBank_name("SBI");
		
		Branch branch1=new Branch();
		branch1.setBranch_name("Vashi");
		
		Branch branch2=new Branch();
		branch2.setBranch_name("Thane");
		
		Branch branch3=new Branch();
		branch3.setBranch_name("Panvel");
		
		Branch branch4=new Branch();
		branch4.setBranch_name("Pune");
		
		List<Branch> branches=new ArrayList<Branch>();
		branches.add(branch4);
		branches.add(branch3);
		branches.add(branch2);
		branches.add(branch1);
		
		//set branches to bank
		bank.setBranches(branches);
		
		//setting bank to multiple branch
		branch1.setBank(bank);
		branch2.setBank(bank);
		branch3.setBank(bank);
		branch4.setBank(bank);
		
		entityTransaction.begin();
		entityManager.persist(bank);
		entityManager.persist(branch1);
		entityManager.persist(branch2);
		entityManager.persist(branch3);
		entityManager.persist(branch4);
		entityTransaction.commit();
	}

}
