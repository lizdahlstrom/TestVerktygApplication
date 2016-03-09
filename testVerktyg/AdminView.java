
package testVerktyg;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

//This class is for AdminView with one CreateQuest button and SaveTest button.
public class AdminView {
	// Instance variables
	private Button btnCreateQuest;
	private Button btnSaveTest;
	private Scene scene;
	private AnchorPane center;
	private QuestionCreator qCreator;

	// Constructor
	public AdminView() {
		setDefaultView();
	}

	public void setDefaultView() {
		center = new AnchorPane();
		
		// Creating button CreateQuest
		btnCreateQuest = new Button();
		center.setTopAnchor(btnCreateQuest, 20.0);
		center.setLeftAnchor(btnCreateQuest, 20.0);
		btnCreateQuest.setText("Create");
	
		// Creating button SaveTest
		btnSaveTest = new Button();
		center.setTopAnchor(btnSaveTest, 160.0);
		center.setLeftAnchor(btnSaveTest, 20.0);
		btnSaveTest.setText("Save");
		
		center.getChildren().addAll(btnCreateQuest, btnSaveTest);
		
		//Setting the scenes size
		scene = new Scene(center, 400, 400);
	}
	// Methods
	public Scene getAdminScene() {
		return scene;
	}

	// Getters and setters methods
	public Button getBtnCreateQuest() {
		return btnCreateQuest;
	}

	public Button getBtnSaveTest() {
		return btnSaveTest;
	}

	public void setCenterView(Scene scene) {
		this.scene = scene;
	}

	public AnchorPane getCenter() {
		return center;
	}
}
