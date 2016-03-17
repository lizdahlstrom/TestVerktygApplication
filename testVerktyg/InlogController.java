package testVerktyg;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InlogController {
	// Views
	@FXML
	private Label label;
	@FXML
	private TextField field;

	@SuppressWarnings("unused")
	private TestToolApp inlog;

	public void setTestToolApp(TestToolApp inlog) {
		this.inlog = inlog;
	}

	public void handleButton() {
		String text = field.getText();
		label.setText(text);

	}
}
