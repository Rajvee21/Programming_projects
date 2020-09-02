/* Fuel Calculator Tester:This is a tester file which tests my program. */


public class FuelCalculatorTester {
	public static void main(String[] args) {
		System.out.println("CSC15 -					Rajvee Modi\n");
		
		FuelCalculator myHighwayDriving, myCityDriving, myOtherCar; // Declare the variables 
		myHighwayDriving = new FuelCalculator();  //   Instantiates the
		myCityDriving = new FuelCalculator();    // FuelCalculator Objects
		myOtherCar = new FuelCalculator(); 		// used for testing equals method below
		
		// Testing the toString method
		System.out.println("TESTING the toString method: \n");
		System.out.println("myHighwayDriving is:\n" + myHighwayDriving);
		System.out.println();
		
		
		// Testing the logMiles method
		System.out.println("TESTING the logMiles method using: \n" +
						   "     logMiles(100, 4.0, 3.00)\n");
		if(myHighwayDriving.logMiles(100, 4.0, 3.00)) {
			// Prints Current values hold by myHighwayDriving object 
			System.out.println("myHighwayDriving is:\n" + myHighwayDriving);
			System.out.println();
		}
		else {
			System.out.println("logMiles method returned false!");
		}
		
		// Another test for logMiles method
		System.out.println("After logMiles(44, 2.0, 2.00)\n");
		
		if(myHighwayDriving.logMiles(44, 2.0, 2.00)) {
			// Prints Current values hold by myHighwayDriving object 
			System.out.println("myHighwayDriving is:\n" + myHighwayDriving);	
			System.out.println();
		}
		else {
			System.out.println("logMiles method returned false!");
		}
		
		
		// Testing the Accessor methods
		
		// For getMiles
		System.out.println("TESTING the getMiles method:");
		System.out.printf("myHighwayDriving miles are: %d\n", myHighwayDriving.getMiles());
		System.out.println();

		// For getGasUsed
		System.out.println("TESTING the getGasUsed method: ");
		System.out.printf("myHighwayDriving gas used is: %.1f\n", myHighwayDriving.getGasUsed());
		System.out.println();

		// For getTotalCost
		System.out.println("TESTING the getTotalCost method: ");
		System.out.printf("myHighwayDriving total cost is: %.1f\n", myHighwayDriving.getTotalCost());
		System.out.println();
		
		
		// Testing the reset Method
		System.out.println("TESTING the reset method:");
		myHighwayDriving.reset();
		// Prints the values of myHighwayDriving object after being reset
		System.out.println("After reseting myHighwayDriving it is:");
		System.out.println("myHighwayDriving is:\n" + myHighwayDriving);
		System.out.println();
		
		
		// Testing the Equals Method
		System.out.println("TESTING The equals method\n");
		System.out.println("The FuelCalculators being tested are:\n");
		myHighwayDriving.logMiles(1000, 31.0, 3.09);
		myCityDriving.logMiles(100, 3.0, 2.99);
		myOtherCar.logMiles(1001, 31.0, 3.09);
		System.out.println("myHighwayDriving:\n" + myHighwayDriving);
		System.out.println();
		System.out.println("myCityDriving:\n" + myCityDriving);
		System.out.println();
		System.out.println("myOtherCar:\n" + myOtherCar);
		System.out.println();
		
		// if/else statement to check if the FuelCalculators are equal 
		// Comparison of myHighwayDriving and myCityDriving  
		System.out.print("myHighwayDriving is");
		if(myHighwayDriving.equals(myCityDriving))
			System.out.print(" EQUAL TO ");
		else
			System.out.print(" NOT EQUAL TO ");
		System.out.println(" myCityDriving.");
		
		// Comparison of myHighwayDriving and myOtherCar 
		System.out.print("myHighwayDriving is");
		if(myHighwayDriving.equals(myOtherCar))
			System.out.print(" EQUAL TO ");
		else
			System.out.print(" NOT EQUAL TO ");
		System.out.println(" myOtherCar.");
		
	}
}
