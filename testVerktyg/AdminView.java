
package testVerktyg;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class AdminView {
	private Button createQuest;
	private Button saveTest;
	private Scene scene;
	private AnchorPane center;

	public AdminView() {

		center = new AnchorPane();

		createQuest = new Button();
		center.setTopAnchor(createQuest, 20.0);
		center.setLeftAnchor(createQuest, 20.0);
		createQuest.setText("Create");

		saveTest = new Button();
		center.setTopAnchor(saveTest, 160.0);
		center.setLeftAnchor(saveTest, 20.0);
		saveTest.setText("Save");

		center.getChildren().addAll(createQuest, saveTest);
		scene = new Scene(center, 400, 400);

	}

	public Scene getAdminScene() {
		return scene;
	}

}
