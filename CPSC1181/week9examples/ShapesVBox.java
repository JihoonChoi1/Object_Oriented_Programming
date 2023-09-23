import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ShapesVBox extends Application {

	@Override
	public void start(Stage primaryStage) {
		Rectangle top = new Rectangle(400,200);
		top.setFill(Color.DARKGREEN);
		
		Ellipse bottom = new Ellipse (200,50);
		bottom.setFill(Color.DARKVIOLET);
		
		VBox root = new VBox(10, top, bottom);
		
		Scene scene = new Scene(root);

		primaryStage.setTitle("Shapes VBox");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}	
	
}
