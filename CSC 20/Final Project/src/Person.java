import java.io.*; 
                                             //run program will fail because of Comparable
public class Person implements Serializable, Comparable {

	
	private String name;
	
	private String lastName;
	
   //constructor
	
	public Person (String name, String lastName) {
		
		this.name = name;
		
		this.lastName = lastName;	
	}
   
   //getter
	public String getName() {	
		
		return name;	
	}


	public String getLastName() {	
		
		return lastName;	
	}

   //setter
	
	public void setName(String name) {	
		
		this.name = name;		
	}
	
	public void setLastName(String lastName) {	
		
		this.lastName = lastName;
	}

   //equals method
	public boolean equals(Person p1) {
      
		if(p1 instanceof Person){
		   
			return this.name.equalsIgnoreCase(p1.name) && this.lastName.equalsIgnoreCase(p1.lastName); 
      
		}
      
		else{
         
			return false;
      
		}
	
	}
	

   //toString 
	public String toString() {
		
		return "Name: "+ this.name + " "+ this.lastName;		
	
	}
   
	//compareTo
	public int compareTo (Object o) {
	   	
	   if (o instanceof Person) {
	     
		   Person othr = (Person) o;	       
	     
		   return this.getLastName().compareTo(othr.getLastName());
	   
	   }	      
	   
	   else {
		   
		   return 0;
	   
	   }
	
	}
	
}