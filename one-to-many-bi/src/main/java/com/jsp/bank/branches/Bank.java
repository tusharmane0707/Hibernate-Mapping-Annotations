package com.jsp.bank.branches;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String bank_name;
	
	//annotation jis side pe hoga foreign key udhar generate hogi
	@OneToMany (mappedBy = "bank")	
	private List<Branch>  branches; 
	
	
	//getter&setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}
	
	

}
