// Floor Client Driver Class : You are to write a program that calculates the cost of flooring. 
//Your program assumes that the user has three different rooms with three different shapes of square, circle and triangle. 
//The user wants to get quotes for wood, tile and carpet flooring. Your program needs to collect the following info: 
//1.Measurements for each room
//2.Cost per square feet for wood
//3.Cost per square feet for tile
//4.Cost per square feet for carpet


//floor client
import java.util.Scanner;
public class FloorClient {
   public static void main (String[] args) {
      Scanner rj = new Scanner(System.in);
      run(rj);
   }
   
   //scanner object
   public static void run(Scanner rj){
      Floor.programHeader();
      
      //print the following statement 
      System.out.print("How many times will be using the software -->");
      int num = rj.nextInt();
      
      for(int i=1; i<=num; i++) {
      
         System.out.println("Enter the price of te flooring per sq.ft.");
         
         System.out.print("Wood -->");
         double costForWood = rj.nextDouble();
         
         System.out.print("Tile -->");
         double costForTile = rj.nextDouble();
         
         System.out.print("Carpet -->");
         double costForCarpet = rj.nextDouble();
         
         //calculate for circle
         calcCircle(rj, costForWood, costForTile, costForCarpet);
         
         //calculate for Rectangle
         calcRectangle(rj, costForWood, costForTile, costForCarpet);
         
         //calculate for Triangle
         calcTriangle(rj, costForWood, costForTile, costForCarpet);
      }
      System.out.println("GoodBye");
   }


   //calculationg circular floor cost
   public static void calcCircle(Scanner rj, double costForWood, double costForTile, double costForCarpet){
      System.out.println("Calculating the Circular floor cost. Please enter the measurements");
   
      System.out.print("Radius -->");
      double Cradius = rj.nextDouble();
   
      Floor.costForCircle(Cradius, costForWood, costForTile, costForCarpet);
   }
 
 
   //calculating rectangular floor cost
   public static void calcRectangle(Scanner rj, double costForWood, double costForTile, double costForCarpet){
      System.out.println("Calculating the Rectangular floor cost. Please enter the measurements");
   
      System.out.print("Length -->");
      double Rectl = rj.nextDouble();
      
      System.out.print("Breath -->");
      double Rectb = rj.nextDouble();
   
      Floor.costForRect(Rectl, Rectb, costForWood, costForTile, costForCarpet);
   }  
   
   
   //calculating triangular floor cost            
   public static void calcTriangle(Scanner rj, double costForWood, double costForTile, double costForCarpet){
      System.out.println("Calculating the Triangular floor cost. Please enter the measurements");
   
      System.out.print("Base -->");
      double Trib = rj.nextDouble();
      
      System.out.print("Height -->");
      double Trih = rj.nextDouble();
   
      Floor.costForTri(Trib, Trih, costForWood, costForTile, costForCarpet);
   }   
}   
               
