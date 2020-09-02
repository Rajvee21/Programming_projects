public class StudentCourseNode {
	
	int position;
	//StudentCourseNode next;
	
	private StudentCourse c;
	public Object data;

	
	private StudentCourse course;
	private StudentCourseNode next;
	

	public StudentCourseNode (StudentCourse c) {
		
		this.c = c;
		//this.setNext(next);	
		
	}
	
	public StudentCourseNode getNext() {
	
		return this.next;
	}

	public StudentCourse getCourse() {
	
		return this.c;
	}

	public void setNext(StudentCourseNode c) {
		
		next = c;

	}
	
}