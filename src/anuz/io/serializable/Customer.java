package anuz.io.serializable;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Getter
@Setter
@ToString(callSuper=false, includeFieldNames=true)
public class Customer implements Serializable{
	
	private int id;
	private String firstName;
	private String lastName;
	private Address address;
	
	public Customer(int id, String firstName, String lastName, Address address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
}
