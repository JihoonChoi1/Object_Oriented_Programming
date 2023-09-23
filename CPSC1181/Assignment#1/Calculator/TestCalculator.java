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

	}

	@Test
	void testAdd() {
		assertEquals(15, Calculator.add(10, 5));
		assertEquals(16, Calculator.add(37,-21));
	}

	@Test
	void testMultiply() {

	}

	@Test
	void testSubtract() {

	}

	@Test
	void testDivide() {

	}

	@Test
	void testAverage() {

	}


	@Test
	void testMedian() {

	}

	@Test
	void testMax() {

	}
	
	@Test
	void testMin() {

	}
}
