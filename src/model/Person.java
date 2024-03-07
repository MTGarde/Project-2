package model;

public class Person {
	private String name;
	private String surname;
	
	
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
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
	
	public Person() {
		setName("Janis");
		setSurname("Berzins");
	}
	
	public Person(String name, String surname) {
		setName(name);
		setSurname(surname);
	}
	
	public String toString() {
		return name+ " " +surname;
	}
}
