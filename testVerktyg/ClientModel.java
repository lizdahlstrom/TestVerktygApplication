package testVerktyg;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClientModel {
	// Instance variables
	private TestReader testReader;
	private List<Test> tests;
	private List<Question> questions = new ArrayList<>();
	private List<Choice> choices = new ArrayList<>();
	private int userId;

	private EntityManager em;
	private EntityManagerFactory emfactory;
	private int uId = TestToolApp.userId;

	private Test currTest = new Test();
	private Question currQuestion = new Question();

	private int questionsize;


	private int questionCounter = 0;
	private int corrQuestionCount = 0;

	// Constructor
	public ClientModel() {
		emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		em = emfactory.createEntityManager();
		testReader = new TestReader(em);
		System.out.println(testReader.getChoiceByQuestionId(2).toString());
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
		questionCounter++;
	}

	public void gradeQuestion(Question q, int userChoice) { // take in question and userChoice
		List<Choice> choiceList;
		choiceList = testReader.getChoiceByQuestionId(q.getQuestId());
		for (Choice choice : choiceList) {
			if (choice.getIsTrue() && choice.getChoiceId() == userChoice) {
				System.out.println("Graded a question correct...");
				corrQuestionCount++;
			}
		}
	}

	public void gradeTest() {
		Question question = new Question();

		choices = testReader.getChoiceByQuestionId(currQuestion.getQuestId());

		choices.forEach(choice -> {
			choice.getIsTrue();
		});
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

	public void setCurrTest(int testId) {
		for (Test test : tests) {
			if (testId == test.getTestId()) {
				currTest = test;
				System.out.println("Found test, set test: " + currTest.getTestTitle());
				questionsize = testReader.getQuestionByTestId(currTest.getTestId()).size(); // sets
				System.out.println("Sert current test to:" + currTest.getTestTitle());
				break;
			}
		}
		;
	}

	public void resetQuestionVariables(){

	}

	public Test getCurrTest() {
		return currTest;
	}

	public List<Choice> getCurrChoices() {
		return choices;
	}

	public Question getCurrQuestion(){
		return currQuestion;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public int getQuestionsize() {
		return questionsize;
	}

	public void setQuestionsize(int questionsize) {
		this.questionsize = questionsize;
	}

	public int getQuestionCounter() {
		return questionCounter;
	}

	public int getCorrQuestionCount() {
		return corrQuestionCount;
	}


}
