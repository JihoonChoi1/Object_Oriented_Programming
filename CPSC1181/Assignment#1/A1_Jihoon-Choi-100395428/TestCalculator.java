/**
 * TestCalculator program is meant for testing all the methods made in Calculator program.
 * @author Jihoon Choi
 * @since 2022-09-18
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * A class for testing the methods of the Calculator class behave
 * as expected.
 * See: http://junit.sourceforge.net/javadoc/org/junit/Assert.html
 * For more JUnit Assertion Statements
 */
class TestCalculator {

	@Test
	void testRemainder() {
		try {
			Calculator.remainder(3,0);
			fail("Expected an ArithmeticException");
		}
		catch(ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}
		
		try {
			Calculator.remainder(-3,0);
			fail("Expected an ArithmeticException");
		}
		catch(ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}
		
		try {
			Calculator.remainder(0,0);
			fail("Expected an ArithmeticException");
		}
		catch(ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}
		
		assertEquals(0, Calculator.remainder(0,1));
		assertEquals(0, Calculator.remainder(0,-1));
		assertEquals(4, Calculator.remainder(4,7));
		assertEquals(-4, Calculator.remainder(-4,7));
		assertEquals(4, Calculator.remainder(4,-7));
		assertEquals(-4, Calculator.remainder(-4,-7));
		assertEquals(3, Calculator.remainder(7,4));
		assertEquals(-3, Calculator.remainder(-7,4));
		assertEquals(3, Calculator.remainder(7,-4));
		assertEquals(-3, Calculator.remainder(-7,-4));
	}

	@Test
	void testAdd() {
		assertEquals(15, Calculator.add(10, 5));
		assertEquals(16, Calculator.add(37,-21));
		assertEquals(-28, Calculator.add(-7,-21));
		assertEquals(8.5, Calculator.add(1.2, 7.3), 0.01);
		assertEquals(-4.9, Calculator.add(-6.2 , 1.3), 0.01);
		assertEquals(-7.5, Calculator.add(-6.2 , -1.3), 0.01);
		assertEquals(0, Calculator.add(0, 0));
		assertEquals(4, Calculator.add(4, 0));
		assertEquals(-4, Calculator.add(-4, 0));
		assertEquals(4.1, Calculator.add(4.1, 0), 0.01);
		assertEquals(-4.1, Calculator.add(-4.1, 0), 0.01);
		assertEquals(4.4, Calculator.add(3.4, 1), 0.01);
		assertEquals(-2.4, Calculator.add(-3.4, 1), 0.01);
		assertEquals(2.4, Calculator.add(3.4, -1), 0.01);
		assertEquals(-4.4, Calculator.add(-3.4, -1), 0.01);
	}

	@Test
	void testMultiply() {
		assertEquals(50, Calculator.multiply(10, 5));
		assertEquals(-50, Calculator.multiply(10,-5));
		assertEquals(50, Calculator.multiply(-10, -5));
		assertEquals(8.76, Calculator.multiply(1.2, 7.3), 0.001);
		assertEquals(-8.76, Calculator.multiply(-1.2 , 7.3), 0.001);
		assertEquals(8.76, Calculator.multiply(-1.2 , -7.3), 0.001);
		assertEquals(0, Calculator.multiply(0, 0));
		assertEquals(0, Calculator.multiply(4, 0));
		assertEquals(0, Calculator.multiply(-4, 0), 0.01); //why is the value -0.0
		assertEquals(0, Calculator.multiply(4.1, 0), 0.01);
		assertEquals(0, Calculator.multiply(-4.1, 0), 0.01);
		assertEquals(3.4, Calculator.multiply(3.4, 1), 0.01);
		assertEquals(-3.4, Calculator.multiply(-3.4, 1), 0.01);
		assertEquals(-3.4, Calculator.multiply(3.4, -1), 0.01);
		assertEquals(3.4, Calculator.multiply(-3.4, -1), 0.01);
		assertEquals(0, Calculator.multiply(-4, 0), 0.01);
	}

	@Test
	void testSubtract() {
		assertEquals(5, Calculator.subtract(10, 5));
		assertEquals(58, Calculator.subtract(37,-21));
		assertEquals(14, Calculator.subtract(-7,-21));
		assertEquals(-6.1, Calculator.subtract(1.2, 7.3), 0.01);
		assertEquals(-7.5, Calculator.subtract(-6.2 , 1.3), 0.01);
		assertEquals(-4.9, Calculator.subtract(-6.2 , -1.3), 0.01);
		assertEquals(0, Calculator.subtract(0, 0));
		assertEquals(4, Calculator.subtract(4, 0));
		assertEquals(-4, Calculator.subtract(-4, 0));
		assertEquals(4.1, Calculator.subtract(4.1, 0), 0.01);
		assertEquals(-4.1, Calculator.subtract(-4.1, 0), 0.01);
		assertEquals(2.4, Calculator.subtract(3.4, 1), 0.01);
		assertEquals(-4.4, Calculator.subtract(-3.4, 1), 0.01);
		assertEquals(4.4, Calculator.subtract(3.4, -1), 0.01);
		assertEquals(-2.4, Calculator.subtract(-3.4, -1), 0.01);
	}

	@Test
	void testDivide() {
		assertEquals(2, Calculator.divide(10, 5));
		assertEquals(-2, Calculator.divide(10,-5));
		assertEquals(2, Calculator.divide(-10,-5));
		assertEquals(0.16, Calculator.divide(1.2, 7.3), 0.01);
		assertEquals(-0.16, Calculator.divide(-1.2, 7.3), 0.01);
		assertEquals(0.16, Calculator.divide(-1.2 , -7.3), 0.01);
		assertEquals(Double.NaN, Calculator.divide(0, 0));
		assertEquals(Double.POSITIVE_INFINITY, Calculator.divide(4, 0));
		assertEquals(Double.NEGATIVE_INFINITY, Calculator.divide(-4, 0));
		assertEquals(Double.POSITIVE_INFINITY, Calculator.divide(4.1, 0), 0.01);
		assertEquals(Double.NEGATIVE_INFINITY, Calculator.divide(-4.1, 0), 0.01);
		assertEquals(3.4, Calculator.divide(3.4, 1), 0.01);
		assertEquals(-3.4, Calculator.divide(-3.4, 1), 0.01);
		assertEquals(-3.4, Calculator.divide(3.4, -1), 0.01);
		assertEquals(3.4, Calculator.divide(-3.4, -1), 0.01);
	}

	@Test
	void testAverage() {
		assertEquals(0, Calculator.average(null));
		assertEquals(0, Calculator.average(new double[] {}));
		assertEquals(0, Calculator.average(new double[] {0}));
		assertEquals(0.5, Calculator.average(new double[] {1,0}), 0.01);
		assertEquals(2, Calculator.average(new double[] {1,2,3}));
		assertEquals(1.33, Calculator.average(new double[] {-1,2,3}), 0.01);
		assertEquals(0, Calculator.average(new double[] {-1,-2,3}));
		assertEquals(-2, Calculator.average(new double[] {-1,-2,-3}));
	}


	@Test
	void testMedian() {
		assertEquals(0, Calculator.median(null));
		assertEquals(0, Calculator.median(new double[] {}));
		assertEquals(0, Calculator.median(new double[] {0}));
		assertEquals(0.5, Calculator.median(new double[] {0,1}), 0.01);
		assertEquals(2, Calculator.median(new double[] {1,2,3}));
		assertEquals(2.5, Calculator.median(new double[] {1,2,3,4}), 0.01);
		assertEquals(1, Calculator.median(new double[] {-2,-1,3,4}));
		assertEquals(-1.5, Calculator.median(new double[] {-3, -2, -1, 0}), 0.01);
	}

	@Test
	void testMax() {
		assertEquals(0, Calculator.max(null));
		assertEquals(0, Calculator.max(new double[] {}));
		assertEquals(1, Calculator.max(new double[] {1}));
		assertEquals(2, Calculator.max(new double[] {1, 2}));
		assertEquals(0, Calculator.max(new double[] {-1, 0}));
		assertEquals(-3, Calculator.max(new double[] {-5, -3, -4}));
	}
	
	@Test
	void testMin() {
		assertEquals(0, Calculator.min(null));
		assertEquals(0, Calculator.min(new double[] {}));
		assertEquals(1, Calculator.min(new double[] {1}));
		assertEquals(1, Calculator.min(new double[] {1, 2}));
		assertEquals(-1, Calculator.min(new double[] {-1, 0}));
		assertEquals(-5, Calculator.min(new double[] {-5, -3, -4}));
	}
}
