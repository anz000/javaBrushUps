package anuz.java8.funcInterface;

import java.time.LocalDateTime;
import java.time.Month;

/**
 * Main Class for CardOperation
 * @author anz
 *
 */
public class Application {
	
	public static void main (String[] args) {
		
		CreditCard cc = new CreditCard(75643844, "Anuj", 144.00, LocalDateTime.of(2020, Month.JANUARY, 25, 6, 30));
		
		System.out.println("Card Details : " + cc);
		cc.checkCC(new CardOperation() {
			@Override
			public void pay() {
				if(!validate(cc.getExpDate())) // false if expired
					System.out.println(" Your card has expired ");
				else if(!CardOperation.validateCardAmount(cc.getAmount())) { // false if 100 to 500
					System.out.println(" Your card with has less than $100 or more than $600 as balance ");
				} else { // if passes both test
					System.out.println(" Your card "+ cc.getCardNumber() +" is ready for use ");
				}
			}
		});
	}
}
