import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ShapesTabPane extends Application {

	@Override
	public void start(Stage primaryStage) {
		Rectangle top = new Rectangle(400,200);
		top.setFill(Color.DARKGREEN);
		
		Ellipse bottom = new Ellipse (200,50);
		bottom.setFill(Color.DARKVIOLET);
		
		VBox vb = new VBox(10, top, bottom);
		
		Rectangle left = new Rectangle(400,200);
		left.setFill(Color.DARKGREEN);
		
		Ellipse right = new Ellipse (200,50);
		right.setFill(Color.DARKVIOLET);
		
		HBox hb = new HBox(10, left, right);
		
		TabPane root = new TabPane();
		Tab t1 = new Tab("HBox",hb);
		t1.setClosable(false);
		Tab t2 = new Tab("VBox",vb);
		root.getTabs().addAll(t1,t2);
		
		Scene scene = new Scene(root);

		primaryStage.setTitle("Shapes TabPane");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}	
	
}
