package testVerktyg;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Choices {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int choiceId;
	private String choice;
	private boolean isTrue;

	@ManyToOne
	private Questions questions;

	public Choices(int optionId, String option, boolean isTrue, Questions questions) {
		super();
		this.choiceId = optionId;
		this.choice = option;
		this.isTrue = isTrue;
		this.questions = questions;

	}

	public Choices() {
		super();
	}

	public int getOptionId() {
		return choiceId;
	}

	public void setOptionId(int optionId) {
		this.choiceId = optionId;
	}

	public String getOption() {
		return choice;
	}

	public void setOption(String option) {
		this.choice = option;
	}

	public boolean isTrue() {
		return isTrue;
	}

	public void setTrue(boolean isTrue) {
		this.isTrue = isTrue;
	}

	public Questions getQuestions() {
		return questions;
	}

}
