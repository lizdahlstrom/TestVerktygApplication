package testVerktyg;

import java.util.ArrayList;

public class AdminModel {
	private ArrayList<Form> test;

	public AdminModel() {
	}

	public void makeTest(Form question) {
		test.add(question);
	}

	public void saveTest() {

	}

	public ArrayList<Form> getTest() {
		return test;
	}

}
