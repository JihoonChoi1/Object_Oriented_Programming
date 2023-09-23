import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
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

public class ChangingTreeColorFX extends Application {
	private Pane root;
	private Tree t1;
	
	@Override
	public void start(Stage primaryStage) {
		root = new Pane();
		
		Rectangle ground = new Rectangle(0, 300, 300, 100);
		ground.setFill(Color.DARKGREEN);
	
		root.getChildren().addAll(ground);
		
		t1 = new Tree(50, 320);
	
		Tree t2 = new Tree(150, 340);	
		
		Button colorButton = new Button("Change color");
		colorButton.setLayoutX(40);
		colorButton.setLayoutY(360);
		colorButton.setOnAction(new ColorEventHandler());
		
		root.getChildren().add(colorButton);
		
		Scene scene = new Scene(root, 300, 400);
		primaryStage.setTitle("FX Trees");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	private class Tree {
		private Rectangle trunk;
		private Ellipse leaves;
		
		public Tree(int x, int y) {
			trunk = new Rectangle(x-10, y-100, 20, 100);
			trunk.setFill(Color.SADDLEBROWN);
			
			leaves = new Ellipse(x,y-100,40,50);
			leaves.setFill(Color.rgb(30,120,80));
			
			root.getChildren().addAll(trunk, leaves);
		}
	
		public void setColor(Color c) {
			leaves.setFill(c);
		}
	}
	
	
	private class ColorEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			Random r = new Random();
			Color c = Color.rgb(r.nextInt(256),r.nextInt(256),r.nextInt(256));
			t1.setColor(c);
		}
	}
}
































/*
 * 		
 		Tree t1 = new Tree(50, 320, 60, 150);
		root.getChildren().addAll(t1.getAllNodes());

		Tree t2 = new Tree(150, 310, 40, 100);
		root.getChildren().addAll(t2.getAllNodes());
 */

/*
public Tree(int x, int y, int w, int h) {
	trunk = new Rectangle(x-w/6, y-2*h/3, w/3, 2*h/3);
	trunk.setFill(Color.SADDLEBROWN);
	
	leaves = new Ellipse(x,y-2*h/3,w/2,h/3);
	leaves.setFill(Color.rgb(30,120,80));
}
*/


