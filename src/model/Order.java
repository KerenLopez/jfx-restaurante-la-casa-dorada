package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Order implements Serializable, Comparable<Order>{
	
	private static final long serialVersionUID = 1;
	private String code;
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
	
	public Order(Client buyer, Employee deliverer, String observations, User creator) {
		this.dateAndTime = new Date();
		this.stateOfOrder = State.SOLICITADO;
		this.creator = creator;
		this.modifier = creator;
		this.buyer = buyer;
		this.observations = observations;
		this.deliverer = deliverer;
		listOfProducts = new ArrayList<Product>();
		listOfQuantity = new ArrayList<Integer>();
		listOfSizes = new ArrayList<Size>();
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public Date getDateAndTime() {
		return dateAndTime;
	}
	
	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	
	public String getDateAndHour() {
		String strDateFormat = "yyyy-MM-dd HH:mm"; 
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
	
	public Client getBuyer() {
		return buyer;
	}
	
	public void setBuyer(Client buyer) {
		this.buyer = buyer;
	}
	
	public String getClientName() {
		String name = buyer.toString();
		return name;
	}
	
	public Employee getDeliverer() {
		return deliverer;
	}
	
	public void setDeliverer(Employee deliverer) {
		this.deliverer = deliverer;
	}
	
	public String getEmployeeName() {
		String name = deliverer.toString();
		return name;
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
	
	public String getAllQuantities() {
		String quantities = "";
		for(int i=0; i<listOfQuantity.size();i++ ) {
			quantities += listOfQuantity.get(i)+"\n\n";
		}
		return quantities;
	}
	
	public String getAllSizes() {
		String sizes = "";
		for(int i=0; i<listOfSizes.size();i++ ) {
			sizes += listOfSizes.get(i)+"\n\n";
		}
		return sizes;
	}

	public ArrayList<Size> getListOfSizes() {
		return listOfSizes;
	}

	public void setListOfSizes(ArrayList<Size> listOfSizes) {
		this.listOfSizes = listOfSizes;
	}
	
	public boolean findProduct(int pId) {
		boolean found=false;
		for(int i=0; i<listOfProducts.size() && !found;i++ ) {
			if(listOfProducts.get(i).getId()==pId) {
				found=true;						
			}
		}		
		return found;
	}
	
	public Size findSize(int index) {
		boolean found=false;
		Size size = null;
		for(int i=0; i<listOfSizes.size() && !found;i++ ) {
			if(i==index) {
				size = listOfSizes.get(i);
				found=true;						
			}
		}		
		return size;
	}
	
	public int findQuantity(int index) {
		boolean found=false;
		int quantity = 0;
		for(int i=0; i<listOfQuantity.size() && !found;i++ ) {
			if(i==index) {
				quantity = listOfQuantity.get(i);
				found=true;						
			}
		}		
		return quantity;
	}

	@Override
	public int compareTo(Order order) {
		return dateAndTime.compareTo(order.getDateAndTime());
	}
}
