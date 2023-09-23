import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class OutlinesFX extends Application {

	public void start(Stage primaryStage) {
		Pane root = new Pane();
		
		Rectangle lineAndFill = new Rectangle(10, 10, 180, 80);
		lineAndFill.setFill(Color.YELLOW);
		lineAndFill.setStroke(Color.PURPLE);

		Rectangle lineOnly = new Rectangle(10, 110, 180, 80);
		lineOnly.setFill(Color.TRANSPARENT);
		lineOnly.setStroke(Color.PURPLE);		
		
		Rectangle wideLine = new Rectangle(10, 210, 180, 80);
		wideLine.setFill(Color.TRANSPARENT);
		wideLine.setStroke(Color.PURPLE);
		wideLine.setStrokeWidth(10);
		
		root.getChildren().addAll(lineAndFill, lineOnly, wideLine);
		
		Scene scene = new Scene(root, 200, 300);
		primaryStage.setTitle("FX Outlines");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
