
import java.util.*;


public class TriangleMain {

   public static void main(String[] args) {
      Scanner sc = new Scanner (System.in);
      run(sc);
   }

   private static void run(Scanner sc) {
   	
      boolean valid = false;
      String str = "";
   	
      do {
      	
         try {
         	
            System.out.println("Enter Three side of Triangle Separet them by space: ");
             
            Scanner sides = new Scanner (sc.nextLine());
         	
            int a = sides.nextInt();
            int b = sides.nextInt();
            int c = sides.nextInt();
         	
            if (a < 0 || b < 0 || c < 0) {
               throw new NegativeSide("Input has Negative sides");
            }
         	
            if ( a + b <= c || a + c <= b || b + c <= a) {
               throw new IllegalTriangleException("Sum of two side is not greater than third one");
            	
            }
         	
            Triangle answer = new Triangle (a, b, c) ;
            System.out.println(answer);
         	
            do {
               System.out.println("Do you want play again (yes or no): ");
               str = sc.nextLine();
            }
            while (!(str.equalsIgnoreCase("yes") || str.equalsIgnoreCase("no")));
         	
            valid = true;
         
            System.out.println("Input should be Integer\n");
         }
          
         //Catch InputMismatchException, if the user enters anything other than a
         //number. No while loop is needed when we use try-catch block. No hasNextInt or
         //hasNextDouble() is needed to be used. 
         catch (InputMismatchException e) { 
            System.out.println("Input should be Integer\n");
            System.out.println();
            e.printStackTrace();
         } 
         
         //Catch NagativeSideException, if statement is needed to check if any of the sides
         //are negative, if so throw a NegativeSideException
         catch (NegativeSide e) {
            System.out.println(e.getMessage());
            System.out.println("input Positive sides\n");
            System.out.println();
            e.printStackTrace();
         }
         
         //Catch IlligalTriangleException, no if statement is needed since the if statement
         //should be inside the constructor. 
         catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
            System.out.println("Sum of two sides must be greater than the third side\n");
            System.out.println();
            e.printStackTrace();
         
         }
         
         //catch noSuchElementException
         catch (NoSuchElementException e) {
            System.out.println("No side found in input");
            System.out.println("Enter Three number separet them by spaces\n");
            System.out.println();
            e.printStackTrace();
         
         }
         
         //catch exception
         catch (Exception e) {
            System.out.println("Exception");
            System.out.println();
            e.printStackTrace();
         
         }
      } while (!valid || str.equalsIgnoreCase("Yes"));
   		    
   }
}
	

