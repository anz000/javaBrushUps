/**
 * @Author : Anuj Shrestha
 */
package anuz.collections.employeeOp;

import java.util.List;
import java.util.Map;

public interface EmployeeOpInterface {
	/**
	 * This method will create a employee
	 * @param id
	 * @param name
	 * @param salary
	 * @param gender
	 * @return The employee with the given data
	 * @throws InvalidSalaryException if the salary is less than 5000
	 */
	public Employee createEmployee(int id, String name, double salary, String gender)
			throws InvalidSalaryException;
	
	/**
	 * This method will delete the employee with the given id
	 * @param id
	 * @return the updated Employee list after removal
	 * @throws EmployeeNotFoundException if the employee id is not found
	 */
	public List<Employee> deleteEmployee(int id) 
			throws EmployeeNotFoundException;
	
	/**
	 * This method will update the Employee with the given ID with the given information
	 * @param id
	 * @param name
	 * @param salary
	 * @param gender
	 * @return The updated Employee List
	 * @throws EmployeeNotFoundException If the employee ID is not found
	 * @throws InvalidSalaryException If the salary is below 5000
	 */
	public List<Employee> updateEmployee(int id, String name, double salary, String gender)
			throws EmployeeNotFoundException, InvalidSalaryException;
	
	/**
	 * This method will return the employee with the given ID
	 * @param id
	 * @return The employee with the given ID
	 * @throws EmployeeNotFoundException If the employee ID is not found
	 */
	public Employee readEmployee(int id) throws EmployeeNotFoundException;
	
	/**
	 * This method will calculate the gross salary of all the employees
	 * @return The gross salary value
	 */
	public double calculateGrossSalary();
	
	/**
	 * This method will calculate the HRA
	 * @return The HRA value
	 */
	public double calculateHRA();
	
	/**
	 * This method will group the employees into gender category
	 * @return List of List containing employees in each gender
	 */
	public Map<String,List<Employee>> groupByGender();
	
	/**
	 * This method will sort the employees by Age
	 * @return The list of employees sorted by age in ascending order
	 */
	public List<Employee> sortByName();
	
	/**
	 * This method will sort the employees by Salary
	 * @return The list of employees sorted by salary in ascending order
	 */
	public List<Employee> sortBySalary();
	
	/**
	 * This method will sort the employees by ID
	 * @return The list of employees sorted by ID in ascending order
	 */
	public List<Employee> sortById();
	
	/**
	 * This method will group the employees into 2 category : above or below average salary
	 * @return List of List containing employees in each above/below av. salary
	 */
	public Map<String,List<Employee>> groupByAvSalary();
}
