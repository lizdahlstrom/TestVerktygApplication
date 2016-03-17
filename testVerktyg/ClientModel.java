package testVerktyg;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClientModel {
	// Instance variables
	private TestReader testReader;
	private List<Test> tests;
	private List<Question> questions;
	private List<Choice> choices;
	private int userId;

	private EntityManager em;
	private EntityManagerFactory emfactory;
	private int uId = TestToolApp.userId;

	private Test currTest;
	private Question currQuestion;

	private int questionCounter = 0;

	// Constructor
	public ClientModel() {
		emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		em = emfactory.createEntityManager();
		testReader = new TestReader(em);
		loadTests(); // Need DB data for testing
	}

	private void loadTests() { // Uses testreader object to load the tests
		try {
			tests = testReader.getTestsByUserId(uId);
			System.out.println("Successfully loaded tests..;");
		} catch (Exception e) {
			System.out.println("Exception loading tests: " + e);
		}
		System.out.println("loading of tests complete..");

	}

	// Getters and setters
	public List<Test> getTests() {
		return tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public void setCurrTest(String strTest) {
		for (Test test : tests) {
			if (test.getTestTitle() == strTest) {
				currTest = test;
				break;
			}
		}
		;
	}

	public Test getCurrTest() {
		return currTest;
	}

	public void generateQuestion() {
		questions = testReader.getQuestionByTestId(currTest.getTestId());
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public boolean gradeQuestion(Question q, int userChoice) {
		List<Choice> choiceList;
		choiceList = testReader.getChoiceByQuestionId(q.getQuestId());
		for (Choice choice : choiceList) {
			if (choice.getIsTrue() == 1 && choice.getChoiceId() == userChoice) {
				System.out.println("Graded a question correct...");
				return true;
			}
		}
		return false;
	}

	public void gradeTest() {
		Question question = new Question();

		choices = testReader.getChoiceByQuestionId(question.getQuestId());

		choices.forEach(choice -> {
			choice.getIsTrue();
		});
	}

}
