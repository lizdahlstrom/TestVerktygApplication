package testVerktyg;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQueries({ 
	@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"), 
	@NamedQuery(name = "User.findUserByNameAndPw", 
	query = "SELECT u FROM User u WHERE u.uName =:uName AND u.uPass = :uPass") 
})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int uId;

	private byte isAdmin;

	private String uName;

	private String uPass;

	//bi-directional many-to-one association to Test
	@OneToMany(mappedBy="user")
	private List<Test> tests;

	public User() {
	}

	public int getUId() {
		return this.uId;
	}

	public void setUId(int uId) {
		this.uId = uId;
	}

	public byte getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(byte isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getUName() {
		return this.uName;
	}

	public void setUName(String uName) {
		this.uName = uName;
	}

	public String getUPass() {
		return this.uPass;
	}

	public void setUPass(String uPass) {
		this.uPass = uPass;
	}

	public List<Test> getTests() {
		return this.tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public Test addTest(Test test) {
		getTests().add(test);
		test.setUser(this);

		return test;
	}

	public Test removeTest(Test test) {
		getTests().remove(test);
		test.setUser(null);

		return test;
	}

}