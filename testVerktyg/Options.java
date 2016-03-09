package testVerktyg;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Options {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int optionId;
	private String option;
	private boolean isTrue;

	@ManyToOne
	private Questions questions;

	public Options(int optionId, String option, boolean isTrue, Questions questions) {
		super();
		this.optionId = optionId;
		this.option = option;
		this.isTrue = isTrue;
		this.questions = questions;

		// this.questId = questId;
	}

	public Options() {
		super();
	}

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
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
