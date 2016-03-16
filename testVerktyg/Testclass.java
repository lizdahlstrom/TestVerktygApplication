package testVerktyg;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Testclass extends Application {
	// Views
	@FXML
	private Label label;
	@FXML
	private TextField field;

	private TestClassMain inlog;

	public void setTestToolApp(TestClassMain inlog) {
		this.inlog = inlog;
	}

	public void handleButton() {
		String text = field.getText();
		label.setText(text);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

	}

}
