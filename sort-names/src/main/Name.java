package main;
public class Name {
	public String firstName, lastName;
	
	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String GetName() {
		return new String(lastName + ", " + firstName);
	}
}
