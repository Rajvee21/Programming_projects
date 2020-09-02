//BasketBallTeam class 


import java.util.*;
import java.io.*;

public class BasketBallTeam {

   
   
   //creates the array list which includes the list of player xtracting from soccer player class
	private ArrayList<Player> team = new ArrayList<Player>();

	public BasketBallTeam() throws FileNotFoundException {
   
      //creates new file
		File file = new File("fangshiwei_50166_1975897_kingslist.txt");
		Scanner scan = new Scanner(file); 
		
      //constructor
		while(scan.hasNextLine()) {
			
			String firstName = scan.next();
			String lastName = scan.next();
			double salary = scan.nextDouble();
			int number = scan.nextInt();
			int threePointer = scan.nextInt();
			int turnOvers = scan.nextInt();
			int assist = scan.nextInt();
			int rebounds = scan.nextInt();
			int twoPointer = scan.nextInt();
			String teamName = scan.next();
			
			BasketBallPlayer player = new BasketBallPlayer(firstName + " " + lastName, salary, number, threePointer, turnOvers, assist, rebounds, twoPointer, teamName);

			team.add(player);
			
		}
		
	}
	
	public void add(BasketBallPlayer p1) {
		team.add(p1);
	}
	
   //getter method
	public ArrayList<Player> getTeam(){
		return this.team;
	}
	
   // selects the best soccer player 
	public BasketBallPlayer selectTheBest() {
   
      //creates a dummy player to compare the goals 
		BasketBallPlayer x = new BasketBallPlayer("abc", -1.0, -1, -1, -1, -1, -1, -1, "xyz");
		
		for(int i=0; i<this.team.size(); ++i) {
			BasketBallPlayer currentPlayer = (BasketBallPlayer) this.team.get(i);
			
			if(x.getThreePointer()+x.getTwoPointers() < currentPlayer.getThreePointer()+currentPlayer.getTwoPointers())
				x = currentPlayer;
			
		}
		
      //returns the value
		return x;
		
	}
	
   //creates a toString method
	public String toString() {
		String s = "";
		
		for(int i=0; i<this.team.size(); ++i) {
			BasketBallPlayer currentPlayer = (BasketBallPlayer) this.team.get(i);
			s += currentPlayer.toString();
		}
		
		return s;
	}
	
   //equals method
	public boolean equals(BasketBallTeam team1) {
		return this.equals(team1);
	}
	
   //remove player
	public void Remove(BasketBallPlayer player) {
		this.team.remove(player);
	}
	
	public void Remove(int index) {
		this.team.remove(index);
	}
	
}
