package model;

public class Student extends Person{
	//variables
	private long stID;
	private String name;
	private String surname;
	
	private static long counter = 10000;
	
	//get and set
	public long getStID() {
		return stID;
	}
	
	
	public void setStID() {
		this.stID = counter;
		counter++;
	}
	
	
	
	//constructors
	public Student(){
		setStID();
		setName("Janis");
		setSurname("Berzins");
	}
	
	public Student(String name, String surname) {
		setStID();
		setName(name);
		setSurname(surname);
	}
	
	//toString
	public String toString() {
		return stID+ " : " +name+ " " +surname;
	}
	
	//other
}
