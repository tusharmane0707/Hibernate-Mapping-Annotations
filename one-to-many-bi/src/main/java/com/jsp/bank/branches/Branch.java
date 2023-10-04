package com.jsp.bank.branches;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	
	private int id;
	private String branch_name;
	
	@JoinColumn
	@ManyToOne	//annotation jis side pe hoga foreign key udhar generate hogi
	private Bank bank; 

	//getter&setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	
}
