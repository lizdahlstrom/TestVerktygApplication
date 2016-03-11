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
		try{
			// Checking if name and password == true or != null
			user = (User) query.getSingleResult();
			//		if (!user.equals(null)) {

			if (user.getIsAdmin() == true) {
				bool = true;

			}
		}catch(Exception e){
			System.out.println("Login exception: " + e);
		}
		return bool;

	}

	public int getUId() {
		return uId;
	}

	// Method isPupil there the method get the parameters mentioned below.
	public boolean isPupil(String name, String pw, EntityManagerFactory emfactory, EntityManager em) {
		query = em.createNamedQuery("User.findUserByNameAndPw", User.class);
		query.setParameter("uName", name);
		query.setParameter("uPass", pw);
		try{
			if (!user.equals(null)) {
				user = (User) query.getSingleResult();
				if (user.getIsAdmin() == false) {
					bool = true;
				}

			}}catch(Exception e){
				System.out.println("Login exception: " + e);
			}

		return bool;
	}

	public boolean isInputValid(String str){
		if(str != null && str.length()<30){
			return true;
		}		
		return false;
	}
}
