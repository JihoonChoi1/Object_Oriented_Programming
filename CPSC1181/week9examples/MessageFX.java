import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MessageFX extends Application {
	private final String initialMessage="Hello, World";
	private final int fontSize = 72;
	private TextField messageTextField;
	private CheckBox boldCheckBox;
	private RadioButton noLineRB;
	private RadioButton underlineRB;
	private RadioButton strikeThroughRB;
	private ToggleGroup textLineGroup ;	
	private Text message;
	
	@Override
	public void start(Stage primaryStage) {
		message = new Text(25, 175, initialMessage);
		message.setFont(Font.font("Arial",fontSize));
	
		messageTextField = new TextField(initialMessage);
		messageTextField.setLayoutX(10);
		messageTextField.setLayoutY(10);	
		messageTextField.setPrefWidth(300);
		
		Button updateMessageButton = new Button("Update Message");
		updateMessageButton.setLayoutX(460);
		updateMessageButton.setLayoutY(10);

		
		boldCheckBox = new CheckBox("Bold");
		boldCheckBox.setLayoutX(10);
		boldCheckBox.setLayoutY(60);
		
		noLineRB = new RadioButton("No Line");
		noLineRB.setLayoutX(180);
		noLineRB.setLayoutY(60);
		underlineRB = new RadioButton("Underline");
		underlineRB.setLayoutX(260);
		underlineRB.setLayoutY(60);
		strikeThroughRB = new RadioButton("Strikethrough");
		strikeThroughRB.setLayoutX(360);
		strikeThroughRB.setLayoutY(60);
		
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
		
		Pane root = new Pane();
		root.getChildren().addAll(messageTextField, updateMessageButton, boldCheckBox, message);
		root.getChildren().addAll(noLineRB, underlineRB, strikeThroughRB);
		Scene scene = new Scene(root, 600, 200);
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



