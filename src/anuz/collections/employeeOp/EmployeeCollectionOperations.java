package anuz.collections.employeeOp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * @author anz
 *
 */
public class EmployeeCollectionOperations implements EmployeeOpInterface {

	private List<Employee> eList = new ArrayList<>();
	
	/**
	 * This method will create a employee
	 * @param id
	 * @param name
	 * @param salary
	 * @param gender
	 * @return The employee with the given data
	 * @throws InvalidSalaryException if the salary is less than 5000
	 */
	@Override
	public Employee createEmployee(int id, String name, double salary, String gender) throws InvalidSalaryException {
		// if the salary is less than 5000, then throw invalid salary exception
		if (salary < 5000)
			throw new InvalidSalaryException("Salary has to be greater than 5000.");

		// if no errors then return the new employee
		Employee newEmp = new Employee(id, name, salary, gender);
		
		eList.add(newEmp);
		
		return newEmp;
	}

	/**
	 * This method will delete the employee with the given id
	 * @param id
	 * @return the updated Employee list after removal
	 * @throws EmployeeNotFoundException if the employee id is not found
	 */
	@Override
	public List<Employee> deleteEmployee(int id) throws EmployeeNotFoundException {
		boolean dFlag = false;
		for (int i = 0; i < eList.size(); i++) {
			if (eList.get(i).getId() == id) {
				eList.remove(i);
				dFlag = true;
			}
		}

		if (!dFlag) {
			throw new EmployeeNotFoundException("Given id is Invalid. Please provide valid employee id");
		}

		return eList;
	}

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
	@Override
	public List<Employee> updateEmployee(int id, String name, double salary, String gender)
			throws EmployeeNotFoundException, InvalidSalaryException {

		boolean uFlag = false;
		for (int i = 0; i < eList.size(); i++) {
			if (eList.get(i).getId() == id) {
				// check for salary exception
				if (salary < 5000)
					throw new InvalidSalaryException("Salary has to be greater than 5000.");

				eList.get(i).setId(id);
				eList.get(i).setGender(gender);
				eList.get(i).setSalary(salary);

				uFlag = true;
			}
		}

		if (!uFlag)
			throw new EmployeeNotFoundException("Given id is Invalid. Please provide valid employee id");

		return eList;
	}

	/**
	 * This method will return the employee with the given ID
	 * @param id
	 * @return The employee with the given ID
	 * @throws EmployeeNotFoundException If the employee ID is not found
	 */
	@Override
	public Employee readEmployee(int id) throws EmployeeNotFoundException {
		int rIndexer = -1;
		for (int i = 0; i < eList.size(); i++) {
			if (eList.get(i).getId() == id) {
				rIndexer = i;
				break;
			}
		}

		if (rIndexer < 0)
			throw new EmployeeNotFoundException("Given id is Invalid. Please provide valid employee id");

		return eList.get(rIndexer);
	}

	/**
	 * This method will calculate the gross salary of all the employees
	 * @return The gross salary value
	 */
	@Override
	public double calculateGrossSalary() {
		double grossSalary = 0;
		for (Employee e : eList) {
			grossSalary += e.getSalary();
		}
		return grossSalary;
	}

	/**
	 * This method will calculate the HRA
	 * @return The HRA value
	 */
	@Override
	public double calculateHRA() {
		double grossHRA = 0;
		for (Employee e : eList)
			grossHRA += e.getSalary() * 0.01 * Employee.reimburseHRA * 12;

		return grossHRA;
	}

	/**
	 * This method will group the employees into gender category
	 * @return List of List containing employees in each gender
	 */
	@Override
	public Map<String, List<Employee>> groupByGender() {
		Map<String, List<Employee>> genderMap = new HashMap<>();

		/**
		 * 1. get the genders, 2. find unique and 3. filter by the unique values and 4.
		 * add it to HashMap
		 */

		// 1. get all the gender values from object
		List<String> genderList = eList.stream().map(e -> e.getGender()).collect(Collectors.toList());
		// System.out.println(" List " + genderList);

		// 2. find unique
		Set<String> uniqueGenderList = new HashSet<>(genderList);
		// System.out.println(" Set " + uniqueGenderList);

		// 3. & 4. filter and add to Map
		for (String s : uniqueGenderList) {
			genderMap.put(s, containsGender(s));
		}

		return genderMap;
	}

	/**
	 * This method takes ina list and checks with a gender string and filters the list 
	 * @param list The list of employees
	 * @param name The name to be searched
	 * @return (List<Employee>) This list of employees that have 'name' gender
	 */
	private List<Employee> containsGender(final String name) {
		return eList.stream().filter(o -> o.getGender().equals(name)).collect(Collectors.toList());
	}

	/**
	 * This method will sort the employees by Age
	 * @return The list of employees sorted by age in ascending order
	 */
	@Override
	public List<Employee> sortByName() {
		List<Employee> temp = new ArrayList<>(eList);
		Collections.sort(temp, new NameComparator());
		return temp;
	}

	/**
	 * This method will sort the employees by Salary
	 * @return The list of employees sorted by salary in ascending order
	 */
	@Override
	public List<Employee> sortBySalary() {
		List<Employee> temp = new ArrayList<>(eList);
		Collections.sort(temp, new SalaryComparator());
		return temp;
	}

	/**
	 * This method will sort the employees by ID
	 * @return The list of employees sorted by ID in ascending order
	 */
	@Override
	public List<Employee> sortById() {
		List<Employee> temp = new ArrayList<>(eList);
		Collections.sort(temp, new IDComparator());
		return temp;
	}

	/**
	 * This method will group the employees into 2 category : above or below average salary
	 * @return List of List containing employees in each above/below av. salary
	 */
	@Override
	public Map<String, List<Employee>> groupByAvSalary() {
		Map<String, List<Employee>> salaryMap = new HashMap<>();

		/**
		 * 1. get the salaries , 2. find quadrants and 3. filter by the within limit
		 * values and 4. add it to HashMap
		 */

		// 1. get all the gender values from object
		List<Double> salaryList = eList.stream().map(e -> e.getSalary()).collect(Collectors.toList());
		//System.out.println(" List " + salaryList);

		// 2. find unique
		double salaryCutoffList = calculateAverage(salaryList);
		//System.out.println(" Average " + salaryCutoffList);

		// 3. & 4. filter and add to Map
		List<Employee> low = eList.stream().filter(o -> o.getSalary() < salaryCutoffList).collect(Collectors.toList());
		List<Employee> high = eList.stream().filter(o -> o.getSalary() >= salaryCutoffList).collect(Collectors.toList());
		
		salaryMap.put("low", low);
		salaryMap.put("high", high);
		
		return salaryMap;
	}

	/**
	 * This method calculates the average value from a list of Doubles
	 * @param sList
	 * @return (double) average of the list
	 */
	private static double calculateAverage(List<Double> sList) {
		double sum = 0.0;
		if (!sList.isEmpty()) {
			for (Double d : sList) {
				sum += d;
			}
			return sum / sList.size();
		}
		return sum;
	}
	
	public String toString() {
		String s = "";
		if(eList.size() > 0) {
			for(Employee e : eList) {
				s += e + "\n";
			}
		}
		return s;
	}

}
