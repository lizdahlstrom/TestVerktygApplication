package testVerktyg;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Denna klassen talar 
@Entity
@Table
public class TestEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int testId;
	@ManyToOne
	private Users users;

	public TestEntity(int testId, Users users) {
		super();
		this.testId = testId;
		this.users = users;
	}

	public TestEntity() {
		super();
	}

	public Users getUsers() {
		return users;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

}
