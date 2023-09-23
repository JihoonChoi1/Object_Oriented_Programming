import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class ShapesFX extends Application {

	@Override
	public void start(Stage primaryStage) {
		Pane root = new Pane();
		
		Rectangle ground = new Rectangle(0, 300, 300, 100);
		ground.setFill(Color.DARKGREEN);
		Rectangle trunk = new Rectangle(140, 220, 20, 100);
		trunk.setFill(Color.SADDLEBROWN);
		
		Ellipse leaves = new Ellipse(150,220,40,50);
		leaves.setFill(Color.rgb(30,120,80));
		
		root.getChildren().addAll(leaves, trunk, ground);
		
		Scene scene = new Scene(root, 300, 400);
		primaryStage.setTitle("FX Shapes");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	

	public static void main(String[] args) {
		Application.launch(args);
	}
}