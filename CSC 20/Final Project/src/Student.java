import java.io.*;
import java.util.*;
                                                             //will not run because of Comparable
public class Student extends Person implements Serializable, Comparable{
	
	private String major;
	
	private StudentCourseList myCourseList;
	
	private int majorUnits; 
    
	private int id;
	
   //constructor
	public Student(String name, String lastName, String major, StudentCourseList myCourseList, int majorUnits, int id) {
		
		super(name, lastName);
		
		this.major = major;
		
		this.myCourseList = myCourseList;
		
		this.majorUnits = majorUnits;	
		
		this.id = id;
		
	
	}
	
    //getter
	public String getMajor() {
		
		return major;
	
	}
	
	public StudentCourseList getMyCourseList() {
		
		return myCourseList;
	
	}
   
	public int getMajorUnits() {
		
		return majorUnits;
	
	}
   
	public int getId() {
		
		return id;
	
	}
   
    //setter
	private void setMajor(String major) {
		
		this.major = major;		
	
	}
	
	private void setMyCourseList(StudentCourseList myCourseList) {
		
		this.myCourseList = myCourseList;	
	
	}
	
	private void setMajorUnits(int majorUnits) {
		
		this.majorUnits = majorUnits;	
	
	}
	
	private void setId(int id) {
		
		this.id = id;	
	
	}
	
    //equals 
	public boolean equals(Student other){
      
		if(other instanceof Student){
	      
			if(this.getId() == other.getId()){
	         
				return true;
	      
			}
	      
			else{
	         
				return false;
	      
			}
         
		}
         
		else {
            
			return false;
         
		}
		
	   
	}
	
	public int getUnitsCompleted() {
		
		int units = 0;
		
		return units;
	
	}
	
	public int getUnitsLeft() {
		
		return this.majorUnits - this.getUnitsCompleted();
	
	}
	
	//toString
	public String toString() {
		
		return "Name: " + super.getName()+ " "+ super.getLastName() + "\nID: " + getId() + "\nMajor: " + getMajor() + "\nMajor units: " + getMajorUnits() + "\n";
	
	}
	
	
	public int compareTo(Student other){
	      
		if(other instanceof Student){
	      
			if(this.getId() < other.getId()){
	        
				return -1;
	         
			}
	        
			else if(this.getId() > other.getId()){
	        
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
	
	public double getGpa() {
		
		double gpa = 0;
      
		while(!myCourseList.isEmpty()){
         
      
		}
      
		return gpa;
	
	}
	
}