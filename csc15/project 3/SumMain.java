// Sum Driver

import java.io.*;
import java.util.*;
public class SumMain {
   // size constant for all the array 
   public static final int size = 25;
   
   
	/*
	 * the main method shows the flow of the game application	 
	 */
   public static void main(String[] args) throws FileNotFoundException {
   	
   	//creates the scanner and the file for the numbers to be added which used in the class
      Scanner rj = new Scanner(System.in);
      File f = new File("sum.txt");
   	
   	// calls the addNum method to add the numbers from the file
      addOfNums(rj, f);
   }
	
   // addition method
   public static void addOfNums(Scanner dg, File fl) throws FileNotFoundException {
      int lines =0;
      Scanner file = new Scanner(fl);
   	
      // loop till lines end
      while(file.hasNextLine()) {
         String line = file.nextLine();	
        // calls method from helper to add 
         SumHelper.getTheSummation(file, line);
        // adds to the no of line
         lines++;
      }
   // to print no of lines in the file
      System.out.println("");	
      System.out.printf("Total Number of lines = %d\n", lines);
   }
   
   
   // method to print the answer
   public static void printAnswer(int[] rj){
      int r = 0;
      // to remove extra zeros
      while (rj[r]==0 && r<size-1) {
         r++;
      }
      // prints the ans
      for(int i=r; i<size; i++){
         System.out.print(rj[i]);
      }
      System.out.print("\n");
   }

}
