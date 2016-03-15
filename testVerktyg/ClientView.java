package testVerktyg;

import java.util.List;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * @author Liz Dahlstrom
 *
 */

public class ClientView {
	// Instance variables
	private Scene testView; // Scene showing test
	private BorderPane layout;
	private AnchorPane bottomBtnPane;
	private AnchorPane topPane;
	private VBox centerLayout;
	private HBox topHbox;
	private ListView<Test> listView;

	// Creating buttons
	private Button btnNext = new Button("Nästa");
	private Button btnPrev = new Button("Tillbaka");
	private Button btnSend = new Button("Lämna in");
	// Creating labels
	private Label lblTitle;
	private Label lblDescript;
	private Label lblTimer;

	// Constructor
	public ClientView(){
		initComponents();
	}

	// Methods
	private void initComponents(){
		listView = new ListView<>();

		//Labels
		lblTitle = new Label("Starta test");
		lblTitle.setFont(Font.font(32));
		lblDescript = new Label("Välj test och tryck på Nästa..");
		lblDescript.setFont(Font.font(16));
		lblTimer = new Label("00:00");
		lblTimer.setFont(Font.font(16));

		//Layouts
		topHbox = new HBox(lblTimer, btnSend);
		topHbox.setSpacing(14);
		topPane = new AnchorPane(topHbox);
		topPane.setRightAnchor(topHbox, 0.0);
		centerLayout  = new VBox();
		centerLayout.setPadding(new Insets(30));
		centerLayout.getChildren().addAll(lblTitle, lblDescript);
		bottomBtnPane = new AnchorPane(btnPrev,btnNext);
		bottomBtnPane.setLeftAnchor(btnPrev, 0.0);
		bottomBtnPane.setRightAnchor(btnNext, 0.0); 
		bottomBtnPane.setMaxHeight(100);

		btnPrev.setPrefSize(100, 50);
		btnNext.setPrefSize(100, 50);

		// Main layout
		layout = new BorderPane();

		layout = new BorderPane();
		centerLayout  = new VBox();
		topPane = new AnchorPane(btnSend);
		topPane.setRightAnchor(btnSend, 0.0);
		centerLayout.setPadding(new Insets(30));
		centerLayout.getChildren().addAll(lblTitle, lblDescript, listView);


		layout.setTop(topPane);
		layout.setCenter(centerLayout);
		layout.setBottom(bottomBtnPane);

		testView = new Scene(layout, 500,600);		
	}

	// Getters and setters
	public ListView<Test> getListView() {
		return listView;
	}

	public void setListViewData(List<Test> tests) {
		listView.setItems((ObservableList <Test>) tests); // casting observable list, not sure if safe !!
	}

	public Test getSelectedTest(){ // Returns selected item 
		return listView.getSelectionModel().getSelectedItem();
	}

	public void setBtnPrev(Button btnPrev) {
		this.btnPrev = btnPrev;
	}

	public Scene getTestView(){
		return testView;
	}

	public Button getBtnNext(){
		return btnNext;
	}

	public Button getBtnPrev(){
		return btnPrev;
	}

	public VBox getCenterLayout() {
		return centerLayout;
	}

	public Button getBtnSend(){
		return btnSend;
	}

	public void setLblTitle(Label lblTitle) {
		this.lblTitle = lblTitle;
	}

	public void setLblDescript(Label lblDescript) {
		this.lblDescript = lblDescript;
	}

	public Label getLblTimer() {
		return lblTimer;
	}


}