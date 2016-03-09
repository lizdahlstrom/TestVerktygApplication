package testVerktyg;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
// This class is the Model for InlogView which contains two if statements.

public class InlogModel {
// Instance variables
	private Users user = new Users();
	private Users pass = new Users();
	private Boolean bool = false;

//Method isAdmin there the method get the parameters mentioned below.
	public boolean isAdmin(String name, String pw, EntityManagerFactory emfactory, EntityManager entitymanager) {

//Checking if name and password == true or != null	
		if ((user = entitymanager.find(Users.class, name)) != null && (pass = entitymanager.find(Users.class, pw)) != null
				&& user.getId() == pass.getId()) {
//Checking if user == isAdmin
			if ((user = entitymanager.find(Users.class, user)).isAdmin()) {
				bool = true;
			}

		}

		return bool;

	}
//Method isPupil there the method get the parameters mentioned below.
	public boolean isPupil(String name, String pw, EntityManagerFactory emfactory, EntityManager entitymanager) {

//Checking if user == isPupil if it is isAdmin == false. 
		if ((user = entitymanager.find(Users.class, name)) != null && (pass = entitymanager.find(Users.class, pw)) != null
				&& user.getId() == pass.getId()) {
			if ((user = entitymanager.find(Users.class, user)).isAdmin() == false) {
				bool = true;
			}

		}

		return bool;
	}

}


