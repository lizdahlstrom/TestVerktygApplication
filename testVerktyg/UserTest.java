package testVerktyg;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the user_test database table.
 *
 */
@Entity
@Table(name = "user_test")
@NamedQueries({ @NamedQuery(name = "UserTest.findAll", query = "SELECT u FROM UserTest u"),
		@NamedQuery(name = "UserTest.findById", query = "SELECT u FROM UserTest u WHERE u.id = :id"),
		@NamedQuery(name = "UserTest.findByUserId", query = "SELECT u FROM UserTest u WHERE u.user.uId = :userId"),
		@NamedQuery(name = "UserTest.findByTestId", query = "SELECT u FROM UserTest u WHERE u.test.testId = :testId"),
		@NamedQuery(name = "UserTest.findUsersByTestId", query = "SELECT u.user FROM UserTest AS u WHERE u.test.testId =:testId"),
		@NamedQuery(name = "UserTest.findTestsByUserId", query = "SELECT u.test FROM UserTest AS u WHERE u.user.uId =:userId") })
public class UserTest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	// bi-directional many-to-one association to Test
	@ManyToOne
	@JoinColumn(name = "testId")
	private Test test;

	// bi-directional many-to-one association to User
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