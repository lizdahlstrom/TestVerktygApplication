	
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
		private Button createQuest;
		private Button saveTest;
		private Scene scene;
		private AnchorPane center;
			public AdminGui() {
				
				
				 center = new AnchorPane();
				
				
				 createQuest = new Button();
				center.setTopAnchor(createQuest, 20.0);
				center.setLeftAnchor(createQuest, 0.0);
				createQuest.setText("Create");
				
				saveTest = new Button();
				center.setTopAnchor(saveTest, 160.0);
				center.setLeftAnchor(saveTest, 0.0);
				saveTest.setText("Save");
		        
				center.getChildren().addAll(createQuest, saveTest);
				scene = new Scene(center,400,400);
			}
			
			
	      
	        
	    
	 
	}

	

	