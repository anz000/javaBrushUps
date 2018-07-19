package anuz.io.employee;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=false, includeFieldNames=true)
public class Employee {
	private String firstName;
	private int id;
	private String lastName;
	private String ssn;
	private double salary;
	private String yearJoined;
	
	//overloaded constructor
	public Employee(String firstName, int id, String lastName, String ssn, double salary, String joinDate) {
		this.firstName = firstName;
		this.id = id;
		this.lastName = lastName;
		this.ssn = ssn;
		this.salary = salary;
		this.yearJoined = joinDate;
	}

	/**
	 * This method returns the structure of the object in CSV format
	 * @return comma-delimited values
	 */
	public String toCSV() {
		return firstName + "," + id + "," + lastName + "," + ssn
				+ "," + salary + "," + yearJoined;
	}

}
