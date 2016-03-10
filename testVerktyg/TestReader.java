package testVerktyg;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TestReader {
	// Instance variables
	private EntityManager eManager;
	private Query query;

	//Constructor
	public TestReader(EntityManager eManager){
		this.eManager = eManager;
	}
	
	//Getters and setters
	public TestEntity getTestById(int testId){
		return eManager.find(TestEntity.class, testId);
	}
	
	public List <TestEntity> getTestsByUserId(int userId){
		query = eManager.createNamedQuery("TestEntity.findByUserId", TestEntity.class);
		query.setParameter("uId", userId);
		return query.getResultList();
	}
	 
	
	public List <TestEntity> getAllTests(){
		query = eManager.createNamedQuery("TestEntity.findAll", TestEntity.class);
		return query.getResultList();
	}
	
	
}
