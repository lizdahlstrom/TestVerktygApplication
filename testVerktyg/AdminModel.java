package testVerktyg;

import java.util.ArrayList;

public class AdminModel {
	private ArrayList<ArrayList<Form>> test;

	public AdminModel() {
	}

	public void makeTest(ArrayList<Form> question) {
		test.add(question);
	}

	public void saveTest() {

	}

}
