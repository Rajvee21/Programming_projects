public class Course{
   
   
	private int units;
	private int number;
	private String name;
	private Course preRequisite;
	private int section;
	private Person instructor;

   //constructor
   
	public Course(int units,int number, String name, Course preRequisite, int section, Person instructor){
      
		this.units = units;
        
		this.number = number;
        
		this.name = name;
      
		this.preRequisite = preRequisite;
      
		this.section = section;
      
		this.instructor = instructor;
   
	}  
   
   //getter
   
	public int getUnits(){
      
		return units;
   
	}
   
	public int getNumber(){
      
		return number;
   
	}
   
	public String getName(){
      
		return name;

	}
   
	public Course getPreRequisite(){
      
		return preRequisite;
   
	}
   
	public int getSection(){
      
		return section;
   
	}
   
	public Person getInstructor(){
      
		return instructor;
   
	}
   
   //setter
   
	public void setUnits(int units){
      
		this.units = units;
   
	}
   
	public void setNumber(int number){
      
		this.number = number;
   
	}
   
	public void setName(String name){
      
		this.name = name;
   
	}
   
	public void setPreRequisite(Course preRequisite){
      
		this.preRequisite = preRequisite;
   
	} 
   
	public void setSection(int section){
      
		this.section = section;
   
	}
   
	public void setInstructor(Person instructor){
      
		this.instructor = instructor;
   
	}
   
   //equals
   
	public boolean equals(Course other){
      
		if(other instanceof Course) {
         
			if(this.getNumber() == other.getNumber()){
            
				return true;
         
			}
      
		}
      
		return false;
   
	}
   
   //toString
   
	public String toString(){
      
		return "\nUnits: " + getUnits() + "\nCourse Name: " + getName() + "\nCourse Number: " + getNumber() + "\nPreRequisite: " + getPreRequisite().getName() + 
				"\nSection: " + getSection() + "\nInstructor " + getInstructor();
   
	}
   
   //compareTo
   
	public int compareTo(Course other){
      
		if(other instanceof Course){
         
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
         //returns -2 because it is not an instanceof 
         
			return -2;
      
		}
   
	}

}