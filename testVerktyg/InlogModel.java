package testVerktyg;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class InlogModel {

	private Users user = new Users();
	private Users pass = new Users();
	private Boolean bool = false;

	public boolean isAdmin(String name, String pw, EntityManagerFactory emfactory, EntityManager entitymanager) {
		// EntityManagerFactory emfactory =
		// Persistence.createEntityManagerFactory("Eclipselink_JPA");
		// EntityManager entitymanager = emfactory.createEntityManager();
		if ((user = entitymanager.find(Users.class, name)) != null && (pass = entitymanager.find(Users.class, pw)) != null
				&& user.getId() == pass.getId()) {

			if ((user = entitymanager.find(Users.class, user)).isAdmin()) {
				bool = true;
			}

		}

		return bool;

	}

	public boolean isPupil(String name, String pw, EntityManagerFactory emfactory, EntityManager entitymanager) {
		// EntityManagerFactory emfactory =
		// Persistence.createEntityManagerFactory("Eclipselink_JPA");
		// EntityManager entitymanager = emfactory.createEntityManager();
		if ((user = entitymanager.find(Users.class, name)) != null && (pass = entitymanager.find(Users.class, pw)) != null
				&& user.getId() == pass.getId()) {
			if ((user = entitymanager.find(Users.class, user)).isAdmin() == false) {
				bool = true;
			}

		}

		return bool;
	}

}

// if sats jämföra string name och string pw om det är admin returna true
