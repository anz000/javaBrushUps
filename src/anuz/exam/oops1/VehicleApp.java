package anuz.exam.oops1;

import java.util.Scanner;

/**
 * Main Vehicle App
 * @author anz
 *
 */
public class VehicleApp {

	/**
	 * Main Method
	 * @param args
	 */
	public static void main(String[] args) {

		Vehicle vehicle = null;

		while (true) {

			int choice = showMenuAndSelection();
			switch (choice) {
			case 1:
				vehicle = new AstonMartin();
				break;

			case 2:
				vehicle = new Ferrari();
				break;

			case 3:
				vehicle = new Scania();
				break;

			case 4:
				vehicle = new Man();
				break;

			case 5:
				System.out.println("Hope you had fun. Exiting now. Bye!");
				System.exit(0);
				break;

			default:
				System.out.println("Please select from the menu. ");
				break;
			}

			// calling the methods on the vehicle
			callMethods(vehicle);
		}
	}

	/**
	 * This method shows the Menu and gets the user input
	 * @return
	 */
	private static int showMenuAndSelection() {
		System.out.println(" * * * * * * * MENU * * * * * * * *  ");
		System.out.println("What would you like to drive today?");
		System.out.println("1.AstonMartin Car");
		System.out.println("2.Ferrari Car");
		System.out.println("3.Scania Truck");
		System.out.println("4.Man Truck");
		System.out.println("5.Exit");
		System.out.println(" # # # # # # # # # # #");

		int selection = 0;
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println();
			System.out.println("Please select from the menu");

			selection = scan.nextInt();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return selection;
	}

	/**
	 * This method calls the required methods
	 * @param v
	 */
	private static void callMethods(Vehicle v) {
		v.drive();
		v.steer(30);
		v.stop();
	}

}
