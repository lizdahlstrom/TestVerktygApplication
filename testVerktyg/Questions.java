package testVerktyg;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Questions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int questId;
	private String question;
	@ManyToOne
	private TestEntity testEntity;

	public Questions(int questId, String question) {
		super();
		this.questId = questId;
		this.question = question;
	}

	public Questions() {
		super();
	}

	public TestEntity getTestEntity() {
		return testEntity;
	}

	public void setTestEntity(TestEntity testEntity) {
		this.testEntity = testEntity;
	}

	public int getQuestId() {
		return questId;
	}

	public void setQuestId(int questId) {
		this.questId = questId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}
