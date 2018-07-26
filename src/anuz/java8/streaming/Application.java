package anuz.java8.streaming;

import java.util.ArrayList;
import java.util.List;

/**
 * Main Application
 * @author anz
 *
 */
public class Application {
	
	/**
	 * Main Method
	 * @param args
	 */
	public static void main (String[] args) {
		List<Transaction> transList = new ArrayList<>();
		
		// creating 20 random Objects
		transList.add( new Transaction(1,20.00,TType.GROCERY) );
		transList.add( new Transaction(2,2140.00,TType.TOYS) );
		transList.add( new Transaction(3,320.00,TType.GROCERY) );
		transList.add( new Transaction(4,6780.00,TType.VEGETABLES) );
		transList.add( new Transaction(5,87.00,TType.GROCERY) );
		transList.add( new Transaction(6,35.00,TType.GROCERY) );
		transList.add( new Transaction(7,45.00,TType.GROCERY) );
		transList.add( new Transaction(8,25.00,TType.DETERGENT) );
		transList.add( new Transaction(9,2.00,TType.GROCERY) );
		transList.add( new Transaction(10,220.00,TType.TOYS) );
		transList.add( new Transaction(11,420.00,TType.GROCERY) );
		transList.add( new Transaction(12,650.00,TType.VEGETABLES) );
		transList.add( new Transaction(13,765.00,TType.DETERGENT) );
		transList.add( new Transaction(14,987.00,TType.TOYS) );
		transList.add( new Transaction(15,989.00,TType.VEGETABLES) );
		transList.add( new Transaction(16,99.00,TType.GROCERY) );
		transList.add( new Transaction(17,320.00,TType.DETERGENT) );
		transList.add( new Transaction(18,277.00,TType.VEGETABLES) );
		transList.add( new Transaction(19,231.00,TType.GROCERY) );
		transList.add( new Transaction(20,282.00,TType.DETERGENT) );
		
		// streaming Java 8
		transList.stream()
					.filter((t)-> t.getTransType() == TType.GROCERY) // filtering
					.sorted((a,b)-> {								 // sorting
						if(a.getPrice()>b.getPrice()) {return 1;}
						else if(a.getPrice()<b.getPrice()) {return -1;}
						else {return 0;}
					})
					.map((t)->t.getId())							 // mapping 
					.forEach(System.out::println);					 // displaying
		
	}
}
