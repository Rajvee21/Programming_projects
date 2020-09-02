// Fraction Driver Class: Write a class encapsulating the concept of a fraction, assuming a fraction has the following attributes: //
//Instance variables: An integer representing the numerator An integer representing the denominator //

public class FractionDriver {

		public static void main(String[] args) {
			// Description of the program
			System.out.println("Testing Object Oriented Methods.\n");
			
			
			// test default constructor
			Fraction f = new Fraction();
			// test constructor wit initial values
			Fraction f1 = new Fraction(15, 20);
			
			// test printing the fraction;
			System.out.println("Testing the default constructor");
			System.out.printf("f = %s\n", f);
			System.out.println("Testing constructor with initial values");
			System.out.printf("f1 = %s\n\n", f1);
			
			// test reducing the fraction
		    System.out.println("Testing the getReducedfraction");
			Fraction f2 = f1.getReducedFraction();
			System.out.printf("f2 = %s\n\n", f2);
				
			//testing setNumerator and getNumerator
			System.out.println("Testing the setNumerator");
			f.setNumerator(23);
			System.out.printf("f = %s\n", f);
			System.out.println("Testing the getNumerator");
			int f3num = f.getNumerator();
			System.out.printf("f3num = %s\n\n", f3num);
			
			// testing setDenominator and getDenominator
			System.out.println("Testing the setDenominator");
			f1.setDenominator(8);
			System.out.printf("f1 = %s\n", f1);
			System.out.println("Testing the getDenominator");
			int f3den = f1.getDenominator();
			System.out.printf("f3den = %s\n\n", f3den);
			
			// testing get double fraction
				//creating new fraction
			System.out.println("Testing the getDoubleFraction after creating a new Fraction f3");
			Fraction f3 = new Fraction(f3num, f3den);
			System.out.printf("f3 = %s\n", f3);
			double f3doub = f3.getDoubleFraction();
			System.out.printf("f3doub = %s\n\n", f3doub);
			
			
			// test equality of fractions
			System.out.println("Testing if the fractions are equal");
			System.out.println("Testing if f and f1 are equal....");
			System.out.println(f.equals(f1));
			System.out.println("Testing if f2 and f3 are equal....");
			System.out.println(f2.equals(f3));
			System.out.println("Testing if f1 and f3 are equal....");
			System.out.println(f1.equals(f3));
	
			
		}

	}


