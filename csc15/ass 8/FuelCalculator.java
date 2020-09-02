//Fuel calculator Project 
//This class defines a Fuel Calculator class to keep track of the
//distance traveled, fuel consumed, and the cost of the gas.
//It includes functions to calculate the fuel efficiency for the trip in miles per gallon and the average cost of a gallon of gas.



public class FuelCalculator {
	
	// instance variables
	private int milesDriven; // - milesDriven
	private double gasUsed; // - gasUsed
	private double totalCost; // -totalCost
	
	
	// reset – resets the miles driven to 0 and gallons of gas used to 0
	 
	public void reset() {
		milesDriven = 0;
		gasUsed = 0;
		totalCost = 0;
	}

	/*
	 *  logMiles – adds:
	 *  				the number of new miles driven
	 *  				the gallons of gas used to drive those miles
	 *  				the cost of that gas
	 */
	public boolean logMiles(int newMilesDriven, double gasUsed,double costPerGallon) {
		if(newMilesDriven>=0 && gasUsed>=0){
			milesDriven += newMilesDriven;
			this.gasUsed += gasUsed;
			totalCost += costPerGallon*gasUsed;
			return true;
		}
		else {
			return false;
		}
	}

	// accessor methods
	
	//get the miles driven
	public int getMiles() {
		return milesDriven;
	}
	
	//get the gallons of gas used
	public double getGasUsed() {
		return gasUsed;
	}
	
	//get the total cost of the gas used
	public double getTotalCost() {
		return totalCost;
	}
	
	//get the fuel efficiency for this trip in miles per gallon
	public double getFuelEfficiency() {
		if(gasUsed > 0) { 
			return milesDriven/gasUsed; // formula to find miles per gallon
		}
		else
		{
			return 0;   // cannot calculate efficiency if no gas used
		}
			
	}

	//get the average cost of a gallon of gas
	public double getCostPerGallon() {
		if(gasUsed > 0) { 
			return totalCost/gasUsed; // formula to find average cost of a gallon of gas
		}
		else
		{
			return 0;	
		}
	}
	
	/*
	 * equals method compares the fuel efficiency of two FuelCalculators. 
	 * Two FuelCalculators are equal if their fuel efficiency is equal within a tenth of a gallon gas used per mile travelled.
	 */
	public boolean equals(FuelCalculator otherCalculator) {
		double difference = getFuelEfficiency() - otherCalculator.getFuelEfficiency();
		return Math.abs(difference) < 0.1;
	}
	
	/*
	 * toString method returns a String that contains the values for the miles driven, gallons used and the fuel efficiency
	 */
	public String toString() {
		double efficiency = getFuelEfficiency(); // get fuel efficiency
		double avg_cost = getCostPerGallon();   // get the average cost of a gallon of gas
		return String.format("Miles Driven: %d     Gas Used: %.1f gallons     Total Cost: $%.2f\n"
							+ "Efficiency:%.1f mpg     Average Cost: $%.2f per gallon",
							  milesDriven, gasUsed, totalCost, efficiency, avg_cost);
	}


} 