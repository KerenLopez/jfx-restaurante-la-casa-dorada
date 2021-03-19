package model;

public class Employee extends Person{
	private int numberOrders;
	
	public Employee(String name, String lastName, String id) {
		super(name, lastName, id);
		setNumberOrders(0);
	}

	public int getNumberOrders() {
		return numberOrders;
	}

	public void setNumberOrders(int numberOrders) {
		this.numberOrders = numberOrders;
	}
	
}
