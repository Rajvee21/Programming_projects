
import java.util.*;

/*****************************************************************************
 * Multiplication Program
 * This program asks for 3 digit integer and returns multiplication of them.
 * Output is represented in form of step by step multiplication.
 * 
 * Write a program to display the multiplication of two numbers.
 * 
 ******************************************************************************/


public class multiplication {
	
	// This method validates the user-input integer by checking if it is in 3-digit.
	public static int[] getValidNumber(Scanner sc) {
		int num[] = new int[2];                   // Array declared of size 2 to collect multiplier and multiplicand 
		System.out.println("Please enter two 3-digit integers for multiplication:");
		System.out.println("Enter number 1:");     // Enter first integer
		num[0] = sc.nextInt();
		System.out.println("Enter number 2:");     // Enter second integer
		num[1] = sc.nextInt();
		
		// Loop to validate that the numbers are in range of 3 digit integer  
		while (Math.abs(num[0]) > 999 | Math.abs(num[1]) > 999 | Math.abs(num[0]) < 100 | Math.abs(num[1]) < 100) {
			// Validity check for number 1
			if (Math.abs(num[0]) > 999 | Math.abs(num[0]) < 100) {
				System.out.println("Number 1 is not 3-digit integer! Please enter again! ");
				System.out.println("Enter number 1:");
				num[0] = sc.nextInt();
			} 
			else 
			// Validity check for number 2
			{   
				System.out.println("Number 2 is not 3-digit integer! Please enter again! ");
				System.out.println("Enter number 2:");
				num[1] = sc.nextInt();
			}
		}
		return num;      // Returns array which has both valid multiplicand and multiplier in 3-digit integer format
	}

	// This method perform the multiplication operation and prints final answer
	public static void multiply(int x, int y) {
		// Print the multiplier and multiplicand in specified format
		System.out.println("Multiplication here after:\n");
		System.out.println("     " + x);
		System.out.println(" X   " + y);
		System.out.println("----------");
		
		// Supporting variables initialization
		int final_ans = 0;
		int j = 5;
		int zeros = 1;
		
		// Multiplication operation 
		while (Math.abs(y) > 0) {
			int mod = y % 10;  // Mod by 10 to get ones, tens and hundreds place digit
			y = y / 10;        // Divide by 10 to get the number after removing ones, tens and hundreds place digit
			int ans = x * mod; 				// ans variable used to do multiplication at each step and print it
			int dummy = x * mod * zeros;    // Dummy variable used to pad zeros and do addition for getting final result
			zeros = zeros * 10;             // Zero padding for each step of multiplication
			
			// Conditional statement: if multiplied by zero, display 3 digits of zero (eg: 123*0 = 000) 
			if (ans != 0) {
				// Loop for adjusting white spaces according to requested output format
				for (int i = j; i > 0; i--) {
					System.out.print(" ");
				}
				j = j - 1;
				System.out.println(ans);      // Printing multiplied output at each stage of multiplication operation 
				final_ans = final_ans + dummy; // Final answer after adding each stage i.e. final multiplication result
			} else {
				// Loop for adjusting white spaces according to requested output format
				for (int i = j - 1; i > 0; i--) {
					System.out.print(" ");
				}
				j = j - 1;
				System.out.printf(" %03d", dummy); // Printing multiplied output at each stage of multiplication operation
				System.out.println("");
				final_ans = final_ans + dummy;  // Final answer after adding each stage i.e. final multiplication result
			}
		}
		// Printing final output in requested format
		System.out.println("----------");
		for (int i = j + 1; i > 0; i--) {
			System.out.print(" ");
		}
		System.out.println(final_ans);
	}

	// Main method which calls above declared methods and performs the multiplication operation successfully
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] num = getValidNumber(sc);   // Method call to get two integers in valid 3-digit format 
		int x = num[0];      // x will contain number 1
		int y = num[1];      // y will contain number 2
		multiply(x, y);      // Method call to multiply number 1 and number 2
	}
}
