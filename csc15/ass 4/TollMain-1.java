// Toll calculations //


import java.util.*;

public class TollMain {
public static void main(String[] args){
   //a loop that makes 10 calls to TollCalculationcalculateToll()
   for(int i=1; i<=10; i++){
   Scanner sc = new Scanner(System.in);
   TollCalculation.calculateToll(sc);
   }
  }
}