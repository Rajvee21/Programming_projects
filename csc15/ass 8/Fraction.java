/* Reprsesntation of a fraction */


	public class Fraction {
	/** 
	 * the numerator portion of the fraction
	 */

	private int numerator;
	/**
	 *  the denominator of the fraction
	 */

	private int denominator;
	/** 
	 * default constructor. will default the number to
	 * 0 and the denominator to 1. 
	 */

	public Fraction() {
	 numerator = 0;
	 denominator = 1;
	}

	/** 
	 * Constructor with initial values
	 * @param initNumerator initial value for the numerator
	 * @param initDenomiantor initial value for the denominator
	 * if set to 0 then it will be changed to 1.
	 */

	public Fraction(int initNumerator, int initDenominator) {
	 numerator = initNumerator;
	 if(initDenominator == 0) {
	  System.out.println("Cannot have a 0 denominator, setting to 1");
	  initDenominator = 1;
	}
	denominator = initDenominator;
	}

	/** 
	 * sets the numerator of the fraction
	 * @param newNumerator of the new value 
	 */

	public void setNumerator(int newNumerator) {
	       numerator = newNumerator;
	 }


	/**
	 * return a boolean variable called success that will indicate whether or
	 *not this method was successful. The method should begin by setting success to true. It should then
	 *validate the newDenominator and set the denominator to newDenominator if newDenominator != 0,
	 *otherwise it will not change the value of the denominator and it will set success to false.
	 *@param newDenominator the new value 
	 *@return true if successful
	 */

	public boolean setDenominator(int newDenominator) {
	 boolean success = true;
	 if(newDenominator == 0) {
	  success = false;
	 
	 } else {
	  denominator = newDenominator;
	 }
	 return success;
	}

	public int getNumerator() {
	 return numerator;
	}

	public int getDenominator() {
	 return denominator;
	}

	public double getDoubleFraction() {
	 return (double)numerator / (double)denominator;
	}

	/**
	 * Reduces the form of the fraction and
	 * returns a new fraction in the reduced form
	 * @return The new fraction 
	 */

	public Fraction getReducedFraction() {
	 int gcdVal = gcd();
	 Fraction reduced = new Fraction();
	 reduced.numerator = numerator / gcdVal;
	 reduced.denominator = denominator / gcdVal;
	 
	 return reduced;
	}

	/**
	 * Reduced true if two fractions reduced 
	 * forms are equal
	 * @param otherFrcat The fraction to compare to
	 * @return true if the reduced fractions are 
	 * equal
	 */

	public boolean equals(Fraction otherFract) {
	 Fraction f1 = getReducedFraction();
	 Fraction f2 = otherFract.getReducedFraction();
	 
	 return f1.numerator == f2.numerator &&
	    f1.denominator == f2.denominator;
	}

	/**
	 * String representation of the Fraction object
	 */

	public String toString() {
	 String myFraction;
	 myFraction = String.format("%d/%d",
	   numerator, denominator);
	 return myFraction;
	}

	private int gcd() {
	 // Set values x and y to numerator and
	 // denominator
	 int x = numerator, y = denominator;
	 
	 // Loop while y != 0
	   while(y != 0) {
	    // Euclid's algorithm 
	    int temp = x % y;
	    x = y;
	    y = temp;
	   }
	   
	   return x;
	}
	}




