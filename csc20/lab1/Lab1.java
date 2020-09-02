//In this lab you are to write a simple Java program to prompt the user for two 3-digit integers and print the
//product of the two integers in the following form.


import java.util.*;

   public class Lab1 {
   public static void main (String [] args) {
   
   //get the input from the user 
   
   Scanner kb = new Scanner(System.in);
   System.out.println ("Enter the first number: ");
   int fnum = kb.nextInt();
	System.out.println("Enter the second number: ");
	int snum = kb.nextInt();

   // spacing
   
	System.out.printf("%10d\n", fnum);
	System.out.printf("X%9d\n", snum);
	System.out.println("------------");
   
   int x = (snum%10)*fnum;
	System.out.printf("%10d\n", x);
	x = (snum/10%10)*fnum;
   System.out.printf("%9d\n", x);
	x = (snum/100)*fnum;
   System.out.printf("%8d\n", x);
	System.out.println("------------");
   int product = fnum * snum;
	System.out.printf("%10d\n", product);

   }
   
   }