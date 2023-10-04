package com.jsp.Hospital.Branches;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//auto generated id
	private int id;
	private String hospital_name;
	private long cno;
	private String email;
	
	@OneToMany
	private	List<HospitalBranches> hospitalBranches;	//multiple branches accepts

	//getter & setter method for all data members
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHospital_name() {
		return hospital_name;
	}

	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}

	public long getCno() {
		return cno;
	}

	public void setCno(long cno) {
		this.cno = cno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<HospitalBranches> getHospitalBranches() {
		return hospitalBranches;
	}

	public void setHospitalBranches(List<HospitalBranches> hospitalBranches) {
		this.hospitalBranches = hospitalBranches;
	}
	
	

}
