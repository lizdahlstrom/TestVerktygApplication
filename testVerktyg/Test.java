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
 * The persistent class for the tests database table.
 *
 */
@Entity
@Table(name = "tests")
@NamedQueries({ @NamedQuery(name = "Test.findAll", query = "SELECT t FROM Test t"),
	@NamedQuery(name = "Test.findByUserId", query = "SELECT t FROM Test t WHERE t.user.uId = :uId") })
public class Test implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int testId;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "uId")
	private User user;

	private String testTitle;

	public Test() {
	}

	public int getTestId() {
		return this.testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTestTitle() {
		return testTitle;
	}

	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", user=" + user + ", testTitle=" + testTitle + "]";
	}

}