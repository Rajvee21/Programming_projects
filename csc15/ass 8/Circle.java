// Circle Project

public class Circle {
    
	// fields for the class
	/**
	 * X co-ordinate of center of the circle
	 */
	private double centerX;
	
	/**
	 * Y co-ordinate of center of the circle
	 */
	private double centerY;
	
	/**
	 * radius of the circle
	 */
	private double radius;
	
	/**
	 * Value of pi to  be used in calculation of perimeter and the area
	 */
	double p = Math.PI;
	
	
	public Circle() {
		
		// Call the explicit value constructor (as code already written)
		this(0.0, 0.0, 1.0);
	}
	
	
	/**
	 * Constructor with values of the coordinates and the radius specified
	 * @param initCenterX
	 * @param initCenterY
	 * @param initRadius
	 */
	public Circle(double initCenterX, double initCenterY, double initRadius) {
		centerX = initCenterX;
		centerY = initCenterY;
		setRadius(initRadius);
		
	}
	
	/**
	 * Sets the radius of the circle 
	 * @param newRadius is the desired new radius of the Circle
	 */
	public void setRadius(double newRadius) {
		if(newRadius >= 0) {
			radius = newRadius;
		}
      // set the radius to 0 for invalid radius values
		else { 
			radius = 0;
		}
		
	}


	/**
	 * sets the x coordinate of the center of the circle
	 * @param newCenterx is the desired new x coordinate of the center
	 */
	public void setCenterX(double newCenterX) {
		centerX = newCenterX;
	}
	
	
	/**
	 * sets the y coordinate of the center of the circle
	 * @param newCenterY is the desired new y coordinate of the center
	 */
	public void setCenterY(double newCenterY) {
		centerY = newCenterY;
	}
	
	
	/**
	 * to store the x coordinate only of the center of the circle separately
	 * @return x coordinate of the center 
	 */
	public double getCenterX() {
		return centerX;
	}
	
	
	/**
	 * to store the y coordinate only of the center of the circle separately
	 * @return y coordinate of the center 
	 */
	public double getCenterY() {
		return centerY;
	}
	
	
	/**
	 * to store separately the Radius of the circle only 
	 * @return Radius of the circle 
	 */
	public double getRadius() {
		return radius;
	}
	
	/**
	 * to the perimeter of the circle calling the method
	 * @return perimeter of the circle
	 */
	public double getPerimeter() {
		// formula perimeter of a circle
		return  (2 * p * radius) ;
	}
	
	
	/**
	 * to the area of the circle calling the method
	 * @return value area of the circle
	 */
	public double getArea() {
		// formula of perimeter of a circle
		return  (p * radius * radius) ;
	}
	
	
	/**
	 * returns the true if the two Circles are equal(that is the same)
	 * @param otherCir Circle to be equated with the first
	 * @return true or false depending on the comparison
	 */
	public boolean equals(Circle otherCir) {
       // as for the circle to be same both the center and the radius has to be equal
		// comparing both the coordinates of the center and the radius also
	   return radius == otherCir.radius &&
			  centerX == otherCir.centerX &&
			  centerY == otherCir.centerY ;
	}
	
	/**
	 * String representation for the Circle
	 */
	public String toString() {
		return String.format("Center: (%.2f, %.2f), Radius: %.2f.",
							  centerX, centerY, radius);
	}

}
