package anuz.exam.collections2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Product implements Comparable<Product>{
	private int productID;
	private String name;
	private double price;
		
	/**
	 * Sorting based on ID
	 */
	@Override
	public int compareTo(Product o) {
		return this.productID - o.getProductID();
	}
}
