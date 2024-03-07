package model;


public class Professor extends Person{
	//1 variables
	
	private long pID;
	private Degree degree;
	
	private static long counter = 0;
	
	
	
	//2 get and set
	public long getpID() {
		return pID;
	}
	
	public Degree getDegree() {
		return degree;
	}
	
	
	public void setpID() {
		this.pID = counter;
		counter++;
	}
	
	
	public void setDegree(Degree degree) {
		if(degree != null ) {  
			this.degree = degree;      
		}else {this.degree = Degree.other;}
		
	}
	
	//3 constructors
	public Professor() {
		super(name, surname);        //izsauc Person konstruktorus
		setpID();
		setDegree(Degree.other);
		super.toString();
	}
	
	public Professor(String name, String surname, Degree degree) {
		setpID();
		setName(name);
		setSurname(surname);
		setDegree(degree);
	}
	
	//4 toString function
	public String toString() {
		return pID+ " : " +degree+ ", " +name+ " " +surname;
	}
	//5 other functions
	
}
