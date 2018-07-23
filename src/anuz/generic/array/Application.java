package anuz.generic.array;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		while (true) {
			menu();
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				stringGenerics();
				break;

			case 2:
				doubleGenerics();
				break;

			case 3:
				employeeGenrics();
				break;

			case 4:
				System.out.println(" Exiting. Bye ! ");
				scan.close();
				System.exit(0);
				break;

			default:
				System.out.println("Wrong Selection");
				break;
			}
		}
	}

	public static void menu() {
		System.out.println(" ** MENU ** ");
		System.out.println(" 1. String ");
		System.out.println(" 2. Double ");
		System.out.println(" 3. Employee");
		System.out.println(" 4. Exit ");
		System.out.println(" _ _ _ _ _ _ _ _ _ ");
	}

	public static void stringGenerics() {
		// String Implementation
		GenericArrayImpl<String> sGA = new GenericArrayImpl<>(2); // creates of size 2 initially and grows dynamically
		// adding elements first
		sGA.add("First");
		sGA.add("Second");
		sGA.add("Third");
		System.out.println(sGA);
		System.out.println(" ---- --- --- ----");
		try {
			// printing , deleting, checking, updating, and checking at index 2
			System.out.println("Initiallly at Index 2 => " + sGA.get(2)); 
			System.out.println("Deleting at Index 2. ");
			sGA.delete(2);
			System.out.println("New element shifted to Index 2 =>" + sGA.get(2));
			sGA.update(2, new String("New String"));
			System.out.println("After updating element at Index 2 => " + sGA.get(2));
		} catch (Exception e) {
			System.out.println(" Invalid ID given ");
		}
		System.out.println(" ** FINAL **");
		System.out.println(sGA);
	}

	public static void doubleGenerics() {
		// Double Implementation
		GenericArrayImpl<Double> dGA = new GenericArrayImpl<>(); // no param in constructor - dynamically grows
		// adding elements first
		dGA.add(1.00);
		dGA.add(10.340);
		dGA.add(9.99);
		dGA.add(0.56);

		System.out.println(dGA);
		System.out.println(" ---- --- --- ----");
		try {
			// printing , deleting, checking, updating, and checking at index 2
			System.out.println("Initiallly at Index 2 => " + dGA.get(2));
			System.out.println("Deleting at Index 2. ");
			dGA.delete(2);
			System.out.println("New element shifted to Index 2 =>" + dGA.get(2));
			dGA.update(2, new Double(99.99));
			System.out.println("After updating element at Index 2 => " + dGA.get(2));
		} catch (Exception e) {
			System.out.println(" Invalid ID given ");
		}
		System.out.println(" ** FINAL **");
		System.out.println(dGA);
	}

	public static void employeeGenrics() {
		// Employee Implementation
		GenericArrayImpl<Employee> empGA = new GenericArrayImpl<>(); // no param in constructor - dynamically grows
		// adding elements first
		empGA.add(new Employee(1001, "Mark", 7000.0, "Male", "CS"));
		empGA.add(new Employee(1002, "Anuj", 91000.0, "Male", "EE"));
		empGA.add(new Employee(100, "Anuj", 88000.0, "Female", "Arch"));
		empGA.add(new Employee(11, "Aaron", 7500.0, "Other", "Accounting"));

		System.out.println(empGA);
		System.out.println(" ---- --- --- ----");
		try {
			// printing , deleting, checking, updating, and checking at index 2
			System.out.println("Initiallly at Index 2 => " + empGA.get(2));
			System.out.println("Deleting at Index 2. ");
			empGA.delete(2);
			System.out.println("New element shifted to Index 2 =>" + empGA.get(2));
			empGA.update(2, new Employee(1201, "Kevin", 27000.0, "Male", "Bioinformatics"));
			System.out.println("After updating element at Index 2 => " + empGA.get(2));
		} catch (Exception e) {
			System.out.println(" Invalid ID given ");
		}
		System.out.println(" ** FINAL **");
		System.out.println(empGA);
	}
}
