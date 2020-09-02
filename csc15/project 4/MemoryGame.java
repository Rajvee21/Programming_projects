//Memory game: Write a program that plays the memory matching game.
//Your program must have three different classes: Cardclass encapsulating the concept of the card  MemoryGameBoardclass encapsulating the concept of the memory game board. 
//MemoryGame classthat is the application that will control the play of the game using the methods from the MemoryGameBoard class.


/*
This program will keep track of how many turns it takes for the player to find all the matches.
It will also allow the player to play as many times as he/she wishes and it will keep track of the player’s best score.
*/

import java.util.Scanner;

public class MemoryGame {

	public static Scanner read_inp = new Scanner(System.in);       //A Scanner object to read from the keyboard
	public static MemoryGameBoard game = new MemoryGameBoard();    //An object of the MemoryGameBoard class called game. 
	
	
	public static void main(String[] args) {
		
		// initializing the variables being used for the game 
		int bestScore = 500;
		int turnCount;
		int pairsLeft;
		String input_read;
		String s_row = "Row :";
		String s_col = "Col :";
		int min = 1;
		int max = game.BOARD_SIZE;
		
      //Introduction to the game
      System.out.println("CSC 15 -     Rajvee Modi");
      System.out.println();
      System.out.println("Welcome to the Memory Game.\nThe goal is to find all the matching pairs in as few turns as possible.\nAt each turn select two different positions on the board to see if they match.");
      System.out.println();
      System.out.println("Press enter to start the game.");  
		read_inp.nextLine();
          
		do {
			game.shuffleCards();
			turnCount = 0;   //Initialize turnCount to zero
			pairsLeft = (game.BOARD_SIZE*game.BOARD_SIZE)/2;  //Initialize pairsLeft to (BOARD_SIZE)2/ 2.
			while(pairsLeft>0) {
				turnCount++; //Add 1 to the turn count
				game.showBoard(); //Display the board 
				System.out.println("Where is the First card you wish to see?");
				int r1 = getValidInt(read_inp, s_row, min, max);  //Call the method getValidInt to get values for row1, col1 
				int c1 = getValidInt(read_inp, s_col, min, max);
				if(game.isFaceUp(r1, c1)) {
					System.out.println("Card already flipped over.\n" + 
									   "Enter the Row and Column Again.");
					r1 = getValidInt(read_inp, s_row, min, max);
				    c1 = getValidInt(read_inp, s_col, min, max);
				}	
				game.flipCard(r1, c1); //Flip the card at row1, col1
				System.out.println("Where is the Second card you wish to see?");
				int r2 = getValidInt(read_inp, s_row, min, max);  //Call the method getValidInt to get values for row2, col2 
				int c2 = getValidInt(read_inp, s_col, min, max);
				if(game.isFaceUp(r2, c2)) {
					System.out.println("Card already flipped over.\n" + 
							           "Enter the Row and Column Again.");
					r2 = getValidInt(read_inp, s_row, min, max);
				    c2 = getValidInt(read_inp, s_col, min, max);
				}		
			   game.flipCard(r2, c2);  //Flip the card at row2, col2
				game.showBoard();  // Display the board

				if(game.cardsMatch(r1, c1, r2, c2)) {
					System.out.println("You Found A Match!");
					pairsLeft = pairsLeft - 1;
				}
				else {
					game.flipCard(r1, c1);
					game.flipCard(r2, c2);
					System.out.println("Not a Match.");
				}
			}
			if(turnCount < bestScore) {  
				bestScore = turnCount; //adjust bestScore as appropriate 
			}
			System.out.println("Great yor just cleared the game");
			System.out.println("Your Score: " + turnCount);  //output turnCount
			System.out.println("The Best Score yet is : " + bestScore);  //print bestScore
         System.out.println("GAME OVER!\n");  // print a message that game is over
			System.out.print("Would you like to play again:");   //Ask the user if he/she wants to play again
			input_read = read_inp.nextLine();
			while(!input_read.equalsIgnoreCase("yes") && !input_read.equalsIgnoreCase("no")) {
				System.out.println("Input should be eithr \"yes\" or \"no\".");
				input_read = read_inp.nextLine();
			}
			System.out.println();
		}while(input_read.equalsIgnoreCase("yes"));
		System.out.println("GoodBye!! Thank You For Playing.");   //Print a goodbye message
	}


    // Take valid input integer from user.
	 public static int getValidInt(Scanner read_inp, String s, int min, int Max) {
	     int number = 0;
	     boolean valid = false;     // validity flag
	     while(!valid) {
	    	  System.out.print(s);
	    	  if(read_inp.hasNextInt()) {
	    		 int num = read_inp.nextInt();
	    		 read_inp.nextLine();
	    		 if(num>=min && num<=Max) {        // check validity of input integer
	    			 valid = true;
	    			 number = num;
	    		 }
	    		 else {
	    			 System.out.println(num + " is not in valid range. {" + min + "..." + Max + "}");  //error msg if num is not between max and min inclusive
	    		 }
	    	 }
	    	 else {
	    		 String numo = read_inp.nextLine();
	    		 System.out.println(numo + " is not a valid integer {" + min + "..." + Max + "}");    //error msg if it is a not a valid integer number
	    	 }
	     }
	     return number;
	 }
}

