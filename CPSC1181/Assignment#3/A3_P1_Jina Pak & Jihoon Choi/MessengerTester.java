/**
 * The class MessengerTester is made for testing Messenger class to make sure whether it works correctly.
 * It adds users to the Messenger object, sends messages, and calls back messages. On top of the object testing, the static variables are tested in the main method as well.
 * 
 * @author Jina Pak  
 * @author Jihoon Choi
 * @since 2022-10-02
 */
public class MessengerTester {
	
	public static void main(String[] args) {
		Messenger messenger = new Messenger();
		
		messenger.addUser("Jihoon");
		messenger.addUser("Jina");
		
		System.out.println("Testing static variables:");
		int numOfMessages = Message.getNumOfMsgs();
		System.out.println("Got: " + numOfMessages + " Expected: 0");
		int totalLength = Message.getTotalLength();
		System.out.println("Got: " + totalLength + " Expected: 0\n");
		System.out.println("===================================\n");

		
		messenger.sendMessage("Jihoon", "Jina", "Hi, morning!");
		messenger.sendMessage("Jihoon", "Jina", "How are you doing?");
		
		System.out.println("Testing static variables:");
		numOfMessages = Message.getNumOfMsgs();
		System.out.println("Got: " + numOfMessages + " Expected: 2");
		totalLength = Message.getTotalLength();
		System.out.println("Got: " + totalLength + " Expected: 30\n");
		System.out.println("===================================\n");
		
		System.out.println("Testing getReceivedMessages() method:");
		System.out.println(messenger.getReceivedMessages("Jina", Message.Status.unread));
		System.out.println("Expected two messages for Jina\n");
		System.out.println("===================================\n");
		
		System.out.println(messenger.getReceivedMessages("Jina", Message.Status.read));
		System.out.println("Expected no messages for Jina\n");
		System.out.println("===================================\n");
		
		System.out.println(messenger.getReceivedMessages("Jina"));
		System.out.println("Expected two messages for Jina\n");
		System.out.println("===================================\n");
		
		messenger.sendMessage("Jina", "Jihoon", "Hi, I'm good.");
		messenger.sendMessage("Jina", "Jihoon", "How are you?");
		
		System.out.println("Testing static variables:");
		numOfMessages = Message.getNumOfMsgs();
		System.out.println("Got: " + numOfMessages + " Expected: 4");
		totalLength = Message.getTotalLength();
		System.out.println("Got: " + totalLength + " Expected: 55\n");
		System.out.println("===================================\n");

		System.out.println("Testing getReceivedMessages() method:");
		System.out.println(messenger.getReceivedMessages("Jihoon", Message.Status.unread));
		System.out.println("Expected two messages for Jihoon\n");
		System.out.println("===================================\n");
		
		System.out.println(messenger.getReceivedMessages("Jihoon", Message.Status.read));
		System.out.println("Expected no messages for Jihoon\n");
		System.out.println("===================================\n");

		System.out.println(messenger.getReceivedMessages("Jihoon"));
		System.out.println("Expected two messages for Jihoon\n");
		System.out.println("===================================");
	}
}