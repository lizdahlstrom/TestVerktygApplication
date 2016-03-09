package testVerktyg;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Denna klassen talar 
@Entity
@Table
public class TestEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int testId;

	public TestEntity(int testId) {
		super();
		this.testId = testId;
	}

	public TestEntity() {
		super();
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

}
