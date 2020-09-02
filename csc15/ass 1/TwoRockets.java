//Two Rockets : Write a complete Java program in a class namedTwoRocketsthat generates the following output. 
//              Use static methods to show structure and eliminate redundancy in your solution.

public class TwoRockets{
public static void main(String[] args){
drawcone();
drawline1();
drawbox();
drawUS();
drawbox();
drawcone();
drawstar1();
drawstar2();
drawline2();
drawline2();
drawstar2();
drawdots();
drawstar1();
drawstar2();
drawline2();
drawline2();
drawstar2();
drawdots();
}

public static void drawcone() {
System.out.println("   /\\       /\\  ");
System.out.println("  /  \\     /  \\ ");
System.out.println(" /    \\   /    \\");
}
    
public static void drawline1() {    
System.out.println("+------+ +------+");
}

public static void drawbox() {
System.out.println("|      | |      |");
System.out.println("|      | |      |");
drawline1();
}

public static void drawUS() {
System.out.println("|United| |United|");
System.out.println("|States| |States|");
drawline1();
}    

public static void drawstar1() {
System.out.println("   **       ** ");
}

public static void drawstar2(){
System.out.println("  ****     ****");
}

public static void drawline2() {
System.out.println("  ||||     ||||");
}

public static void drawdots() {
    System.out.println("  ....     ....");
}
}