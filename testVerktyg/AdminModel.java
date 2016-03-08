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

		Test test = new Test();
		Options options = new Options();

	}

	public ArrayList<Form> getTest() {
		return test;
	}

}
