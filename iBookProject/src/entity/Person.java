package entity;

public class Person {
	private String personID;
	private String firstName;
	private String lastName;
//	private String userName;
//	private String password;
	private String email;
	
	public Person()
	{
		this.personID = "";
		this.firstName = "";
		this.lastName = "";
		this.email = "";
	}
	
	public String GetPersonID() {
		return personID;
	}
	
	public void SetPersonID(String personID) {
		this.personID = personID;
	}
	
	public String GetFirstName() {
		return firstName;
	}
	
	public void SetFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String GetLastName() {
		return lastName;
	}
	
	public void SetLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String GetEmail() {
		return email;
	}
	
	public void SetEmail(String email) {
		this.email = email;
	}

}
