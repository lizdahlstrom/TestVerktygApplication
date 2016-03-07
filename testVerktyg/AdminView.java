
package testVerktyg;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class AdminView {
	private Button btnCreateQuest;
	private Button btnSaveTest;
	private Scene scene;
	private AnchorPane center;
	private QuestionCreator qCreator;



	public AdminView() {
		setDefaultView();		
		// Create button event
		btnCreateQuest.setOnAction(e -> {
			qCreator = new QuestionCreator();
			center.getChildren().clear();
			center.getChildren().add(qCreator.getQuestionList());
		});
		// Save button event
		btnSaveTest.setOnAction(e -> {

		});
	}

	public void setDefaultView(){
		center = new AnchorPane();

		btnCreateQuest = new Button();
		center.setTopAnchor(btnCreateQuest, 20.0);
		center.setLeftAnchor(btnCreateQuest, 20.0);
		btnCreateQuest.setText("Create");

		btnSaveTest = new Button();
		center.setTopAnchor(btnSaveTest, 160.0);
		center.setLeftAnchor(btnSaveTest, 20.0);
		btnSaveTest.setText("Save");

		center.getChildren().addAll(btnCreateQuest, btnSaveTest);
		scene = new Scene(center, 400, 400);		
	}

	public Scene getAdminScene() {
		return scene;
	}

	// Getters och setters
	public Button getBtnCreateQuest() {
		return btnCreateQuest;
	}

	public Button getBtnSaveTest() {
		return btnSaveTest;
	}

	public void setCenterView(Scene scene){
		this.scene = scene;
	}

}
