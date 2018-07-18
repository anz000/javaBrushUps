package anuz.exception.employeeOp;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

// The main app 
public class EmployeeApp {

	// this is a static reference that allows operation on Employees
	public static EmployeeOp empOp = new EmployeeOp();
	// this is a static reference that allows scanning inputs
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// This holds the Employee objects
		Employee empArr[];

		// Try catch block - handles Erroneous inout types
		try {

			int size = getEmployeeCount();

			// set the employee array size
			empArr = new Employee[size];
			int empArrIndex = 0; // indexing for insertion

			while (true) {
				// Display the Menu
				displayMenu();
				int selection = getMenuSelection();
				
				switch (selection) {
				case 1: // 1. Create a new Employee :
					Employee temp = create();
					if (temp.getName() != null) // if name is not null
						empArr[empArrIndex++] = temp; // add it to employee array and increment the counter
					break;

				case 2: // 2. Delete a Employee
					empArr = delete(empArr);
					//empArrIndex--; // decrease the counter
					break;

				case 3: // 3. update an existing Employee :
					empArr = update(empArr);
					break;

				case 4: // 4. Find a new Employee :
					System.out.println(read(empArr));
					break;

				case 5:
					getHRA(empArr);
					break;

				case 6:
					getGrossSalary(empArr);
					break;

				case 7:
					System.out.println("Exiting, Thank You!");
					System.exit(0);
					break;

				default:
					System.out.println("Invalid Selection. Please select from the menu");
					break;
				}
				System.out.println("\n" + " * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
			}
		} catch (InputMismatchException e) {
			System.out.println(" Input Mismatch Exception : You are supposed to enter number. So Exiting. ");
			//System.out.println(e.getMessage());
		} catch (NoSuchElementException e) {
			System.out.println("No Such Element");
		}
	}

	public static void displayMenu() {
		System.out.println("\n" + " ************************MENU************************");
		System.out.println("1. Create a new Employee : ");
		System.out.println("2. Delete a Employee");
		System.out.println("3. update an existing Employee : ");
		System.out.println("4. Find an Employee : ");
		System.out.println("5 .Calculate HRA : ");
		System.out.println("6. Total Gross Salary : ");
		System.out.println("7. Exit : ");
	}
	
	public static int getMenuSelection() {
		System.out.println("Select a number from the menu");
		int temp = 0;
		//try (Scanner scan = new Scanner(System.in)){
		try {
			//while(!scan.hasNextLine()) {}
			temp = scan.nextInt(); // get the menu selection
			
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElement inside menuSelection");
			return 0;
		}
		return temp;
	}
	
	public static int getEmployeeCount() {
		System.out.println(" Enter the number of employees");
		int count = 0;
		//try (Scanner scan = new Scanner(System.in)) {
		try {
			count = scan.nextInt();
			
		}catch (NoSuchElementException e) {
			System.out.println("NoSuchElement inside getEmployeeCount");
			return 0;
		}
		return count;
	}

	public static Employee create() {
		Employee temp = new Employee();
//		try (Scanner scan = new Scanner(System.in)) {
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
			

			temp = empOp.createEmployee(id, name, salary, gender); // create the new employee with the details
		} catch (InvalidSalaryException e) {
			System.out.println(e.getMessage());
			return temp; // returns employee object with null values if exception
		}
		return temp;
	}

	public static Employee[] delete(Employee[] empArr) {
//		try (Scanner scan = new Scanner(System.in)){
		try {
			System.out.println("Enter the Id of employee to be deleted");
			int deleteId = scan.nextInt();
			
			empArr = empOp.deleteEmployee(empArr, deleteId); // deletes the employee with the ID and returns the array
		} catch (EmployeeNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return empArr;
	}

	public static Employee[] update(Employee[] empArr) {
//		try (Scanner scan = new Scanner(System.in)){
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
			empArr = empOp.updateEmployee(empArr, updateId, uName, uSalary, uGender); 
		} catch (EmployeeNotFoundException | InvalidSalaryException e) {
			System.out.println(e.getMessage());
		}
		return empArr;
	}

	public static Employee read(Employee[] empArr) {
		Employee temp = new Employee();
//		try (Scanner scan = new Scanner(System.in)) {
		try {
			System.out.println("Enter the ID of the employee that you want to read");
			int readId = scan.nextInt();
			

			temp = empOp.readEmployee(empArr, readId); // find the employee with the ID from the array and return it
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return temp;
	}

	public static void getHRA(Employee[] empArr) {
		System.out.println("The HRA @" + Employee.reimburseHRA + " : " + empOp.calculateHRA(empArr));
	}

	public static void getGrossSalary(Employee[] empArr) {
		System.out.println("The Gross salary of employees : " + empOp.calculateGrossSalary(empArr));
	}
}
