//This lab gives you exercises with using two dimensional arrays of Java and practices with using
//methods that return arrays. What you should do is to download and complete the instructor’s
//program lab03.java:
//1. Implement print2D(A) so that it prints out its 2D array argument A in the matrix form.
//2. Implement add2Ds(A,B) so that it creates and returns a new 2D array C such that C=A+B.
//3. Implement multiScalar2D(c,A) so that it creates and returns a new 2D array B such that B=c×A.
//4. Implement transpose2D(A), which creates and returns a new 2D array B such that B is the transpose of A. 
 
   public class lab_03 {
   static void print(int[][]A) {
      for(int i=0; i<A.length; i++){
         for(int j=0; j<A[i].length; j++){
            System.out.printf("%3d", A[i][j]);
         }
         System.out.println();
      }
      System.out.println();
   }
   
   static int[][] add2Ds(int[][]A, int[][]B) {
      int[][]P= new int[A.length][A[0].length];
      for(int i=0; i<A.length; i++){
         for(int j=0; j<A[i].length; j++){
            P[i][j] = A[i][j]+B[i][j];
         }
      }
      return P;
   }

   static int[][] multi_scaling2D(int scaling2D, int[][]A) {
      int[][]Q= new int[A.length][A[0].length];
      for(int i=0;i<A.length;i++){
         for(int j=0; j<A[i].length; j++){
            Q[i][j]=scaling2D*A[i][j];    
         }
      }
      return Q;
   }

// Transposing a matrix
   static int[][] transpose(int[][]A) {
      int[][]R= new int[A[0].length][A.length];
      for( int i=0; i<A[0].length; i++){
         for(int j=0;j<A.length; j++){
            R[i][j]=A[j][i];
         }
      }
      return R;
   }

   public static void main(String args[]) {
      int A[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
      int B[][] = {{2, 4, 6, 8}, {10, 12, 14, 16}, {18, 20, 22, 24}};
      System.out.println("Test program\n");
      System.out.println("A = ");
      print(A);
      System.out.println("B = ");
      print(B);
      System.out.println("A + B = ");
      print(add2Ds(A,B));
      System.out.println("5 X A = ");
      print(multi_scaling2D(5,A));
      System.out.println("Transpose of A = ");
      print(transpose(A));
   }
}