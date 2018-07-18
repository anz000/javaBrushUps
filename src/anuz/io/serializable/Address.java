package anuz.io.serializable;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Getter
@Setter
@ToString(callSuper=false, includeFieldNames=true)
public class Address implements Serializable{
	private String street;
	private String unitNum;
	private String city;
	private String state;
	
	public Address(String street, String unitNum, String city, String state) {
		super();
		this.street = street;
		this.unitNum = unitNum;
		this.city = city;
		this.state = state;
	}
}
