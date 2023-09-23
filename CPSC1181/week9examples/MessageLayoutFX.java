import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MessageLayoutFX extends Application {
	private final String initialMessage="Hello, World";
	private final int fontSize = 72;
	private TextField messageTextField;
	private CheckBox boldCheckBox;
	private RadioButton noLineRB;
	private RadioButton underlineRB;
	private RadioButton strikeThroughRB;
	private ToggleGroup textLineGroup;	
	private Text message;
	
@Override
public void start(Stage primaryStage) {
	Pane messagePane = new Pane();
	messagePane.setPrefWidth(500);
	messagePane.setPrefHeight(100);
	message = new Text(20,85,initialMessage);
	messagePane.getChildren().add(message);
	
	message.setFont(Font.font("Arial",fontSize));

	messageTextField = new TextField(initialMessage);
	
	Button updateMessageButton = new Button("Update Message");

	boldCheckBox = new CheckBox("Bold");
	
	noLineRB = new RadioButton("No Line");
	underlineRB = new RadioButton("Underline");
	strikeThroughRB = new RadioButton("Strikethrough");
	VBox leftSide = new VBox(5,boldCheckBox,noLineRB, underlineRB, strikeThroughRB);
	
	textLineGroup = new ToggleGroup();
	noLineRB.setToggleGroup(textLineGroup);
	underlineRB.setToggleGroup(textLineGroup);
	strikeThroughRB.setToggleGroup(textLineGroup);
	textLineGroup.selectToggle(noLineRB);		
	
	MessageEventHandler meh = new MessageEventHandler();
	updateMessageButton.setOnAction(meh);
	messageTextField.setOnAction(meh);
	boldCheckBox.setOnAction(meh);
	noLineRB.setOnAction(meh);
	underlineRB.setOnAction(meh);
	strikeThroughRB.setOnAction(meh);

	BorderPane root = new BorderPane();
	root.setCenter(messagePane);
	root.setTop(messageTextField);
	root.setBottom(updateMessageButton);
	root.setAlignment(updateMessageButton, Pos.CENTER);
	root.setLeft(leftSide);
	
	root.setPadding(new Insets(5));
	leftSide.setPadding(new Insets(5,5,5,0));
	leftSide.setMargin(boldCheckBox, new Insets(0,0,10,0));
	
	Scene scene = new Scene(root);
	primaryStage.setTitle("FX Custom Text Message");
	primaryStage.setScene(scene);
	primaryStage.show();
}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
		
	private class MessageEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			message.setText(messageTextField.getText());
			FontWeight fw = FontWeight.NORMAL;
			if (boldCheckBox.isSelected()) {
				fw = FontWeight.BOLD;
			}
			message.setFont(Font.font("Arial",fw,fontSize));
			
			message.setStrikethrough(strikeThroughRB.isSelected());
			message.setUnderline(underlineRB.isSelected());				
		}
	}
}



