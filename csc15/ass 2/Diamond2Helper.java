//Diamond Helper Class : Use modular design to write a program that draws a figure that looks like the diamond

public class Diamond2Helper {
   public static final int SIZE=4;
   
   //the top line 
   public static void drawline() {
      System.out.print("+");
      for (int j=1; j<= (SIZE*2)+1; j++){
         System.out.print("-");
      }
      System.out.println("+");
   }

   //print the top most diamond
   public static void drawtopdiamond() {
      for(int i=1; i <= SIZE; i++){
         System.out.print("|"); //left border
      
      
         //print spaces
         for(int j=1; j <= -i + (SIZE+1); j++){
            System.out.print(" ");
         }
      
         //print "/" line
         for(int j=1; j <= i-1; j++){
            System.out.print("/");
         }
      
         //print "*" line
         for(int j=1; j <= 1; j++){
            System.out.print("*");
         }
      
         //print "\" line
         for(int j=1; j <= i-1; j++){
            System.out.print("\\");
         }
      
         //print spaces
         for(int j=1; j <= -i + (SIZE+1); j++){
            System.out.print(" ");
         }
      
         System.out.println("|"); //print right line
      }
   }


   //print the bottom diamond
   public static void drawbottomdiamond() {
      for(int i=1; i <= SIZE; i++){
         System.out.print("|"); //left border
      
         //print spaces
         for(int j=1; j <= i; j++){
            System.out.print(" ");
         }
      
         //print "/" line
         for(int j=1; j <= -i + SIZE; j++){
            System.out.print("\\");
         }
      
         //print "*" line
         for(int j=1; j <= 1; j++){
            System.out.print("*");
         }
      
         //print "\" line
         for(int j=1; j <= -i + SIZE; j++){
            System.out.print("/");
         }
      
         //print spaces
         for(int j=1; j <= i; j++){
            System.out.print(" ");
         }
      
         System.out.println("|"); //print right line
      }
   }
}
   




 











