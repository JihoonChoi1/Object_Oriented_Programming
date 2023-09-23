import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IncrementDecrementFX extends Application {
	private Button incButton;
	private Button decButton;
	private Text valueText;
	private int val = 0;

	@Override
	public void start(Stage primaryStage) {
		incButton = new Button("Increment");
		incButton.setLayoutX(5);
		incButton.setLayoutY(60);
		decButton = new Button("Decrement");
		decButton.setLayoutX(105);
		decButton.setLayoutY(60);		
		valueText = new Text(95,20,""+val);
		
		IncrementListener incListener = new IncrementListener();
		incButton.setOnAction(incListener);
		decButton.setOnAction(incListener);	
		
		Pane root = new Pane();
		root.getChildren().addAll(incButton, decButton, valueText);
		
		Scene scene = new Scene(root, 200, 100);

		primaryStage.setTitle("FX Increment/Decrement Buttons");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	private class IncrementListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			if (e.getSource() == incButton) {
				val++;
			} else {
				val--;
			}
			valueText.setText(""+val);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}	
	
}
