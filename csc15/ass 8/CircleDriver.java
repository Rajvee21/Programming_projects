// Circle Project Driver Class: Write a class encapsulating the concept of a circle, assuming a circle has the following attributes: 
// two doubles representing the x and y coordinates of the center of the circle
// a double representing the radius of the circleInclude the following methods:
// two constructors accessor methods mutator methods toString and equals
// methods returning the perimeter (2 * F042* radius) and area (F042* radius2) of the circle

public class CircleDriver {

	public static void main(String[] args) {
		// PROGRAM DESCRIPTION
		System.out.println("SHOWS THE TESTS AND THEIR RESULTS FOR VARIOUS TESTS OF METHODS IN THE Circle() Class.\n");
		
		// Tests for the constructor Methods
		Circle ca = new Circle(); // using default constructor 
		Circle cb = new Circle(3, 6, 21); // using initialized constructor with valid radius
		Circle cc = new Circle(4, 1, -17); // using initialized constructor with invalid radius
		System.out.println("Test for the Constructor Methods:-");
		System.out.printf("The default constructor is used by the circle: %s\n", ca);
		System.out.printf("The initialised constructor used by the circle, \n" +
						      "and Center is at (3, 6) and Radius is = 21: %s\n", cb);
		System.out.printf("The initialised constructor used by the circle, \n" +
						      "and Center is at (4, 1) and Radius is = -17: %s\n\n", cc);
		
		// Tests for the Accessor Methods
		double X = cb.getCenterX(); // X-coordinate of the center
		double Y = cb.getCenterY(); // Y-coordinate of the center
		double R = cb.getRadius(); // radius of the circle
		double PR = cb.getPerimeter(); // perimeter of the circle
		double AR = cb.getArea(); // area of the circle
		System.out.println("Test for the Accessor Methods:-\n" +
		                   "For the Circle cb created with Initialised constructor");
		System.out.printf("X-Coordinate of the center : %s\n", X);
		System.out.printf("Y-Coordinate of the center : %s\n", Y);
		System.out.printf("radius of the Circle : %s\n", R);
		System.out.printf("Perimeter of the circle : %s\n", PR);
		System.out.printf("Area for the Circle : %s\n\n", AR);
		
		// Tests for the Mutator Methods
		System.out.println("Test for the Mutator Methods:-\n" +
				             "For the Circle cc");
		cc.setCenterX(8); // changing the x coordinate of the center to 8
		cc.setCenterY(10); // changing the y coordinate of the center to 10
		cc.setRadius(13); // changing the radius of the circle to 13
		System.out.println("After Changing the Center to (8, 10) and Radius to 13");
		System.out.printf("The Circle is: %s\n", cc);
		cc.setRadius(-7); // changing the radius of the circle to -7
		System.out.println("After Changing the Radius to -7");
		System.out.printf("The Circle is: %s\n\n", cc);
		
		// Testing the Equals Method
		System.out.println("Test for The Equals Method");
		// to display the circle being compared
		System.out.printf("Circle1 is: %s\n", ca);
		System.out.printf("Circle2 is: %s\n", cb);
		// to make the circle cc equal to cb
		cc.setCenterX(3);
		cc.setCenterY(6);
		cc.setRadius(21);
		System.out.printf("Circle3 is: %s\n", cc);
		// string to compare the circle depending on the equals method
		String s;
		// for comparing ca and cb
		if(ca.equals(cb)) {
			s = "is";
		}
		else {
			s = "is not";
		}
		System.out.println("Circle1 " + s + " Equal to(Same as) Circle2");
		// for comparing cb and cc
		if(cb.equals(cc)) {
			s = "is";
		}
		else {
			s = "is not";
		}
		System.out.println("Circle2 " + s + " Equal to(Same as) Circle3");
		// for comparing cc and ca
		if(cc.equals(ca)) {
			s = "is";
		}
		else {
			s = "is not";
		}
		System.out.println("Circle3 " + s + " Equal(Same as) to Circle1");
	}

}
