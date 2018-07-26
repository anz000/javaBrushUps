package anuz.java8.funcInterface;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreditCard  {
	
	private long cardNumber;
	private String name;
	private double amount;
	private LocalDateTime expDate;
	
	//overloaded constructor
	public CreditCard(long cardNumber, String name, double amount, LocalDateTime localDateTime) {
		super();
		this.cardNumber = cardNumber;
		this.name = name;
		this.amount = amount;
		this.expDate = localDateTime;
	}

	/**
	 * This method will check if the credit card is usable or not
	 * @param c
	 */
	public void checkCC (CardOperation c) {
		c.pay();
	}
}
