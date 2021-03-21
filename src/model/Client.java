package model;

public class Client extends Person {
	private String address;
	private String phone;
	private String observations;
	private int autoId;//ID AUTOGENERADO, DIFERENTE AL NUM DE IDENTIFICACION
	
	public Client(String name, String lastName, String id, String address, String phone,
			String obstervations, User creator) {
		super(name, lastName, id, creator);
		this.address = address;
		this.phone = phone;
		this.observations = obstervations;
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

	public int getAutoId() {
		return autoId;
	}

	public void setAutoId(int autoId) {
		this.autoId = autoId;
	}
	
	
	
}
