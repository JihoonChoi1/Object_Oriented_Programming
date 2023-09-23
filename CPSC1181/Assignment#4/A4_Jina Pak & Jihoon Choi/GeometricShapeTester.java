import java.util.Arrays;

/**
 * GeometricShapeTester class is a class to test all the classes and their interfaces.
 * 
 * @author Jina Pak
 * @author Jihoon Choi
 * @since 2022-10-23
 */
public class GeometricShapeTester {
	
	public static void main(String[] args) {
		GeometricShape[] shapes = {new RectangleShape(5,5), new RectangleShape(7,4, false), new RectangleShape(3,3, false)};
		
		Arrays.sort(shapes);
		
		
		for(int i = 0 ; i < shapes.length ; i++) {
			System.out.println(shapes[i].drawAsASCII());
		}
		
		System.out.println("======================\n");
		
		ASCIIDrawable[] drawables = {new RectangleShape(3,3, false), new RectangleShape(5,5), new RectangleShape(4,7, false), new BillBoard("Old Joe's Place")};
		
		for(int i = 0 ; i < drawables.length ; i++) {
			System.out.println(drawables[i].drawAsASCII());
		}
		
		System.out.println("======================\n");
		
		Arrays.sort(shapes, new PerimeterComparator());
		
		for(int i = 0 ; i < shapes.length ; i++) {
			System.out.println(shapes[i].drawAsASCII());
		}
	}
}
