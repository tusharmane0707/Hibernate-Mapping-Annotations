package com.jsp.Hospital.Branches;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSave {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("tushar");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		//hospital data set
		Hospital hospital=new Hospital();
		hospital.setHospital_name("MGM");
		hospital.setEmail("mgm@mail.com");
		hospital.setCno(1234567890);
		
		//hospitalbranches object 1
		HospitalBranches brancheHospitalBranches1=new HospitalBranches();
		brancheHospitalBranches1.setBranch_city("Mumbai");
		
		//hospitalbranches object 2
		HospitalBranches brancheHospitalBranches2=new HospitalBranches();
		brancheHospitalBranches2.setBranch_city("Delhi");
		
		//hospitalbranches object 3
		HospitalBranches brancheHospitalBranches3=new HospitalBranches();
		brancheHospitalBranches3.setBranch_city("Chennai");
		
		//hospitalbranches objects are stored in list
		List<HospitalBranches> hospitalBranches=new ArrayList<HospitalBranches>();
		hospitalBranches.add(brancheHospitalBranches3);
		hospitalBranches.add(brancheHospitalBranches2);
		hospitalBranches.add(brancheHospitalBranches1);
		
		//set a hospital with multiple bank branch
		hospital.setHospitalBranches(hospitalBranches);
		
		entityTransaction.begin();
		entityManager.persist(hospital);	//hospital data save
		entityManager.persist(brancheHospitalBranches1);	//hospital branche1 data save
		entityManager.persist(brancheHospitalBranches2);	//hospital branche2 data save
		entityManager.persist(brancheHospitalBranches3);	//hospital branche3 data save
		entityTransaction.commit();
	}
}

/*

Hospital data=
id  cno         email           hospital_name
1	1234567890	mgm@mail.com	MGM


HospitalBranches=
id  branch_city
1	Mumbai
2	Delhi
3	Chennai

//primary_key&forein key of both table
 
hospital_id		hospitalbranches_id
1				1
1				2
1				3
	
*/	
	