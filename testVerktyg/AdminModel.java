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

		entitymanager.persist(test);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}

	public ArrayList<Form> getTest() {
		return test;
	}

}
