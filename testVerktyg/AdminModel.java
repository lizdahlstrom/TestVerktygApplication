package testVerktyg;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class AdminModel {
	private ArrayList<Form> test;
	private int testId = 0;

	public AdminModel() {
	}

	public void makeTest(Form question) {
		test.add(question);
	}

	public void saveTest(EntityManagerFactory emfactory, EntityManager entitymanager) {

		entitymanager.getTransaction().begin();
		Users users = new Users();
		TestEntity testEntity = new TestEntity();
		Questions questions = new Questions();
		Choices options = new Choices();

		test.forEach((form) -> {

			testEntity.setTestId(0);

			questions.setQuestion(form.getQuery());
			questions.setTestEntity(testEntity);
			entitymanager.persist(questions);

			form.getOptions().forEach((option) -> {
				options.setOption(option);

				test.forEach((corr) -> {
					if (options.getOption() == corr.getOptions().get(corr.getCorrAns())) {
						options.setTrue(true);

					} else {
						options.setTrue(false);
					}

				});
				entitymanager.persist(options);
			});

		});

		entitymanager.getTransaction().commit();
	}

	public ArrayList<Form> getTest() {
		return test;
	}

}
