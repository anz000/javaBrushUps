package anuz.interfaceEx.employeeOpPayment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class ImmutableClass {
	private int customerNumber;
	private String customerName;
	private String contactLastname;
	private String contactFirstname;
	private int phone;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private int postalCode;
	private String Country;
	private int SalesRepEmployeeNumt;
	private double creditLimit;

	public ImmutableClass(int customerNumber, String customerName, String contactLastname, String contactFirstname,
			int phone, String addressLine1, String addressLine2, String city, String state, int postalCode,
			String country, int salesRepEmployeeNumt, double creditLimit) {
		super();
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.contactLastname = contactLastname;
		this.contactFirstname = contactFirstname;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		Country = country;
		SalesRepEmployeeNumt = salesRepEmployeeNumt;
		this.creditLimit = creditLimit;
	}
}
