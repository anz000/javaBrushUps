package anuz.java8.funcInterface;

import java.time.LocalDateTime;

@FunctionalInterface
public interface CardOperation {

	// abstract method
	public void pay();
	
	// default method
	public default boolean validate (LocalDateTime expDate) {
		LocalDateTime currentDate = LocalDateTime.now();
		if( currentDate.isAfter(expDate) )
			return false;
		else
			return true;
	}
	
	// static method
	public static boolean validateCardAmount(double amount) {
		if(amount > 100 && amount < 500)
			return true;
		else
			return false;
	}
}
