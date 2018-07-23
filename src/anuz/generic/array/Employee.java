package anuz.generic.array;

import java.util.Comparator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee implements Comparable<Employee> {
	private int id;
	private String name;
	private double salary;
	private String gender;
	private String department;

	public final static float reimburseHRA = 5;
	
	/**
	 * Nested Class that sorts the objects by Department
	 */
	public static class EmployeeDepartmentComparator implements Comparator<Employee>{

		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.getDepartment().compareTo(o2.getDepartment());
		}
	}
	
	/**
	 * Overloaded Constructor
	 * @param id
	 * @param name
	 * @param salary
	 * @param gender
	 * @param department
	 */
	public Employee(int id, String name, double salary, String gender, String department) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.gender = gender;
		this.department = department;
	}
	
	/**
	 * This is the implementation for the Comparable interface
	 */
	@Override
	public int compareTo(Employee o) {
		// first sort by name
		int i = this.name.compareTo(o.getName());
		if (i != 0) {
			return i;
		}

		// if name is identical then sort by salary
		if (this.salary > o.getSalary())
			return 1;
		else if (this.salary < o.getSalary())
			return -1;
		else
			return 0;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", gender=" + gender + ", department="
				+ department + "] \n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}
}
