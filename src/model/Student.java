package model;

public class Student {
	//variables
	private long stID;
	private String name;
	private String surname;
	
	private static long counter = 10000;
	
	//get and set
	public long getStID() {
		return stID;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	
	public void setStID() {
		this.stID = counter;
		counter++;
	}
	
	public void setName(String name) {
		if(name != null && name.matches("[A-Z]{1}[a-z]+([A-Z]{1}[a-z]+)?")) {  //regex pirmais lielais parejie mazie jebkadi, iespejami vairaki vardi (regex 101)
			this.name = name;                                                  //konta numurs butu "LV[0-9]{2}[A-Z]{4}[0-9]{13}"
		}else {this.name = "----";}
	}
	public void setSurname(String surname) {
		if(surname != null && surname.matches("[A-Z]{1}[a-z]+([A-Z]{1}[a-z]+)?")) {  
			this.surname = surname;              
		}else {this.surname = "----";}
		
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
