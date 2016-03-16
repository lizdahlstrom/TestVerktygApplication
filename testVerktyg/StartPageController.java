package testVerktyg;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class StartPageController {
	// private TestToolApp testToolApp;

	@FXML // fx:id ="mILogIn"
	private MenuItem mILogIn;

	public StartPageController() {

	}

	@FXML
	public void initialize() {

		mILogIn.setOnAction(e -> {

			System.out.println("Test!");
			TestToolApp.loginStart();
		});

	}

}
