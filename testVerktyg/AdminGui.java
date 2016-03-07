	
package testVerktyg;

import javafx.application.Application;
	import javafx.scene.Group;
	import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
	public class AdminGui {

			
			AnchorPane center = new AnchorPane();
			
			VBox vbox = new VBox(30);
			
			Button createQuest = new Button();
			center.setTopAnchor(createQuest);
			center.setLeftAnchor(createQuest);
			createQuest.setText("Create");
			
			Button saveTest = new Button();
			center.setTopAnchor(saveTest);
			center.setLeftAnchor(saveTest);
			saveTest.setText("Save");
	        
			center.getChildren().addAll(createQuest, saveTest);
	        Scene scene = new Scene(center,400,400);
	      
	        
	    
	 
	}

	

	