 //Card


public class Card {
	private int value;
	private boolean faceUp;
	
   //Explicit value constructor initializes value to initValue and faceUp to false.
	public Card(int initValue) {
		value = initValue;
		faceUp = false;
		}
	
   //Returns the value of the instance variable value.
	public int getValue() {
		return value;
	}
	
   //Returns the value of the variable faceUp.
	public boolean isFaceUp(){
		return faceUp;
	}
	
   // Reverses the value of faceUp. 
	public void flipCard() {
		faceUp = !faceUp;
	}
	
   //Sets faceUp to true.
	public void setFaceUp() {
		faceUp = true;
	}
	
   //Sets faceUp to false.
	public void setFaceDown() {
		faceUp = false;
	}
	
   // Returns true if the value of this card is equal to the value of otherCard, otherwise it returns false.
	public boolean equals(Card c) {
		if(value == c.value) {
			return true;
		}
		else{
			return false;
		}
	}
   
   //Returns a String that contains the value of the Card if the card is face-up or an asterisk if the card is face-down.
	public String toString() {
	  if(faceUp) {
		  return String.format("%d",value);
	  }
	  else {
		  return "*";
	  }
	}
}
