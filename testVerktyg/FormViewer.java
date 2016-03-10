package testVerktyg;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FormViewer {
	//Instance variables
	private VBox vbox;
	private ArrayList <HBox> hbox;
	private String title;
	private ArrayList <RadioButton> rbs;
	private ArrayList <Label> strQuestions;
	private List <Test> tests;
	private ListView <Test> listView;


	// Constructor
	public FormViewer(){
		vbox = new VBox();
	}

	public VBox getView(){
		return vbox;
	}

	public void setShownForm(List <Test> testList){
		listView = new ListView <>();
		ObservableList<Test> oList = FXCollections.observableList(testList);
		listView.setItems(oList);


	}

	public ListView getListView(){
		return listView;
	}

}
