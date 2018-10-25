package expertqa.october22_2018.degreehierarchy;

public class Student {
	
	private String firstName;
	private String lastName;
	private int studentNumber;
	public String getFullName() {
		return firstName + " " + lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String first) {
		this.firstName = first;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String last) {
		this.lastName = last;
	}
	public int getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(int studentNum) {
		this.studentNumber = studentNum;
	}
	
	

}
