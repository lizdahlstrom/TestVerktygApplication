package testVerktyg.adminViews;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TestSavePopup {
	ObservableList<String> lstId = FXCollections.observableArrayList();

	public TestSavePopup() {
		BorderPane center = new BorderPane();
		center.setPrefHeight(600);
		center.prefWidth(400);
		AnchorPane layout = new AnchorPane(), top = new AnchorPane();
		layout.setPrefHeight(600);
		layout.prefWidth(400);
		Label lblDescript1 = new Label("Please enter Users that should have access"),
				lblDescript2 = new Label("to the test.");
		Button btnSaveUser = new Button("Save User"), btnDone = new Button("Done");
		ListView<String> lstUser = new ListView<>();
		HBox south = new HBox();
		TextField txtUserInput = new TextField();
		Stage stage = new Stage();
		ObservableList<String> lstString = FXCollections.observableArrayList();

		top.getChildren().addAll(lblDescript1, lblDescript2, txtUserInput, btnSaveUser);
		south.getChildren().add(btnDone);
		center.getChildren().addAll(lstUser);
		layout.getChildren().add(center);
		center.setTop(top);
		center.setBottom(south);

		// center.getTopAnchor(top);
		// center.getBottomAnchor(south);

		stage.setScene(new Scene(layout, 400, 400));

		btnSaveUser.setOnAction((value) -> {
			lstString.add(txtUserInput.getText());
			lstUser.setItems(lstString);
		});
		btnDone.setOnAction((value) -> {
			lstId.addAll(lstUser.getItems());
		});
		stage.showAndWait();
	}

	public ObservableList<String> getlstId() {

		return lstId;
	}

}
