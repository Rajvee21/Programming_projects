// SoccerPlayer class 

public class SoccerPlayer extends Player{   //child class which is extended from player class 
	
   //constructor 
	private int goals, fouls, redCard, yellowCard, offside, assist;
	private String teamName;
	
	public SoccerPlayer(String name, double salary, int number, int goals, int fouls, int redCard, int yellowCard, int offside, int assist, String teamName) {
		super(name, salary, number);
		this.goals = goals;
		this.fouls = fouls;
		this.redCard = redCard;
		this.yellowCard = yellowCard;
		this.offside = offside;
		this.assist = assist;
		this.teamName = teamName;
	}
   
   //Getter and Setter methods
	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public int getFouls() {
		return fouls;
	}

	public void setFouls(int fouls) {
		this.fouls = fouls;
	}

	public int getRedCard() {
		return redCard;
	}

	public void setRedCard(int redCard) {
		this.redCard = redCard;
	}

	public int getYellowCard() {
		return yellowCard;
	}

	public void setYellowCard(int yellowCard) {
		this.yellowCard = yellowCard;
	}

	public int getOffside() {
		return offside;
	}

	public void setOffside(int offside) {
		this.offside = offside;
	}

	public int getAssist() {
		return assist;
	}

	public void setAssist(int assist) {
		this.assist = assist;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
   //toString method
	public String toString() {
		String s = super.toString();
		s += "\nGoals: "+ this.goals +
			 "\nFouls: "+ this.fouls +
			 "\nRed Card: "+ this.redCard +
			 "\nYellow Card: "+ this.yellowCard +
			 "\nOffside: " + this.offside +
			 "\nAssist: " + this.assist + 
			 "\nTeam Name: " + this.teamName+"\n";
		
      //returns the value
		return s;
	}
	
   //equals method
	public boolean equals(SoccerPlayer p1) {
		return (this.equals(p1) && super.equals(p1));
	}
	
   //pulls out the player who has more than three fouls or two yellow card
	public boolean pullOutPlayer() {
		return (this.fouls > 3 || this.yellowCard >= 2) ? false : true;
	}
}
