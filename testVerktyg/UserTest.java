package testVerktyg;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the user_test database table.
 *
 */
@Entity
@Table(name = "user_test")
@NamedQuery(name = "UserTest.findAll", query = "SELECT u FROM UserTest u")
public class UserTest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	// bi-directional many-to-one association to Test2
	@ManyToOne
	@JoinColumn(name = "testId")
	private Test test;

	// bi-directional many-to-one association to User2
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	public UserTest() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Test getTest() {
		return this.test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}