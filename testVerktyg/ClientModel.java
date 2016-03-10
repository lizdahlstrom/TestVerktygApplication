package testVerktyg;

import java.util.List;

import javax.persistence.EntityManager;

public class ClientModel {
	//Instance variables
	private TestReader testReader;
	private List <Test> tests;
	private int userId;
	//Constructor
	public ClientModel(EntityManager em, int userId){
		this.userId = userId;
		testReader = new TestReader(em);
	}
	
	public void loadTests(){ // Uses testreader object to load the tests
		setTests(testReader.getTestsByUserId(userId));
	}
	// Getters and setters
	public List <Test> getTests() {
		return tests;
	}

	public void setTests(List <Test> tests) {
		this.tests = tests;
	}

}
