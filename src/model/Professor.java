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
			this.name = name;
		}else {this.name = "----";}
	}
	public void setSurname(String surname) {
		Surname = surname;
	}
	public void setDegree(Degree degree) {
		this.degree = degree;
	}
	
	
	
	//3 constructors
	//4 toString function
	//5 other functions
	
}
