package testVerktyg.ClientFXML;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import testVerktyg.Test;
import testVerktyg.TestReader;
import testVerktyg.TestToolApp;

public class CIientViewController implements Initializable {

	@FXML private VBox clientWindow;
	@FXML private MenuItem menuShow;
	@FXML private MenuItem menuClose;
	@FXML private MenuItem menuSave;
	@FXML private MenuItem menuQuit;
	@FXML private AnchorPane centerContent;
	@FXML private Button btnNext;
	@FXML private Button btnPrev;
	@FXML private TestViewController testController; // hold testcontroller

	private ObservableList <Test> tests;
	private ArrayList <Test> arrTests = new ArrayList<>() ;
	private EntityManager em;
	private EntityManagerFactory emfactory;
	private TestReader tReader;
	private int uId = TestToolApp.userId;


	public CIientViewController(){
		emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		em = emfactory.createEntityManager();
		System.out.println(uId);

		testController = new TestViewController();

		tReader = new TestReader(em); // SOme test code
		//		Test testVar = tReader.getTestById(1);
		loadUserTests();
		displayTestList();
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
		});
		btnPrev.setOnAction(e->{
			//			testController.gotoPrevQuestion();
		});

	}

	private void loadUserTests(){
		arrTests.add(tReader.getTestById(uId));
		tests = FXCollections.observableArrayList(arrTests);

	}

	private void displayTestList(){

		//		ListView<Test> listView = new ListView<>(tests);
		//		centerContent.getChildren().add(listView);
	}

	//	public void startTest(Test test){
	//		//		testController = new TestViewController();
	//		//		testController.setTest(test);
	//		testController.gotoNextQuestion();
	//	}


}