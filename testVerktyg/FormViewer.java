package testVerktyg;

import java.util.ArrayList;

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

	// Constructor
	public FormViewer(Form form){
		vbox = new VBox();
	}

	public VBox getView(){
		return vbox;
	}

	public void setShownForm(Form form){
		title = form.getQuery();

		form.getOptions().forEach((e) ->
		{
			strQuestions.add(new Label(e));
			rbs.add(new RadioButton());
		});

	}

}
