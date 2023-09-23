/**
 * Geometric class is an abstract class that creates a filled in shape or an unfilled shape.
 * It has two interfaces called Comparable which is part of the Java library and ASCIIDrawable.
 * @author Jina Pak
 * @author Jihoon Choi
 * @since 2022-10-23
 */
public abstract class GeometricShape implements Comparable<GeometricShape>, ASCIIDrawable {
	private boolean isFilled;
	
	/**
	 * A constructor that creates a filled in shape if a parameter is true, and unfilled shape if false.
	 * @param isFilled : if the value is true, creates a filled in shape, and if false, creates an unfilled shape.
	 */
	public GeometricShape(boolean isFilled) {
		this.isFilled = isFilled;
	}
	
	/**
	 * A constructor that creates a filled in shape as a default.
	 */
	public GeometricShape() {
		this(true);
	}
	
	/**
	 * setIsFilled() method to set the shape to be filled or not.
	 * @param isFilled : if the value is true, shape will be filled, and if false, shape won't be filled.
	 */
	public void setIsFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}
	
	/**
	 * getIsFilled() method is to get the boolean type to check if caller object is filled in or not.
	 * @return returns true if the shape is filled or false if unfilled.
	 */
	public boolean getIsFilled() {
		return this.isFilled;
	}
	
	/**
	 * getArea() method gets the area of a shape.
	 * @return the area of a shape.
	 */
	public abstract int getArea();
	
	/**
	 * getPerimeter() method gets the perimeter of the shape.
	 * @return the perimeter of the shape
	 */
	public abstract int getPerimeter();
	
	/**
	 * compareTo() method compares two GeometricShape objects to the area.
	 * @return returns a positive integer if the caller object's area is bigger than the argument object, zero if equal, a negative integer if smaller.
	 */
	@Override
	public int compareTo(GeometricShape other) {
		return (this.getArea() - other.getArea());
	}
	
	/**
	 * toString() method is to return the string that shows if the shape is filled or not.
	 * @return a string that shows if the shape is filled or not.
	 */
	@Override
	public String toString() {
		if(this.isFilled) {
			return "a filled ";
		}
		else {
			return "an unfilled ";
		}
	}
}
