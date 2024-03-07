package model;

public class Grade {
	//variables
	private long gID;
	private int value;
	private Student student;
	private Course course;
	
	private static long counter = 200000;
	
	//get set
	public long getgID() {
		return gID;
	}
	public int getValue() {
		return value;
	}
	public Student getStudent() {
		return student;
	}
	public Course getCourse() {
		return course;
	}
	
	
	public void setgID() {
		this.gID = counter;
		counter++;
	}
	
	public void setValue(int number) {
		if(number >= 0 && number <= 10) {
			value = number;
		}else {value = 0;}
	}
	
	public void setStudent(Student student) {
		if(student != null) {
			this.student = student;
		} else {this.student= new Student();}
	}
	
	public void setCourse(Course course) {
		if(course != null) {
			this.course = course;
		} else {this.course= new Course();}
	}
	
	//constructors
	public Grade() {
		setgID();
		setValue(4);
		setCourse(new Course());
		setStudent(new Student());
		
	}
	
	public Grade(int value, Course course, Student student) {
		setgID();
		setValue(value);
		setCourse(course);
		setStudent(student);
		
	}
	
	//toString
	public String toString() {
		return student.getName()+ " " +student.getSurname()+ " gets " +value+ " in " +course.getTitle();
	}
	//other
}
