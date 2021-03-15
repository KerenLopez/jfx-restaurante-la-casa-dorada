package model;

import java.util.ArrayList;

public class Product {
	private String name;
	private boolean enabled;
	private ArrayList<String> sizes;
	private ArrayList<Double> prices;
	
	private User creator;
	private User modifier;
	private TypeOfProduct type;
	private ArrayList<Ingredient> listOfIngredients;
	
	public Product(String name, boolean enabled, User creator, User modifier, TypeOfProduct type,
			ArrayList<Ingredient> listOfIngredients) {
		super();
		this.name = name;
		this.enabled = enabled;
		this.creator = creator;
		this.modifier = modifier;
		this.type = type;
		this.listOfIngredients = listOfIngredients;
		sizes= new ArrayList<String>();
		prices= new ArrayList<Double>();
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public ArrayList<String> getSizes() {
		return sizes;
	}
	public void setSizes(ArrayList<String> sizes) {
		this.sizes = sizes;
	}
	public ArrayList<Double> getPrices() {
		return prices;
	}
	public void setPrices(ArrayList<Double> prices) {
		this.prices = prices;
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
	public TypeOfProduct getType() {
		return type;
	}
	public void setType(TypeOfProduct type) {
		this.type = type;
	}
	public ArrayList<Ingredient> getListOfIngredients() {
		return listOfIngredients;
	}
	public void setListOfIngredients(ArrayList<Ingredient> listOfIngredients) {
		this.listOfIngredients = listOfIngredients;
	}
	
	
	public boolean findIngredient(Ingredient ing) {
		boolean found=false;
		for(int i=0; i<listOfIngredients.size() && !found;i++ ) {
			if(listOfIngredients.get(i)==ing) {
				found=true;						
			}
		}
				
		return found;
	}
	
	
	

}
