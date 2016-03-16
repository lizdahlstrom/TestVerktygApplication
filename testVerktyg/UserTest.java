package testVerktyg;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_test database table.
 * 
 */
@Entity
@Table(name="user_test")
@NamedQuery(name="UserTest.findAll", query="SELECT u FROM UserTest u")
public class UserTest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Test2
	@ManyToOne
	@JoinColumn(name="testId")
	private Test2 test;

	//bi-directional many-to-one association to User2
	@ManyToOne
	@JoinColumn(name="userId")
	private User2 user;

	public UserTest() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Test2 getTest() {
		return this.test;
	}

	public void setTest(Test2 test) {
		this.test = test;
	}

	public User2 getUser() {
		return this.user;
	}

	public void setUser(User2 user) {
		this.user = user;
	}

}