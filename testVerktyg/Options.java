package testVerktyg;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Options {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int optionId;
	private String option;
	private boolean isTrue;
	@OneToMany
	private int questId;

	public Options(int optionId, String option, boolean isTrue, int questId) {
		super();
		this.optionId = optionId;
		this.option = option;
		this.isTrue = isTrue;
		this.questId = questId;
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

	public int getQuestId() {
		return questId;
	}

	public void setQuestId(int questId) {
		this.questId = questId;
	}

}
