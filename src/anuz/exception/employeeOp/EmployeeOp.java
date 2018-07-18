package anuz.exception.employeeOp;

public class EmployeeOp implements EmployeeOpInterface {

	@Override
	public Employee createEmployee(int id, String name, double salary, String gender)
						throws InvalidSalaryException{
		// if the salary is less than 5000, then throw invalid salary exception
		if(salary < 5000)
			throw new InvalidSalaryException("Salary has to be greater than 5000.");
		
		// if no errors then return the new employee
		return new Employee(id, name, salary, gender);
	}

	@Override
	public Employee[] deleteEmployee(Employee[] e, int id) 
							throws EmployeeNotFoundException {
		// flag to check if the given id is found from the array
		boolean deleted = false;
		for (int i = 0; i < e.length; i++) {
			if (e[i].getId() == id) { // if id to be deleted found
				e[i] = null; // set the object to null
				deleted = true; // set the flag to true
			}
		}

		// if the employee with the given id was not found, throw Employee Not Found exception
		if(!deleted)
			throw new EmployeeNotFoundException("Given id is Invalid. Please provide valid employee id");
		
		return e;
	}

	@Override
	public Employee[] updateEmployee(Employee[] e, int id, String name, double salary, String gender) 
	throws EmployeeNotFoundException, InvalidSalaryException{
		// flag to check if the  update occured or not
		boolean updated = false;
		for (int i = 0; i < e.length; i++) {
			if (e[i].getId() == id) {
				
				// salary check exception
				if(salary < 5000)
					throw new InvalidSalaryException("Salary has to be greater than 5000.");
				
				// update the fields
				e[i].setName(name);
				e[i].setSalary(salary);
				e[i].setGender(gender);
				updated = true; //  set the flag to true
			}
		}
		
		// employee not found exception
		if(!updated)
			throw new EmployeeNotFoundException("Given id is Invalid. Please provide valid employee id");

		return e;
	}

	@Override
	public Employee readEmployee(Employee[] e, int id) {
		// iterate and find the employee object with the given id
		for (Employee temp : e) {
			if (temp.getId() == id) {
				return temp;
			}
		}
		return null;
	}

	@Override
	public double calculateGrossSalary(Employee[] e) {
		double grossSalary = 0;
		for (Employee temp : e) {
			grossSalary += temp.getSalary();
		}
		return grossSalary;
	}

	@Override
	public double calculateHRA(Employee[] e) {
		double grossHRA = 0;
		for (Employee temp : e) {
			grossHRA += temp.getSalary() * 0.01 * Employee.reimburseHRA * 12;
		}
		return grossHRA;
	}
}
