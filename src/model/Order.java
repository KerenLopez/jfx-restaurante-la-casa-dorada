package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Order {
	private int code;
	private Date dateAndTime;
	private String observations;
	private State stateOfOrder;
	private User creator;
	private User modifier;
	private Client buyer;
	private Employee deliverer;
	private ArrayList<Product> listOfProducts;
	private ArrayList<Size> listOfSizes;
	private ArrayList<Integer> listOfQuantity;
	
	public Order(Client buyer, Employee deliverer, ArrayList<Product> listOfProducts, ArrayList<Size> listOfSizes, ArrayList<Integer> listOfQuantity, String observations, User creator) {
		this.dateAndTime = new Date();
		this.stateOfOrder = State.SOLICITADO;
		this.creator = creator;
		this.modifier = creator;
		this.buyer = buyer;
		this.deliverer = deliverer;
		this.listOfProducts = listOfProducts;
		this.listOfQuantity = listOfQuantity;
		this.listOfSizes = listOfSizes;
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
	
	public String getDateAndHour() {
		String strDateFormat = "hh: mm: ss a dd-MMM-aaaa"; 
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        String dateAndHour = objSDF.format(dateAndTime);
        return dateAndHour;
	}
	
	public State getStateOfOrder() {
		return stateOfOrder;
	}
	
	public void setStateOfOrder(State stateOfOrder) {
		this.stateOfOrder = stateOfOrder;
	}
	
	public String getStatus() {
		String status = "";
		if(stateOfOrder==State.EN_PROCESO) {
			status = "En proceso";
		}
		if(stateOfOrder==State.CANCELADO) {
			status = "Cancelada";
		}
		if(stateOfOrder==State.ENTREGADO) {
			status="Entregada";
		}
		if(stateOfOrder==State.SOLICITADO) {
			status="Solicitada";
		}
		if(stateOfOrder==State.ENVIADO) {
			status="Enviada";
		}
		return status;
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
	
	public User getCreator() {
		return creator;
	}


	public void setCreator(User creator) {
		this.creator = creator;
	}


	public User getModifier() {
		return modifier;
	}


	public void setModifier(User modifier) {
		this.modifier = modifier;
	}

	public String getCreatorName() {
		String name;
		if(creator==null) {
			name="-";
		}else {
			name = creator.getUserName();
		}
		return name;
	}
	
	public String getModifierName() {
		String name;
		if(modifier==null) {
			name="-";
		}else {
			name = modifier.getUserName();
		}
		return name;
	}

	public ArrayList<Integer> getListOfQuantity() {
		return listOfQuantity;
	}

	public void setListOfQuantity(ArrayList<Integer> listOfQuantity) {
		this.listOfQuantity = listOfQuantity;
	}

	public ArrayList<Size> getListOfSizes() {
		return listOfSizes;
	}

	public void setListOfSizes(ArrayList<Size> listOfSizes) {
		this.listOfSizes = listOfSizes;
	}
}
