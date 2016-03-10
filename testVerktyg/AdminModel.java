package testVerktyg;

import java.util.ArrayList;

import javax.persistence.EntityManager;

public class AdminModel {
	private ArrayList<Question> tests;
	private Test test;
	private Question questions;
	private int testId = 0;
	private String quest;

	public AdminModel() {
	}

	public void makeTest(Question question) {
		tests.add(question);
	}

	public void saveTest(EntityManager entitymanager) {

		entitymanager.getTransaction().begin();
		User users = new User();
		Test testEntity = new Test();
		Question questions = new Question();
		Choice options = new Choice();

		tests.forEach((form) -> {

			questions.setQuestion(form.getQuestion());

			entitymanager.persist(questions);

			form.getChoices().forEach((option) -> {
				options.setChoice(option.getChoice());

				form.getChoices().forEach((corr) -> {
					if (options.getChoice() == corr.getChoice() && corr.getIsTrue() == 1) {
						options.setIsTrue((byte) 1);

					} else {
						options.setIsTrue((byte) 0);
						;
					}

				});
				entitymanager.persist(options);
			});

		});

		entitymanager.getTransaction().commit();
	}

	public ArrayList<Question> getTests() {
		return tests;
	}

}
