// BasketBallPlayer class 

public class BasketBallPlayer extends Player {   //child class which is extended from player class 
   
   //constructor
	private int threePointer, turnOvers, assist, rebounds, twoPointers;
	private String teamName;
	
	public BasketBallPlayer(String name, double salary, int number, int threePointer, int turnOvers, int assist, int rebounds, int twoPointers, String teamName) {
		super(name, salary, number);
		this.setThreePointer(threePointer);
		this.setTurnOvers(turnOvers);
		this.setAssist(assist);
		this.setRebounds(rebounds);
		this.setTwoPointers(twoPointers);
		this.setTeamName(teamName);
	}
   
   //Getter and Setter methods
	public int getThreePointer() {
		return threePointer;
	}

	public void setThreePointer(int threePointer) {
		this.threePointer = threePointer;
	}

	public int getTurnOvers() {
		return turnOvers;
	}

	public void setTurnOvers(int turnOvers) {
		this.turnOvers = turnOvers;
	}

	public int getAssist() {
		return assist;
	}

	public void setAssist(int assist) {
		this.assist = assist;
	}

	public int getRebounds() {
		return rebounds;
	}

	public void setRebounds(int rebounds) {
		this.rebounds = rebounds;
	}

	public int getTwoPointers() {
		return twoPointers;
	}

	public void setTwoPointers(int twoPointers) {
		this.twoPointers = twoPointers;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
   //equals method
	public boolean equals(BasketBallPlayer p1) {
		return (this.equals(p1) && super.equals(p1));
	}
	
   //toString method
	public String toString() {
		String s = super.toString();
		s += "\nThree Pointer: "+this.threePointer +
			 "\nTurn Overs: "+ this.turnOvers + 
			 "\nAssist: "+ this.assist +
			 "\nRebounds: "+ this.rebounds +
			 "\nTwo Pointers: "+ this.twoPointers +
			 "\nTeam Name: "+ this.teamName+"\n";
		
      //returns the value 
		return s;
	}
	
   //adds up three pointers and two pointers 
	public int getTotalPoints() {
		return this.threePointer + this.twoPointers;
	}

}
