public class Triangle {

   //double side 1
   private double x;
   
   //double side 2
   private double y;
   
   //double side 3
   private double z;
   
   
	//triangle class
   public Triangle (double x, double y, double z)
   {
      this.x = x;
      this.y = y;
      this.z = z;
   }
	
   public Triangle() 
   {
      this(0, 0, 0);
   }

   // getter and setter methods
   public double getA() {
      return x;
   }

   public void setX(double x) {
      this.x = x;
   }

   public double getY() {
      return y;
   }

   public void setY(double y) {
      this.y = y;
   }

   public double getZ() {
      return z;
   }

   public void setZ(double z) {
      this.z = z;
   }
	
   //get area 
   public double getArea()
   {
      double semi = (x + y + z)/2;
      return Math.sqrt(semi * (semi - x) * (semi - y) * (semi - z));
   	
   }

   //get perimeter 
   public double getPerimeter()
   {
      return x + y + z;
   	
   }
	
   //equals 
   public boolean equals(Object a) 
   {
      if ( a instanceof Triangle) {
         Triangle othr = (Triangle) a;
         return this.x == othr.x &&
               this.y == othr.y &&
               this.z == othr.z;
      }
      else {
      
         return false;
      }
   }

   // toString 
   public String toString() {
      return String.format("Triangle: x= %.1f, y= %.1f, z= %.1f \nArea = %f \nPerimeter = %.2f ",
         	             x, y, z, this.getArea(), this.getPerimeter());
   }
	
   //compareTo
   public int compareTo (Object a) {
   	
      if (a instanceof Triangle) {
         Triangle othr = (Triangle) a;
         if (this.getArea() < othr.getArea()) {
            return -1;
         }
         else if (this.getArea() > this.getArea()) {
            return +1;
         }
         else {
            return 0;
         }
      }
      
      
      else {
         return 0;
      }
   	
   }
}
