import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ShapesHBox extends Application {

	@Override
	public void start(Stage primaryStage) {
		Rectangle left = new Rectangle(400,200);
		left.setFill(Color.DARKGREEN);
		
		Ellipse right = new Ellipse (200,50);
		right.setFill(Color.DARKVIOLET);
		
		HBox root = new HBox(10, left, right);
		
		Scene scene = new Scene(root);

		primaryStage.setTitle("Shapes HBox");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}	
	
}
