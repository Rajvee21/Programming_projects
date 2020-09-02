import java.io.*;
import java.util.*;

public class Driver{

   public static void main(String[] args)throws FileNotFoundException{
      //reads from file
      Scanner kb = new Scanner(new File("courses.txt"));
      Scanner console = new Scanner(new File("students.txt"));
      //user input
      Scanner answer = new Scanner(System.in);
      //variable used to prompt at end to run program again
      String choice = "";
      
      //these arrays will populate the IO files with the current classes, students, and courses taken
      //then the student option 3 will add these into the IO files and continue to add
      ArrayList<String> TakingCourses = new ArrayList<String>();
      ArrayList<String> newStudents = new ArrayList<String>();
      ArrayList<String> newCourses = new ArrayList<String>();
      while(kb.hasNextLine()){
    	  newCourses.add(kb.nextLine());
      }
      while(kb.hasNextLine()){
    	  newStudents.add(console.nextLine());
      }
      //reset scanner pointer
      kb = new Scanner(new File("courses.txt"));
      console = new Scanner(new File("students.txt"));
      
      //Object of class
      CourseList courses = new CourseList();
      //populate the Linked List for CourseList
      while(kb.hasNextLine()){
    	  int units = kb.nextInt();
    	  String course = kb.next();
    	  int number = kb.nextInt();
    	  String preReq = kb.next();
    	  int section = kb.nextInt();
    	  String first = kb.next();
    	  String second = kb.next();
    	  
    	  Person instructor = new Person(first, second);
    	  
    	  Course preReqObj = (Course) courses.search(preReq);
    	  
    	  if(preReqObj==null) {
    		  preReqObj = new Course(0, 0, preReq, null, 0, null);
    	  }
    	  
    	  Course courseObj = new Course(units, number, course, preReqObj, section, instructor);
    	  
    	  courses.add(courseObj);
    	  
    	  //System.out.println(courses.toString()); 
      }
      
    
      //Object of class
      StudentList students = new StudentList();
      //populate the ArrayList for StudentList
      while(console.hasNextLine()){
         String first = console.next();
         String second = console.next();	
         String name = first + " " + second;
         int id = console.nextInt();
         String major = console.next();
         Student studentObj = new Student(first, second, major, null, 124, id);
         
         students.add(studentObj);
         //students.print();
      }
      
      do{
    	
      //kb = new Scanner(new File("\\\\GAIA\\modir\\CSC20\\Final Project\\src\\courses.txt"));
      //console = new Scanner(new File("\\\\GAIA\\modir\\CSC20\\Final Project\\src\\students.txt"));
      
      System.out.println("Enter number for option:");
      System.out.println("1. List of all the students in the list.");
      System.out.println("2. List of all the courses in the list.");
      System.out.println("3. Student Options");
      System.out.println("4. Enter as admin");
      int option = answer.nextInt();
      
      //Option 1: List all the student info
      if(option == 1){
         /*System.out.println("Here are all the student name, ID, and major: ");
         while (console.hasNextLine()){
            System.out.println(console.nextLine());
         }*/
    	  students.print(); 
      }
      //Option 2: List all the course info
      else if(option == 2){
    	  /*
         System.out.println("Here are all the courses: ");
         while(kb.hasNextLine()){
            System.out.println(kb.nextLine());
         }*/
    	  System.out.println(courses.toString()); 
      }
      //Option 3: Open student menu
      else if(option == 3){
         boolean cont = false;
        
	    	Scanner in = new Scanner(System.in);
	    	System.out.println("Please enter your student id: ");
	    	int stu_id = in.nextInt();
	    	int counter = 0;
            console = new Scanner(new File("students.txt"));
            while(console.hasNextLine()){
               String first = console.next();
               String second = console.next();
               int id = console.nextInt();
               String major = console.next();
               if(stu_id == id){
                  counter++;
               }
            }
            while(counter == 0){
               System.out.println("There is no student with that ID");
               System.out.println("Please input another ID");
               stu_id = answer.nextInt();
               console = new Scanner(new File("students.txt"));
               while(console.hasNextLine()){
                  String first = console.next();
                  String second = console.next();
                  int id = console.nextInt();
                  String major = console.next();
                  if(stu_id == id){
                  System.out.println("Welcome: " + first + " " + second);
                     counter++;
               }
               }
            }
            while(cont == false){
	    	   Object stu = students.search(stu_id);
            System.out.println("Student Options:");
            System.out.println("1. Display The List of courses taken");
            System.out.println("2. Display GPA");
            System.out.println("3. Add courses to the list");
            System.out.println("4. Remove a course from the list");
            System.out.println("5. Output the units taken so far");
            System.out.println("6. Display units left to take");
            System.out.println("7. List all the courses taught by a particular instructor");
            System.out.println("8. List all the sections for a particular course");
            option = answer.nextInt();
            
            //Display List of Courses taken
            if(option == 1){       	
               try{
                  // if binary file is already created, read courses from this file
                  File f = new File("a.dat");
                  StudentCourseList coursesTaken = new StudentCourseList();
                  if(f.exists()){
                     ObjectInputStream inn = new ObjectInputStream(new FileInputStream("a.dat"));
                     TakingCourses = (ArrayList) inn.readObject();
                     inn.readObject();
                  }
                  //if binary file is not yet created will prompt
                  else{
            	      System.out.println("No courses has been taken yet.");
                  }
               }
               catch (IOException e){
                  System.out.println("IOException");
               }
               catch (ClassNotFoundException e){
                  System.out.println("ClassNotFoundException");
               }
               cont = true;      
            }
            //Display GPA
            else if(option == 2){ 
            	int id = stu_id;
            	Student s = (Student) students.search(id);
            	double gpa = 0.0;
            	StudentCourseList studentCourseList = s.getMyCourseList();
               cont = true;
            }
            //Add course to List
            else if(option == 3){
               try{
               File f = new File("a.out");
               //if file exists already, continue to add
               if(!f.exists()){
                  ObjectInputStream inn = new ObjectInputStream(new FileInputStream("a.dat"));
                  System.out.println("Enter class you want to add: units, class, and class number");
                  String add = answer.next();
                  TakingCourses.add(add);
                  TakingCourses = (ArrayList) inn.readObject();
                  inn.readObject();
               }
               //creates file here if it does not exist then add first element in arraylist
               else{
                  ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("a.dat", true));
                  System.out.println("Enter class you want to add: units, class, and class number");
                  String add = answer.next();
                  TakingCourses.add(add);
                  out.writeObject(TakingCourses);
               }
               }
               catch (IOException e){
                  System.out.println("IOException");
               }
               catch (ClassNotFoundException e){
                  System.out.println("ClassNotFoundException");
               }
               cont = true;
            }
            //Remove course from List
            else if(option == 4){
               cont = true;
            }
            //Display units taken so far
            else if(option == 5){
           //   double gpa = studentObj.getGPA();
           //   System.out.println("Your GPA is: " + gpa);
               cont = true;
            }
            //Display units needed to take still
            else if(option == 6){
               int neededUnits = 0;
               System.out.println("You still need: " + neededUnits);
               cont = true;
            }
            //Display courses taught by a specific instructor
            else if(option == 7){
               System.out.println("Enter professor name");
               //instructor name you are looking for 
               String instructor = answer.next();
               int count = 0;
               kb = new Scanner(new File("courses.txt"));
               //reads through one line at a time
               while(kb.hasNextLine()){
                  int units = kb.nextInt();
                  String course = kb.next();
                  int section = kb.nextInt();
                  String preReq = kb.next();
                  int sectionReq = kb.nextInt();
                  String first = kb.next();
                  String second = kb.next();
                  //checks to see if input contains instructor name
                  if(instructor.contains(first) == true){
                     System.out.println(first + " " + second + " teaches: " + course + " Section: " + section +". The preRequisite for this class is: " + preReq );
                     count++;
                  } 
                  //checks to see if input is instructors last name only
                  else if(instructor.contains(second) == true){
                     System.out.println(first + " " + second + " teaches: " + course + " Section: " + section +". The preRequisite for this class is: " + preReq );
                     count++;
                  } 
               } 
               if(count == 0){
                  System.out.println("No instructor by that name: " + instructor);
               }  
               cont = true;
            }
            //display all sections for the course
            else if(option == 8){
               System.out.println("Enter course name to see all the section");
               String csc = answer.next();
               //loops if there is a next line in the file
               while(kb.hasNextLine()){
                  int units = kb.nextInt();
                  String course = kb.next();
                  int section = kb.nextInt();
                  String preReq = kb.next();
                  int sectionReq = kb.nextInt();
                  String first = kb.next();
                  String second = kb.next();
                  //checks if the course matches the user's input
                  if(csc.equalsIgnoreCase(course) == true){
                     System.out.println("Section: " + section + " Professor: " + first + " " + second);
                  }
               }
               cont = true;
            }
            else{
               System.out.println("Error. Please enter a number between 1-8 this time.");
               System.out.println();
            }
          }     
      
      }
      //Option 4: open admin menu
      else if(option == 4){
         boolean cont = false;
         while(cont == false){
            System.out.println("1. Would you like to add a new course to the list?");
            System.out.println("2. Would you like to remove a course from the list?");
            System.out.println("3. Would you like to add a new student into the list?");
            option = answer.nextInt();
            //add new course to list
            if(option == 1){
               try{
                  File f = new File("b.dat");
                  if(!f.exists()){
                     ObjectInputStream inn = new ObjectInputStream(new FileInputStream("b.dat"));
                     System.out.println("Enter class you want to add: units, class, and class number");
                     String add = answer.next();
                     newCourses.add(add);
                     newCourses = (ArrayList) inn.readObject();
                     inn.readObject();
                  }
                  else{
                     ObjectInputStream inn = new ObjectInputStream(new FileInputStream("b.dat"));
                     System.out.println("Enter class you want to add: units, class, and class number");
                     String add = answer.next();
                     newCourses.add(add);
                     newCourses = (ArrayList) inn.readObject();
                     inn.readObject();                       
                  }
               }
               catch (IOException e){
                   System.out.println("IOException");
               }
               catch (ClassNotFoundException e){
                  System.out.println("ClassNotFoundException");
               }
               cont = true;
            }
            //remove course from list
            else if(option == 2){
               System.out.println("Enter the name of the class you want to remove from the list");
               cont = true;
            }
            //add new student to list
            else if(option == 3){  
               try{
                  File f = new File("c.dat");
                  if(!f.exists()){
                     ObjectInputStream inn = new ObjectInputStream(new FileInputStream("c.dat"));
                     System.out.println("Enter class you want to add: units, class, and class number");
                     String add = answer.next();
                     newStudents.add(add);
                     newStudents = (ArrayList) inn.readObject();
                     inn.readObject();
                  }
                  else{
                     ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("c.dat", true));
                     System.out.println("Enter class you want to add: units, class, and class number");
                     String add = answer.next();
                     newStudents.add(add);
                     out.writeObject(newStudents);
                  }
               }
               catch (IOException e){
                   System.out.println("IOException");
               }
               catch (ClassNotFoundException e){
                  System.out.println("ClassNotFoundException");
               }
               cont = true;
            }
            else{
               System.out.println("Error. Please enter a number between 1-3 this time.");
               System.out.println();
               cont = false;
            }
         }
     }
      else{
      System.out.println("Error. Wrong input");
      } 
      //prompts to re-run
      System.out.println("Would you like to go again?(Yes | No)");
      answer.nextLine();
      choice = answer.next();
 
     }while(choice.equals("Yes"));   
   }
}
     