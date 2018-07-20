package anuz.collections.employeeOp;

import java.util.Comparator;

public class IDComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getId()-o2.getId();
	}

}
