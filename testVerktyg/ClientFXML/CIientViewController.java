package testVerktyg.ClientFXML;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import testVerktyg.Test;
import testVerktyg.TestReader;

public class CIientViewController implements Initializable {

	@FXML private MenuItem menuShow;
	@FXML private MenuItem menuClose;
	@FXML private MenuItem menuSave;
	@FXML private MenuItem menuQuit;
	@FXML private AnchorPane centerContent;
	@FXML private Button btnNext;
	@FXML private Button btnPrev;
	@FXML private TestViewController testController; // hold testcontroller

	private ArrayList <Test> tests;
	private EntityManager em;
	private EntityManagerFactory emfactory;

	private int uId;

	public CIientViewController(int uId){
		this.uId = uId;
		emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		em = emfactory.createEntityManager();


		testController = new TestViewController();

		TestReader tReader = new TestReader(em); // SOme test code
		Test testVar = tReader.getTestById(1);

	}



	@Override
	public void initialize(URL location, ResourceBundle resources) {



		//Actionevents
		menuShow.setOnAction(e->{
			//			testController = new TestViewController();
			//			centerContent.getChildren().add(testController.getVbox());
		});
		menuClose.setOnAction(e->{

		});

		menuSave.setOnAction(e->{
			// Take testResult from testViewController and send to DB
		});
		menuQuit.setOnAction(e->{
			Platform.exit();
		});
		btnNext.setOnAction(e->{
			testController.gotoNextQuestion();
		});
		btnPrev.setOnAction(e->{
			//			testController.gotoPrevQuestion();
		});

	}

	private void loadTests(){

	}

	//	public void startTest(Test test){
	//		//		testController = new TestViewController();
	//		//		testController.setTest(test);
	//		testController.gotoNextQuestion();
	//	}


}