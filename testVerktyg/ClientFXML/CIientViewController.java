package testVerktyg.clientFXML;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
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

public class CIientViewController implements Initializable {

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
	private TestViewController testController; // hold testcontroller
	@FXML
	private VBox TestView;

	private ClientModel clientModel = new ClientModel();;

	public CIientViewController() {
		testController = new TestViewController();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		TestView.setVisible(false);

		// Actionevents
		menuShow.setOnAction(e -> {
			listView = new ListView<>();

			// List<Test> testList = clientModel.getTests();
			// testList.forEach((test) -> {
			// listView.getItems().add(test.getTestTitle());
			// });
			listView.getItems().add("Hello");
			listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			listView.setVisible(true);
			btnStart.setVisible(true);
			System.out.println("Updated list of tests...");

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
			if (listView != null) {
				String selectedStr = listView.getSelectionModel().getSelectedItem();
				// if (selectedStr != null || !selectedStr.isEmpty()) {
				clientModel.setCurrTest(selectedStr); // Sending testtitle
														// string to set test
				startTest();
			} else {

			}
			btnStart.setVisible(false);

		});
		System.out.println("ClientView init complete");
	}

	private void startTest() {
		System.out.println("Starting new test...");
		Test test = clientModel.getCurrTest();
		lblTitle.setText(test.getTestTitle());

		listView.setVisible(false);
		btnStart.setVisible(false);
		TestView.setVisible(true);
		// show a question, set label of question, generate optionfields
		clientModel.getQuestions();

	}

}