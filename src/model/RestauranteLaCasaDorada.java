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



	public boolean addIngredient(String name, String un) {
		Ingredient ingredient=searchIngredient(name);
		User creator=searchUser(un);

		boolean added=false;
		if(ingredient==null) {
			ingredient= new Ingredient(name, creator);
			ingredients.add(ingredient);
			added=true;
		}

		return added;
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

	public boolean updateIngredient(String ingredientName, boolean enabled, String un) {
		Ingredient ing=searchIngredient(ingredientName);
		boolean updated=false;
		if(ing!=null) {
			ing.setEnabled(enabled);
			ing.setModifier(searchUser(un));
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


	public boolean addTypeOfProduct(String name, String un) {
		TypeOfProduct top=searchTypeOfProduct(name);
		User creator=searchUser(un);

		boolean added=false;
		if(top==null) {
			top= new  TypeOfProduct(name, creator);
			typesOfProducts.add(top);
			added=true;
		}

		return added;

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

	public boolean updateTypeOfProduct(String topName, boolean enabled, String un) {
		Ingredient ing=searchIngredient(topName);
		boolean updated=false;
		if(ing!=null) {
			ing.setEnabled(enabled);
			ing.setModifier(searchUser(un));
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

	
	public boolean addProduct(String name, String t,
			String listOfIngredients, String un) {
		Product p=searchProduct(name);
		User creator=searchUser(un);
		TypeOfProduct type=searchTypeOfProduct(t);
		boolean added=false;
		if(p==null) {
			String[] parts= listOfIngredients.split(";");
			ArrayList<Ingredient> list= new ArrayList<Ingredient>();
			for(int i=0; i<parts.length;i++) {

				list.add(searchIngredient(parts[i]));
			}
			p= new Product(name, creator, type, list);
			products.add(p);
			added=true;
		}

		return added;

	}

	public boolean deleteProduct(String pName) {
		boolean deleted=false;
		Product p=searchProduct(pName);
		if(p!=null) {
			//CONDICION PARA BUSCAR SI EL PRODUCTO ESTÁ EN UNA ORDEN ...if(!searchOrderProduct(p)){
			int i=products.indexOf(p);
			products.remove(i);
			deleted=true;

		}
		return deleted;
	}

	public boolean updateProduct(String pName, boolean enabled, String t,
			String listOfIngredients, String un) {
		Product p=searchProduct(pName);
		boolean updated=false;
		if(p!=null) {
			p.setEnabled(enabled);
			p.setType(searchTypeOfProduct(t));

			String[] parts= listOfIngredients.split(";");
			ArrayList<Ingredient> list= new ArrayList<Ingredient>();
			for(int i=0; i<parts.length;i++) {

				list.add(searchIngredient(parts[i]));
			}

			p.setListOfIngredients(list);
			p.setModifier(searchUser(un));
			updated=true;
		}
		return updated;
	}


	//search the product in the list of products
	public Product searchProduct(String pName) {
		boolean found=false;
		Product p=null;
		for(int i=0; i<products.size() && !found;i++ ) {
			if(products.get(i).getName().equals(pName)) {
				p=products.get(i);
				found=true;						
			}
		}
		return p;
	}

	
	public User searchUser(String userName) {
		boolean found=false;
		User u=null;
		for(int i=0; i<users.size() && !found;i++ ) {
			if(users.get(i).getUserName().equals(userName)) {
				u=users.get(i);
				found=true;						
			}
		}
		return u;
	}




}
