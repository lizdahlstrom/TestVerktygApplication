package testVerktyg.clientFXML;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import testVerktyg.Test;

public class TestViewController implements Initializable {
	// Instance variables
	@FXML
	private VBox view;
	@FXML
	private VBox centerVbox;
	@FXML
	private Label lblQuestion = new Label();
	@FXML
	private ToggleGroup tGroup = new ToggleGroup();
	private int questionCount = 0;
	private int questionNum;
	private int count;

	private ArrayList<RadioButton> btnList = new ArrayList<>();
	private Test test;

	// Constructor
	public TestViewController() {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	private void generateView() {

	}

	public void setlblQuestion(String strQuestion) {
		lblQuestion.setText(strQuestion);
	}
}