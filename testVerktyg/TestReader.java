package testVerktyg;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class TestReader {
	// Instance variables
	private EntityManager eManager;
	private Query query;

	//Constructor
	public TestReader(EntityManager eManager){
		this.eManager = eManager;
	}

	//Getters and setters
	public Test getTestById(int testId){
		return eManager.find(Test.class, testId);
	}

	public List <Test> getTestsByUserId(int userId){
		query = eManager.createNamedQuery("TestEntity.findByUserId", Test.class);
		query.setParameter("uId", userId);
		return query.getResultList();
	}


	public List <Test> getAllTests(){
		query = eManager.createNamedQuery("TestEntity.findAll", Test.class);
		return query.getResultList();
	}
}
