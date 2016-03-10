package testVerktyg;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class FormViewer {
	//Instance variables
	private AnchorPane anchorPane;
	private ArrayList <HBox> hbox;
	private String title;
	private ArrayList <RadioButton> rbs;
	private ArrayList <Label> strQuestions;
	private List <Test> testList;
	private ListView <Test> listView;

	// Constructor
	public FormViewer(List <Test> testList){
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
}
