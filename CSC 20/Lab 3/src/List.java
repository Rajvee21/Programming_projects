
public interface List {

	//Adds the digit to the most significant position in the list
	public void addMostSignificant (int digit);	
	
	//Adds the digit to the least significant position
	public void addLeastSignificant(int digit);
	
	//Inserts the digit to the given position
	public void insert(int position,int digit);

	//Finds the sum of the longNumber this and number returns the result as a string
	public String Add(LongNumber num);
	
	//Delete the digit at the given position. 
	public void delete (int position);	
		
}
