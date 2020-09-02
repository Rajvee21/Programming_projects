//This Project takes scores of a student as input and compares it with another student scores input
// Admit helper class

import java.util.*;

public class Admit {
   
   //Method for Introduction
   public static void Intro() {
      System.out.println("This program compares two applicants to\n"+
                     " determine which one seems like the stronger\n"+
                     " applicant.  For each candidate I will need\n"+
                     " either GRE or GMAT scores plus a weighted GPA\n"+
                     "  and a GSS(Goal Statement Score: range 0-4).");
   }
   
   //Method for GRE or GMAT decision
   public static double User_Input(Scanner sc) {
      System.out.print("    do you have 1) GRE scores or 2) GMAT scores? ");
      int inp = sc.nextInt();
      if(inp == 1){
         double overall_gre = GRE(sc); 
         return overall_gre;
      }
      else{
         double overall_gmat = GMAT(sc);
         return overall_gmat;
      }
   }


   //Takes input for all GRE scores
   public static double GRE(Scanner sc) {
      System.out.print("    GRE math? ");
      int math = sc.nextInt();
      System.out.print("    GMAT verbal? ");
      int verbal = sc.nextInt();
      System.out.print("    overall GPA? ");
      double gpa = sc.nextDouble();
      System.out.print("    max GPA? ");
      double max_gpa = sc.nextDouble();
      System.out.print("    GSS? ");
      int gss = sc.nextInt();
      
      double over_sc_gre = overall_sc_gre(math, verbal, gpa, max_gpa, gss);
      
      return over_sc_gre;
   }


   // Calculates overall GRE score
   public static double overall_sc_gre(int math, int verbal, double gpa, double max_gpa, int gss){
   
      double gre_score = (double)(2 * verbal + math)/24;
      double count_gpa = (gpa/max_gpa)*100;
      double gss_result = (double)0.01 * gss;
   
      double overall_score = gre_score + count_gpa + gss_result;
   
      return overall_score;
   }


   // Takes input for all GMAT scores
   public static double GMAT(Scanner sc) {
      System.out.print("    GMAT English? ");
      int english = sc.nextInt();
      System.out.print("    GMAT math? ");
      int math = sc.nextInt();
      System.out.print("    GMAT reading? ");
      int reading = sc.nextInt();
      System.out.print("    GMAT science? ");
      int science = sc.nextInt();
      System.out.print("    overall GPA? ");
      double gpa = sc.nextDouble();
      System.out.print("    max GPA? ");
      double max_gpa = sc.nextDouble();
      System.out.print("    GSS? ");
      int gss = sc.nextInt();  
      
      double over_sc_gmat = overall_sc_gmat(english, math, reading, science, gpa, max_gpa, gss);
      
      return over_sc_gmat;
      
   }


   // Calculates overall GMAT score
   public static double overall_sc_gmat(int english, int math, int reading, int science, double gpa, double max_gpa, int gss){
   
      double gmat_score = (double)(2 * reading + english + math + science)/1.8;
      double count_gpa = (gpa/max_gpa)*100;
      double gss_result = (double)0.01 * gss;
   
      double overall_score = gmat_score + count_gpa + gss_result;
   
      return overall_score;
   }


   //Print each applicant's score
   public static void print_scores(double score1, double score2) {
      System.out.printf("\nFirst applicant overall score = %.3f", score1);
      System.out.printf("\nSecond applicant overall score = %.3f", score2);
   }


   // Compare both applicant
   public static void compare(double score1, double score2) {
      if (score1 > score2){
         System.out.println("\nThe first applicant seems to be better");
      }
      else if(score1 < score2) {
         System.out.println("\nThe second applicant seems to be better");
      }
      else {
         System.out.println("\nFirst and Second applicants are equal");
      }
   }

}