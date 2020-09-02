// Driver class 

import java.io.*;
import java.util.*;

public class Driver {
	//Create a method called listPlayers, this methods accepts an array of players and displays
   //the info about all the players. 
	public static void listPlayers(ArrayList<Player> team) {
		
		for(int i=0; i<team.size(); ++i)
			System.out.println(team.get(i).toString());
		
	}
	// method that accepts an array of SoccerPlayer and lists all the players with red
   //card.
	public static void listAllRedCards(ArrayList<Player> team) {
		for(int i=0; i<team.size(); ++i) {
			SoccerPlayer currentPlayer = (SoccerPlayer) team.get(i);
			
			if(currentPlayer.getRedCard()>0) {
				System.out.println(currentPlayer.toString());
			}
		}
	}
	
   // method named mostRebound that displays the player with the most rebound
	public static void mostRebound(ArrayList<Player> team) {
		BasketBallPlayer x = new BasketBallPlayer("abc", -1.0, -1, -1, -1, -1, -1, -1, "xyz");
		for(int i=0; i<team.size(); ++i) {
			BasketBallPlayer currentPlayer = (BasketBallPlayer) team.get(i);
			
			if(currentPlayer.getRebounds()>x.getRebounds()) {
				x = currentPlayer;
			}
		}
		
		System.out.println(x.toString());
	}
	
   // method called serachPlayer that accepts an array of type Player and a name of a
   //player. This methods searches the list , if the player is found display the info, otherwise
   //print a message that the player does not exist. 
	public static void searchPlayer(ArrayList<Player> team, String name) {
		boolean flag = false;
		for(int i=0; i<team.size(); ++i) {
			Player currentPlayer = team.get(i);
			if(currentPlayer.getName().equals(name)) {
				flag = true;
				System.out.println(currentPlayer.toString());
				break;
			}
		}
		
		if(!flag) {
			System.out.println("Player with the name "+name+ " does not exist in the team.");
		}
	}
	
   // method that display the best player with the most goals/points
	public static void bestPlayerOverall(SoccerTeam bearCat, BasketBallTeam kings) {
		SoccerPlayer bestSoccerPlayer = bearCat.selectTheBest();
		BasketBallPlayer bestBasketBallPlayer = kings.selectTheBest();
		
		if(bestSoccerPlayer.getGoals() > bestBasketBallPlayer.getTotalPoints()) {
			System.out.println(bestSoccerPlayer.toString());
		} else {
			System.out.println(bestBasketBallPlayer.toString());
		}
		
	}
	
   //main methods 
	public static void main(String[] args) throws FileNotFoundException {
		SoccerTeam bearCat = new SoccerTeam();
		BasketBallTeam kings = new BasketBallTeam();
		
		listPlayers(bearCat.getTeam());
		
		System.out.println("\n\n\n+++++++++++++++++++++++++++++++++++\n\n\n");
		
		listPlayers(kings.getTeam());
      
      System.out.println("\n\n\n+++++++++++++++++++++++++++++++++++\n\n\n");
		
		listAllRedCards(bearCat.getTeam());
      
      System.out.println("\n\n\n+++++++++++++++++++++++++++++++++++\n\n\n");
		
		mostRebound(kings.getTeam());
      
		System.out.println("\n\n\n+++++++++++++++++++++++++++++++++++\n\n\n");

		searchPlayer(bearCat.getTeam(), "Austin Smythe");
      
      System.out.println("\n\n\n+++++++++++++++++++++++++++++++++++\n\n\n");
		
		bestPlayerOverall(bearCat, kings);
		
      System.out.println("\n\n\n+++++++++++++++++++++++++++++++++++\n\n\n");

	}
	
}
