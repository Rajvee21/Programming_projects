// player class 

public class Player {   //Parent Class

	private String name;
	private double salary;
	private int number;
	
	/**
	 * Contructor for Player class
	 * 
	 * @param name - player name
	 * @param salary - player salary
	 * @param number - player number
	 */
	public Player(String name, double salary, int number) {
		this.name = name;
		this.salary = salary;
		this.number = number;
	}
	
	//Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	//Getters
	public String getName() {
		return this.name;
	}
	
	public double getSalary() {
		return this.salary;
	}
	
	public int getNumber() {
		return this.number;
	}
	
   //equals method
	public boolean equals(Player p1) {
		return this.equals(p1);
	}
	
   //toString method
	public String toString() {
		String s = "Name: "+this.name+"\nSalary: "+this.salary+"\nNumber: "+this.number;
		return s;
	}
}
