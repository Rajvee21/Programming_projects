
import java.util.*;

public class Node {
	int digit;
	Node next;
	
public Node(int digit) {
	this.digit = digit;
}

public void setNext(Node n) {
	this.next = n;
}

public int getDigit() {
	return digit;
}

public Node getNext() {
	return this.next;
}



}
