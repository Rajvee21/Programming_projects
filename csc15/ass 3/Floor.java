// Floor Helper class : You are to write a program that calculates the cost of flooring. 
//Your program assumes that the user has three different rooms with three different shapes of square, circle and triangle. 
//The user wants to get quotes for wood, tile and carpet flooring. Your program needs to collect the following info: 
//1.Measurements for each room
//2.Cost per square feet for wood
//3.Cost per square feet for tile
//4.Cost per square feet for carpet


public class Floor{


   //find the area of circle
   public static double areaCircle (double radius){
      double Area;
      Area = (Math.PI)*(Math.pow(radius,2));//formula for arae of circle
      return Area;
   }
   
   //find the area of rectangle
   public static double areaRectangle (double length, double breath){
   
      double Area;
      Area = length*breath; //formula for area of rectangle
      return Area;
   }
   
   //find the area of triangle
   public static double areaTriangle (double height, double breath){
   
      double Area;
      Area = (height*breath)/2; //formula for area of triangle
      return Area;
   }
   
   //find the total cost of florring including area and price per sqr ft.
   public static double costOfFlorring (double totalArea, double pricePerSqFt){
   
      double Cost;
      Cost = totalArea*pricePerSqFt; //formula for finding the total cost
      return Cost;
   } 
   
   //find the cost of circle including wood, tile, carpet.
   public static void costForCircle(double radius, double costForWood, double costForTile, double costForCarpet){       
   
      double area = areaCircle(radius);
   
   //finding the cost for wood, tile, and carpet individually.
      double totalWoodCost = costOfFlorring(area, costForWood); 
      double totalTileCost = costOfFlorring(area, costForTile);  
      double totalCarpetCost = costOfFlorring(area, costForCarpet); 
      totalCost(totalWoodCost, totalTileCost, totalCarpetCost);
   }
   
   //find the cost of rectangle including wood, tile, carpet.
   public static void costForRect(double length, double breath, double costForWood, double costForTile, double costForCarpet){       
   
      double area = areaRectangle(length, breath);
   
   //finding the cost for wood, tile, and carpet individually.
      double totalWoodCost = costOfFlorring(area, costForWood); 
      double totalTileCost = costOfFlorring(area, costForTile);  
      double totalCarpetCost = costOfFlorring(area, costForCarpet); 
      totalCost(totalWoodCost, totalTileCost, totalCarpetCost);
   } 
   
   //find the cost of triangle including wood, tile, carpet.
   public static void costForTri(double base, double height, double costForWood, double costForTile, double costForCarpet){       
   
      double area = areaTriangle(base, height);
   
   //finding the cost for wood, tile, and carpet individually.
      double totalWoodCost = costOfFlorring(area, costForWood); 
      double totalTileCost = costOfFlorring(area, costForTile);  
      double totalCarpetCost = costOfFlorring(area, costForCarpet); 
      totalCost(totalWoodCost, totalTileCost, totalCarpetCost);
   }                                         
  
  //for header statement
   public static void programHeader(){
      System.out.println("**************************************************************************\n" +
                     "** \n" +
                     "Welcome to Nature flooring \n" +
                     "We can give you a quote on the flooring that you are looking floor. \n" +
                     "Just give us some measurements and we will promptly give you the quote \n" +
                     "************************************************************************** \n" +
                     "*** \n" );                                       
   }
  
  //statemnet for total cost
   public static void totalCost (double woodTotal, double tileTotal, double carpetTotal) {
      System.out.printf("\t\tWood\t\tTile\tCarpet\n"+
                     "\t%.2f\t%.2f\t%.2f", woodTotal, tileTotal, carpetTotal);
      System.out.println();                  
   }
}