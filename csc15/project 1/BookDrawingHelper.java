// Book Drawing Helper Class: Write a program that produces the following figure (which vaguely resembles your textbook) as its output. Use a class constant to make it possible to change the size of the figure. Note that if your size is an odd number the book binding doesn’t line up exactly with the base of the book; this is acceptable as is.

public class BookDrawingHelper {
   // size constant //
   public static final int SIZE = 13;
    
   // print top part //
   public static void drawTop(){
      for(int i = 1; i<=SIZE+1; i++){
         System.out.print(" ");
      }
      
      // print (+) sign //      
      System.out.print("+");
      for(int i = 1;i<=SIZE*3; i++){
         System.out.print("-");    
      }
      
      // print the plus sign (+) //      
      System.out.println("+");
      
      // print space //        
      for(int i = 1; i<=SIZE; i++){
         for(int j = i; j<=SIZE-1; j++){
            System.out.print(" ");
         }
         
         // print (/) //         
         System.out.print(" /");
            
         for(int k = (SIZE*3)-(i*2)-1; k>=i; k--){
            System.out.print(" ");
         }
         
         // print (__) //        
         System.out.print("___");

         // print (/) // 
         System.out.print("/");

         // print (__/) //            
         for(int k = 0; k<=i-2; k++){
            System.out.print("__/");
         }
            
         // print slash(/) //            
         for(int k = 0;k<=i-2 ;k++ ){
            System.out.print("/");
         }
                     
         System.out.println("");
      }
        
        
      // print plus and dash (+) (-) //        
      System.out.print("+");
      for(int i = 1;i<=SIZE*3; i++){
         System.out.print("-");    
      }
      
      System.out.print("+");

      // print slash(/) //        
      for(int k = 1;k<=SIZE ;k++ ){
         System.out.print("/");
      }
        
      // print the space //        
      System.out.println("");
   }
    
   // print the bottom part //    
   public static void drawBottom(){

      // print (|) //    
      for(int i = 1; i <= SIZE/2; i++){
         System.out.print("|");
        
         // print space //        
         for(int j = 1;j<= ((SIZE*3) - 22)/2 ;j++){
            System.out.print(" ");
         }
         
         // print the statement building java programs //        
         System.out.print("Building Java Programs");
        
         // print the space //        
         for(int j = 1;j<= ((SIZE*3) - 22)/2 ;j++){
            System.out.print(" ");
         }
         
         // print line(|) //        
         System.out.print("|");

         // print slash(/) //       
         for(int k = i*2;k<=SIZE + 1; k++){
            System.out.print("/");
         }
         System.out.println("");
      }
      
      // print plus sign (+) //
      System.out.print("+");
      
      // print dash(-) //    
      for(int k = 1;k<=SIZE*3; k++){
         System.out.print("-");    
      }
      
      // print plus sign (+) //      
      System.out.print("+");
    
   }
}