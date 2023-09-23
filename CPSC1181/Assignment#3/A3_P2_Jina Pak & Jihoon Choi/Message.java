/**
 * This class simulates a message sent between two people. 
 * It includes the information of the sender, recipient, message of text, status, the number of messages and cumulative length of a message.
 * Through this class, a user can get the information and set some attributes for changes. 
 * 
 * @author Jina Pak
 * @author Jihoon Choi
 * @since 2022-10-02
 */
public class Message {
	public enum Status{unread, read, trash};
	private String sender;
	private String recipient;
	private String text;
	private Status status;
	private static int numOfMsgs = 0;
	private static int totalLength = 0;
	
	/**
	 * a constructor taking four parameters to save the information. Any of parameters can't be null here.
	 * Also, this constructor calculates the number of messages and saves the length of the text on the total length of other constructors' texts.   
	 * @param sender  a name of the sender of a message.
	 * @param recipient  a name of the recipient of a message.
	 * @param text  the content of the message from the sender.
	 * @param status  status of the message to be set.
	 */
	public Message (String sender, String recipient, String text, Status status) {
		if(sender == null || recipient == null || text == null || status == null) {
			throw new NullPointerException("All parameters shouldn't be null");
		}
		this.sender = sender;
		this.recipient = recipient;
		this.text = text;
		this.status = status;
		++numOfMsgs;
		totalLength += text.length();
	}
	
	/**
	 * a constructor taking three parameters with unread status as a default. Any of parameters can't be null here.
	 * Also, this constructor calculates the number of messages and saves the length of the text on the total length of other constructors' texts.
	 * @param sender  a name of the sender of a message.
	 * @param recipient  a name of the recipient of a message.
	 * @param text  the content of the message from the sender.
	 */
	public Message (String sender, String recipient, String text) {
		this(sender, recipient, text, Status.unread);
	}
	
	/**
	 * Gets the name of the sender.
	 * @return a string of the sender name.
	 */
	public String getSender() {
		return this.sender;
	}
	
	/**
	 * Gets the name of the recipient.
	 * @return a string of the recipient name.
	 */
	public String getRecipient() {
		return this.recipient;
	}
	
	/**
	 * Gets the text of the message.
	 * @return a string of the text.
	 */
	public String getText() {
		return this.text;
	}
	
	/**
	 * Gets the status of the message out of "read", "unread", and "trash".  
	 * @return the status of a message.
	 */
	public Status getStatus() {
		return this.status;
	}
	
	/**
	 * Sets new status of a message. It is not supposed to return something but innerly saves desired information-status. 
	 * @param new status to set for the message object.
	 */
	public void setStatus(Status status) {
		if(status == null) {
			throw new NullPointerException("Parameter shouldn't be null");
		}
		this.status = status;
	}
	
	/**
	 * Offers information of an object in a certain form.
	 * Messages are displayed to the user in this format. 
	 * @return String  information of an object.
	 */
	@Override
	public String toString() {
		String result = "\nSender: " + this.sender;
		result += "\nRecipient: " + this.recipient;
		result += "\nStatus: " + this.status;
		result += "\n" + this.text;
		return result + "\n";
	}
	
	/**
	 * Gets the total number of message objects.
	 * @return the total number of messages.
	 */
	public static int getNumOfMsgs() {
		return numOfMsgs;
	}
	
	/**
	 * Brings the total length of characters in all message objects.
	 * @return the total length of all texts.
	 */
	public static int getTotalLength() {
		return totalLength;
	}
	
	/**
	 * getPreview() method returns a String containing the status, the sender, and the beginning of the text for a message on one line.
	 * If the length of a string that gets returned is higher than 70, it cuts out the rest.
	 * @return a String containing status, the sender, and the beginning of the text for a message.
	 */
	public String getPreview() {
		String previewText = this.text.replace('\n', ' ');
		String result = "(" + this.status + ")" + "From " + this.sender + ": ";
		if(result.length() + previewText.length() > 70) {
			result += previewText.substring(0, 70 - result.length()) + "...";
		}
		else {
			result += previewText;
		}
		return result;
	}
}
