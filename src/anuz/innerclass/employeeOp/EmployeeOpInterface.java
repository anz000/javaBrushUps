/**
 * @Author : Anuj Shrestha
 */
package anuz.innerclass.employeeOp;

import java.util.Iterator;
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
	public Employee createEmployee(int id, String name, double salary, String gender, String department)
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
	public List<Employee> updateEmployee(int id, String name, double salary, String gender, String department)
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
	 * This method will group the employees into 2 category : above or below average salary
	 * @return List of List containing employees in each above/below av. salary
	 */
	public Map<String,List<Employee>> groupByAvSalary();
	
	/**
	 * This method sorts by name and salary combined
	 * @return (list) The employees sorted by name+salary
	 */
	public List<Employee> sortByNameAndSalary();
	
	/**
	 * This method sorts the objects by department using Nested Class Comparator
	 * @return (list) the employees sorted by department
	 */
	public List<Employee> sortByDepartment();
	
	/**
	 * This method sorts by name and salary combined
	 * @return (list) The employees sorted by name+salary
	 */
	public List<Employee> sortByID();

	/**
	 * This method gets all the iterator to get employees that have higher salary than the given one
	 * @param iSalary
	 * @return (iterator) 
	 */
	public Iterator<Employee> getHighSalary(double iSalary);
}
