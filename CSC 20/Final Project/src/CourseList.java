import java.io.*;
import java.util.*;
                                         //will not run unless delete Comparable

public class CourseList implements List, Serializable{

	
	private CourseNode front;
   
   //constructor
   
	public CourseList(Course c){
      
		front = new CourseNode(c);
   
	}
	
	public CourseList() {
		
		front = null;

	}

	
	public void add(Object o) {
      
		Course O = (Course)o;
      
		if(front == null){
         
			front = new CourseNode(O);
      
		}
      
		CourseNode n = new CourseNode(O);
      
		CourseNode current = front;
      
		while(current.getNext() != null){
         
			current = current.getNext();   
      
		}
      
		current.setNext(n);		
	
	}

	
	public void remove(Object o) {
		
		Course O = (Course)o;
      
		if(front == null){
         
			front = new CourseNode(O);
      
		}
      
		CourseNode current = front;
      
		CourseNode prev = null;
      
		while(current != null) {
         
			if(o.equals(current)){
            
				current = front.getNext();
         
			}
         
			else {
            
				prev.setNext(current.getNext());
         
			}
         
			current = current.getNext();
      
		}	
	
	}

	
	public void insert(int position, Object o) {
		
		Course O = (Course) o;
      
		CourseNode n =  new CourseNode(O);
      
		if(front == null){
         
			front = new CourseNode(O);
      
		}
      
		if(position == 0){
         
			front = n;
      
		} 
      
		else {
         
			CourseNode current = front;
         
			CourseNode previous = null;
         
			int i = 0;
         
			while(i< position-1){
            
				previous = current;
            
				current = current.getNext();
            
				if(current == null){
               
					break;
            
				}
            
				i++;
         
			}
         
         
			n.setNext(current);
         
			previous.setNext(n);
      
		}
	
	}

   // searches for element and return index of that element
	public Object search(Object other) {
	  if(other instanceof Integer){
		int o = (Integer)other;
      
		CourseNode current = front;
      
		int index = 0;
      
		while(current != null){
         
			if (current.getCourse().getNumber() == o){
            
				return current.getCourse();
         
			}
         
			else{
            
				current = current.getNext();
            
				index++;
         
			}
      
		}
	  }
	  else{
			String o = (String)other;
		      
			CourseNode current = front;
	      
			int index = 0;
	      
			while(current != null){
	         
				if (current.getCourse().getName().equals(o)){
	            
					return current.getCourse();
	         
				}
	         
				else{
	            
					current = current.getNext();
	            
					index++;
	         
				}
	      
			}  
	  }
		return null; 
	
	}

	public int size() {
   	
		int size = 0;
      
		CourseNode current = front;
      
		while(current != null){
         
			size++;
         
			current = current.getNext();
      
		}
      
		return size;
	
	}

	public void insert(Object o, int position) {
		
		Course O = (Course) o;
      
		CourseNode n =  new CourseNode(O);
      
		if(front == null)
         
			front = new CourseNode(O);
      
		if(position == 0){
         
			front = n;
      
		} else {
         
			CourseNode current = front;
         
			CourseNode previous = null;
         
			int i = 0;
         
			while(i < position-1){
            
				previous = current;
            
				current = current.getNext();
           
				if(current == null)
               
					break;
            
				i++;
         
			}
         
         
			n.setNext(current);
         
			previous.setNext(n);
      
		}
		
	}

	public void sort() {		
		
		for (int i = 0; i < size(); i++ ) {
          
			CourseNode current = front;
          
			CourseNode next = front.getNext();
          
			for (int j = 0; j < size() - 1; j++) {
              
				if (current.equals(next)) {
              
					CourseNode temp = current;
              
					current = next;
              
					next = temp;
              
				} 
          
				current = next;
          
				next = next.getNext();                   
          
			} 
     
		}				
	
	}

	public Object copy() {	
		
		CourseNode copy = front;
      
		CourseList cop = null;
      
		while(copy != null){
         
			cop.add(copy);
         
			copy = copy.getNext();
      
		}
      
		return cop;
	
	}
	
	public boolean isEmpty() {
      
		if(front == null){
		   
			return false;
      
		}
     
		else{
         
			return true;
      
		}
	
	}

	
	public void addFirst(Object o) {
		
		Course O = (Course)o;
      
		if (front == null) { 
     
			front = new CourseNode(O);
   
		}
   
		else {
     
			CourseNode current = new CourseNode(O);
     
			current.setNext(front);
     
			front = current;
      
		}	
	
	}  
   
	public String toString(){
      
		CourseNode current = front;
     
		String s = "";
     
		while(current.getNext() != null){
			
			s += current.getCourse();
			
			//s = s + current + " ";
         
			if(current.getNext() != null){
                s += "\n ";
			}
			
			current = current.getNext();
      
		}
      
		return s;
   
	}
   
  
	public int compareTo(Object o){ 
      
		CourseNode O = (CourseNode)o;
      
		return 0;
   
	} 
	
	
	
}