package anuz.threads.io;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee{
	/**
	 * class variable instances
	 */
	private int id;
	private String name;
	private double salary;
	private String gender;
	
	/**
	 * Overloaded Constructor
	 * @param id
	 * @param name
	 * @param salary
	 * @param gender
	 * @param department
	 */
	public Employee(int id, String name, double salary, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.gender = gender;
	}
	
	/**
	 * This method returns the objects in CSV format
	 * @return
	 */
	public String toCSV() {
		return id + "," + name + "," + salary + "," + gender;
	}

	/**
	 * This method returns toString() for debugging
	 */
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", gender=" + gender + "]";
	}
}
