//This lab's objective is to exercise you with the use of Java’s control statements. You are
//required to use exactly one while statement, one for statement and one switch statement.
//You will also practice on how to use some basic input methods of the Scanner class and some
//formatting techniques of method printf().


import java.util.*;
public class lab02 {
   public static void main(String[] args) {
      Scanner kb = new Scanner (System.in);
      JulianDate JD = new JulianDate();
      System.out.println("Enter a year:");
      int year = kb.nextInt();
      int date = JD.toJulian(year,1,1);
      int WeekDay_number = (date+1)%7; 
      String month_name;
      int Day_number;
      int i = 1;
   
      System.out.printf("%13d\n",year);
        
      for(int count=1; count<13; count++ ){
         switch(count){
            case  1: month_name = "January"; Day_number = 31; 
               break;
            case  2: month_name = "Februay";Day_number = 28;
               if(year%4 == 0&&(!(year%100 == 0)||year%400 == 0)){
                  Day_number = 29;
               }
               break;
            case  3: month_name = "March"; Day_number = 31; 
               break;
            case  4: month_name = "April"; Day_number = 30; 
               break;
            case  5: month_name = "May"; Day_number = 31; 
               break;
            case  6: month_name = "June"; Day_number = 30; 
               break;
            case  7: month_name = "July"; Day_number = 31; 
               break;
            case  8: month_name = "August"; Day_number = 31; 
               break;
            case  9: month_name = "September"; Day_number = 30; 
               break;
            case 10: month_name = "October"; Day_number = 31; 
               break;
            case 11: month_name = "November"; Day_number = 30;
               break;
            case 12: month_name = "December"; Day_number = 31;
               break;
            default: month_name = "Decemeber"; Day_number = 31; 
               break;
         }
         System.out.println();
         System.out.printf("%" + (11 + month_name.length()/2)+"s\n", month_name);
         System.out.println();
            
         System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
         int d =1;
         while(d<=Day_number){
            if(WeekDay_number > 0 && d==1){
               System.out.printf("%"+ (WeekDay_number * 3 + 3) + "d",d);
               WeekDay_number++;
               d++;
            }
            else{
               System.out.printf("%3d",d);
               d++;
               WeekDay_number++;
            }
         
            if(WeekDay_number == 7){
               System.out.println();
               WeekDay_number=0;
            }
         }
         System.out.println();         
      }      
      
   }
}
