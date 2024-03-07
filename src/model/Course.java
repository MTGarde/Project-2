package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Course {
	//variables
	private long cID;
	private String title;
	private int creditPoints;
	private ArrayList<Professor> professors;
	
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

	public Professor getProfessors() {
		return professors;
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
	
	public void setProfessors(ArrayList<Professor> professors) {
		if(professors != null) {
			this.professors = professors;
		} else {this.professors = new ArrayList<Professor>(Arrays.asList(new Professor()));}
	}
	
	//constructors
	public Course() {
		setcID();
		setTitle("Default name");
		setCreditPoints(2);
		ArrayList<Professor> tempProfs = new ArrayList<Professor>(Arrays.asList(new Professor()));
		setProfessors(tempProfs);
	}
	
	public Course(String title, int credits, Professor prof) {
		setcID();
		setTitle(title);
		setCreditPoints(credits);
		setProfessors(prof);
	}
	
	//toString
	public String toString() {
		return cID+ " : " +title+ " " +creditPoints+ " | " +professors; // tiek izsaukta professor toString funkcija
	}
	//other
	
	public void addProfessor(Professor professor) {
		if(!professors.contains(professor)) {
			professors.add(professor);
		}
	}
	
	public void removeProfessor(Professor professor) {
		if(professors.contains(professor)) {
			professors.remove(professor);
		}
	}
}







