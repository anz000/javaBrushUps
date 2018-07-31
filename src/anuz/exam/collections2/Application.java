package anuz.exam.collections2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Main Application
 * @author anz
 *
 */
public class Application {
	private static List<Product> productList = new ArrayList<Product>(); // static placeholder for products
	
	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		//Adding 5 products to the list
		addDummyProducts();
		
		while(true) {
			int sortSelection = sortMenu(); // switch based on input
			
			switch (sortSelection) {
			case 1:
				Collections.sort(productList);
				break;

			case 2:
				Collections.sort(productList, new PriceComparator());
				break;

			case 3:
				System.out.println("Hope you got your products. Exiting. Bye! ");
				System.exit(0);
				break;

			default:
				break;
			}
			
			// showing the products
			showProducts();
		}
	}

	/**
	 * This method adds the dummy products to the list
	 */
	private static void addDummyProducts() {
		productList.add(new Product(1, "Prod_1", 40.00));
		productList.add(new Product(2, "Prod_2", 30.00));
		productList.add(new Product(3, "Prod_3", 45.20));
		productList.add(new Product(40, "Prod_4", 45.99));
		productList.add(new Product(5, "Prod_5", 16.40));		
	}

	/**
	 * menu and get input from user
	 * @return
	 */
	private static int sortMenu() {
		System.out.println(" * * * * MENU * * * * * ");
		System.out.println("1. Sort by Product Id");
		System.out.println("2. Sort by Product Price");
		System.out.println("3. EXIT");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please select from the menu.");
	
		int selection = scan.nextInt();
		return selection;
	}
	
	/**
	 * Display the products
	 */
	private static void showProducts() {
		Iterator<Product> pIter = productList.iterator();
		while(pIter.hasNext()) {
			System.out.println(pIter.next());
		}
	}
}
