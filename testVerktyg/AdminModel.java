package testVerktyg;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdminModel {
	private ArrayList<Form> test;

	public AdminModel() {
	}

	public void makeTest(Form question) {
		test.add(question);
	}

	public void saveTest() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EclipseLink_JPA");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		TestEntity t = new TestEntity();
		Questions questions = new Questions();
		Options options = new Options();

		test.forEach((form) -> {

			questions.setQuestion(form.getQuery());
			entitymanager.persist(questions);

			t.setQuestId(questions.getQuestId());
			entitymanager.persist(t);

			form.getOptions().forEach((option) -> {
				options.setOption(option);
				entitymanager.persist(options);
			});

			form.getCorrAns();

		});

		options.setOption(test.get(0).getQuery());

		entitymanager.persist(test);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}

	public ArrayList<Form> getTest() {
		return test;
	}

}
