package testVerktyg;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class TestReader {
	// Instance variables
	private EntityManager eManager;
	private Query query;

	// Constructor
	public TestReader(EntityManager eManager) {
		this.eManager = eManager;
	}

	// Getters and setters
	public Test getTestById(int testId) {
		return eManager.find(Test.class, testId);
	}

	public List<Test> getTestsByUserId(int userId) {
		query = eManager.createNamedQuery("Test.findByUserId", Test.class);
		query.setParameter("uId", userId);
		return query.getResultList();
	}

	public List<Test> getAllTests() {
		query = eManager.createNamedQuery("Test.findAll", Test.class);
		return query.getResultList();
	}

	public List<Test> getAllTestsByUserId(int userId) {
		query = eManager.createNamedQuery("UserTest.findTestsByUserId", Test.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}

	public List<User> getAllUsersByTestId(int testId) {
		query = eManager.createNamedQuery("UserTest.findUsersByTestId", User.class);
		query.setParameter("testId", testId);
		return query.getResultList();
	}

	public List<Choice> getChoiceByQuestionId(int questionId) {
		query = eManager.createNamedQuery("Choice.findByQuestionId", Choice.class);
		query.setParameter("questionId", questionId);
		return query.getResultList();
	}

	public List<Question> getQuestionByTestId(int testId) {
		query = eManager.createNamedQuery("Question.findByTestId", Question.class);
		query.setParameter("testId", testId);
		return query.getResultList();
	}
}
