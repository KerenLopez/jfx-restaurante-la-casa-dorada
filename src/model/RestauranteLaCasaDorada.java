package model;

import java.util.ArrayList;

public class RestauranteLaCasaDorada {
	private ArrayList<Order> orders;
	private ArrayList<Product> products;
	private ArrayList<Ingredient> ingredients;
	private ArrayList<TypeOfProduct> typesOfProducts;
	private ArrayList<Employee> employees;
	private ArrayList<Client> clients;
	private ArrayList<User> users;
	
	
	public RestauranteLaCasaDorada() {
		orders= new ArrayList<Order>();
		products= new ArrayList<Product>() ;
		ingredients= new ArrayList<Ingredient>();
		typesOfProducts= new ArrayList<TypeOfProduct>() ;
		employees= new ArrayList<Employee>() ;
		clients= new ArrayList<Client>(); 	
		users= new ArrayList<User>() ;
		
	}


	public ArrayList<Order> getOrders() {
		return orders;
	}


	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}


	public ArrayList<Product> getProducts() {
		return products;
	}


	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}


	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}


	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}


	public ArrayList<TypeOfProduct> getTypesOfProducts() {
		return typesOfProducts;
	}


	public void setTypesOfProducts(ArrayList<TypeOfProduct> typesOfProducts) {
		this.typesOfProducts = typesOfProducts;
	}


	public ArrayList<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}


	public ArrayList<Client> getClients() {
		return clients;
	}


	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}


	public ArrayList<User> getUsers() {
		return users;
	}


	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	
	
	public void addIngredient(String name, User creator) {
		Ingredient ingredient= new Ingredient(name, creator);
		ingredients.add(ingredient);
	}
	
	public boolean deleteIngredient(String ingredientName) {
		boolean deleted=false;
		Ingredient ing=searchIngredient(ingredientName);
		if(ing!=null) {
			if(!searchProductIngredient(ing)){
				int i=ingredients.indexOf(ing);
				ingredients.remove(i);
				deleted=true;
			}
		}
		return deleted;
	}
	
	public boolean updateIngredient(String ingredientName, boolean enabled) {
		Ingredient ing=searchIngredient(ingredientName);
		boolean updated=false;
		if(ing!=null) {
			ing.setEnabled(enabled);
			updated=true;
		}
		return updated;
	}
	
	//search the ingredient in the list of ingredients
	public Ingredient searchIngredient(String ingredientName) {
		boolean found=false;
		Ingredient ing=null;
		for(int i=0; i<ingredients.size() && !found;i++ ) {
			if(ingredients.get(i).getName().equals(ingredientName)) {
				ing=ingredients.get(i);
				found=true;						
			}
		}
		return ing;
	}
	
	//search the ingredient in the list of products
	public boolean searchProductIngredient(Ingredient ing) {
		boolean found=false;
		for(int i=0; i<products.size() && !found;i++) {
			found=products.get(i).findIngredient(ing);	
		}
		return found;

	}
	
	
	public void addTypeOfProduct(String name, User creator) {
		TypeOfProduct top= new  TypeOfProduct(name, creator);
		typesOfProducts.add(top);
	}
	
	public boolean deleteTypeOfProduct(String topName) {
		boolean deleted=false;
		TypeOfProduct top=searchTypeOfProduct(topName);
		if(top!=null) {
			if(!searchProductTypeOfProduct(top)){
				int i=typesOfProducts.indexOf(top);
				typesOfProducts.remove(i);
				deleted=true;
			}
		}
		return deleted;
	}
	
	public boolean updateTypeOfProduct(String topName, boolean enabled) {
		Ingredient ing=searchIngredient(topName);
		boolean updated=false;
		if(ing!=null) {
			ing.setEnabled(enabled);
			updated=true;
		}
		return updated;
	}
	
	
	//search the type of product in the list of types
		public TypeOfProduct searchTypeOfProduct(String topName) {
			boolean found=false;
			TypeOfProduct top=null;
			for(int i=0; i<typesOfProducts.size() && !found;i++ ) {
				if(typesOfProducts.get(i).getName().equals(topName)) {
					top=typesOfProducts.get(i);
					found=true;						
				}
			}
			return top;
		}
		
		//search the type of product in the list of products
		public boolean searchProductTypeOfProduct(TypeOfProduct top) {
			boolean found=false;
			for(int i=0; i<products.size() && !found;i++) {
				if(products.get(i).getType()==top) {
					found=true;
				}
				
			}
			return found;

		}
	
	
	
}
