// Spell Check Helper class: You are to write a java program allowing the user to play a word game. There should be two different lists of words: a set of misspelled words and a set of words spelled correctly.

import java.util.*;
import java.io.*;
public class SpellCheckHelper {

   
   public static void proDes() {
	// the description of the program
	System.out.println("This Game requires you to decide whethere the word shown is correctly spelled or not.");   
	// describes the actions to be done 
	System.out.println("Scoring is +1: for correct guess\n" +
					   "           -1: for incoorect guess\n" +
					   "           +1: \"BONUS!!\" for correctly guessing the correct spelling of incorrectly spelled word\n" +
					   "               after guessing that the word is incorrectly spelled");
   }
	
	
   public static String[] loadArrays(File f) throws FileNotFoundException{
	   // array to store the words
      String[] s = new String[10];
      Scanner fileReader = new Scanner(f);
	   // Loop while the input file has lines of
	   // text to read
	   for(int i = 0; i<10; i++) {
		   s[i] = fileReader.nextLine();
	   }
	   return s;
   }
   
   public static String wordSelector(String[] a, Random rand) {
      // Chooses the word from the file
	   int x = rand.nextInt(10);
	   String word = a[x];
       a[x] = null;
      //returns the Array string
	 return word;
   }
   
 /* Have the Idea but due to minor error and no information other than from internet didn't work 
 
 public static boolean incorrToCorr(String s) throws IOException {
      // stores the file having the correct spellings of incorrect words
	   File f3 = SpellCheckerDriver.getFile("IncorrectWordsCorrectly.txt"); 
	   String file = Files.readFileToString(f3);
      // checks if the correct spelling matches the user input by checking whether it's present in the file
      if(file.toLowerCase().contains(s)) {
    	 // displays the result
    	 System.out.println("You are correct!");
    	 return true;
      }
      else {
    	// displays the result
    	  System.out.println("Sorry you are wrong.");
    	  return false;
      }
   }
   */

}