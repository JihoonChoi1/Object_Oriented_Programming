/**
 * RectangleShape class is a sub-class of GeometricShape class that creates a rectangle.
 * 
 * @author Jina Pak
 * @author Jihoon Choi
 * @since 2022-10-23
 */
public class RectangleShape extends GeometricShape {
	private int width;
	private int height;
	
	/**
	 * A constructor that creates a rectangle with given arguments. Integer arguments should be positive.
	 * @param width : width of the rectangle
	 * @param height : height of the rectangle
	 * @param isFilled : The state of the rectangle(filled or unfilled)
	 */
	public RectangleShape(int width, int height, boolean isFilled) {
		super(isFilled);
		if(width <= 0 || height <= 0) {
			throw new IllegalArgumentException("Width and Height shouldn't be 0 or the negative integer(s).");
		}
		this.width = width;
		this.height = height;
	}
	
	/**
	 * A constructor that creates a filled in rectangle with given arguments. Integer arguments should be positive.
	 * @param width : a width of the rectangle
	 * @param height : a height of the rectangle
	 */
	public RectangleShape(int width, int height) {
		this(width, height, true);
	}
	
	/**
	 * getWidth() method is to get the width of the rectangle object.
	 * @return a width of the rectangle object.
	 */
	public int getWidth() {
		return this.width;
	}
	
	/**
	 * getHeight() method is to get the height of the rectangle object.
	 * @return a height of the rectangle object.
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * setWidth() method is to set the width of the rectangle object.
	 * @param width : a width of the rectangle object.
	 */
	public void setWidth(int width) {
		if(width <= 0) {
			throw new IllegalArgumentException("The argument shouldn't be 0 or a negative integer.");
		}
		this.width = width;
	}
	
	/**
	 * setHeight() method is to set the height of the rectangle object.
	 * @param height : a height of the rectangle object.
	 */
	public void setHeight(int height) {
		if(height <= 0) {
			throw new IllegalArgumentException("The argument shouldn't be 0 or a negative integer.");
		}
		this.height = height;
	}
	
	/**
	 * getArea() method is to get the area of the rectangle object.
	 * @return an area of the rectangle object.
	 */
	@Override
	public int getArea() {
		return this.width * this.height;
	}
	
	/**
	 * getPerimeter() method is to get the perimeter of the rectangle object.
	 * @return a perimeter of the rectangle object.
	 */
	@Override
	public int getPerimeter() {
		return 2*(this.width + this.height);
	}
	
	/**
	 * toString() method is to return the string that explains about the caller rectangle object.
	 * @return a string with brief explanation of the caller object.
	 */
	@Override
	public String toString() {
		String str = super.toString();
		str += "rectangle with width: " + this.width + ", height: " + this.height;
		return str;
	}
	
	/**
	 * drawAsAsCII() method is to return the string that shows a shape of the caller rectangle object.
	 * @return a string that shows a shape of the caller rectangle object.
	 */
	@Override
	public String drawAsASCII() {
		String str = "";
		if(this.getIsFilled()) {
			for(int i = 0 ; i < this.height ; i++) {			
				for(int j = 0 ; j < this.width ; j++) {
					str += "#";
				}	
				str += "\n";
			}
		}
		else {
	        for(int i = 0 ; i < this.height ; i++) {
	            if(i == 0 || i == this.height-1) {
	                for(int j = 0 ; j < this.width ; j++) {
	                    str += "#";
	                }
	                str += "\n";
	            }
	            else {
	                for(int j = 0 ; j < this.width ; j++) {
	                    if(j == 0 || j == this.width-1) {
	                        str += "#";
	                    }
	                    else {
	                        str += " ";
	                    }
	                }
	                str += "\n";
	            }
	        }	
		}
		return str;
	}
}
