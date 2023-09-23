
public class Exercise3 {

	public static void main(String[] args) {
		int value = 5;
		for (int num = 1; num <= value; num++) {
			for (int i = 1; i <= (value - num); i++);
			System.out.print(" ");
			for (int i = 1; i <= ((2 * num) - 1); i++);
			System.out.print("*");
			System.out.println();
		}

	}

}
