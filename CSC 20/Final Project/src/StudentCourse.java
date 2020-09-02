import java.io.*; 
import java.util.*;

public class StudentCourse extends Course  implements Comparable, Serializable{

   private String grade;
   private int year;
   private String semester;

   
   //constructor
   public StudentCourse(int units, int number, String name, Course preRequisite,int section, Person instructor, String grade, int year, String semester){
      
	   super(units, number, name, preRequisite, section, instructor);
      
	   this.grade = grade;
      
	   this.year = year;
      
	   this.semester = semester;
   
   }
   
   //getter
   public String getGrade(){
     
	   return grade;
   
   }
   
   public int getYear(){
    
	   return year;
   
   }
   
   public String getSemester(){
    
	   return semester;
   
   }
   
   //setter
   public void setGrade(String grade){
      
	   this.grade = grade;
   
   }
   
   public void setYear(int year){
   
	   this.year = year;
   
   }
   
   public void setSemester(String semester){
   
	   this.semester = semester;
  
   }
   
   //compareTo
   public int compareTo(Object o){
      
	   if(o instanceof StudentCourse){
       
		   StudentCourse other = (StudentCourse) o;
    	  
		   if(this.getNumber() < other.getNumber()){
           
			   return -1;
         
		   }
         
		   else if(this.getNumber() > other.getNumber()){
           
			   return 1;
         
		   }
         
		   else{
           
			   return 0;
         
		   }
      
	   }
      
	   else{
         //returns -2 because it is not an instance of  
         
		   return -2;
 
	   }
  
   }
   
   //equals
   public boolean equals(StudentCourse other){
    
	   if(this.getNumber() == other.getNumber()){
       
		   return true;
      
	   }
      
	   else{
       
		   return false;
      
	   }
   
   }
   
   //toString
   public String toString(){
    
	   return "Student grade: " + getGrade() + " Year: " + getYear() + " Semester: " + getSemester();
   
   }

}