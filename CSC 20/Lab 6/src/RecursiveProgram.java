// Recursion program 

import java.util.*;

public class RecursiveProgram {
	
	//main method
	public static void main(String[] args) {
	
		System.out.println("Number of Occurenses: " + count("My name is Rajvee", 'r'));
	
		System.out.println("Sum of digits: " + sumOfDigits(23032000));
		
		int[] number = {23, 3, 20, 8, 9, 94, 11, 10, 86};
		System.out.println("Maximum number is: " + maxValue(number, 0));
		System.out.println("Conversion of hex to decimal number:");
  
		Scanner sc = new Scanner(System.in); 
		String line = "";
		String reply = "";
		
		// do and while loops
		do { 
   
			System.out.print("Enter a valid Hex number:");
			line = sc.next();
			sc.nextLine();
      
			while(!inputValidate(line)){  
         
				System.out.print("Enter a valid Hex number:");
				line = sc.next();
				sc.nextLine();
      
			}
      
			System.out.println("Your Number in decimal is:" +hexToDecimal(line, line.length()));
   	
			System.out.print("Do you have another number:");
      
			reply= sc.nextLine();   	
      
			while(!reply.equalsIgnoreCase("yes") && !reply.equalsIgnoreCase("no")) {
         
				System.out.print("reply as \"yes\" or \"no\"");
        
				reply = sc.nextLine();
      
			}
  
		}
		
		while(reply.equalsIgnoreCase("yes"));

	}
	
	//method for input validation using string parameter
	public static boolean inputValidate(String line) {
	
		char letter;  
   
		//for and if loops 
		for (int i=0; i<line.length(); i++) {
      
			letter = line.charAt(i);
      
			if (letter != 'A' && letter != 'B' && letter != 'C' && letter != 'D' && letter != 'E' && letter != 'F' 
       		
					&& letter != '0' && letter != '1' && letter != '2' && letter != '3' && letter != '4' && letter != '5' 
       		
					&& letter != '6' &&letter != '7' && letter != '8' && letter != '9' ) {
        
				return false;
      
			}
   
		}
  
		return true;

	}

	//hexdecimal method 
	public static double hexToDecimal(String line,int i) {
   
		if(line.length() == 0){
      
			return 0;
   
		}
   
		int number;
   
		if(line.charAt(0) == 'A'){
      
			number = 10;
   
		}
   
		else if(line.charAt(0) == 'B'){
      
			number = 11;
   
		}
   
		else if(line.charAt(0) == 'C'){
      
			number = 12;
   
		}
   
		else if(line.charAt(0) == 'D'){
      
			number = 13;
   
		}
  
		else if(line.charAt(0) == 'E'){
      
			number = 14;
   
		}
   
		else if(line.charAt(0) == 'F'){
      
			number = 15;
   
		}
   
		else{
      
			number = Character.getNumericValue(line.charAt(0));
   
		}
   
		return number * Math.pow(16, i-1) + hexToDecimal(line.substring(1),i-1);

	}

	//count method
	public static int count(String str, char c) {
   
		if(str.length() == 0) {
      
			return 0;
   
		}

		int i = 0;
   
		if(str.charAt(0) == c) {
      
			i++;
   
		}
   
		return i + count(str.substring(1),c) ;

	}

	//maxValue method 
	public static int maxValue(int[] number, int i) {
	
		if(i == number.length-1) {
      
			return number[i-1];
   
		}
	
		return Math.max(number[i], maxValue(number, i+1));		

	}

	//method sumOfDigits
	public static int sumOfDigits(int number) {
   
		if(number/10 == 0)
      
			return number % 10;
   
		return number %10 + sumOfDigits(number/10);
	
	}

}
