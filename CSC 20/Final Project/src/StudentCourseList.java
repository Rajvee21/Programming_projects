import java.io.Serializable;

public class StudentCourseList implements List, Serializable {
	
	private StudentCourseNode front;
	private int size;
	
	 public StudentCourseList () {

		 front = null;
	 
	 }
	 
	 public void StudentCourseNode(StudentCourse c) {

		 front = new StudentCourseNode (c);
	    
		 size++;
	    
	 } 
		
	 public void add(Object o) {
	
		 StudentCourseNode n = new StudentCourseNode((StudentCourse) o);
		
		 StudentCourseNode current = front;
		 
		 if(current == null) {
		 
			 front = n;
		 
			 size++;
		  
			 // to be done with the method
		  
			 return;
		 
		 }
		 
		 
		 while(current.getNext() != null) {
		  
			 current = current.getNext();
		 
		 }
		 
		 size++;
		 
		 current.setNext(n);
	
	 }
	 
	
	 public void remove(Object o) {
		
		
		 StudentCourseNode current = front;
		
		 StudentCourseNode prev = front;
		
		 int i = 1;
		
		
		 while(current != null) {
			
			 if (i == size) {
			
				 prev.setNext(current.getNext());
				
				 size--;
				
			
			 }
			
		
			 prev = current;
			
			 current = current.getNext();
			
			 i++;
			
	
		 }
		
	
	 }
	
	 public void insert(int position, Object o) {
		
	
		 StudentCourseNode current = front;
		
		 StudentCourseNode prev = front;
		
		 StudentCourseNode n = new StudentCourseNode ((StudentCourse) o) ;
		
		 int number = 0;
		
		
		 while(position > size) {
			position = position % size;
			
		 }
		
		 while (current != null) {
			
	
			 if (number == size-position+1) {
		
				 prev.setNext(n);
		
				 n.setNext(current);
		
				 size++;
		
				 return;
		
			 }
		
			 prev = current;
		
			 current = current.getNext();
		
			 number++;
		
		 }		
		
	
	 }

	public Object search(Object o) {
	
		
		StudentCourseNode current = front;
		
		StudentCourseNode prev = front;
		
		int i = 0;
		
		while(current != null && i <= size) {
			
			if(i == size - i) {
			
				return current.data;
			
			}
			
			
			prev = current;
			
			current = current.getNext();
			
			i++;
		
		}
			
		return 0;
	}
	
	public int size() {
		
		int size = 0;
	     
		StudentCourseNode current = front;
	    
		while(current != null){
	    
			size++;
	        
			current = current.getNext();
	      
		}
	    
		return size;
	
	}
	
	public void insert(Object o, int position) {
		
		StudentCourseNode current = front;
		
		StudentCourseNode prev = front;
		
		StudentCourseNode n = new StudentCourseNode((StudentCourse) o);
		
		int number = 0;
		
		while(position > size) {
			
			position = position % size;
			
		}
		
		while (current != null) {
			
		
			if (number == size - position + 1) {
		
				prev.setNext(n);
		
				n.setNext(current);
		
				size++;
		
				return;
		
			}
		
			prev = current;
		
			current = current.getNext();
		
			number++;
		
		}
		
	}
	
	public void sort() {
		
		for (int i = 0; i < size(); i++ ) {
	     
			StudentCourseNode current = front;
	        
			StudentCourseNode next = front.getNext();
	        
			for (int j = 0; j < size() - 1; j++) {
	         
				if (current.equals(next)) {
	            
					StudentCourseNode temp = current;
	              
					current = next;
	              
					next = temp;
	              
				} 
	          
				current = next;
	          
				next = next.getNext();                   
	          
			} 
	     
		}			
		
	}
	
	public List copy() {
		
		StudentCourseNode copy = front;
	    
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
		
		StudentCourseNode n = new StudentCourseNode((StudentCourse) o);
		
		n.setNext(front);
		
		front = n;
		
		size++;
		
	}
	
	public String toString(){
	
		StudentCourseNode current = front;
	    
		String s = "";
	    
		while(current != null){
	    
			s = s + current + " ";
	        
			current = current.getNext();
	      
		}
	    
		return s;
	   
	}
	
}