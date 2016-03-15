package ClientFXML;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

public class CIientViewController implements Initializable {

	@FXML private MenuItem menuShow;
	@FXML private MenuItem menuClose;
	@FXML private MenuItem menuSave;
	@FXML private MenuItem menuQuit;
	@FXML private AnchorPane centerContent;
	@FXML private Button btnNext;
	@FXML private Button btnPrev;
	@FXML private TestViewController testController; // hold testcontroller

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		//Actionevents
		menuShow.setOnAction(e->{
			testController = new TestViewController();
			//			centerContent.getChildren().add(testController.getVbox());
		});
		menuClose.setOnAction(e->{

		});

		menuSave.setOnAction(e->{

		});
		menuQuit.setOnAction(e->{

		});
		btnNext.setOnAction(e->{

		});
		btnPrev.setOnAction(e->{

		});

	}



}