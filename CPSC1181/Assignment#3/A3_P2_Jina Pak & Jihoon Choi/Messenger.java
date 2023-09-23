import java.util.ArrayList;

/**
 * Messenger class carries all of the information regarding users and messages sent to one another.
 * 
 * @author Jina Pak
 * @author Jihoon Choi
 * @since 2022-10-02
 */
public class Messenger {
	private ArrayList<String> userNames;
	private ArrayList<Message> sentMsgs;
	
	/**
	 * A constructor that generates an object that initializes two ArrayLists to be empty.
	 */
	public Messenger() {
		userNames = new ArrayList<String>();
		sentMsgs = new ArrayList<Message>();
	}
	
	/**
	 * Adds a user name into the ArrayList-userNames. This method doesn't take null values as a parameter. 
	 * If a parameter - username is identical to one of existing strings(user names) in the list, it merely returns.
	 * @param username  a user name needed to be added to the list of user names.
	 */
	public void addUser(String username) {
		if(username == null) {
			throw new NullPointerException("Passed parameter shouldn't be null");
		}
		if (userNames.contains(username)) {
			return;
		}
		userNames.add(username);
	}
	
	/**
	 * A sender sends a message to a receiver. Therefore, any of parameters are not allowed to be null.
	 * if a sender and a receiver that a user inputs are not equal to one of the previous saved name information in the list, 
	 * this method are not able to send a message and throw an exception.
	 * @param sender  a name of the sender.
	 * @param receiver  a name of the receiver.
	 * @param text  content of the message from the sender to the receiver.
	 */
	public void sendMessage(String sender, String receiver, String text) {
		if(sender == null || receiver == null || text == null) {
			throw new NullPointerException("All parameters shouldn't be null");
		}
		if(!(userNames.contains(sender) && userNames.contains(receiver))) {
			throw new IllegalArgumentException("The sender or receiver is not contained in userNames.");
		}
		Message msg = new Message(sender, receiver, text);
		sentMsgs.add(msg);
	}
	
	/**
	 * A method returning an exact message that matches the given recipient name.
	 * The parameter can't be null so that the methods ensure to examine every single message in the ArrayList : sentMsgs.
	 * @param username  a name of the recipient.
	 * @return ArrayList of the inquired message.
	 */
	public ArrayList<Message> getReceivedMessages(String username) {
		if(username == null) {
			throw new NullPointerException("Passed parameter shouldn't be null");
		}
		ArrayList<Message> list = new ArrayList<Message>();
		for(Message a : sentMsgs) {
			if(username.equals(a.getRecipient())) {
				list.add(a);
			}
		}
		return list;
	}
	
	/**
	 * A method returning an exact message that matches the given recipient name and the status.
	 * The parameter can't be null so that the methods ensure to examine every single message in the ArrayList : sentMsgs.
	 * @param username  a name of the recipient.
	 * @param status  a status of the message.
	 * @return ArrayList of the inquired messages.
	 */
	public ArrayList<Message> getReceivedMessages(String username, Message.Status status) {
		if(username == null || status == null) {
			throw new NullPointerException("All parameters shouldn't be null");
		}
		ArrayList<Message> list = new ArrayList<Message>();
		for(Message a : sentMsgs) {
			if(username.equals(a.getRecipient()) && status == a.getStatus()) {
				list.add(a);
			}
		}
		return list;
	}
	
	/**
	 * sendSmile method creates a SmileMessage and adds it to the message ArrayList.
	 * @param from  the name of the sender. Shouldn't be null.
	 * @param to  the name of the recipient. Shouldn't be null.
	 */
	public void sendSmile(String from, String to) {
		if(from == null || to == null) {
			throw new NullPointerException("All parameters shouldn't be null");
		}
		if(!(userNames.contains(from) && userNames.contains(to))) {
			throw new IllegalArgumentException("The sender or receiver is not contained in userNames.");
		}
		sentMsgs.add(new SmileMessage(from, to));
	}
	
	/**
	 * sendReply method creates a Reply using the supplied information and adds the Reply to the message ArrayList.
	 * @param original  Message object which we are replying to.
	 * @param  text  String that are getting sent for the reply.
	 */
	public void sendReply(Message original, String text) {
		if(original == null || text == null) {
			throw new NullPointerException("Parameters shouldn't be null");
		}
		sentMsgs.add(new Reply(original.getRecipient(), original.getSender(), text, original));
	}
	
	/**
	 * getUser() method gets the copy of userNames ArrayList.
	 * @return the ArrayList of users.
	 */
	public ArrayList<String> getUser(){
		return new ArrayList<String>(userNames);
	}
}
