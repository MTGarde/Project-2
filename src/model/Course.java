package model;

public class Course {
	//variables
	private long cID;
	private String title;
	private int creditPoints;
	private Professor professor;
	
	private static long counter = 100000;
	
	//get set
	public long getcID() {
		return cID;
	}

	public String getTitle() {
		return title;
	}

	public int getCreditpoints() {
		return creditPoints;
	}

	public Professor getProfessor() {
		return professor;
	}
	
	
	public void setcID() {
		this.cID = counter;
		counter++;
	}
	
	
	public void setTitle(String title) {
		if(title != null && title.matches("[A-Za-z ]+")) {  
			this.title = title;              
		}else {this.title = "undefined";}
		
	}
	
	public void setCreditPoints(int number) {
		if(number > 0 && number <= 20) {
			creditPoints = number;
		} else {creditPoints = 2;}
	}
	
	public void setProfessor(Professor professor) {
		if(professor != null) {
			this.professor = professor;
		} else {this.professor = new Professor();}
	}
	
	//constructors
	public Course() {
		setcID();
		setTitle("Default name");
		setCreditPoints(2);
		setProfessor(new Professor());
	}
	
	public Course(String title, int credits, Professor prof) {
		setcID();
		setTitle(title);
		setCreditPoints(credits);
		setProfessor(prof);
	}
	
	//toString
	public String toString() {
		return cID+ " : " +title+ " " +creditPoints+ " | " +professor; // tiek izsaukta professor toString funkcija
	}
	//other
}
