package model;


public class Client extends Person {
	private String address;
	private String phone;
	private String observations;
	
	public Client(String name, String lastName, String id, String address, String phone,
			String observations, User creator) {
		super(name, lastName, id, creator);
		this.address = address;
		this.phone = phone;
		this.observations = observations;
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

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}
	
	
	
}
