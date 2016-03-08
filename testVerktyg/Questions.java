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
	private int testId;

	public Questions(int questId, String question, int testId) {
		super();
		this.questId = questId;
		this.question = question;
		this.testId = testId;
	}

	public Questions() {
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}
