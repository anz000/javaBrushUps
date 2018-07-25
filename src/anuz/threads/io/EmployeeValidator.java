package anuz.threads.io;

import java.util.Iterator;
import java.util.List;

public class EmployeeValidator {
	
	private List<Employee> empList;
	private List<Employee> invalidList;
	
	/**
	 * Overloaded Constructor 
	 * @param employees The employees list
	 */
	public EmployeeValidator(List<Employee> employees, List<Employee> inValid) {
		this.empList = employees;	// placeholder for correct employees
		this.invalidList = inValid; // placeholder for invalid employees
	}
	
	/**
	 * This method will call all the other validators
	 */
	public void runValidator() {
		salaryValidator(); // salary validator
		// run other validators
	}
	
	/**
	 * This method validates Business Logic for Salary
	 */
	private void salaryValidator() {
		Iterator<Employee> eIter = empList.iterator();
		while(eIter.hasNext()) {
			Employee e =eIter.next(); 
			// if salary less than 7000
			if(e.getSalary() < 7000) {
				invalidList.add(e);
				eIter.remove(); // remove if less than 7000
			}
		}
	}

}
