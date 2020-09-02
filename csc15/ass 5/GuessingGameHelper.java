// Guessing Game Application Helper Class: Write a program that plays a guessing game with the user. 
//The program should generate a random number between 1 and 100, then prompt the user repeatedly to guess the number. 
//When the user guesses incorrectly, the game should give the user a hint about whether the correct answer is higher or lower than the guess. 
//Once the user guesses correctly, the program should print a message showing the number of guesses that the user made and ask them if they would like to play again. When the user hasfinishedplayingthe game the program should print a message with the total number of games played and their average score.This program must not crash if the user types in invalid input. Any invalid input, including guesses not between 1 and 100, should result in an error message and not count negatively against them


// imports Scanner and Random classes
import java.util.Scanner;
import java.util.Random;


public class GuessingGameHelper {

  // sets the lower boundary to select the random no from
  public static final int min = 1; 
  // sets the lower boundary to select the random no from
  public static final int max = 100; 	

	 
	public static int getRandomNumber(Random rand) {	
      // sets the random number in b/w the boundary depending upon the class constants
      int no = rand.nextInt(max - min + 1) + min;
		return no;
    }
	
	public static int getInput(Scanner pm, String prompt) {
		// prints the prompt
      System.out.print(prompt);
      // sets the initial value to false to run the while loop before 
		boolean valid = false;  
		// sets the initial input to 0
      int inp = 0; 
		
      // while loop to run until the value of valid changes
	   while (!valid) {
		  
		// while loop to run until the input is the valid one  
		while(!pm.hasNextInt()) {
            // error message to be displayed when inp not an integer
				System.out.println("Input must be an integer, please try again."); 
				// to shift the cursor to the next line
            pm.nextLine(); 
            // prints the same prompt again
				System.out.print(prompt); 
		}
		
         // stores the inp when the input is integer		
			inp = pm.nextInt();
			// goes to the next line
         pm.nextLine(); 
		// checks if the no in between the specified boundary	
	    valid = (inp >= min && inp <= max);
	    // wrong(error) message if the no is not in between the boundary
		if (!valid){
			System.out.printf("Must enter a value between %d and %d\n", min, max);
		}
	  }
        // returns the inp	  
		return inp;
	}
	
// ask user to give inpur and check whether it is what we wanted or not
	public static boolean askPlayAgain(Scanner pm, String prompt) {
		// the prompt for response
		System.out.print(prompt);
		// initiates the boolean variable
		boolean PA;
      // stores the input
		String inp = pm.nextLine(); 

		// Loop until inp is yes or no
		      while (!(inp.equalsIgnoreCase("yes") || inp.equalsIgnoreCase("no"))) {
			// error message to be printed when input not yes or no
			System.out.println("Invalid response, must enter \"Yes\" or \"No\".");
			// stores the next inp to be checked again
		    inp = pm.nextLine();
		}
		
		// to assign value when yes
		if (inp.equalsIgnoreCase("yes")) {
			PA = true;
		}
		// to assign value when no
		else {
			PA = false;
		}
		
		// returns result
		return PA;
	}
}
