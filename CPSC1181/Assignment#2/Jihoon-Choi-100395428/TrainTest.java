import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * TrainTest program is meant for testing all the methods made in Train class
 * @author Jihoon Choi
 * @since 2022-09-28
 */
class TrainTest {
	
	@Test
	void testConstructor() {
		try {
			Train train = new Train(null, 3);
			fail("Train constructor didn't throw exception for null String");
		}
		catch(NullPointerException e){}
		
		try {
			Train train = new Train(null, -1);
			fail("Train constructor didn't throw exception for null String");	
		}
		catch(NullPointerException e) {}
		
		try {
			Train train = new Train("", -1);
			fail("Train constructor didn't throw exception for negative power");
		}
		catch(IllegalArgumentException e) {}
		
		Train train = new Train("train", 3);
		assertEquals("train", train.getName());
	}
	
	@Test
	void testGetSetName() {
		Train train = new Train("", 0);
		assertEquals("", train.getName());
		
		try {
			train.setName(null);
			fail("setName method didn't throw exception for null String");
		}
		catch(NullPointerException e) {}
		train.setName("train1");
		assertEquals("train1", train.getName());
		train.setName("");
		assertEquals("", train.getName());
	}
	
	@Test
	void testGetSetPower() {
		Train train = new Train("", 0);
		assertEquals(0, train.getPower());
		
		try {
			train.setPower(-1);
			fail("setPower method didn't throw exception for negative power");
		}
		catch(IllegalArgumentException e) {}
		
		train.setPower(150);
		assertEquals(150, train.getPower());
		train.setPower(0);
		assertEquals(0, train.getPower());
	}
	
	@Test
	void testGetAddCars() {
		Train train = new Train("", 0);
		try {
			train.addCars(null);
			fail("addCars method didn't throw exception for negative weight car");
		}
		catch(NullPointerException e) {}

		try {
			train.addCars(new int[] {-1, 1, 1});
			fail("addCars method didn't throw exception for negative weight car");
		}
		catch(IllegalArgumentException e) {}
		
		try {
			train.addCars(new int[] {1, -1, 1});
			fail("addCars method didn't throw exception for negative weight car");
		}
		catch(IllegalArgumentException e) {}
		
		try {
			train.addCars(new int[] {1, 1, -1});
			fail("addCars method didn't throw exception for negative weight car");
		}
		catch(IllegalArgumentException e) {}

		assertArrayEquals(new int[] {}, train.getCars());
		train.addCars(new int[] {});
		assertArrayEquals(new int[] {}, train.getCars());
		train.addCars(new int[] {1, 2});
		assertArrayEquals(new int[] {1,2}, train.getCars());
		train.addCars(new int[] {3,4});
		assertArrayEquals(new int[] {1,2,3,4}, train.getCars());
	}
	
	@Test
	void testRemoveAllCars() {
		Train train = new Train("train", 150);
		train.addCars(new int[] {1,2,3});
		assertArrayEquals(new int[] {1,2,3}, train.getCars());
		train.removeAllCars();
		assertArrayEquals(new int[] {}, train.getCars());
		
		Train train2 = new Train("train2", 150);
		train2.addCars(new int[] {1,2});
		assertArrayEquals(new int[] {1,2}, train2.getCars());
		train2.removeAllCars();
		assertArrayEquals(new int[] {}, train2.getCars());
	}
	
	@Test
	void testGetTotalWeightOfCars() {
		Train train = new Train("train", 150);
		assertEquals(0, train.getTotalWeightOfCars());
		train.addCars(new int[] {1, 2, 3});
		assertEquals(6, train.getTotalWeightOfCars());
		train.addCars(new int[] {4,5,6});
		assertEquals(21, train.getTotalWeightOfCars());
	}
	
	@Test
	void testgetNumberOfCars() {
		Train train = new Train("train", 150);
		assertEquals(0, train.getNumberOfCars());
		train.addCars(new int[] {1, 2, 3});
		assertEquals(3, train.getNumberOfCars());
		train.addCars(new int[] {4,5,6});
		assertEquals(6, train.getNumberOfCars());
	}
	
	@Test
	void testgetMaxSpeed() {
		Train train = new Train("train", 150);
		assertEquals(150, train.getMaxSpeed());
		train.addCars(new int[] {1, 2, 3});
		assertEquals(144, train.getMaxSpeed());
		train.addCars(new int[] {4,5,6});
		assertEquals(129, train.getMaxSpeed());
		
		Train train2 = new Train("train2", 10);
		assertEquals(10, train2.getMaxSpeed());
		train2.addCars(new int[] {1, 2, 3});
		assertEquals(4, train2.getMaxSpeed());
		train2.addCars(new int[] {4,5,6});
		assertEquals(0, train2.getMaxSpeed());
	}
	
	@Test
	void testmergeTrains() {
		Train train1 = new Train("train1", 150);
		Train train2 = new Train("train2", 150);
		Train train3 = null;
		
		try {
			train2.mergeTrains(train3);
			fail("mergeTrains method didn't throw exception for null object");
		}
		catch(NullPointerException e) {}
		
		train1.addCars(1,2,3);
		train2.addCars(4,5,6);
		train2.mergeTrains(train1);
		assertEquals(0, train1.getPower());
		assertArrayEquals(new int[] {}, train1.getCars());
		assertEquals(300, train2.getPower());
		assertArrayEquals(new int[] {4,5,6,1,2,3}, train2.getCars());
	}
}
