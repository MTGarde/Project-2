package model;


public class Professor {
	//1 variables
	private long pID;
	private String name;
	private String Surname;
	private Degree degree;
	
	private static long counter = 0;
	
	
	
	//2 get and set
	public long getpID() {
		return pID;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return Surname;
	}
	public Degree getDegree() {
		return degree;
	}
	
	
	public void setpID() {
		this.pID = counter;
		counter++;
	}
	
	
	public void setName(String name) {
		if(name != null && name.matches("[A-Z]{1}[a-z]+([A-Z]{1}[a-z]+)?")) {  //regex pirmais lielais parejie mazie jebkadi, iespejami vairaki vardi (regex 101)
			this.name = name;                                                  //konta numurs butu "LV[0-9]{2}[A-Z]{4}[0-9]{13}"
		}else {this.name = "----";}
	}
	public void setSurname(String surname) {
		if(surname != null && surname.matches("[A-Z]{1}[a-z]+([A-Z]{1}[a-z]+)?")) {  
			this.Surname = surname;              
		}else {this.Surname = "----";}
		
	}
	public void setDegree(Degree degree) {
		if(degree != null ) {  
			this.degree = degree;      
		}else {this.degree = Degree.other;}
		
	}
	
	//3 constructors
	public Professor() {
		setpID();
		setName("Janis");
		setSurname("Berzins");
		setDegree(Degree.other);
	}
	
	public Professor(String name, String surname, Degree degree) {
		setpID();
		setName(name);
		setSurname(surname);
		setDegree(degree);
	}
	
	//4 toString function
	public String toString() {
		return pID+ " : " +degree+ ", " +name+ " " +Surname;
	}
	//5 other functions
	
}
