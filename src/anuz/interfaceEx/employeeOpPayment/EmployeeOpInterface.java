package anuz.interfaceEx.employeeOpPayment;

public interface EmployeeOpInterface {
	public Employee createEmployee(int id, String name, double salary, String gender);
	public Employee[] deleteEmployee(Employee[] e, int id);
	public Employee[] updateEmployee(Employee[] e, int id, String name, double salary, String gender);
	public Employee readEmployee(Employee[] e, int id); 
	public double calculateGrossSalary(Employee[] e);
	public double calculateHRA(Employee[] e);
}
