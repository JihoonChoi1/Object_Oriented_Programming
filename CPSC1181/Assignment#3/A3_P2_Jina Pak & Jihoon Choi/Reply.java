/**
 * This class is a subclass of a Message class. It creates a message which is meant for the reply.
 * 
 * @author Jina Pak
 * @author Jihoon Choi
 * @since 2022-10-15
 */
public class Reply extends Message{
	private Message message;
	
	/**
	 * A constructor that takes three strings to assign the names and the text. Moreover, it takes one Message object to know what Message the reply is for.
	 * @param sender The name of the sender.
	 * @param recipient The name of the recipient.
	 * @param text The text message that is going to be sent.
	 * @param message A message object to know what Message the reply is for.
	 */
	public Reply(String sender, String recipient, String text, Message message) {
		super(sender, recipient, text);
		if(message == null) {
			throw new NullPointerException("paramter shouldn't be null");
		}
		this.message = message;
	}
	
	/**
	 * Offers information of an object in a certain form.
	 * Reply is displayed to the user in this format. 
	 * @return String  information of an object.
	 */
	@Override
	public String toString() {
		String result = super.toString();
		result += "\n--------------Replying To--------------\n";
		result += this.message.toString();
		return result;
	}
	
	
}
