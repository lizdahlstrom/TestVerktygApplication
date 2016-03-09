package testVerktyg;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InlogModel {

	private User user = new User();
	private User pass = new User();
	private Boolean bool = false;

	public boolean isAdmin(String name, String pw) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		EntityManager entitymanager = emfactory.createEntityManager();
		if ((user = entitymanager.find(User.class, name)) != null && (pass = entitymanager.find(User.class, pw)) != null
				&& user.getId() == pass.getId()) {

			if ((user = entitymanager.find(User.class, user)).isAdmin()) {
				bool = true;
			}

		}

		return bool;

	}

	public boolean isPupil(String name, String pw) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		EntityManager entitymanager = emfactory.createEntityManager();
		if ((user = entitymanager.find(User.class, name)) != null && (pass = entitymanager.find(User.class, pw)) != null
				&& user.getId() == pass.getId()) {
			if ((user = entitymanager.find(User.class, user)).isAdmin() == false) {
				bool = true;
			}

		}

		return bool;
	}

}

// if sats jämföra string name och string pw om det är admin returna true
