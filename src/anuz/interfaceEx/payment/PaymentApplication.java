package anuz.interfaceEx.payment;

import java.util.Scanner;

public class PaymentApplication {

	public static void main(String[] args) {

		String response = "";
		
		PaymentInterfaceImpl payImpl = new PaymentInterfaceImpl();

		Scanner sc = new Scanner(System.in);

		boolean run = true;

		while (run) {
			displayMenu();
			try {
				System.out.println("Please select from the menu");
				int selection = sc.nextInt();

				switch (selection) {
				case 1:
					response = payImpl.sale(new SaleRequest());
					break;

				case 2:
					response = payImpl.voidM(new VoidRequest());
					break;

				case 3:
					response = payImpl.authorization(new AuthRequest());
					break;

				case 4:
					response = payImpl.priorAuthorationSale(new SaleRequest());
					break;

				case 5:
					response = payImpl.incrementAuthorization(new IncrementAuthorizationRequest());
					break;

				case 6:
					response = "You've decided to EXIT. Bye!";
					run = false;
					break;

				default:
					response = "Please select correct entries";
					break;
				}

				System.out.println(response);
				System.out.println();
				System.out.println();
				System.out.println();

			} catch (Exception e) {
				System.out.println("Please select from the menu");
			}
		}
		sc.close();
	}

	public static void displayMenu() {
		System.out.println(" # # # # # # #  MENU  # # # # # # #");
		System.out.println(" 1. Sale ");
		System.out.println(" 2. Void ");
		System.out.println(" 3. Authorization ");
		System.out.println(" 4. PriorAuthorizationSale ");
		System.out.println(" 5. Increment Authorization ");
		System.out.println(" 6. EXIT ");
		System.out.println(" # # # # # # # # # # # # # # # # # #");
	}

}
