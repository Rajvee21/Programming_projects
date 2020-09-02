// SumHelper

import java.util.*;

public class SumHelper {
	// size constant for all the array 
   public static final int size = 25;
	
   // the summation method for the program handles the arrays summation 
   public static void getTheSummation(Scanner dg, String s) {
   
      Scanner line = new Scanner(s);
      int nn = totNums(s);
   
     // array to store nums 
      String[] num = new String[nn];
      int[] ans = new int[size];
      
      // loop for the addition
      for(int i=0; i<nn; i++) {
      // stores a single number
         String m= line.next();
         char[] N = new  char[size];
         int[] n = new int[size]; 
         for (int j = 0; j<size ; j++) {
            if(j<=size-1-m.length()) {
               N[j] = 0;
            }
            else {
               // storing and cconversion of nums from char type to int 
               N[j]=m.charAt(j-(size-m.length()));
               n[j] = Character.getNumericValue(N[j]);
            }
         } 
         // updating answer to print
         for (int j = size-1; j>=1; j--) {
            int temp =ans[j]; 
            ans[j] = (ans[j]+n[j])%10;
            ans[j-1] = ans[j-1] + (temp + n[j])/10;
         } 
         num[i]=m;
      }
      // prints the nums to be added
      System.out.print(num[0]);
      for(int i = 1; i<nn; i++) {
         System.out.print(" + " + num[i]);
      }
      System.out.print(" = ");
      // calls the method to print the answer
      SumMain.printAnswer(ans);
   }
   
   // method to decide the no of nums  
   public static int totNums(String s) {
      Scanner lineReader = new Scanner(s);
      int n = 0;
      // string to store words to move cursor
      String a;
      while(lineReader.hasNext()) {
         n++;
         a = lineReader.next();
      }
      return n;
   }
   }
