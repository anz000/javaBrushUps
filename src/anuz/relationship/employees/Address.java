package anuz.relationship.employees;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
	private String city;
	private String country;
	private int id;
	private String postalCode;
	private String province;
	private String street;
	private long version;

	public Address(String city, String country, int id, String postalCode, String province, String street,
			long version) {
		super();
		this.city = city;
		this.country = country;
		this.id = id;
		this.postalCode = postalCode;
		this.province = province;
		this.street = street;
		this.version = version;
	}

}
