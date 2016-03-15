package testVerktyg;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class TestViewer {
	//Instance variables
	private AnchorPane anchorPane;
	private ArrayList <HBox> hbox;
	private String title;
	private ArrayList <RadioButton> rbs;
	private ArrayList <Label> strQuestions;
	private List <Test> testList;
	private ListView <Test> listView;

	private ToggleGroup tGroup;
	private Test test;

	// Constructor
	public TestViewer(List <Test> testList){
		this.testList = testList;
		setShownForm(testList);
		generateAnchorPane();
	}

	public AnchorPane getView(){
		return anchorPane;
	}

	public void setShownForm(List <Test> testList){
		listView = new ListView <>();
		//ObservableList<Test> oList = FXCollections.observableList(testList);
		listView.setItems((ObservableList<Test>) testList);		
	}

	private void generateAnchorPane(){
		anchorPane = new AnchorPane();
		anchorPane.setPrefSize(300, 460);
		anchorPane.getChildren().add(listView);
	}

	public ListView<Test> getListView(){
		return listView;
	}

	public void generateTestForm(int testId){
		tGroup = new ToggleGroup();

		testList.forEach((currTest) -> { // Use hashmap instead which enables map.get(id) method?? 
			if(currTest.getTestId()== testId ){
				test = currTest;
			}
		});

		test.getQuestions().forEach((question) -> {
			question.getQuestion();
			question.getChoices().forEach((choice)-> {


			});
		});
	}
}
