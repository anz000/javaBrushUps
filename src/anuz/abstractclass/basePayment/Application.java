package anuz.abstractclass.basePayment;

import java.util.Scanner;

import anuz.interfaceEx.payment.AuthRequest;
import anuz.interfaceEx.payment.IncrementAuthorizationRequest;
import anuz.interfaceEx.payment.SaleRequest;
import anuz.interfaceEx.payment.VoidRequest;

public class Application {

	public static void main(String[] args) {
		
		BasePaymentInterface paymentObj; // This holds the paymentObj - elavon OR shift4
		
		Scanner sc = new Scanner(System.in);
		boolean run = true;

		while (run) {
			displayMenu(); // display the menu
			
			System.out.println("Please select from the menu");
			int selection = sc.nextInt();

			switch (selection) {
			case 1:
				paymentObj = new ElavonPaymentInterfaceImpl();
				callMethods(paymentObj); // call the methods
				break;

			case 2:
				paymentObj = new Shift4PaymentInterfaceImpl();
				callMethods(paymentObj); // call the methods
				break;
				
			case 3:
				System.out.println(" Now Exiting..");
				run=false;
				break;
				
			default:
				System.out.println("Please enter from the menu");
				break;
			}
		}
		sc.close();

	}
	
	/*
	 * This method calls all the associated methods with the objects
	 * @argument : BasePaymentInterface
	 */
	public static void callMethods(BasePaymentInterface temp) {
		System.out.println(temp.sale(new SaleRequest()));
		System.out.println(temp.voidM(new VoidRequest()));
		System.out.println(temp.authorization(new AuthRequest()));
		System.out.println(temp.priorAuthorationSale(new SaleRequest()));
		System.out.println(temp.incrementAuthorization(new IncrementAuthorizationRequest()));
	}
	
	/*
	 * This method gives the menu
	 */
	public static void displayMenu() {
		System.out.println(" # # # # # # #  MENU  # # # # # # #");
		System.out.println(" 1. Elavon Payment ");
		System.out.println(" 2. Shift 4 Payment ");
		System.out.println(" 3. EXIT ");
		System.out.println(" # # # # # # # # # # # # # # # # # #");
	}

}
