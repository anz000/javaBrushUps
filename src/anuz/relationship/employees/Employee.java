package anuz.relationship.employees;

import java.util.List;

import org.omg.IOP.ExceptionDetailMessage;
import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
	private Address address;
	private String firstName;
	private Gender gender;
	private int id;
	private String lastName;
	private List<Employee> managedEmployees;
	private Employee manager;
	private EmploymentPeriod period;
	private List<PhoneNumber> phoneNumbers;
	private List<String> responsilities;
	private double salary;
	private long version;

	public Employee(Address address, String firstName, Gender gender, int id, String lastName,
			List<Employee> managedEmployees, Employee manager, EmploymentPeriod period, List<PhoneNumber> phoneNumbers,
			List<String> responsilities, double salary, long version) {
		super();
		this.address = address;
		this.firstName = firstName;
		this.gender = gender;
		this.id = id;
		this.lastName = lastName;
		this.managedEmployees = managedEmployees;
		this.manager = manager;
		this.period = period;
		this.phoneNumbers = phoneNumbers;
		this.responsilities = responsilities;
		this.salary = salary;
		this.version = version;
	}

	public Employee() {

	}

	@Override
	public String toString() {
		return "Employee \n[firstName=" + firstName + ", \ngender=" + gender + ", \nid=" + id
		// + ", \nmanagedEmployees=" + managedEmployees
				+ ", \nmanager=" + manager + ", \nperiod=" + period + ", \nphoneNumbers=" + phoneNumbers + "]";
	}

	

}
