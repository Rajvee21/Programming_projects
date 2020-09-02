//Exception class called NegativeSide that extends the Exception class. This exception
//will be thrown if any of the given sides are negative.

public class NegativeSide extends Exception {

	public NegativeSide (String message) {
		super(message);
	}
	
}
