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
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class TextFX extends Application {
	
	@Override
	public void start(Stage primaryStage) {

		Pane root = new Pane();
		
		Text t1 = new Text(25, 75, "Filled");
		t1.setFont(Font.font(48));
		t1.setFill(Color.STEELBLUE);
		
		Text t2 = new Text(25, 175, "Bold Outline");
		Font f = Font.font("Times New Roman", FontWeight.BOLD ,48);
		t2.setFont(f);
		t2.setFill(Color.TRANSPARENT);
		t2.setStroke(Color.BLACK);
		
		root.getChildren().addAll(t1, t2);
		
		Scene scene = new Scene(root, 400, 200);
		primaryStage.setTitle("FX Text");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}