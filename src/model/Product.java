package model;

import java.util.ArrayList;

public class Product {
	
	private int id;
	private String name;
	private boolean enabled;
	private ArrayList<Size> sizes;
	private ArrayList<Double> prices;
	private User creator;
	private User modifier;
	private TypeOfProduct type;
	private ArrayList<Ingredient> listOfIngredients;
	
	public Product(String name, User creator, TypeOfProduct type, int id) {
		this.name = name;
		this.enabled = true;
		this.creator = creator;
		this.modifier = creator;
		this.type = type;
		this.id = id;
		listOfIngredients = new ArrayList<Ingredient>();
		sizes= new ArrayList<Size>();
		prices= new ArrayList<Double>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStatus() {
		String status = "";
		if(enabled==true) {
			status = "Habilitado";
		}else {
			status = "Deshabilitado";
		}
		return status;
	}
	
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public ArrayList<Size> getSizes() {
		return sizes;
	}
	
	public void setSizes(ArrayList<Size> sizes) {
		this.sizes = sizes;
	}
	
	public String getAllSizes() {
		String allSizes = "";
		for(int k=0; k<sizes.size();k++) {
			allSizes += sizes.get(k).getName()+"\n";
		}
		return allSizes;
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
	
	public boolean findIngredient(int ingId) {
		boolean found=false;
		for(int i=0; i<listOfIngredients.size() && !found;i++ ) {
			if(listOfIngredients.get(i).getId()==ingId) {
				found=true;						
			}
		}		
		return found;
	}
	
	public Size findSize(String name) {
		boolean found = false;
		Size size=null;
		for(int i=0; i<sizes.size() && !found;i++ ) {
			if(sizes.get(i).getName().equalsIgnoreCase(name)) {
				size=sizes.get(i);
				found=true;
			}
		}		
		return size;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
}
