import java.util.*;
import java.io.*;

public class StudentList implements List, Serializable {

	//private final ArrayList<Student> s;
	private int size;
   
   //constructor
  
    ArrayList<Student> s = new ArrayList<Student>();
	
	public void add(Object o) {
	
		if(o instanceof Student){
		
			s.add((Student)o);
		   
			size++;
      
		}
	
	}

	public void remove(Object o) {
	
		if(o instanceof Student){
		
			s.remove((Student)o);
		   
			size--;
      
		}
	
	}
	
	public void insert(int position, Object o) {
	
		if(o instanceof Student){
		
			s.add(position,(Student)o);
		   
			size++;
      
		}
		
	}
	
	public Object search(Object o) {
		
		int id = (Integer) o;
		
		for(int i = 0; i<s.size(); ++i) {
			
			if(id==s.get(i).getId()) {
				
				return s.get(i);
			
			}
		
		}
		
		
		return null;
	
	}
	
	public int size() {
	
		return size;
	
	}

	public void insert(Object o, int position) {
	
		if(o instanceof Student){
        
			Student p = (Student)o;
         
			s.add(position, p);
      
		}
	}

	public void sort() {
		
		
		Student [] students = (Student[]) copy();
		
		
		for (int i = 0; i < students.length -1; i++) {
			
		
			for (int j = 0; j < students.length -1 -i; j++) {
				
				if (students [j + 1].compareTo(students[j]) < 0 ) {
				
				
					Student temp = students [j];
			
					students [j] = students [j + 1];
			
					students [j + 1] = temp;
				
				}	

			}
		
		}		
		
	}
	
	public Object copy() {
		
	
		Student[] students = new Student [size]; 	
		
		for(int i = 0; i < s.size(); i++){		
		
			students[i] =  s.get(i);	 			
	   
		}
	
		return students;	
	
	}
	
	public boolean isEmpty() {
    
		return s.isEmpty();
	
	}
	
	public void addFirst(Object o) {
	
		if(o instanceof Student){
		
			s.add(0,(Student)o);
      
		}
	
	}
	
	public void print() {
        for (int i = 0; i < s.size(); i++) {
            System.out.println(s.get(i));
        }
    }

}