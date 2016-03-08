package testVerktyg;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class TestEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int testId;
	@ManyToOne
	private int questId;

	public TestEntity(int testId, int questId) {
		super();
		this.testId = testId;
		this.questId = questId;
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

	public int getQuestId() {
		return questId;
	}

	public void setQuestId(int questId) {
		this.questId = questId;
	}

}
