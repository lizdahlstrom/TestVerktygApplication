package testVerktyg.adminControllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class QuestionWindowController implements Initializable {

	@FXML // fx:id ="questionWindow"
	private AnchorPane questionWindow;

	@Override
	public void initialize(URL questionWindow, ResourceBundle resources) {

	}

	public AnchorPane getQuestionWindow() {
		return questionWindow;
	}

}
