package anuz.interfaceEx.employeeOpPayment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=false, includeFieldNames=true)
public class Employee {
	private int id;
	private String name;
	private double salary;
	private String gender;
	
	public final static float reimburseHRA = 5;
	
	public Employee() {
		
	}

	public Employee(int id, String name, double salary, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.gender = gender;
	}

}
