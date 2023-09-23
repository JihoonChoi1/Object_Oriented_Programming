import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * HalloweenFX class is inherited from the Application class of JavaFX which draws one scenery of a Halloween day.
 * Background items : sky, ground, clouds, stars, moon.
 * Foreground items : house, ghosts.
 * Some foreground item constructors generate their locations and sizes randomly 
 * whereas the background is pretty much fixed except for stars. 
 * This class uses VBox, HBox and border pane layouts with radio buttons and check-boxes with which you change
 * forms of drawings: width and height of an item and visibility of the display for items, which are triggered by 
 * event handler functions.
 * 
 * @author Jihoon Choi
 * @author Jina Pak
 * @since 2022-10-30
 */
public class HalloweenFX extends Application{
	private Pane center;
	
	private Cloud[] cloudsArr;
	private Moon moon;
	private Star[] starsArr;
	private House house;
	private ArrayList<Ghost> ghostsArr = new ArrayList<Ghost>();
	
	private CheckBox cloudsCB;
	private CheckBox starsCB;
	private CheckBox moonCB;
	private CheckBox houseCB;
	private CheckBox ghostsCB;
	
	private RadioButton narrowRB;
	private RadioButton wideRB;
	private ToggleGroup widthGroup;
	
	private RadioButton shortRB;
	private RadioButton tallRB;
	private ToggleGroup heightGroup;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
			
			center = new Pane();
			
			Rectangle sky = new Rectangle(0,0, 1000, 500);
			sky.setFill(Color.rgb(23, 70, 99));
			
			Ground ground = new Ground();
			
			moon = new Moon(680, 80, 50);
			moon.setVisible(false);
					
			cloudsArr = new Cloud[]{new Cloud(750, 135, 150, 50), new Cloud(200, 100, 200, 66), new Cloud(500, 200, 100,33), new Cloud(100, 200, 80, 26), new Cloud(900, 150, 90, 30), new Cloud(450, 120, 180, 60), new Cloud(200, 270, 60, 20), new Cloud(500, 290, 60, 20), new Cloud(800, 250, 60, 20)};
			for(Cloud c : cloudsArr) {
				c.setVisible(false);
			}
			
			starsArr = new Star[50];
			for(int i = 0; i < starsArr.length; i ++) {
				starsArr[i] = new Star((int)(Math.random()*1000), (int)(Math.random()*350), 5, 5);
			}
			for(Star s : starsArr) {
				s.setVisible(false);
			}
			
			house = new House(200, 500, 300, 300);
			house.setVisible(false);
			
			
			center.getChildren().addAll(sky, ground);
			center.getChildren().addAll(starsArr);
			center.getChildren().add(moon);
			center.getChildren().addAll(cloudsArr);
			center.getChildren().add(house);
			
			
			Text topTitle = new Text("Background");
			
			cloudsCB = new CheckBox("Clouds");
			starsCB = new CheckBox("Stars");
			moonCB = new CheckBox("Moon");
			houseCB = new CheckBox("Houses");
			ghostsCB = new CheckBox("Ghosts");
			HBox objectsCB = new HBox(5, cloudsCB, starsCB, moonCB, houseCB, ghostsCB);
			objectsCB.setAlignment(Pos.CENTER);		
			
			VBox top = new VBox(5, topTitle, objectsCB);
			top.setPadding(new Insets(0,5,5,5));
			top.setAlignment(Pos.CENTER);
			
			CBEventHandler cbeh = new CBEventHandler();
			cloudsCB.setOnAction(cbeh);
			starsCB.setOnAction(cbeh);
			moonCB.setOnAction(cbeh);
			houseCB.setOnAction(cbeh);
			ghostsCB.setOnAction(cbeh);

			Text bottomTitle = new Text("Add a Ghost");
			
			Text widthText = new Text("Width");
			narrowRB = new RadioButton("Narrow");
			wideRB = new RadioButton("Wide");
			
			widthGroup = new ToggleGroup();
			narrowRB.setToggleGroup(widthGroup);
			wideRB.setToggleGroup(widthGroup);
			widthGroup.selectToggle(wideRB);
			
			VBox widthVB = new VBox(5, widthText, narrowRB, wideRB);
			widthVB.setAlignment(Pos.CENTER);

			
			Text heightText = new Text("Height");
			shortRB = new RadioButton("Short");
			tallRB = new RadioButton("Tall");
			
			heightGroup = new ToggleGroup();
			shortRB.setToggleGroup(heightGroup);
			tallRB.setToggleGroup(heightGroup);
			heightGroup.selectToggle(tallRB);
			
			VBox heightVB = new VBox(5, heightText, shortRB, tallRB);
			heightVB.setAlignment(Pos.CENTER);
			
			
			HBox RBs = new HBox(15, widthVB, heightVB);
			RBs.setAlignment(Pos.CENTER);
			RBs.setPadding(new Insets(5,5,0,5));
			
			
			Button createNewButton = new Button("Create New");
			
			CreateEventHandler ceh = new CreateEventHandler();
			createNewButton.setOnAction(ceh);
			
			BorderPane bottom = new BorderPane();
			bottom.setTop(bottomTitle);
			bottom.setCenter(RBs);
			bottom.setRight(createNewButton);
			BorderPane.setAlignment(bottomTitle, Pos.CENTER);
			BorderPane.setAlignment(createNewButton, Pos.BOTTOM_RIGHT);
			
			
			BorderPane root = new BorderPane();
			root.setCenter(center);
			root.setTop(top);
			root.setBottom(bottom);
			root.setPadding(new Insets(5));
			
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
	}
	
	private class Cloud extends Group{
		private Arc smallest, right, biggest, left;
		public Cloud(int x, int y, int width, int height) {
			smallest = new Arc(x+((5*width)/12.0), y, width/12.0, height/4.0, 0, 180);
			smallest.setFill(Color.rgb(84, 148, 137));
			right = new Arc(x+(width/4.0), y, width/6.0, height/2.0, 0, 180);
			right.setFill(Color.rgb(84, 148, 137));
			biggest = new Arc(x-(width/24.0), y, (width*7)/24.0, height, 0, 180);
			biggest.setFill(Color.rgb(84, 148, 137));
			left = new Arc(x-(width/3.0), y, width/6.0, height/2.0, 0, 180);
			left.setFill(Color.rgb(84, 148, 137));
			
			this.getChildren().addAll(smallest, right, biggest, left);
		}
	}
	
	private class Star extends Group{
		private Polygon a, b;
		public Star(int x, int y, int width, int height) {
			a = new Polygon(x-width/2.0,y-height/4.0 , x+width/2.0,y-height/4.0 , x,y-height);
			b = new Polygon(x,y , x-width/2.0,y-((height*3)/4.0) , x+width/2.0,y-((height*3)/4.0));
			a.setFill(Color.WHITE);
			b.setFill(Color.WHITE);
			
			this.getChildren().addAll(a,b);
		}
	}
	
	private class Moon extends Group{
		private Ellipse[] gradation = new Ellipse[11];
		
		public Moon(int x, int y, double r) {
			r+=4.5;
			for(int i = 0 ; i < gradation.length ; i++) {
				gradation[i] = new Ellipse(x, y, r, r);
				r -= 0.409;
			}
			gradation[0].setFill(Color.rgb(36,69,96));
			gradation[1].setFill(Color.rgb(56,87,109));
			gradation[2].setFill(Color.rgb(77,105,122));
			gradation[3].setFill(Color.rgb(99,123,135));
			gradation[4].setFill(Color.rgb(120,141,149));
			gradation[5].setFill(Color.rgb(143,160,162));
			gradation[6].setFill(Color.rgb(165,178,175));
			gradation[7].setFill(Color.rgb(187,197,189));
			gradation[8].setFill(Color.rgb(209,215,202));
			gradation[9].setFill(Color.rgb(231,233,216));
			gradation[10].setFill(Color.rgb(255,252,229));
			
			this.getChildren().addAll(gradation);
		}
	}
	
	private class Ground extends Group{
		private Rectangle ground;
		private Polygon layer;
		
		public Ground() {
			ground = new Rectangle(0,500, 1000, 100);
			ground.setFill(Color.rgb(43,93,92));
			layer = new Polygon(0,600 , 0,533 , 50,520 , 100,533 , 150,520 , 200,533 , 250,520 , 300,533 , 350,520 , 400,533 , 450,520 ,
					500,533 , 550,520 , 600,533 , 650,520 , 700,533 , 750,520 , 800,533 , 850,520 , 900,533 , 950,520 , 1000,533 , 1000, 600);
			layer.setFill(Color.rgb(50,48,48));
			
			this.getChildren().addAll(ground, layer);
		}
	}
	
	private class House extends Group{
		Ellipse biggest, middle, smallest, knob;
		Arc top, mainDoorTop, leftWindowTop, rightWindowTop;
		Rectangle base, mainDoor, leftWindow, rightWindow;
		Line winRFrame, winLFrame;

		public House(int x, int y, int width, int height) {
			smallest = new Ellipse(x, y-(5*height)/12.0, width/6.0, (5*height)/12.0);
			smallest.setStroke(Color.rgb(223, 113, 46));
			smallest.setStrokeWidth(height/70.0);
			smallest.setFill(Color.rgb(237, 160, 57));
			middle = new Ellipse(x, y-(5*height)/12.0, width/3.0, (5*height)/12.0);
			middle.setStroke(Color.rgb(223, 113, 46));
			middle.setStrokeWidth(height/70.0);
			middle.setFill(Color.rgb(237, 160, 57));
			biggest = new Ellipse(x, y-(5*height)/12.0, width/2.0, (5*height)/12.0);
			biggest.setStroke(Color.rgb(223, 113, 46));
			biggest.setStrokeWidth(height/70.0);
			biggest.setFill(Color.rgb(237, 160, 57));
			
			top = new Arc(x+width/12.0, y-(5*height)/6.0, width/12.0, height/6.0, 45, 135);
			top.setStrokeWidth(width/12.0);
			top.setStroke(Color.rgb(48,35,31));
			top.setFill(Color.TRANSPARENT);
			
			base = new Rectangle(x-width/2.0, y-height/24.0, width, height/24.0 + height/140.0);
			base.setFill(Color.BLACK);
			base.setStroke(Color.rgb(75,55,40));
			
			mainDoor = new Rectangle(x-width/6.0, y-height/3.0, width/3.0, height/3.0);
			mainDoor.setFill(Color.rgb(232,192,81));
			mainDoor.setStroke(Color.SADDLEBROWN);
			mainDoor.setStrokeWidth(height/120.0);
			
			mainDoorTop = new Arc(x, y-height/3.0, width/6.0, height/6.0, 0, 180);
			mainDoorTop.setFill(Color.rgb(232,192,81));
			mainDoorTop.setStroke(Color.SADDLEBROWN);
			mainDoorTop.setStrokeWidth(height/120.0);
			
			knob = new Ellipse(x+width/9.0, y-height/4.0, width/30.0, height/30.0);
			knob.setFill(Color.rgb(76,67,69));
			
			rightWindow = new Rectangle(x+(5*width)/18.0, y-height/2.0, width/9.0, height/12.0);
			rightWindowTop = new Arc(x+width/3.0, y-height/2.0, width/18.0, height/12.0, 0, 180);
			rightWindow.setFill(Color.rgb(235,176,64));
			rightWindowTop.setFill(Color.rgb(235,176,64));
			rightWindow.setStroke(Color.SADDLEBROWN);
			rightWindowTop.setStroke(Color.SADDLEBROWN);
			rightWindow.setStrokeWidth(height/120.0);
			rightWindowTop.setStrokeWidth(height/120.0);
			
			leftWindow = new Rectangle(x-(7*width)/18.0, y-height/2.0, width/9.0, height/12.0);
			leftWindowTop = new Arc(x-width/3.0, y-height/2.0, width/18.0, height/12.0, 0, 180);
			leftWindow.setFill(Color.rgb(235,176,64));
			leftWindowTop.setFill(Color.rgb(235,176,64));
			leftWindow.setStroke(Color.SADDLEBROWN);
			leftWindowTop.setStroke(Color.SADDLEBROWN);
			leftWindow.setStrokeWidth(height/120.0);
			leftWindowTop.setStrokeWidth(height/120.0);
			
			winRFrame = new Line(x+width/3.0, y-(height*5)/12.0, x+width/3.0, y-(height*7)/12.0);
			winRFrame.setStroke(Color.SADDLEBROWN);
			winRFrame.setStrokeWidth(height/120.0);
			
			winLFrame = new Line(x-width/3.0, y-(height*5)/12.0, x-width/3.0, y-(height*7)/12.0);
			winLFrame.setStroke(Color.SADDLEBROWN);
			winLFrame.setStrokeWidth(height/120.0);
			 
			this.getChildren().addAll(top, biggest, middle, smallest, mainDoorTop, mainDoor, knob, rightWindowTop, rightWindow, winRFrame, leftWindowTop, leftWindow, winLFrame, base);
		}
	}
	
	private class Ghost extends Group{
		private Rectangle torso, mouth;
		private Ellipse head, armLeft, armRight, leg1, leg2, leg3, leg4, leftPupil, rightPupil, whiteLeft, whiteRight;
		private Arc tooth1, tooth2;
		
		public Ghost(int x, int y, int width, int height) {
			torso = new Rectangle(x-(2*width)/5.0, y-(5*height)/6.0, (4*width)/5.0, (2*height)/3.0);
			torso.setFill(Color.WHITE);
			
			head = new Ellipse(x, y-(5*height)/6.0, (2*width)/5.0, height/6.0);
			head.setFill(Color.WHITE);
			
			armLeft = new Ellipse(x-(2*width)/5.0, y-(height/2.0), width/10.0, height/12.0);
			armLeft.setFill(Color.WHITE);
			
			armRight = new Ellipse(x+(2*width)/5.0, y-(height/2.0), width/10.0, height/12.0);
			armRight.setFill(Color.WHITE);
			
			leg1 = new Ellipse(x-(width*3)/10.0, y-(height/6.0), width/10.0, height/6.0);
			leg1.setFill(Color.WHITE);
			
			leg2 = new Ellipse(x-width/10.0, y-(height/6.0), width/10.0, height/6.0);
			leg2.setFill(Color.WHITE);

			leg3 = new Ellipse(x+width/10.0, y-(height/6.0), width/10.0, height/6.0);
			leg3.setFill(Color.WHITE);
			
			leg4 = new Ellipse(x+(width*3)/10.0, y-(height/6.0), width/10.0, height/6.0);
			leg4.setFill(Color.WHITE);
			
			whiteLeft = new Ellipse(x-(width/6.0), y-(height*3)/4.0, width/16.0, height/16.0);
			whiteLeft.setFill(Color.WHEAT);
			leftPupil = new Ellipse(x-(width/6.0), y-(height*3)/4.0, width/24.0, height/24.0);
			leftPupil.setFill(Color.BLACK);
			
			whiteRight = new Ellipse(x+(width/6.0), y-(height*3)/4.0, width/12.0, height/12.0);
			whiteRight.setFill(Color.WHEAT);
			rightPupil = new Ellipse(x+(width/6.0), y-(height*3)/4.0, width/24.0, height/24.0);
			rightPupil.setFill(Color.BLACK);
			
			mouth = new Rectangle(x-(width/6.0), y-(height*9)/14.0, width/3.0, height/6.0);
			mouth.setFill(Color.LIGHTPINK);
			
			tooth1 = new Arc(x-(width/15.0), y-(height*9)/14.0, width/20.0, height/18.0, 180, 180);
			tooth1.setFill(Color.ALICEBLUE);
			
			tooth2 = new Arc(x+(width/15.0), y-(height*9)/14.0, width/20.0, height/18.0, 180, 180);
			tooth2.setFill(Color.ALICEBLUE);
					
			this.getChildren().addAll(head, armLeft, armRight, leg1, leg2, leg3, leg4, torso, whiteLeft, leftPupil, whiteRight, rightPupil, mouth, tooth1, tooth2);
		}
	}
	
	private class CBEventHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent e) {
			if(e.getSource() == cloudsCB) {
				if(cloudsCB.isSelected()) {
					for(Cloud c : cloudsArr) {
						c.setVisible(true);
					}
				}
				else {
					for(Cloud c : cloudsArr) {
						c.setVisible(false);
					}
				}
			}
			else if(e.getSource() == starsCB) {
				if(starsCB.isSelected()) {
					for(Star s : starsArr) {
						s.setVisible(true);
					}
				}
				else {
					for(Star s : starsArr) {
						s.setVisible(false);
					}
				}
			}
			else if(e.getSource() == moonCB) {
				if(moonCB.isSelected()) {
					moon.setVisible(true);
				}
				else {
					moon.setVisible(false);
				}
			}
			else if(e.getSource() == houseCB) {
				if(houseCB.isSelected()) {
					house.setVisible(true);
				}
				else {
					house.setVisible(false);
				}
			}
			else if(e.getSource() == ghostsCB) {
				if(ghostsCB.isSelected()) {
					for(Ghost g : ghostsArr) {
						g.setVisible(true);
					}
				}
				else {
					for(Ghost g : ghostsArr) {
						g.setVisible(false);
					}
				}
			}
		}	
	}
	
	private class CreateEventHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent e) {
			Ghost ghost;
			
			if(narrowRB.isSelected() && shortRB.isSelected()) {
				ghost = new Ghost(25+(int)(Math.random()*951), 80+(int)(Math.random()*521), 50, 80);
			}
			else if(narrowRB.isSelected() && tallRB.isSelected()) {
				ghost = new Ghost(25+(int)(Math.random()*951), 200+(int)(Math.random()*401), 50, 200);
			}
			else if(wideRB.isSelected() && shortRB.isSelected()) {
				ghost = new Ghost(55+(int)(Math.random()*891), 80+(int)(Math.random()*521), 110, 80);
			}
			else {
				ghost = new Ghost(55+(int)(Math.random()*891), 200+(int)(Math.random()*401), 110, 200);
			}
			
			if(ghostsCB.isSelected()) {
				ghost.setVisible(true);
			}
			else {
				ghost.setVisible(false);
			}
			ghostsArr.add(ghost);
			center.getChildren().add(ghost);
		}	
	}	
}
