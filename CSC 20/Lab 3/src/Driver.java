
import java.io.*;
import java.util.*;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		 
		File f = new File("NodeTextFile.txt");
		
		Scanner sc = new Scanner(f);
		
		create(sc);
		
	}

		//method create
		public static void create(Scanner sc) {
		
			int line = 0;
		 
			while(sc.hasNextLine()) {
		  
				line++;
		  
				String digit1 = sc.next();
				String digit2 = sc.next();
		  
				char a;
				char b= digit1.charAt(0);
		  
				LongNumber X = new LongNumber(Character.getNumericValue(b));
		  
				for(int i =1; i<digit1.length(); i++) {
		   
					a = digit1.charAt(i);
					X.addLeastSignificant(Character.getNumericValue(a));
		  
				}
		  
				b=digit2.charAt(0);
		  
				LongNumber Y = new LongNumber(Character.getNumericValue(b));
		  
				for(int i =1; i<digit2.length(); i++) {
		   
					a = digit2.charAt(i);
					Y.addLeastSignificant(Character.getNumericValue(a));
		  
				}
				
				// prints inserting the given number
				System.out.println(X + "+" + Y + "=" + X.Add(Y));
				X.insert(3,9);
				System.out.println("inserting the digit 9 at position 3 to num1");
				Y.insert(4,7);
				System.out.println("inserting the digit 7 at position 4 to num2");

				//prints adding up the least significant number
				System.out.println(X + "+" + Y + "=" + X.Add(Y));
				X.addLeastSignificant(8);
				System.out.println("Adding a digit to the least significant position to num1 and num2");
				Y.addLeastSignificant(5);
				//System.out.println(X + "+" + Y + "=" + X.Add(Y));
				
				//prints adding up the most significant number
				System.out.println(X + "+" + Y + "=" + X.Add(Y));
				X.addMostSignificant(8);
				System.out.println("Adding a digit to the most significant position to num1 and num2");
				Y.addMostSignificant(5);
				System.out.println(X + "+" + Y + "=" + X.Add(Y));
				
				//deletes the number at given position
				X.delete(2);
				System.out.println("Deleting number at position 2 in num1 and at position 3 in num 2");
				Y.delete(3);
				System.out.println(X + "+" + Y + "=" + X.Add(Y));
				
			}
		
		}

}
