package anuz.exam.collections2;

import java.util.Comparator;

/**
 * This comparator compares based on price
 * @author anz
 *
 */
public class PriceComparator implements Comparator<Product>{

	/**
	 * This sorts based on price
	 */
	@Override
	public int compare(Product o1, Product o2) {
		if(o1.getPrice() > o2.getPrice())
			return 1;
		else if(o1.getPrice() < o2.getPrice())
			return -1;
		else
			return 0;
	}

}
