package anuz.java8.streaming;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * enummerator for Transaction Type
 * @author anz
 *
 */
enum TType {
	GROCERY, DETERGENT,
	TOYS,VEGETABLES
}

@Getter
@Setter
@ToString(callSuper=false, includeFieldNames=true)
public class Transaction {
	private int id;			// id
	private double price;	// price
	private TType transType;// enum type
	
	// Overloaded Constructor
	public Transaction(int id, double price, TType t) {
		super();
		this.id = id;
		this.price = price;
		this.transType = t; 
	}
	
}
