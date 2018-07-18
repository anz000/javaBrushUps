package anuz.exception.employeeOp;

public interface EmployeeOpInterface {
	public Employee createEmployee(int id, String name, double salary, String gender)
			throws InvalidSalaryException;
	
	public Employee[] deleteEmployee(Employee[] e, int id) 
			throws EmployeeNotFoundException;
	
	public Employee[] updateEmployee(Employee[] e, int id, String name, double salary, String gender)
			throws EmployeeNotFoundException, InvalidSalaryException;
	
	public Employee readEmployee(Employee[] e, int id); 
	public double calculateGrossSalary(Employee[] e);
	public double calculateHRA(Employee[] e);
}
