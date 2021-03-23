package model;

public class Employee extends Person{
	
	private static final long serialVersionUID = 1;
	private int numberOrders;
	
	public Employee(String name, String lastName, String id, User creator) {
		super(name, lastName, id, creator);
		setNumberOrders(0);
	}

	public int getNumberOrders() {
		return numberOrders;
	}

	public void setNumberOrders(int numberOrders) {
		this.numberOrders = numberOrders;
	}
	
	
	
	
}
