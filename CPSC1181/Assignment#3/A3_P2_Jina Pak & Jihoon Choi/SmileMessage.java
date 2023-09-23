/**
 * This class is a subclass of a Message class. It creates a message that sets the text as a smile.
 * 
 * @author Jina Pak
 * @author Jihoon Choi
 * @since 2022-10-15
 */
public class SmileMessage extends Message{
	
	/**
	 * A constructor that takes two strings as parameters to assign the sender name and the recipient name of such object
	 * @param sender String to assign the sender name of the active object. Shouldn't be null
	 * @param recipient String to assign the recipient name of the active object. Shouldn't be null
	 */
	public SmileMessage(String sender, String recipient) {
		super(sender,recipient, " @  @ \n" + "      \n" + "@    @\n" + " @  @ \n" + "  @@  \n");
	}
	
	/**
	 * getPreview() method creates a string for the preview.
	 * @return a string of the preview.
	 */
	@Override
	public String getPreview() {
		String previewText = ":)";
		String result = "(" + this.getStatus() + ")" + "From " + this.getSender() + ": " + previewText;
		return result;
	}
}
