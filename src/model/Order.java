package model;

import java.util.ArrayList;
import java.util.Date;

public class Order {
	private int code;
	private Date dateAndTime;
	private String observations;
	private State stateOfOrder;
	
	private Client buyer;
	private Employee deliverer;
	private ArrayList<Product> listOfProducts;
	
	public Order(Client buyer, Employee deliverer, ArrayList<Product> listOfProducts, String observations) {
		this.dateAndTime = new Date();
		this.stateOfOrder = State.SOLICITADO;
		this.buyer = buyer;
		this.deliverer = deliverer;
		this.listOfProducts = listOfProducts;
	}
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Date getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	public State getStateOfOrder() {
		return stateOfOrder;
	}
	public void setStateOfOrder(State stateOfOrder) {
		this.stateOfOrder = stateOfOrder;
	}
	public Client getBuyer() {
		return buyer;
	}
	public void setBuyer(Client buyer) {
		this.buyer = buyer;
	}
	public Employee getDeliverer() {
		return deliverer;
	}
	public void setDeliverer(Employee deliverer) {
		this.deliverer = deliverer;
	}
	public ArrayList<Product> getListOfProducts() {
		return listOfProducts;
	}
	public void setListOfProducts(ArrayList<Product> listOfProducts) {
		this.listOfProducts = listOfProducts;
	}


	public String getObservations() {
		return observations;
	}


	public void setObservations(String observations) {
		this.observations = observations;
	}
	
	public void updateState(String state) {
		stateOfOrder=State.valueOf(state);
	}
	
	
	
	
}
