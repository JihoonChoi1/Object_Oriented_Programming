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
import javafx.scene.shape.Arc;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class MoreShapesFX extends Application {

	@Override
	public void start(Stage primaryStage) {
		Pane root = new Pane();
		
		Line mast = new Line(200, 50, 200, 200);
		mast.setStrokeWidth(5);
		mast.setStroke(Color.BROWN);
		
		double[] sailPoints = {205,55 , 205,195 , 275,195};
		Polygon sail = new Polygon(sailPoints);
		sail.setFill(Color.ANTIQUEWHITE);
		
		Arc hull = new Arc(200,200,100,50,180,180);
		hull.setFill(Color.BROWN);
		
		root.getChildren().addAll(mast, sail, hull);
		
		Scene scene = new Scene(root, 400, 300);
		primaryStage.setTitle("FX More Shapes");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	

	public static void main(String[] args) {
		Application.launch(args);
	}
}