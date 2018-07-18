package anuz.interfaceEx.employeeOpPayment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeApp {

	public static void main(String[] args) {

		EmployeeOp empOp = new EmployeeOp();
		Employee empArr[];

		Scanner scan = new Scanner(System.in);
		
		try {
			
			System.out.println(" Enter the Employee number : ");
			int size = scan.nextInt();

			empArr = new Employee[size];
			int empArrIndex = 0;

			boolean run = true;
			while (run) {
				displayMenu();
				int selection = scan.nextInt();

				switch (selection) {
				case 1: // 1. Create a new Employee :
					System.out.println("Please enter the new employee details");
					System.out.println("ID?");
					int id = scan.nextInt();
					System.out.println("Name?");
					String name = scan.next();
					System.out.println("Salary?");
					double salary = scan.nextDouble();
					System.out.println("Gender?");
					String gender = scan.next();

					empArr[empArrIndex++] = empOp.createEmployee(id, name, salary, gender);
					break;

				case 2: // 2. Delete a Employee
					System.out.println("Enter the Id of employee to be deleted");
					int deleteId = scan.nextInt();
					empArr = empOp.deleteEmployee(empArr, deleteId);

					break;

				case 3: // 3. update an existing Employee :

					System.out.println("Enter the ID of the employee that you want to update");
					int updateId = scan.nextInt();

					System.out.println("Type name.");
					String uName = scan.next();
					System.out.println("Type salary.");
					double uSalary = scan.nextDouble();
					System.out.println("Type gender.");
					String uGender = scan.next();

					empArr = empOp.updateEmployee(empArr, updateId, uName, uSalary, uGender);

					break;

				case 4: // 4. Find a new Employee :
					System.out.println("Enter the ID of the employee that you want to read");
					int readId = scan.nextInt();

					System.out.println(empOp.readEmployee(empArr, readId));
					break;

				case 5:
					System.out.println("The HRA @" + Employee.reimburseHRA + " : " + empOp.calculateHRA(empArr));
					break;

				case 6:
					System.out.println("The Gross salary of employees : " + empOp.calculateGrossSalary(empArr));
					break;

				case 7:
					run = false;
					break;

				default:
					System.out.println("Invalid Selection. Please select from the menu");
					break;
				}
				System.out.println("\n" + " * * * * * * * * * * * * * * * * * * * * * * * * * * * ");

			}

		} catch (InputMismatchException e) {
			System.out.println(" Input Mismatch Exception : You are supposed to enter numbers. So Exiting. ");
		} finally {
			scan.close();
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
}
