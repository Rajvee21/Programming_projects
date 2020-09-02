//Write an interactiveprogram that prompts the user for information about two applicants andcomputes an overall score for each applicant.  
//This is a simplified version of a program that might be used for admissions purposes. 
// Admit Mian Class

import java.util.*;

public class AdmitMain {
   public static void main(String[] args) {
      //Print Introduction
      Admit.Intro(); 
      Scanner sc =new Scanner(System.in);

      //Processing for 1st applicant
      System.out.println("\nInformation for the first applicant:");
      
      double score1 = Admit.User_Input(sc);

      //Processing for 2nd applicant   
      System.out.println("\nInformation for the second applicant:");
      double score2 = Admit.User_Input(sc);
      
      //Print the final calculated score
      Admit.print_scores(score1, score2);
      
      //Compare and print the better applicant
      Admit.compare(score1, score2);
   }

}
