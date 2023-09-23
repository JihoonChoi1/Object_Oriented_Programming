import java.util.Arrays;

/**
 * 
 *
 *         A simple class that contains many common methods used for performing
 *         various computations. These methods may or may not be correct. We
 *         should add a test class to check the validity of these methods.
 */
public class Calculator {

	public static int remainder(int a, int b) {
		return a % b;
	}

	public static double add(double a, double b) {
		return a + b;
	}

	public static double multiply(double a, double b) {
		return a * b;
	}

	public static double subtract(double a, double b) {
		return a - b;
	}

	public static double divide(double a, double b) {
		return a / b;
	}

	public static int average(double... values) {
		int sum = 0;
		for (double n : values) {
			sum += n;
		}
		return sum / values.length;
	}



	// calculate arithmetic median
	// he median of a finite list of numbers can be found
	// by arranging all the numbers from smallest to greatest.
	// If there is an odd number of numbers, the middle one is
	// picked. If there is an even number of observations, then
	// there is no single middle value; the median is then usually
	// defined to be the mean of the two middle values
	public static double median(double... values) {
		Arrays.sort(values);
		return values[values.length / 2];

	}

	public static double max(double... values) {
		double max = 0;
		if (values.length > 0 || values != null) {
			max = values[0];
			for (int i = 1; i < values.length; i++) {
				if (values[i] > max)
					max = values[i];
			}
		}
		return max;
	}

	public static double min(double... values) {
		double min = 0;
		if (values.length > 0 || values != null) {
			min = values[0];
			for (int i = 1; i < values.length; i++) {
				if (values[i] < min)
					min = values[i];
			}
		}
		return min;
	}

}
