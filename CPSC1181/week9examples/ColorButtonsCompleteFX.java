import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ColorButtonsCompleteFX extends Application {
	private Button redButton;
	private Button blueButton;
	private Rectangle background;

	@Override
	public void start(Stage primaryStage) {
		redButton = new Button("RED!");
		redButton.setLayoutX(5);
		redButton.setLayoutY(60);
		blueButton = new Button("BLUE!");
		blueButton.setLayoutX(105);
		blueButton.setLayoutY(60);		

		background = new Rectangle(0,0,200,100);
		
		
		redButton.setOnAction(new ColorChangeListener());
		blueButton.setOnAction(new ColorChangeListener());	
		
		Pane root = new Pane();
		root.getChildren().addAll(background, redButton, blueButton);
		
		Scene scene = new Scene(root, 200, 100);

		primaryStage.setTitle("FX Red/Green Color Buttons");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	private class ColorChangeListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			if (e.getSource() == redButton) {
				background.setFill(Color.RED);;
			} else {
				background.setFill(Color.BLUE);;
			}
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}	
	
}
