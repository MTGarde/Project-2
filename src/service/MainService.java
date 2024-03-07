package service;

import java.util.ArrayList;

import model.Course;
import model.Degree;
import model.Grade;
import model.Professor;
import model.Student;

public class MainService {
	private static ArrayList<Professor> allProfessors = new ArrayList<Professor>();
	private static ArrayList<Student> allStudents = new ArrayList<Student>();
	private static ArrayList<Course> allCourses = new ArrayList<Course>();
	private static ArrayList<Grade> allGrades = new ArrayList<Grade>();

	public static void main(String[] args) {
		Professor p1 = new Professor();
		Professor p2 = new Professor("Karina", "Skirmante", Degree.mg);

		for(Professor prof : allProfessors) {
			System.out.println(prof);
		}
		
		Student st1 = new Student();
		Student st2 = new Student("Marta", "Garde");
		Student st3 = new Student("Krishtians", "Koks");
		Student st4 = new Student("Kate", "Sprigele");
		Student st5 = new Student("Anna", "Kiegele");
		allStudents.add(st1);
		allStudents.add(st2);
		allStudents.add(st3);
		allStudents.add(st4);
		allStudents.add(st5);
		
		for(Student student : allStudents) {
			System.out.println(student);
		}
		
		Course c1 = new Course();
		Course c2 = new Course("Programmesana JAVA", 4, p2);
		allCourses.add(c1);
		allCourses.add(c2);
		
		for(Course course: allCourses) {
			System.out.println(course);
		}
		
		Grade g1 = new Grade();
		Grade g2 = new Grade(7, c2, st2);
		Grade g3 = new Grade(8, c2, st4);
		Grade g4 = new Grade(4, c2, st5);
		Grade g5 = new Grade(9, c2, st3);
		Grade g6 = new Grade(2, c2, st4);
		allGrades.add(g1);
		allGrades.add(g2);
		allGrades.add(g3);
		allGrades.add(g4);
		allGrades.add(g5);
		allGrades.add(g6);
		
		for(Grade grade : allGrades) {
			System.out.println(grade);
		}
		
		try {
			System.out.println(averageGrade(st2));
			System.out.println(averageWeighedGrade(st2));
			System.out.println(averageGradeCourse(c2));
			System.out.println(howManyCoursesTeach(p2));
			
			
			
			System.out.println("Student list: ");
			for(Student student: allStudents) {
				System.out.println(student);
			}
			
			sortStudentsByAvg(allStudents);
			
			System.out.println("Student list sorted by average grade: ");
			for(Student student: allStudents) {
				System.out.println(student);
			}
			
		}catch(Exception e) {
			System.out.println("Problem.");
		}
		
		
	}
	
	public static float averageGrade(Student student) throws Exception {
		if(student == null) throw new Exception("Bad student input");
		
		float sum = 0;
		int howMany = 0;
		
		for(Grade grade : allGrades) {
			if(grade.getStudent().equals(student)) {
				sum+= grade.getValue();
				howMany++;
			}
		}
		return sum/howMany;
	}

	
	//sum = atzime*kp + atzime2*kp2 ....
	//howmany = kp1 + kp2 ......
	//sum/howMany
	public static float averageWeighedGrade(Student student) throws Exception {
		if(student == null) throw new Exception("Bad student input");
		
		float sum = 0;
		int howMany = 0;
		
		for(Grade grade : allGrades) {
			if(grade.getStudent().equals(student)) {
				sum+= grade.getValue() * grade.getCourse().getCreditpoints();
				howMany+= grade.getCourse().getCreditpoints(); 
			}
		}
		return sum/howMany;
	}
	
	public static float averageGradeCourse(Course course) throws Exception {
		if(course == null) throw new Exception("Bad course input");
		
		float sum = 0;
		int howMany = 0;
		
		for(Grade grade: allGrades) {
			if(grade.getCourse().equals(course)) {
				sum+= grade.getValue();
				howMany++;
			}
		}
		return sum/howMany;
	}
	
	public static int howManyCoursesTeach(Professor prof) throws Exception{
		if(prof == null) throw new Exception("Bad professor input");
		
		
		int howMany = 0;
		
		for(Course course : allCourses) {
			if(course.getProfessor() == prof) {
				howMany ++;
			}
		}
		
		return howMany;
	}
	
	public static void sortStudentsByAvg(ArrayList<Student> studentList) throws Exception{
		if(studentList == null) throw new Exception("Student list empty");
		if(studentList.size() == 1) throw new Exception("Only one student, can't sort");
		
		Student tempStudent = new Student();
		
		for(int i = 0; i < studentList.size()-1; i++) {
			for(int j = i+1; j < studentList.size(); j++) {
				if(averageGrade(studentList.get(i)) < averageGrade(studentList.get(j))) {
					tempStudent = studentList.get(i);
					studentList.set(i, studentList.get(j));
					studentList.set(j, tempStudent);
				}
			}
		}
	}
	
	
	public static void createStudent(String name, String surname) throws Exception {


		if(name == null || surname == null) {
			throw new Exception("invalid arguments");
		}
		
		for(Student tempSt : allStudents) {
			if(tempSt.getName().equals(name) && tempSt.getSurname().equals(surname)) {
				throw new Exception("already registered");
			}
		}
		
		Student st = new Student(name, surname);
		allStudents.add(st);
	}
	
	//returieve by surname- labak vajag sarakstu jo var but vairaki vienadi uzvardi
	//TODO retrieve by personas kods
	public static Student retrieveStrudentBysurname(String surname) throws Exception {
		if(surname == null) throw new Exception("Bad");
		
		for(Student tempSt : allStudents) {
			if(tempSt.getSurname().equals(surname)) {
				return tempSt;
			}
		}
		throw new Exception("student doesn't exist");
	}

	public static void updateStudentNameSurname(String name, String surname, String newSurname) throws Exception {
		if(name == null || surname == null || newSurname == null) {
			throw new Exception("invalid arguments");
		}
		
		for(Student tempSt : allStudents) {
			if(tempSt.getName().equals(name) && tempSt.getSurname().equals(surname) && (!surname.equals(newSurname))) {
				tempSt.setSurname(newSurname);
				return;
			}
		}
		
		throw new Exception("Student doesn't exist");
	}

	
	//TODO ieviest personas kodu pec kura dzest
	public static void deleteByNameAndSurname(String name, String surname) throws Exception {
		if(name == null || surname == null) {
			throw new Exception("invalid arguments");
		}
		
		
		for(Student tempSt : allStudents) {
			if(tempSt.getName().equals(name) && tempSt.getSurname().equals(surname)) {
				allStudents.remove(tempSt);
				return;
			}
		}
		
		throw new Exception("impossible");
	}
	
}











