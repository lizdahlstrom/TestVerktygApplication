package testVerktyg;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Label;
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


	// Constructor
	public FormViewer(Form form){
		vbox = new VBox();
	}

	public VBox getView(){
		return vbox;
	}

	public void setShownForm(){


	}

}
