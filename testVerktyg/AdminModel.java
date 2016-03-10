package testVerktyg;

import java.util.ArrayList;

import javax.persistence.EntityManager;

public class AdminModel {
	private ArrayList<Question> tests;

	public AdminModel() {
	}

	public void makeTest(Question question) {
		tests.add(question);
	}

	public void saveTest(EntityManager entitymanager, int uId) {

		entitymanager.getTransaction().begin();
		User users = new User();
		Test test = new Test();
		Question questions = new Question();
		Choice options = new Choice();

		users.setUId(uId);
		entitymanager.persist(users);

		test.setQuestions(tests);

		entitymanager.persist(test);

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
