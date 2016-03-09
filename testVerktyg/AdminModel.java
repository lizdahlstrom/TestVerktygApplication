package testVerktyg;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class AdminModel {
	private ArrayList<Form> test;

	public AdminModel() {
	}

	public void makeTest(Form question) {
		test.add(question);
	}

	public void saveTest(EntityManagerFactory emfactory, EntityManager entitymanager) {
		// EntityManagerFactory emfactory =
		// Persistence.createEntityManagerFactory("EclipseLink_JPA");
		// EntityManager entitymanager = emfactory.createEntityManager();

		entitymanager.getTransaction().begin();

		TestEntity t = new TestEntity();
		Questions questions = new Questions();
		Choices options = new Choices();

		test.forEach((form) -> {

			questions.setQuestion(form.getQuery());
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
		entitymanager.close();
		emfactory.close();
	}

	public ArrayList<Form> getTest() {
		return test;
	}

}
