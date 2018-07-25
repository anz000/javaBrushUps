package anuz.threads.io;

import java.util.Iterator;
import java.util.List;

public class EmployeeValidator {
	
	private List<Employee> empList;
	
	/**
	 * Overloaded Constructor 
	 * @param employees The employees list
	 */
	public EmployeeValidator(List<Employee> employees) {
		this.empList = employees;
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
			// if salary less than 7000
			if(eIter.next().getSalary() < 7000) {
				eIter.remove(); // remove if less than 7000
			}
		}
	}

}
