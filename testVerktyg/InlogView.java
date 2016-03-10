package testVerktyg;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//This class is for the inlogGUi with one "OK" button where the user can type in the username and password.

public class InlogView {

	private String name1 = "";
	private String pass1 = "";
	private Stage stage1;

	public InlogView() {

		BorderPane layout = new BorderPane();
		AnchorPane center = new AnchorPane();

		VBox vbox = new VBox(30);

		Label name = new Label("Password");
		center.setTopAnchor(name, 30.0);
		center.setLeftAnchor(name, 30.0);

		TextField text = new TextField();
		center.setTopAnchor(text, 65.0);
		center.setLeftAnchor(text, 10.0);

		Label pass = new Label("Name");
		center.setTopAnchor(pass, 40.0);
		center.setLeftAnchor(pass, 40.0);

		TextField text1 = new TextField();
		center.setTopAnchor(text1, 20.0);
		center.setLeftAnchor(text1, 10.0);

		Button btn = new Button();
		center.setTopAnchor(btn, 350.0);
		center.setLeftAnchor(btn, 350.0);
		btn.setText("OK");

		vbox.getChildren().addAll(name, pass);
		center.getChildren().addAll(vbox, text1, text, btn);

		stage1 = new Stage();
		stage1.setScene(new Scene(center, 400, 400));
		stage1.setTitle("Log in");
		btn.setOnAction(event -> {
			name1 = text.getText();
			pass1 = text1.getText();
			stage1.close();
		});
		stage1.showAndWait(); // Show and wait used for putting all other
								// actions on hold

	}

	public String getName() {
		return name1;
	}

	public String getPass() {
		return pass1;
	}
}