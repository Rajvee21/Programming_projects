// Toll calculations : Write aprogram that calculates the toll amount for travel along a toll road or toll lane. 
//The toll amount is based on the time of day, day of the week, and number of persons in the vehicle.
//The program gets the time of travel from the user using 24 hours formatas a string, then extracts the hour to determine the toll amount.
//You will need indexOfand substringmethods.You will also need to use Integer.parseInt(inputString)method to convert a string to integer.
//The program also asks for type of day from the user (0 for weekdays, and 1 for weekends or holidays).
//Since a toll road may have a discount for carpools, sometimes called high-occupancy vehicles (HOV). 
//The program asks for the number of people in the vehicleto adjust the toll amount based on this information. 
//The carpool discount rules are: •A carpool is 3 or more person per vehicle.  •The toll for carpools on weekdays between 6:00 am and 10:00 am is half the normal toll.  •Otherwise, the toll for carpools is 0 (as in free).Use if-else, nested if-else and multi-branch if-else statement as needed to determine the tollAmount based on the tables and user information.//


import java.util.*;

public class TollCalculation {
   
   public static void calculateToll(Scanner sc) {
   double amt;
   
   //get time of travel from user in string format
   String time = getInput(sc);
   
   //convert time into integer dividing into hour and minutes
   int hour = getHour(time);
   int min = getMin(time);
   
   //get type of day
   System.out.print("Enter type of day (0 - weekday, 1 - weekend/holiday): ");
   int day = sc.nextInt();

   //get number of person in car
   System.out.print("Enter number of persons in vehicle: ");
   int person = sc.nextInt();
   
   //check carpool rules
   if(person >= 3){
      amt = carpoolCalculation(day, hour, min); // calculate carpool toll
   }
   else
   {
   if(day == 0){
      amt = weekdayCalculation(hour, min);      // weekday toll calculation
   }
   else
   {
      amt = weekendCalculation(hour, min);      // weekend toll calculation
   }
}
   
   //logic for "am" and "pm"
   if(hour<12){
   System.out.println("Toll at "+hour+":"+min+" am is "+ amt);
   }
   else
   {
   System.out.println("Toll at "+hour+":"+min+" pm is "+ amt);
   }
}
   
   
   // time: get input from user
   public static String getInput(Scanner sc){    
      System.out.print("Enter time of travel (HH:MM in 24 hour format): ");
      String time = sc.nextLine();
      return time;
   }
   
   // weekday toll price calculation according to the given table
   public static double weekdayCalculation(int hour, int min){    
         if (hour<=5){
            double amt = 1.55;
            return amt;
          }
          else if(hour>=6 && hour<=9){
            double amt = 4.65;
            return amt;
          }
          else if(hour>=10 && hour<=12){
            double amt = 2.35;
            return amt;
          }
          else if(hour>12 && hour<=17){
            double amt = 2.35;
            return amt;
         }
         else {
            double amt = 1.55;
            return amt;
         }
   }
   
   
   // carpool toll price calculation according to the given carpool rules   
   public static double carpoolCalculation(int day, int hour, int min){
      if(day == 0){
         double amt = weekdayCalculation(hour, min);
         if(hour>6 && hour<10){
          double amt_c = amt/2;
          return amt_c;
      }
      else
      {
         return 0;
      }
   } 
   else
   {
      return 0;
   }
   
}  
   
   
   
   
   // weekend toll price calculation according to the given table   
   public static double weekendCalculation(int hour, int min){    
     
         if (hour<=7){
            double amt = 1.55;
            return amt;
          }
          else if(hour>=8 && hour<=11) {
            double amt = 3.05;
            return amt;
          }
          else if(hour>=12 && hour<=15){
            double amt = 3.45;
            return amt;
         }
         else if(hour>=16 && hour<=18){
            double amt = 3.60;
            return amt;
         }
         else if(hour>=19 && hour<=21){
            double amt = 3.05;
            return amt;
         }
         else{
            double amt = 1.55;
            return amt;
         }
   }
   
   
   //extract hour from time string
   public static int getHour(String time){    
      String str= new String(time); 
      int ind = str.indexOf(":");
      String hourString = str.substring(0, ind);                                  
      int hour = Integer.parseInt(hourString);    
      return hour;
   }



   //extract minutes from time string   
   public static int getMin(String time){    
      String str= new String(time); 
      int ind = str.indexOf(":");
      String minString = str.substring((ind+1), (ind+3));
      int min = Integer.parseInt(minString);
      return min;
   } 
}
