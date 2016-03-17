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
	private int corrQuestionCount = 0;

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
			System.out.println("Successfully loaded tests.. " + tests.toString());
		} catch (Exception e) {
			System.out.println("Exception loading tests: " + e);
		}
	}

	public void generateQuestion() {
		questions = testReader.getQuestionByTestId(currTest.getTestId());
		currQuestion = questions.get(questionCounter);
		choices = testReader.getChoiceByQuestionId(currQuestion.getQuestId());
	}

	public boolean gradeQuestion(Question q, int userChoice) { // take in question and userChoice
		List<Choice> choiceList;
		choiceList = testReader.getChoiceByQuestionId(q.getQuestId());
		for (Choice choice : choiceList) {
			if (choice.getIsTrue() == 1 && choice.getChoiceId() == userChoice) {
				System.out.println("Graded a question correct...");
				corrQuestionCount++;
				return true;
			}
		}
		return false;
	}

	public String getQuestionCountToStr(){
		return questionCounter + " / " + questions.size();
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
				questionCounter = testReader.getQuestionByTestId(currTest.getTestId()).size(); // sets
				// questioncount
				break;
			}
		}
		;
	}

	public Test getCurrTest() {
		return currTest;
	}

	public List<Choice> getChoices() {
		return choices;
	}

	public Question getCurrQuestion(){
		return currQuestion;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void gradeTest() {
		Question question = new Question();

		choices = testReader.getChoiceByQuestionId(currQuestion.getQuestId());

		choices.forEach(choice -> {
			choice.getIsTrue();
		});
	}

}
