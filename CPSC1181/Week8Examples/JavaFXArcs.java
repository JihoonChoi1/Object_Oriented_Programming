import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class JavaFXArcs extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane root = new Pane();
		
		Arc a1 = new Arc(50, 100, 40, 40, 0, 90);
		Arc a2 = new Arc(150, 100, 40, 40, 0, 90);	
		a2.setType(ArcType.CHORD);
		Arc a3 = new Arc(250, 100, 40, 40, 0, 90);	
		a3.setType(ArcType.ROUND);	
		Arc a4 = new Arc(350, 100, 40, 40, 180, 90);
		Arc a5 = new Arc(450, 100, 40, 40, 180, 270);	
		Arc[] arcs = {a1,a2,a3,a4,a5};
		for (Arc a: arcs) {
			a.setFill(Color.TRANSPARENT);
			a.setStrokeWidth(2);
			a.setStroke(Color.BLACK);
		}
		root.getChildren().addAll(arcs);
		
		Scene scene = new Scene(root, 500, 200);
		primaryStage.setTitle("FX Arcs");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
