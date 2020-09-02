// Spell Check Driver class: You are to write a java program allowing the user to play a word game. There should be two different lists of words: a set of misspelled words and a set of words spelled correctly.


import java.util.*;
import java.io.*;
public class SpellCheckerDriver {
	// creates the class constants
		//correct
		public static final File corr = getFile("CorrectWords.txt");
		//incorrect
		public static final File incorr = getFile("InncorrectWords.txt");
		//size
		public static final int size = 10;
		
	/**
	 * the main method shows the flow of the game application	
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		//creates the scanner random and file object used in the class
		Scanner dg = new Scanner(System.in);
		Random rand = new Random();
		// call the program description method from helper
        SpellCheckHelper.proDes();
		// calls the start game method
        game(dg, rand, corr, incorr);
	}
	
	public static File getFile(String s) {
		File f = new File(s);
		// Loop until file is valid
		while(!f.exists()) 
		{
	    System.out.print("Invalid name, try again: ");
	}		
		// File is valid, return object
		return f;
		}
	
	
	public static void game(Scanner dg, Random rand, File f1, File f2)throws FileNotFoundException {
	  // populate arrays using the helper class method
		String[] cor = SpellCheckHelper.loadArrays(f1);
		String[] incor = SpellCheckHelper.loadArrays(f2);  
      String[] f; 
      // Initialize the number of games; user input to play again; score; boolean for the score
	  int noOfGames = 0;
	  int score = 0;
	  String inp;
	  boolean ans;
	  // result strings displayed when ans entered 
	  String resultt = "You are correct!";
	  String resultf = "You are Wrong.";
		// while loop for playing again till the number of repetition reaches the max tries allowed
	  	do {
			// selects the list/text-file using random
	  		int list = rand.nextInt(2);
			if(list==0) {
			   f = cor;
			}
			else {
			   f = incor;
			}
	  		// selects the word from the using helper class
	  		String word = SpellCheckHelper.wordSelector(f, rand);
	  		
	  		System.out.printf("The word is %s.", word);
			// prompts the user to enter whether the word is correctly spelled or not
	  		System.out.println("Is the word correctly spelled or not (Answer yes or no)");
	  		inp = dg.nextLine();
	  		// checks if user is correct by matching the arrays
	  		if (inp.equalsIgnoreCase("yes")) {
	  			if (list==0) {
	  			// displays the result & updates the score according to the answer
	  			 System.out.print(resultt);
	  			 score = score + 1;
	  			}
	  			else {
	  				// displays the result & updates the score according to the answer
	  				System.out.print(resultf);   
	  				score = score - 1;
                }
	  		}
	  		else {
	  			if(list==1) {
	  				// displays the result & updates the score according to the answer
	  				System.out.print(resultt);
		  			score = score + 1;
		  			/* IF the User wants calls method from helper to allow user to check whether
             		they know the correct spelling if incorrectly spelled word*/
                  // cuurently a dummy part as the method didint workno
		  			System.out.println("Would you like try for the bonus?(Reply yes or no)");
		  			inp = dg.nextLine();
		  			if(inp.equalsIgnoreCase("yes")) {
		  			    System.out.print("What is the correct spelling?");
		  				inp = dg.nextLine();
		  				//ans = SpellCheckHelper.incorrToCorr(inp);
		  					if(true) {
		  						score = score + 1;
		  					}
		  			}
	  			}
	  			else {
	  				// displays the result & updates the score according to the answer
	  				System.out.print(resultf);
		  			score = score - 1;	
	  			}
	  		}
	  		// asks the user if they want to play again
	  		System.out.print("Would you like to play again:");
	  		inp = dg.nextLine();
	  	} while(noOfGames<=size && inp.equalsIgnoreCase("yes"));
	  		// displays the score
	  		System.out.printf("Your Final Score is %d", score);
   }
	
}
