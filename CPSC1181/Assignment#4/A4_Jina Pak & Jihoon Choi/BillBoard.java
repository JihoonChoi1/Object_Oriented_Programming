/**
 * BillBoard is a class that represents a sign containing a message and implements an interface ASCIIDrawable.
 * 
 * @author Jina Pak
 * @author Jihoon Choi
 * @since 2022-10-23
 */
public class BillBoard implements ASCIIDrawable {
	private String message;
	
	/**
	 * A constructor that creates a billboard that shows a message.
	 * @param message : a message to be shown in a billboard. The value of the parameter message shouldn't be null.
	 */
	public BillBoard(String message) {
		if(message == null) {
			throw new NullPointerException("Argument shouldn't be null");
		}
		this.message = message;
	}
	
	/**
	 * setMessage() method is to set the new message of the billboard.
	 * @param message : a message to be set. The value of the parameter message shouldn't be null.
	 */
	public void setMessage(String message) {
		if(message == null) {
			throw new NullPointerException("Argument shouldn't be null");
		}
		this.message = message;
	}
	
	/**
	 * getMessage() method is to get the message of the billboard.
	 * @return the message of the billboard.
	 */
	public String getMessage() {
		return this.message;
	}
	
	/**
	 * toString() method is to return the string that contains brief information about the billboard.
	 * @return a string that contains brief information about the billboard.
	 */
	@Override
	public String toString() {
		
		return "A billBoard with a message: \"" + message + "\"";
	}
	
	/**
	 * drawAsASCII() method is to return a string that shows the shape of the billboard.
	 * @return a string of the billboard drawn as ASCII.
	 */
	@Override
	public String drawAsASCII() {
		String str = "";
		for(int i = 0 ; i < 5 ; i++) {
            if(i == 0 || i == 4) {
                for(int j = 0 ; j < this.message.length() + 4 ; j++) {
                    str += "#";
                }
                str += "\n";
            }
            else {
            	if(i == 2){
            		str += "# " + this.message + " #";
            	}
            	else {
            		for(int j = 0 ; j < this.message.length() + 4 ; j++) {
            			if(j == 0 || j == this.message.length() + 3) {
            				str += "#";
            			}
            			else {
            				str += " ";
            			}
            		}
            	}
                str += "\n";
            }
        }
		return str;
	}
}
