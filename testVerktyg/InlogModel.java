package testVerktyg;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
// This class is the Model for InlogView which contains two if statements.

public class InlogModel {
	// Instance variables
	private User user = new User();
	private User pass = new User();
	private Boolean bool = false;

	// Method isAdmin there the method get the parameters mentioned below.
	public boolean isAdmin(String name, String pw, EntityManagerFactory emfactory, EntityManager entitymanager) {

		// Checking if name and password == true or != null
		if ((user = entitymanager.find(User.class, name)) != null && (pass = entitymanager.find(User.class, pw)) != null
				&& user.getUId() == pass.getUId()) {
			// Checking if user == isAdmin
			if ((user = entitymanager.find(User.class, user)).getIsAdmin() == 1) {
				bool = true;
			}

		}

		return bool;

	}

	// Method isPupil there the method get the parameters mentioned below.
	public boolean isPupil(String name, String pw, EntityManagerFactory emfactory, EntityManager entitymanager) {

		// Checking if user == isPupil if it is isAdmin == false.
		if ((user = entitymanager.find(User.class, name)) != null && (pass = entitymanager.find(User.class, pw)) != null
				&& user.getUId() == pass.getUId()) {
			if ((user = entitymanager.find(User.class, user)).getIsAdmin() == 0) {
				bool = true;
			}

		}

		return bool;
	}

}
