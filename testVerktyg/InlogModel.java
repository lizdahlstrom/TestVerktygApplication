package testVerktyg;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
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
	private String errorMsg = "Uknown error...";

	// Method isAdmin there the method get the parameters mentioned below.
	public Boolean isAdmin(String name, String pw, EntityManager em) {

		query = em.createNamedQuery("User.findUserByNameAndPw", User.class);

		query.setParameter("uName", name);
		query.setParameter("uPass", pw);
		try {
			// Checking if name and password == true or != null
			user = (User) query.getSingleResult();
			setUId(user.getUId());
			// if (!user.equals(null)) {

			if (user.getIsAdmin() == true) {
				bool = true;

			}
		} catch (Exception e) {
			handleNoResultException(e);
			return false;
		}
		return bool;
	}


	// Method isPupil there the method get the parameters mentioned below.
	public boolean isPupil(String name, String pw, EntityManagerFactory emfactory, EntityManager em) {
		query = em.createNamedQuery("User.findUserByNameAndPw", User.class);
		query.setParameter("uName", name);
		query.setParameter("uPass", pw);
		try {
			if (!user.equals(null)) {
				user = (User) query.getSingleResult();
				setUId(user.getUId());
				if (user.getIsAdmin() == false) {
					bool = true;
				}

			}
		} catch (NoResultException e) {
			handleNoResultException(e);
			return false;
		}

		return bool;
	}

	public boolean isInputValid(String str) {
		if (str != null && !str.isEmpty() && str.length() < 30) {
			return true;
		}
		return false;
	}

	private void handleNoResultException(Exception e) {
		System.out.println("Login exception: " + e);
		errorMsg = new String("Login exception: Incorrect username or password.");
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setUId(int uId){
		this.uId = uId;
	}

	public int getUId() {
		return uId;
	}
}
