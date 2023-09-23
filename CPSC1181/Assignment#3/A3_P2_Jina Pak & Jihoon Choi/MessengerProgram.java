import java.util.Scanner;
import java.util.ArrayList;

/**
 * MessengerProgram is a class that runs a program that acts as a messenger which uses all the classes we have made 
 * that is related to a message.
 * 
 * @author Jina Pak
 * @author Jihoon Choi
 * @since 2022-10-15
 */
public class MessengerProgram {
	
	private Scanner scanner;
	private Messenger messenger;
	private String activeUser;
	
	public static void main(String[] args) {
		MessengerProgram prog = new MessengerProgram();
		prog.execute();
	}
	
	/**
	 * MessengerProgram() method is a method that fills up all the requirements needed to execute the program.
	 */
	public MessengerProgram() {
		scanner = new Scanner(System.in);
		messenger = new Messenger();
		messenger.addUser("Jihoon");
		messenger.addUser("Jina");
		messenger.sendMessage("Jina", "Jihoon", "Hello Jihoon!");
		messenger.sendMessage("Jina", "Jihoon", "How are you doing?");
		messenger.sendMessage("Jihoon", "Jina", "Hello Jina, this is Jihoon");
		messenger.sendMessage("Jihoon", "Jina", "Hello Jina, this is still Jihoon");
	}
	
	/**
	 * execute() method is a method that acts as the main of the program that interacts with a user by
	 * prompting inputs for each part.
	 */
	public void execute() {
		ArrayList<String> menu = makeMenu();
		ArrayList<String> messageOptions = makeMsgOptions();
		ArrayList<String> users = messenger.getUser();
		activateUser(users);
		System.out.println("Starting Messenger");
		int num = choose(menu);
		while((num+1) != 7) {
			switch(num+1) 
			{
				case 1:
					seeMessages(messageOptions);
					break;
				case 2:
					seeMessages(messageOptions, Message.Status.unread);
					break;
				case 3:
					sendMessage(users);
					break;
				case 4:
					sendSmile(users);
					break;
				case 5:
					activateUser(users);
					break;
				case 6:
					seeStats();
					break;	
			}
			num = choose(menu);
		}
	}
	
	/**
	 * makeMenu() method is to make a menu with options.
	 * @return an ArrayList of multiple options used for a menu.
	 */
	public ArrayList<String> makeMenu(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("See All Messages");
		list.add("See Unread Messages");
		list.add("Send Message");
		list.add("Send Smile");
		list.add("Switch Active User");
		list.add("See Messenger Stats");
		list.add("Exit");
		
		return list;
	}
	
	/**
	 * maekMsgOptions() method is to create a list of options used for messages.
	 * @return an ArrayList of multiple options used for messages.
	 */
	public ArrayList<String> makeMsgOptions(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("Mark Unread");
		list.add("Mark as Trash");
		list.add("Reply");
		list.add("Do Nothing");
		
		return list;
	}
	
	/**
	 * activateUser() method is a method for activating the user. It makes the user to choose the name.
	 * @param users  list of users that the user can choose
	 */
	public void activateUser(ArrayList<String> users) {
		if(users.size() > 0) {
			System.out.println("Choose Active User");
			int num = choose(users);
			activeUser = users.get(num);
		}
		else {
			System.out.println("There are no users");
			System.exit(0);
		}
	}
	
	/**
	 * seeMessages() method is a method that shows the message for the current active user. After seeing the message, it provides
	 * some options that the user can choose.
	 * @param messageOptions  an ArrayList of options that user can choose after seeing the message.
	 */
	public void seeMessages(ArrayList<String> messageOptions) {
		ArrayList<Message> list = messenger.getReceivedMessages(activeUser);
		if(list.size() == 0) {
			System.out.println("====No messages to display====\n");
			return;
		}
		int num = chooseMessage(list);
		if(list.get(num).getStatus() == Message.Status.unread) {
			list.get(num).setStatus(Message.Status.read);
		}
		System.out.println(list.get(num).toString());
			
		int input = choose(messageOptions);		
		
		switch(input+1)
		{
			case 1:
				list.get(num).setStatus(Message.Status.unread);
				break;
			case 2:
				list.get(num).setStatus(Message.Status.trash);
				break;
			case 3:
				scanner.useDelimiter("\\n\\n");
				System.out.println(("Type Your Message"));
				messenger.sendReply(list.get(num), scanner.next());
				scanner.reset();
				break;
		}
	}
	
	/**
	 * seeMessages() is a overloading method that adds the feature of getting the messages that corresponds to the passed status.
	 * @param messageOptions  an ArrayList of options that user can choose after seeing the message.
	 * @param status  A status of the messages that the user wants to see.
	 */
	public void seeMessages(ArrayList<String> messageOptions, Message.Status status) {
		ArrayList<Message> list = messenger.getReceivedMessages(activeUser, status);
		if(list.size() == 0) {
			System.out.println("====No messages to display====\n");
			return;
		}
		int num = chooseMessage(list);
		list.get(num).setStatus(Message.Status.read);
		System.out.println(list.get(num).toString());
					
		int input = choose(messageOptions);
		
		switch(input+1)
		{
			case 1:
				list.get(num).setStatus(Message.Status.unread);
				break;
			case 2:
				list.get(num).setStatus(Message.Status.trash);
				break;
			case 3:
				scanner.useDelimiter("\\n\\n");
				System.out.println(("Type Your Message"));		
				messenger.sendReply(list.get(num), scanner.next());
				scanner.reset();
				break;
		}
	}
	
	/**
	 * sendMessage() method is a method that lets the active user to send a message to the other users.
	 * @param users  an ArrayList of users whom the message can be sent to.
	 */
	public void sendMessage(ArrayList<String> users) {
		System.out.println("Who is the recipient?");
		int num = choose(users);
		scanner.useDelimiter("\\n\\n");
		System.out.println("Type Your Message");
		messenger.sendMessage(activeUser, users.get(num), scanner.next());
		scanner.reset();
	}
	
	/**
	 * sendSmile() method is a method that lets the active user to send a smile shaped message to the other users
	 * @param users  an ArrayList of users whom the smile message can be sent to.
	 */
	public void sendSmile(ArrayList<String> users) {
		System.out.println("Who is the recipient?");
		messenger.sendSmile(activeUser, users.get(choose(users)));
	}
	
	/**
	 * seeStats() method is a method that shows the total number of messages sent, and the total number of characters sent.
	 */
	public void seeStats() {
		System.out.println(Message.getNumOfMsgs() + " messages sent");
		System.out.println(Message.getTotalLength() + " characters sent\n");
	}
	
	/**
	 * choose() method is a method that prompts the user to make a choice of the given list.
	 * @param list  an ArrayList of options that the active user can choose.
	 * @return an index of the option chosen.
	 */
	public int choose(ArrayList<String> list) {
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.println(i+1 + ": " + list.get(i));
		}
		System.out.print("Enter a number from the choices above: ");
		int num = scanner.nextInt();
		scanner.nextLine();
		while(num < 1 || num > list.size()) {
			System.out.print("Enter a number from the choices above: ");
			num = scanner.nextInt();
			scanner.nextLine();
		}
		System.out.println("User Chose: " + list.get(num-1) + "\n");
		return num-1;
	}
	
	/**
	 * chooseMessage() method is a method that prompts the user to make a choice of the given Message list.
	 * @param list  an ArrayList of options that the active user can choose.
	 * @return an index of the option chosen.
	 */
	public int chooseMessage(ArrayList<Message> list) {
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.println(i+1 + ": " + list.get(i).getPreview());
		}
		System.out.print("Choose a message to read: ");
		int num = scanner.nextInt();
		scanner.nextLine();
		while(num < 1 || num > list.size()) {
			System.out.print("Choose a message to read: ");
			num = scanner.nextInt();
			scanner.nextLine();
		}
		System.out.println("User Chose: " + list.get(num-1).getPreview() + "\n");
		return num-1;
	}
}
