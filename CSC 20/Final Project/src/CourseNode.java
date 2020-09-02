import java.util.*;


public class CourseNode {
	
	
	private Course c;
	CourseNode next;
	
	//node constructor
	public CourseNode (Course c) {          
		this.c=c;
	
	}

    //getter
	public CourseNode getNext() {
		return this.next;
	
	}
	
	//setNext
	public void setNext(CourseNode next) {
		this.next = next;
	
	}
	//getCourse
	public Course getCourse() {
		return c;
   }
	
}