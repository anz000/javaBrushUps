
package anuz.collections.employeeOp;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author anz
 *
 */
public class EmpCollctionApplication {

	private static EmployeeOpInterface eOperations = new EmployeeCollectionOperations();

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Intializing Employee Operations usng Collection operations");

		while (true) {
			// the option from the menu
			int selection = displayAndSelectMenu();

			switch (selection) {
			case 1:
				createEmployee();
				break;

			case 2:
				readEmployee();
				break;

			case 3:
				updateEmployee();
				break;

			case 4:
				deleteEmployee();
				break;

			case 5:
				calcGrossSalary();
				break;

			case 6:
				calcHRA();
				break;

			case 7:
				groupByGender();
				break;

			case 8:
				sortByID();
				break;

			case 9:
				sortByName();
				break;

			case 10:
				sortBySalary();
				break;

			case 11:
				groupByAvSalary();
				break;

			case 12:
				setDummyData();
				break;
				
			case 13:
				System.out.println(eOperations);
				break;

			case 14:
				System.out.println(" Exiting Now.. Bye!! ");
				System.exit(0); // terminates the program
				break;
				
			default:
				System.out.println(" Wrong Selection. Please select from the menu.");
				break;
			}
		}

	}

	/**
	 * This method populates the employee list with dummy data for testing purpose
	 */
	private static void setDummyData() {
		try {
			eOperations.createEmployee(1001, "Mark", 7000.0, "Male");
			eOperations.createEmployee(1002, "Anuj", 91000.0, "Male");
			eOperations.createEmployee(100, "Simone", 88000.0, "Female");
			eOperations.createEmployee(11, "Aaron", 7500.0, "Other");
			eOperations.createEmployee(21, "Steven", 55000.0, "Male");
			eOperations.createEmployee(3001, "Wilson", 12000.0, "Female");
			eOperations.createEmployee(4401, "Varrg", 16000.0, "Female");
			eOperations.createEmployee(601, "Mikael", 6000.0, "Female");
			eOperations.createEmployee(1201, "Kevin", 27000.0, "Male");
		} catch (InvalidSalaryException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
	}

	/**
	 * This method displays the menu and then returns the selected option
	 * 
	 * @return (int) the selected option
	 */
	private static int displayAndSelectMenu() {
		System.out.println();
		System.out.println(" *** **** MENU **** ***");
		System.out.println(" 1. Create Employee");
		System.out.println(" 2. Read Employee");
		System.out.println(" 3. Update Employee");
		System.out.println(" 4. Delete Employee");
		System.out.println(" 5. Calculate Gross Salary");
		System.out.println(" 6. Calculate HRA");
		System.out.println(" 7. Group by Gender");
		System.out.println(" 8. Sort by ID");
		System.out.println(" 9. Sort By Name");
		System.out.println(" 10. Sort by Salary");
		System.out.println(" 11. Group by Salary");
		System.out.println(" 12. Set Dummy data");
		System.out.println(" 13. Show All Employee List");
		System.out.println(" 14. Exit");

		int selection = 0;
		Scanner scan = new Scanner(System.in);
		try {
			if (scan.hasNextInt())
				selection = scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			System.out.println(" Exception occurred !! " + e.getMessage());
		}
		return selection;
	}

	/**
	 * This method asks for employee details and add it to the list of employees
	 * Handles Invalid Salary exception if the salary is less than 5000
	 */
	private static void createEmployee() {

		Scanner scan = new Scanner(System.in);

		try {
			System.out.println("Please enter the new employee details");
			System.out.println("ID?");
			int id = scan.nextInt();

			System.out.println("Name?");
			String name = scan.next();

			System.out.println("Salary?");
			double salary = scan.nextDouble();

			System.out.println("Gender?");
			String gender = scan.next();

			Employee temp = eOperations.createEmployee(id, name, salary, gender);

			System.out.println("Succesfully created !!");
			System.out.println(temp);
			// } catch (InvalidSalaryException e) {
			// System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This method asks for an ID and finds the corresponding employee Handles
	 * exception if the ID is not found
	 */
	private static void readEmployee() {
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Enter the ID of the employee that you want to read");
			int rId = scan.nextInt();
			Employee temp = eOperations.readEmployee(rId); // find the employee with the ID from the array
															// and return it
			System.out.println(temp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This method asks for employee iD and updates the properties for that employee
	 * Handles exception if Employee ID is not found or salary is less than 5000
	 */
	private static void updateEmployee() {
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Enter the ID of the employee that you want to update");
			int updateId = scan.nextInt();

			System.out.println("Type name.");
			String uName = scan.next();

			System.out.println("Type salary.");
			double uSalary = scan.nextDouble();

			System.out.println("Type gender.");
			String uGender = scan.next();

			// updates the given employee with new info and returns the whole array
			eOperations.updateEmployee(updateId, uName, uSalary, uGender);
		} catch (EmployeeNotFoundException | InvalidSalaryException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This method asks for employee ID and then deletes it Handles exception if id
	 * not found
	 */
	private static void deleteEmployee() {
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Enter the Id of employee to be deleted");
			int deleteId = scan.nextInt();

			eOperations.deleteEmployee(deleteId);// deletes the employee with the ID and returns the array
		} catch (EmployeeNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This method calculates the gross salary
	 */
	private static void calcGrossSalary() {
		System.out.println("The HRA @" + Employee.reimburseHRA + " : " + eOperations.calculateGrossSalary());
	}

	/**
	 * This method calculates the HRA
	 */
	private static void calcHRA() {
		System.out.println("The Gross salary of employees : " + eOperations.calculateHRA());
	}

	/**
	 * This method groups the employees by the unique values in gender
	 */
	private static void groupByGender() {
		// setDummyData();
		Map<String, List<Employee>> grpGenderEList = eOperations.groupByGender();

		System.out.println(grpGenderEList);

	}

	/**
	 * This method sorts the employees by ID in ascending order
	 */
	private static void sortByID() {
		// setDummyData();
		List<Employee> temp = eOperations.sortById();
		System.out.println(temp);
	}

	/**
	 * This method sorts the employees by age in ascending order
	 */
	private static void sortByName() {
		// setDummyData();
		List<Employee> temp = eOperations.sortByName();
		System.out.println(temp);
	}

	/**
	 * This method sorts the employees by salary in ascending order
	 */
	private static void sortBySalary() {
		// setDummyData();
		List<Employee> temp = eOperations.sortBySalary();
		System.out.println(temp);
	}

	/**
	 * This method divides the employee list into below average and equal/above
	 * average
	 */
	private static void groupByAvSalary() {
		// setDummyData();
		Map<String, List<Employee>> grpAvSalaryEList = eOperations.groupByAvSalary();

		System.out.println(grpAvSalaryEList);
	}
}
