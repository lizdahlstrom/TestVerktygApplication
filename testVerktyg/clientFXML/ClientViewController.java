package testVerktyg.clientFXML;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import testVerktyg.ClientModel;
import testVerktyg.Test;

public class ClientViewController implements Initializable {

	@FXML
	private VBox clientWindow;
	@FXML
	private MenuItem menuShow;
	@FXML
	private MenuItem menuClose;
	@FXML
	private MenuItem menuSave;
	@FXML
	private MenuItem menuQuit;
	@FXML
	private AnchorPane centerContent;
	@FXML
	private Button btnNext;
	@FXML
	private Button btnPrev;
	@FXML
	private Button btnStart;
	@FXML
	private ListView<String> listView;
	@FXML
	private Label lblTitle;
	@FXML
	private Label lblTimer;
	@FXML
	private Label lblQuestionCount;
	@FXML
	private TestViewController testController; // hold testcontroller
	@FXML
	private VBox TestView;

	private ClientModel clientModel = new ClientModel();;

	public ClientViewController() {
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		testController = new TestViewController();
		testController.testsysout();
		TestView.setVisible(false);

		ArrayList <String>arrayList = new ArrayList<>();
		clientModel.getTests().forEach(test ->{
			arrayList.add(Integer.toString(test.getTestId()));
		});
		ObservableList<String> observableList = FXCollections.observableArrayList(arrayList);
		listView.setItems(observableList);
		listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		listView.getSelectionModel().select(0);// selects item with index 0 by default
		listView.setVisible(true);
		btnStart.setVisible(true);
		System.out.println("Updated list of tests...");

		// Actionevents
		menuShow.setOnAction(e -> {

		});
		menuClose.setOnAction(e -> {

		});

		menuSave.setOnAction(e -> {
			// Take testResult from testViewController and send to DB
		});
		menuQuit.setOnAction(e -> {
			Platform.exit();
		});
		btnNext.setOnAction(e -> {
		});
		btnPrev.setOnAction(e -> {

		});

		btnStart.setOnAction(e -> {

			String selectedStr = listView.getSelectionModel().getSelectedItem();
			System.out.println("Selected item:" + selectedStr);

			clientModel.setCurrTest(selectedStr); // Sending testtitle
			// string to set test
			startTest();

		});
		System.out.println("ClientView init complete");
	}

	private void startTest() {
		listView.setVisible(false);
		btnStart.setVisible(false);
		TestView.setVisible(true);
		System.out.println("Starting new test...");
		clientModel.generateQuestion();
		Test test = clientModel.getCurrTest();
		lblTitle.setText("Test title: \" " + test.getTestTitle() + "\" "); // Test title
		lblQuestionCount.setText("Question: " + clientModel.getQuestionCounter() + "/" + clientModel.getQuestionsize());

		// show a question, set label of question, generate optionfields
		testController.testsysout();
		testController.setlblQuestion(clientModel.getCurrQuestion().getQuestion());
		testController.generateView(clientModel.getCurrChoices());
	}

	private void generateOptionButtons() {
		clientModel.getQuestions().get(0);
	}

}