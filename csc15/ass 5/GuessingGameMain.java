// Guessing Game Application Main Class : Write a program that plays a guessing game with the user. 
//The program should generate a random number between 1 and 100, then prompt the user repeatedly to guess the number. 
//When the user guesses incorrectly, the game should give the user a hint about whether the correct answer is higher or lower than the guess. 
//Once the user guesses correctly, the program should print a message showing the number of guesses that the user made and ask them if they would like to play again. When the user hasfinishedplayingthe game the program should print a message with the total number of games played and their average score.This program must not crash if the user types in invalid input. Any invalid input, including guesses not between 1 and 100, should result in an error message and not count negatively against them

// imports the Scanner and Random Classes
import java.util.Scanner;
import java.util.Random;

public class GuessingGameMain {
    
   public static void main(String[] args) {
   
   	 // define the scanner object
      java.util.Scanner pm = new Scanner(System.in);
      
      // define the random object 
      java.util.Random rand = new Random(); 
   	
      runProgram(pm, rand);
   }
	
   public static void runProgram(Scanner pm, Random rand) {
   // sets the starting number of attempts and games played at 0.
      int games = 0;  
      int attps = 0;
      // introduces the boolean character
      boolean PA = true; 
      // defines string that is used as a parameter in other methods
      String prompt = "Do You Want To Play Again:"; 
   	
   	// do while loop for starting the game atleast once and then depending upon the user 
      while(PA) {
      // increment in no of games per repetition
         games++; 
         // adding no of attempts taken to guess the answer also calls the play game method
         attps = attps + playGame(pm, rand); 
         // used to decide whether the loop will repeat
         PA = GuessingGameHelper.askPlayAgain(pm, prompt); 	
      } 
   	// converting the integer to double as the average requires an answer in double format
      double noOfGames = games; 
      // finds the average
      double average = attps/noOfGames; 	
      	// displays the ending statement for the application
      System.out.printf("Great job! You played %d games and your average number of guesses was %.2f\n" , games, average);
   }
	
   public static int playGame(Scanner pm, Random rand) {
   
   	// defines the string used in the methods as parameter
      String prompt = "Enter a number between 1 and 100:";
      // sets the random number to be found as the answer
      int no = GuessingGameHelper.getRandomNumber(rand);
      // takes the user input using the helper class 	
      int inp = GuessingGameHelper.getInput(pm, prompt); 
      // sets the initial no of attempts to 1 as it needs at least one attempt to do proccess
      int attps = 1; 
        
   	// while loop for the case when the input is not the answer 
      while (inp != no) {
      	
      	// if else loop for prompting the user in the correct direction 
         if(inp > no) {
         	// when the input is greater than required it shows below massage
            System.out.println("Sorry, too high...");
            // input for the next attempt 
            inp = GuessingGameHelper.getInput(pm, prompt); 
         }
         
         else {
         	// when the input is lower than required it shows below massage
            System.out.println("Sorry, too low...");
            // ask for input the next attempt 
            inp = GuessingGameHelper.getInput(pm, prompt); 
         }
      	// increment in the number of attempts per try
         attps++;
      }
   	// message displayed on right guess and it also display the number of attempts
      System.out.printf("You got it! It only took you %d attempt(s)\n", attps);
   	// returns the no of attempts it took
      return attps; 
   }

}