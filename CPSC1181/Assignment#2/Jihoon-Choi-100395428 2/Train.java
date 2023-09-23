import java.util.Arrays;
/**
 * Train class simulates a freight train that consists of bunch of setters, getters, and a merge method.
 * @author Jihoon Choi
 * @since 2022-09-27
 */
public class Train {
	private String name;
	private int power;
	private int[] cars = {};
	
	/**
	 * A constructor that takes the string and integer as parameters to assign the name and the power of such object
	 * @param name String to assign the name of the active object and shouldn't be null.
	 * @param power integer to assign the power of the active object and shouldn't be negative.
	 */
	public Train(String name, int power) {
		if(name == null) {
			throw new NullPointerException("name must not be null");
		}
		if(power < 0) {
			throw new IllegalArgumentException("power must not be negative");
		}
		this.name = name;
		this.power = power;
	}
	
	/**
	 * getName method returns the name of the active object
	 * @return the name of the active object
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * setName method is to set the name of the active object
	 * @param name the name which will be assigned to member variable. Shouldn't be null.
	 */
	public void setName(String name) {
		if(name == null) {
			throw new NullPointerException("name must not be null");
		}
		this.name = name;
	}
	
	/**
	 * getPower method returns the power of the active object
	 * @return the power of the active object
	 */
	public int getPower() {
		return power;
	}
	
	/**
	 * setPower method is to set the power of the active object
	 * @param power the power which will be assigned to member variable. Shouldn't be null
	 */
	public void setPower(int power) {
		if(power < 0) {
			throw new IllegalArgumentException("power must not be negative");
		}
		this.power = power;
	}

	/**
	 * getCars method returns the copy of cars array of the active object
	 * @return the cars array of the active object
	 */
	public int[] getCars() {
		return Arrays.copyOf(this.cars, this.cars.length);
	}
	
	/**
	 * addCars method is to add the parameter array to the cars array of the active object
	 * @param weights Passed array to be added. Shouldn't be null
	 */
	public void addCars(int... weights) {
		if(weights == null) {
			throw new NullPointerException("Passed parameter object shouldn't be null");
		}
		
		for(int i = 0 ; i < weights.length ; i++) {
			if(weights[i] < 0) {
				throw new IllegalArgumentException("Weight of car must not be negative");
			}
		}
		
		int[] temp = new int[this.cars.length + weights.length];
		
		for(int i = 0 ; i < this.cars.length ; i++) {
			temp[i] = this.cars[i];
		}
		
		for(int i = this.cars.length, j = 0 ; i < this.cars.length + weights.length ; i++, j++) {
			temp[i] = weights[j];
		}
		
		this.cars = temp;
	}
	
	/**
	 * removeAllCars method is to remove all the cars of the active object
	 */
	public void removeAllCars() {
		this.cars = new int[] {};
	}
	
	/**
	 * getTotalWeightOfCars method is to sum up all values in cars array of the active object and return the sum value
	 * @return the sum of weight of cars
	 */
	public int getTotalWeightOfCars() {
		int sum = 0;
		for(int i = 0 ; i < this.cars.length; i++) {
			sum += this.cars[i];
		}
		return sum;
	}
	
	/**
	 * getNumberOfCars method counts the number of cars of the active object and returns the number of cars
	 * @return the number of cars existing in the active object
	 */
	public int getNumberOfCars() {
		return this.cars.length;
	}
	
	/**
	 * getMaxSpeed method calculates the max speed of the active object and returns the max speed
	 * @return the max speed of an active object
	 */
	public int getMaxSpeed() {
		int MaxSpeed = 0;
		
		if(this.power >= 150) {
			MaxSpeed = 150;
			MaxSpeed -= this.getTotalWeightOfCars();
		}
		else{
			MaxSpeed = this.power;
			MaxSpeed -= this.getTotalWeightOfCars();
		}
		
		if(MaxSpeed < 0) {
			return 0;
		}
		else {
			return MaxSpeed;
		}
	}
	
	/**
	 * mergeTrains method adds all of the locomotive power and cars from the other train to the current train. 
	 * So after calling train1.mergeTrains(train2) the parameter train will have no cars and 0 locomotive 
	 * power when done. They will all have been added to train1.
	 * @param other parameter Train object to be merged.
	 */
	public void mergeTrains(Train other) {
		if(other == null) {
			throw new NullPointerException("Passed parameter object shouldn't be null");
		}
		this.power += other.getPower();
		other.setPower(0);
		this.addCars(other.getCars());
		other.removeAllCars();
	}
	
	/**
	 * returns a string summary of the Train object.
	 */
	public String toString() {
		String result = "****Train: " + this.name + "****";
		result += "\nPower: " + this.power;
		result += "\nCars: ";
		for(int i = 0 ; i < this.cars.length ; i++) {
			result += this.cars[i] + " ";
		}
		return result + "\n";
	}	
}
