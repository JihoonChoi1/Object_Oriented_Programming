import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * MessengerGUI class allows users to select one user, load the user's all messages with the other unchosen person,
 * load the user's unread messages and send a written message or an auto-made smile message to the recipient on GUI.
 * The GUI is divided into 3 tabs where the user utilizes a designated feature on each as above, those
 * features appear when the user clicks on each of the tabs.
 * 
 * This class extends the Application class to perform designing aspect tasks - structuring GUI and
 * its inner tasks handle events happening on GUI which is derived from user interactions.
 * 
 * @author Jihoon Choi
 * @author Jina Pak
 * @since 2022-11-21
 */
public class MessengerGUI extends Application{
	private Messenger messenger;
	
	private Text titleText;
	private Tab tab1, tab2, tab3;
	private BorderPane pane1, pane2, pane3;
	
	private TextField enterNameField;
	private Button selectB;
	
	private TextArea readMessages;
	private Button nextB , loadAllMessageB, loadUnreadMessageB;
	
	private TextField toUserName;
	private TextArea sendMessage;
	private RadioButton smileRB, writtenRB;
	private ToggleGroup messageTypeGroup;
	private Button sendB;
	
	private ArrayList<String> userNames;
	private ArrayList<Message> receivedMessages;
	
	private String activeUser;
	private boolean isActive = false;
	
	private int currMessageInd;
	
	private final String initialMessage = "No Message Displayed";
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		titleText = new Text("SELECT A User");
		
		Text enterName = new Text("Enter Username: ");
		enterNameField = new TextField("");
		selectB = new Button("Select");
		selectB.setOnAction(new SelectUserHandler());
		HBox chooseUser = new HBox(3, enterName, enterNameField, selectB);
		chooseUser.setAlignment(Pos.CENTER);
		pane1 = new BorderPane();
		pane1.setCenter(chooseUser);
		tab1 = new Tab("Choose User", pane1);
		tab1.setClosable(false);
		
		readMessages = new TextArea(initialMessage);
		readMessages.setEditable(false);
		readMessages.setFont(Font.font("monospace"));
		nextB = new Button("Next");
		nextB.setDisable(true);
		nextB.setOnAction(new NextMessageHandler());
		loadAllMessageB = new Button("Load All Messages");
		loadAllMessageB.setOnAction(new LoadMessageHandler());
		loadUnreadMessageB = new Button("Load Unread Messages");
		loadUnreadMessageB.setOnAction(new LoadMessageHandler());
		HBox loadMessages = new HBox(5, loadAllMessageB, loadUnreadMessageB);
		loadMessages.setAlignment(Pos.CENTER);
		pane2 = new BorderPane();
		pane2.setCenter(readMessages);
		pane2.setRight(nextB);
		pane2.setBottom(loadMessages);
		pane2.setPadding(new Insets(3));
		BorderPane.setMargin(loadMessages, new Insets(3,0,0,0));
		BorderPane.setMargin(nextB, new Insets(0,0,0,3));
		BorderPane.setAlignment(nextB, Pos.CENTER);
		tab2 = new Tab("Read Messages", pane2);
		tab2.setClosable(false);
		
		Text to = new Text("To:");
		toUserName = new TextField();
		toUserName.setEditable(false);
		HBox tab3Top = new HBox(3, to, toUserName);
		tab3Top.setAlignment(Pos.CENTER_LEFT);
		sendMessage = new TextArea();
		sendMessage.setEditable(false);
		sendMessage.setFont(Font.font("monospace"));
		Text messageType = new Text("Message Type");
		smileRB = new RadioButton("Smile");
		smileRB.setOnAction(new RBHandler());
		writtenRB = new RadioButton("Written");
		writtenRB.setOnAction(new RBHandler());
		messageTypeGroup = new ToggleGroup();
		smileRB.setToggleGroup(messageTypeGroup);
		writtenRB.setToggleGroup(messageTypeGroup);
		messageTypeGroup.selectToggle(writtenRB);
		sendB = new Button("Send");
		sendB.setOnAction(new SendMessageHandler());
		HBox tab3Bottom = new HBox(3, messageType, smileRB, writtenRB, sendB);
		HBox.setMargin(sendB, new Insets(0,0,0,40));
		tab3Bottom.setAlignment(Pos.CENTER);
		
		pane3 = new BorderPane();
		pane3.setTop(tab3Top);
		pane3.setCenter(sendMessage);
		pane3.setBottom(tab3Bottom);
		pane3.setPadding(new Insets(3));
		BorderPane.setMargin(tab3Top, new Insets(0,0,3,0));
		BorderPane.setMargin(tab3Bottom, new Insets(3,0,0,0));
		tab3 = new Tab("Send Message", pane3);
		tab3.setClosable(false);
		
		TabPane tabPane = new TabPane();
		tabPane.getTabs().addAll(tab1, tab2, tab3);
		titleText = new Text("Select A User");
		titleText.setFont(Font.font(15));
		
		BorderPane root = new BorderPane();
		root.setTop(titleText);
		root.setCenter(tabPane);
		BorderPane.setAlignment(titleText, Pos.CENTER);
		
		messenger = new Messenger();
		messenger.addUser("Jihoon");
		messenger.addUser("Jina");
		messenger.sendMessage("Jina", "Jihoon", "Hello Jihoon!");
		messenger.sendMessage("Jina", "Jihoon", "How are you doing?");
		messenger.sendMessage("Jihoon", "Jina", "Hello Jina, this is Jihoon");
		messenger.sendMessage("Jihoon", "Jina", "Hello Jina, this is still Jihoon");
		
		userNames = messenger.getUserList();
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("Messenger GUI");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private class SelectUserHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e) {
			boolean userExists = false;
			String typedName = enterNameField.getText();
			for(String userName : userNames) {
				if(typedName.equals(userName)) {
					userExists = true;
					break;
				}
			}
			if(userExists) {
				titleText.setText("Current user: " + typedName);
				activeUser = typedName;
				isActive = true;
				toUserName.setEditable(true);
				sendMessage.setEditable(true);
				readMessages.setText(initialMessage);
				nextB.setDisable(true);
			}
			else {
				titleText.setText("Incorrect Username");
			}
		}
	}
	
	private class LoadMessageHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e) {	
			if(isActive) {
				currMessageInd = 0;
				if(e.getSource() == loadAllMessageB) {
					receivedMessages = messenger.getReceivedMessages(activeUser);
				}
				else {
					receivedMessages = messenger.getReceivedMessages(activeUser, Message.Status.unread);
				}
				if(receivedMessages.size() > 0) {
					if(receivedMessages.size() == 1) {
						nextB.setDisable(true);
					}
					else {
						nextB.setDisable(false);
					}
					titleText.setText(receivedMessages.size() + " message(s) loaded");
					receivedMessages.get(currMessageInd).setStatus(Message.Status.read);
					readMessages.setText(receivedMessages.get(0).toString());
				}
				else {
					readMessages.setText(initialMessage);
					titleText.setText(receivedMessages.size() + " message(s) loaded");
					nextB.setDisable(true);
				}

			}	
		}
	}
	
	private class NextMessageHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			++currMessageInd;
			if(currMessageInd == receivedMessages.size()-1) {
				nextB.setDisable(true);
			}
			receivedMessages.get(currMessageInd).setStatus(Message.Status.read);
			readMessages.setText(receivedMessages.get(currMessageInd).toString());
		}	
	}
	
	private class SendMessageHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			if(isActive) {
				boolean userExists = false;
				String recipientName = toUserName.getText();
				for(String userName : userNames) {
					if(recipientName.equals(userName)) {
						userExists = true;
						break;
					}
				}
				if(userExists) {
					messenger.sendMessage(activeUser, recipientName, sendMessage.getText());
					if(smileRB.isSelected()) {
						titleText.setText("Smile Successfully Sent");
					}
					else {
						titleText.setText("Message Successfully Sent");
					}
				}
				else {
					titleText.setText("Recipient Username Not Found");
				}
			}	
		}	
	}
	
	private class RBHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			if(isActive) {
				if(e.getSource() == smileRB) {
					sendMessage.setEditable(false);
					sendMessage.setText(" @  @ \n" + "      \n" + "@    @\n" + " @  @ \n" + "  @@  \n");
				}
				else {
					sendMessage.setEditable(true);
					sendMessage.setText("");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}	
}
