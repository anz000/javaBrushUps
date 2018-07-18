package anuz.relationship.employees;

public class PhoneNumber {
	private String areaCode;
	private String number;
	private Employee owner;
	private String Type;
	private int id;

	public PhoneNumber(String areaCode, String number, Employee owner, String type, int id) {
		super();
		this.areaCode = areaCode;
		this.number = number;
		this.owner = owner;
		Type = type;
		this.id = id;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Employee getOwner() {
		return owner;
	}

	public void setOwner(Employee owner) {
		this.owner = owner;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "PhoneNumber [areaCode=" + areaCode + ", number=" + number + ", Type=" + Type
				+ ", id=" + id + "]";
	}

}
