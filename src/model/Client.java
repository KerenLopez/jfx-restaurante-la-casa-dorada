package model;

public class Client extends Person {
	private String address;
	private String phone;
	private String obstervations;
	
	public Client(String name, String lastName, String id, String address, String phone,
			String obstervations) {
		super(name, lastName, id);
		this.address = address;
		this.phone = phone;
		this.obstervations = obstervations;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getObstervations() {
		return obstervations;
	}

	public void setObstervations(String obstervations) {
		this.obstervations = obstervations;
	}
	
}
