/**
 * Calculator program consists of bunch of methods that can be used for basic calculations.
 * @author Jihoon Choi
 * @since 2022-09-18
 */
import java.util.Arrays;

/**
 * 
 *
 *         A simple class that contains many common methods used for performing
 *         various computations. These methods may or may not be correct. We
 *         should add a test class to check the validity of these methods.
 */
public class Calculator {

	/**
	 * remainder method is to find out the remaining values when two given parameters are divided
	 * @param a number to be divided
	 * @param b divider
	 * @return the remaining value when a is divided by b
	 */
	public static int remainder(int a, int b) {
		return a % b;
	}

	/**
	 * add method is to find out the value when two double numbers are added
	 * @param a number to be added
	 * @param b number to be added
	 * @return the added value of a and b
	 */
	public static double add(double a, double b) {
		return a + b;
	}

	/**
	 * multiply method is to find out the value when two double numbers are multiplied
	 * @param a number to be multiplied
	 * @param b number to be multiplied
	 * @return the multiplied value of a and b
	 */
	public static double multiply(double a, double b) {
		return a * b;
	}

	/**
	 * subtract method is to find out the value when two numbers are subtracted
	 * @param a number to be subtracted
	 * @param b number to subtract
	 * @return the value when a is subtracted by b
	 */
	public static double subtract(double a, double b) {
		return a - b;
	}

	/**
	 * divide method is to find out the value when two numbers are divided
	 * @param a number to be divided
	 * @param b divider
	 * @return the value when a is divided by b
	 */
	public static double divide(double a, double b) {
		return a / b;
	}

	/**
	 * average method is to find out the average of the given array
	 * @param values array for the average to be checked
	 * @return the average number of the given array
	 */
	public static double average(double... values) {
		double sum = 0;
		if(values != null && values.length > 0) {
			for (double n : values) {
				sum += n;
			}
			 sum /= values.length;
		}
		return sum;
	}

	// calculate arithmetic median
	// he median of a finite list of numbers can be found
	// by arranging all the numbers from smallest to greatest.
	// If there is an odd number of numbers, the middle one is
	// picked. If there is an even number of observations, then
	// there is no single middle value; the median is then usually
	// defined to be the mean of the two middle values
	
	/**
	 * median method is to find out the median of the given array
	 * @param values array for the median to be checked
	 * @return the median of the given array
	 */
	public static double median(double... values) {
		if(values == null || values.length == 0) {
			return 0;
		}
		Arrays.sort(values);
		if(values.length % 2 == 0) {
			return (values[values.length / 2] + values[values.length / 2 - 1])/2;
		}
		else {
			return values[values.length / 2];
		}
	}

	/**
	 * max method is to find out the maximum value contained in an array
	 * @param values array for the maximum value to be checked
	 * @return the maximum value of the given array
	 */
	public static double max(double... values) {
		double max = 0;
		if (values != null && values.length > 0) {
			max = values[0];
			for (int i = 1; i < values.length; i++) {
				if (values[i] > max) {
					max = values[i];
				}
			}
		}
		return max;
	}

	/**
	 * min method is to find out the minimum value contained in an array
	 * @param values array for the minimum value to be checked
	 * @return the minimum value of the given array
	 */
	public static double min(double... values) {
		double min = 0;
		if (values != null && values.length > 0) {
			min = values[0];
			for (int i = 1; i < values.length; i++) {
				if (values[i] < min) {
					min = values[i];
				}
			}
		}
		return min;
	}

}
