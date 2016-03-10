package testVerktyg;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
// This class is the Model for InlogView which contains two if statements.

public class InlogModel {
	// Instance variables
	private User user = new User();
	private User pass = new User();
	private Boolean bool = false;
	private int uId;
	private Query query;
	private int test;

	// Method isAdmin there the method get the parameters mentioned below.
	public Boolean isAdmin(String name, String pw, EntityManagerFactory emfactory, EntityManager em) {
		query = em.createNamedQuery("User.findUserByNameAndPw", User.class);
		query.setParameter("uName", name);
		query.setParameter("uPass", pw);

		// Checking if name and password == true or != null

		if (!(query.getSingleResult()).equals(null)) {
			uId = (int) query.getSingleResult();
			query = em.createNamedQuery("User.findUserAdminStatus", User.class);
			query.setParameter("uId", uId);
			if (query.getSingleResult().equals(1)) {
				bool = true;

			}

		}
		/*
		 * if ((user = em.find(User.class, query.getFirstResult())) != null &&
		 * (pass = em.find(User.class, pw)) != null && user.getUId() ==
		 * pass.getUId()) { // Checking if user == isAdmin if ((user =
		 * em.find(User.class, user)).getIsAdmin() == 1) { uId =
		 * em.find(User.class, user).getUId(); bool = true; }
		 * 
		 * }
		 */

		return bool;

	}

	public int getUId() {
		return uId;
	}

	// Method isPupil there the method get the parameters mentioned below.
	public boolean isPupil(String name, String pw, EntityManagerFactory emfactory, EntityManager entitymanager) {

		// Checking if user == isPupil if it is isAdmin == false.
		if ((user = entitymanager.find(User.class, name)) != null && (pass = entitymanager.find(User.class, pw)) != null
				&& user.getUId() == pass.getUId()) {
			if ((user = entitymanager.find(User.class, user)).getIsAdmin() == 0) {
				bool = true;
				uId = entitymanager.find(User.class, user).getUId();
			}

		}

		return bool;
	}

}
