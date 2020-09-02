// SoccerTeam class 

import java.util.*;
import java.io.*;

public class SoccerTeam {
   
   //creates the array list which includes the list of player xtracting from soccer player class
	private ArrayList<Player> team = new ArrayList<Player>();

	public SoccerTeam() throws FileNotFoundException {
      
      //creates new file 
      //constructor 
		File file = new File("fangshiwei_50166_1975896_bearcatlist.txt");
		Scanner scan = new Scanner(file); 
		
		while(scan.hasNextLine()) {
			
			String firstName = scan.next();
			String lastName = scan.next();
			double salary = scan.nextDouble();
			int number = scan.nextInt();
			int goals = scan.nextInt();
			int fouls = scan.nextInt();
			int redCard = scan.nextInt();
			int yellowCard = scan.nextInt();
			int offside = scan.nextInt();
			int assist = scan.nextInt();
			String teamName = scan.next();
			
			SoccerPlayer player = new SoccerPlayer(firstName + " " + lastName, salary, number, goals, fouls, redCard, yellowCard, offside, assist,  teamName);

			team.add(player);
			
		}
		
	}
	
	public void add(SoccerPlayer p1) {
		team.add(p1);
	}
	
   //getter method
	public ArrayList<Player> getTeam(){
		return this.team;
	}
	
   // selects the best soccer player 
	public SoccerPlayer selectTheBest() {
   
      //creates a dummy player to compare the goals 
		SoccerPlayer x = new SoccerPlayer("abc", -1.0, -1, -1, -1, -1, -1, -1, -1, "xyz");
		
		for(int i=0; i<this.team.size(); ++i) {
			SoccerPlayer currentPlayer = (SoccerPlayer) this.team.get(i);
			
			if(x.getGoals() < currentPlayer.getGoals())
				x = currentPlayer;
			
		}
		
      //returns the value 
		return x;
		
	}
	
   //selects the player with most red cards 
	public SoccerPlayer selectMostRed() {
   
      //created a dummy player to compare with other players 
		SoccerPlayer x = new SoccerPlayer("abc", -1.0, -1, -1, -1, -1, -1, -1, -1, "xyz");
		
		for(int i=0; i<this.team.size(); ++i) {
			SoccerPlayer currentPlayer = (SoccerPlayer) this.team.get(i);
			
			if(x.getRedCard() < currentPlayer.getRedCard())
				x = currentPlayer;
			
		}
		
		return x;
		
	}
	
   //created a toString method
	public String toString() {
		String s = "";
		
		for(int i=0; i<this.team.size(); ++i) {
			SoccerPlayer currentPlayer = (SoccerPlayer) this.team.get(i);
			s += currentPlayer.toString();
		}
		
		return s;
	}
	
   //created equals methos
	public boolean equals(SoccerTeam team1) {
		return this.equals(team1);
	}
	
   //removes the player 
	public void Remove(SoccerPlayer player) {
		this.team.remove(player);
	}
	
	public void Remove(int index) {
		this.team.remove(index);
	}

}
