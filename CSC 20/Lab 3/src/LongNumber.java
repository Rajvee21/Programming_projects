//Long Number 

public class LongNumber implements List {
	
	Node front;
    int size;
    
    public LongNumber () {

    	front = null;
    	}
    
    public LongNumber (int digit) {

    	front = new Node (digit);
    	size++;
    	} 
    
    // adds most significant value in linked list
	public void addMostSignificant(int digit) {
		 Node n = new Node(digit);
		 n.next = front;
		 front = n;
		 size++;
	}

	// adds least significant value in linked list
	public void addLeastSignificant(int digit) {
		
		 //Creating new node to be added
		 Node n = new Node(digit);
		 Node current = front;
		 
		 if(current == null) {
		  front = n;
		  size++;
		  // to be done with the method
		  return;
		 }
		 
		 while(current.next != null) {
		  current = current.next;
		 }
		 size++;
		 current.next = n;
		}
		
	//inserts the digit at the given position 
	public void insert(int position, int digit) {
		
		Node current = front;
		Node prev = front;
		Node n = new Node (digit) ;
		int number = 0;
		
		while(position > size) {
			position = position % size;
			
		}
		while (current != null) {
			
		if (number == size-position+1) {
		prev.next = n;
		n.next = current;
		size++;
		return;
		}
		prev = current;
		current = current.next;
		number++;
		}
		
		
	}

	//String method
	public String Add(LongNumber num) {
	
		LongNumber answer = new LongNumber();
	
		int position = 1;
		int digit1;
		int digit2;
		int result;
		int carry = 0;
		while (size - position >= 0 || num.size - position >= 0) {
			
			digit1 = this.getAt(position);
			digit2 = num.getAt(position);
			result = (digit1 + digit2 + carry)%10;
			answer.addMostSignificant(result);
			carry = (digit1 + digit2 + carry)/10;
			position++;
		}
		
		return String.format("%s", answer);
		 
	}

	//method getAt
	private int getAt(int position) {
		
		Node current = front;
		Node prev = front;
		int i = 0;
		
		while(current != null && i <= size) {
			
			if(i == size - position) {
				return current.digit;
			}
			
			prev = current;
			current = current.next;
			i++;
		}
		
		return 0;
	}

	//deletes the number at given position
	public void delete(int position) {
		
		Node current = front;
		Node prev = front;
		int i = 1;
		
		while(current != null) {
			if (i == position) {
				prev.next = current.next;
				size--;
				
			}
			
			prev = current;
			current = current.next;
			i++;
			
		}
	
	}
	
	//toString method
	public String toString() {
		String s = "";
		 Node current = front;
		 while(current != null) {
		  s += current.getDigit();
		  current = current.getNext();
		 }
		 
		 //returns s value
		 return s;
	}

}
