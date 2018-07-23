package anuz.innerclass.employeeOp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
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
	 * Inner Class to create an iterator for High Salary than a given value
	 *
	 */
	public class HighSalaryIterator implements Iterator<Employee>{
		int index = 0;
		double iSalary = 0.0;
		
		public HighSalaryIterator(double iSalary) {
			this.iSalary = iSalary; // set the cut off salary
		}

		@Override
		public boolean hasNext() {
			for(int i = index; i<eList.size() ; i++) {
				if(eList.get(i).getSalary() > iSalary) { // condition check
					index = i; // returns the index of the next element
					return true;
				}
			}
			return false;
		}

		@Override
		public Employee next() {
			Employee temp = null;
			if(hasNext()) {
				 temp = eList.get(index); // return the element at the index
				 index++; 				  // point to next element as the starting point
			}
			return temp;
		}		
	}

	/**
	 * This method will create a employee
	 * 
	 * @param id
	 * @param name
	 * @param salary
	 * @param gender
	 * @return The employee with the given data
	 * @throws InvalidSalaryException
	 *             if the salary is less than 5000
	 */
	@Override
	public Employee createEmployee(int id, String name, double salary, String gender, String department)
			throws InvalidSalaryException {
		// if the salary is less than 5000, then throw invalid salary exception
		if (salary < 5000)
			throw new InvalidSalaryException("Salary has to be greater than 5000.");

		// if no errors then return the new employee
		Employee newEmp = new Employee(id, name, salary, gender, department);

		eList.add(newEmp);

		return newEmp;
	}

	/**
	 * This method will delete the employee with the given id
	 * 
	 * @param id
	 * @return the updated Employee list after removal
	 * @throws EmployeeNotFoundException
	 *             if the employee id is not found
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
	 * This method will update the Employee with the given ID with the given
	 * information
	 * 
	 * @param id
	 * @param name
	 * @param salary
	 * @param gender
	 * @return The updated Employee List
	 * @throws EmployeeNotFoundException
	 *             If the employee ID is not found
	 * @throws InvalidSalaryException
	 *             If the salary is below 5000
	 */
	@Override
	public List<Employee> updateEmployee(int id, String name, double salary, String gender, String department)
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
				eList.get(i).setDepartment(department);

				uFlag = true;
			}
		}

		if (!uFlag)
			throw new EmployeeNotFoundException("Given id is Invalid. Please provide valid employee id");

		return eList;
	}

	/**
	 * This method will return the employee with the given ID
	 * 
	 * @param id
	 * @return The employee with the given ID
	 * @throws EmployeeNotFoundException
	 *             If the employee ID is not found
	 */
	@Override
	public Employee readEmployee(int id) throws EmployeeNotFoundException {
		boolean rFlag = false;
		Employee temp = null;

		for (ListIterator<Employee> iter = eList.listIterator(); iter.hasNext();) {
			Employee element = iter.next();
			if (element.getId() == id) {
				rFlag = true;
				temp = element;
			}
		}

		if ( !rFlag )
			throw new EmployeeNotFoundException("Given id is Invalid. Please provide valid employee id");
		
		return temp;
	}

	/**
	 * This method will calculate the gross salary of all the employees
	 * 
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
	 * 
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
	 * 
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
	 * This method takes in a list and checks with a gender string and filters the
	 * list
	 * 
	 * @param list
	 *            The list of employees
	 * @param name
	 *            The name to be searched
	 * @return (List<Employee>) This list of employees that have 'name' gender
	 */
	private List<Employee> containsGender(final String name) {
		return eList.stream().filter(o -> o.getGender().equals(name)).collect(Collectors.toList());
	}

	/**
	 * This method will group the employees into 2 category : above or below average
	 * salary
	 * 
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
		// System.out.println(" List " + salaryList);

		// 2. find unique
		double salaryCutoffList = calculateAverage(salaryList);
		// System.out.println(" Average " + salaryCutoffList);

		// 3. & 4. filter and add to Map
		List<Employee> low = eList.stream().filter(o -> o.getSalary() < salaryCutoffList).collect(Collectors.toList());
		List<Employee> high = eList.stream().filter(o -> o.getSalary() >= salaryCutoffList)
				.collect(Collectors.toList());

		salaryMap.put("low", low);
		salaryMap.put("high", high);

		return salaryMap;
	}

	/**
	 * This method calculates the average value from a list of Doubles
	 * 
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

	/**
	 * This method returns all the details of all the employees
	 */
	public String toString() {
		String s = "";
		if (eList.size() > 0) {
			for (Employee e : eList) {
				s += e;
			}
		}
		return s;
	}

	/**
	 * This method sorts by name and salary combined using Comparable
	 * 
	 * @return (list) The employees sorted by name+salary
	 */
	@Override
	public List<Employee> sortByNameAndSalary() {
		List<Employee> temp = eList;
		Collections.sort(temp); // uses Comparable
		return temp;
	}

	/**
	 * This method sorts the objects by department using Nested Class Comparator
	 * 
	 * @return (list) the employees sorted by department
	 */
	@Override
	public List<Employee> sortByDepartment() {
		List<Employee> temp = eList;
		// creating an instance of the nested class
		Employee.EmployeeDepartmentComparator departmentComparator = new Employee.EmployeeDepartmentComparator();
		Collections.sort(temp, departmentComparator); // uses the comparator of the nested class
		return temp;
	}

	/**
	 * This method sorts the objects by ID using Annonymous Class for Comparator
	 * 
	 * @return (list) the employees sorted by ID
	 */
	@Override
	public List<Employee> sortByID() {
		List<Employee> temp = eList;
		// now using annonymous class for comparator
		Collections.sort(temp, new Comparator<Employee>() {

			// use ID for comparison
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getId() - o2.getId();
			}
		});
		return temp;
	}

	/**
	 * This method gets all the iterator to get employees that have higher salary than the given one
	 * @param iSalary
	 * @return (iterator) 
	 */
	public Iterator<Employee> getHighSalary(double iSalary) {
		Iterator<Employee> hSalaryEmpIter = this.new HighSalaryIterator(iSalary);
		return hSalaryEmpIter;
	}

}
