import java.util.Comparator;

/**
 * PerimeterComparator class implements Comparator interface to be used as a comparator.
 * 
 * @author Jina Pak
 * @author Jihoon Choi
 * @since 2022-10-23
 */
public class PerimeterComparator implements Comparator<GeometricShape>{

	/**
	 * compare() method compares two given GeometricShape objects to perimeters of one another.
	 * @return a positive integer if the perimeter of the first argument object is bigger than the second one, zero if equal, a negative integer if smaller. 
	 */
	@Override
	public int compare(GeometricShape o1, GeometricShape o2) {
		return o2.getPerimeter() - o1.getPerimeter();
	}

}
