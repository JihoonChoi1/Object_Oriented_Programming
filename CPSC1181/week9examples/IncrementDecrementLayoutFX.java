import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IncrementDecrementLayoutFX extends Application {
	private Button incButton;
	private Button decButton;
	private Text valueText;
	private int val = 0;

	@Override
	public void start(Stage primaryStage) {
		incButton = new Button("Increment");
		decButton = new Button("Decrement");	
		valueText = new Text(""+val);
		
		IncrementListener incListener = new IncrementListener();
		incButton.setOnAction(incListener);
		decButton.setOnAction(incListener);	
		
		HBox buttons = new HBox(10,incButton,decButton);
		VBox mainPane = new VBox(10,valueText,buttons);
		
		mainPane.setAlignment(Pos.CENTER);
		mainPane.setPadding(new Insets(5));
	
		Scene scene = new Scene(mainPane);
		primaryStage.setResizable(false);
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
