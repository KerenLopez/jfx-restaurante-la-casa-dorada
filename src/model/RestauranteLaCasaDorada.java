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

	public boolean addIngredient(String name, String userId) {
		Ingredient ingredient=searchIngredientByName(name);
		User creator=searchUser(userId);

		boolean added=false;
		if(ingredient==null) {
			ingredient= new Ingredient(name, creator);
			ingredients.add(ingredient);
			added=true;
		}

		return added;
	}

	public boolean deleteIngredient(int ingredientId) {
		boolean deleted=false;
		Ingredient ing=searchIngredientById(ingredientId);
		if(ing!=null) {
			if(!searchProductIngredient(ingredientId)){
				int i=ingredients.indexOf(ing);
				ingredients.remove(i);
				deleted=true;
			}
		}
		return deleted;
	}

	public boolean updateIngredient(String newName, int ingredientId, boolean enabled, String userId) {
		Ingredient ing1 = searchIngredientById(ingredientId);
		Ingredient ing2 = searchIngredientByName(newName);
		boolean updated=false;
		if(ing1!=null && ing2==null) {
			ing1.setName(newName);
			ing1.setEnabled(enabled);
			ing1.setModifier(searchUser(userId));
			updated=true;
		}
		return updated;
	}

	//search an ingredient in the list of ingredients by its id
	public Ingredient searchIngredientById(int ingredientId) {
		boolean found=false;
		Ingredient ing=null;
		for(int i=0; i<ingredients.size() && !found;i++ ) {
			if(ingredients.get(i).getId()==ingredientId) {
				ing=ingredients.get(i);
				found=true;						
			}
		}
		return ing;
	}
	
	//search an ingredient in the list of ingredients by its name
	public Ingredient searchIngredientByName(String ingredientId) {
		boolean found=false;
		Ingredient ing=null;
		for(int i=0; i<ingredients.size() && !found;i++ ) {
			if(ingredients.get(i).getName().equalsIgnoreCase(ingredientId)) {
				ing=ingredients.get(i);
				found=true;						
			}
		}
		return ing;
	}

	//search an ingredient in the list of products
	public boolean searchProductIngredient(int id) {
		boolean found=false;
		for(int i=0; i<products.size() && !found;i++) {
			found=products.get(i).findIngredient(id);	
		}
		return found;
	}

	public boolean addTypeOfProduct(String name, String userId) {
		TypeOfProduct top=searchTypeOfProductByName(name);
		User creator=searchUser(userId);

		boolean added=false;
		if(top==null) {
			top= new  TypeOfProduct(name, creator);
			typesOfProducts.add(top);
			added=true;
		}
		return added;
	}
	
	public boolean deleteTypeOfProduct(int TpId) {
		boolean deleted=false;
		TypeOfProduct top=searchTypeOfProductById(TpId);
		if(top!=null) {
			if(!searchProductTypeOfProduct(TpId)){
				int i=typesOfProducts.indexOf(top);
				typesOfProducts.remove(i);
				deleted=true;
			}
		}
		return deleted;
	}

	public boolean updateTypeOfProduct(String newName, int TpId, boolean enabled, String userName) {
		TypeOfProduct Tp1=searchTypeOfProductByName(newName);
		TypeOfProduct Tp2=searchTypeOfProductById(TpId);
		boolean updated=false;
		if(Tp1!=null && Tp2==null) {
			Tp1.setName(newName);
			Tp1.setEnabled(enabled);
			Tp1.setModifier(searchUser(userName));
			updated=true;
		}
		return updated;
	}


	//search a type of product in the list of types by its name.
	public TypeOfProduct searchTypeOfProductByName(String topName) {
		boolean found=false;
		TypeOfProduct top=null;
		for(int i=0; i<typesOfProducts.size() && !found;i++ ) {
			if(typesOfProducts.get(i).getName().equalsIgnoreCase(topName)) {
				top=typesOfProducts.get(i);
				found=true;						
			}
		}
		return top;
	}
	
	//search a type of product in the list of types by its id.
	public TypeOfProduct searchTypeOfProductById(int TpId) {
		boolean found=false;
		TypeOfProduct top=null;
		for(int i=0; i<typesOfProducts.size() && !found;i++ ) {
			if(typesOfProducts.get(i).getId()==TpId) {
				top=typesOfProducts.get(i);
				found=true;						
			}
		}
		return top;
	}

	//search a type of product in the list of products.
	public boolean searchProductTypeOfProduct(int TpId) {
		boolean found=false;
		for(int i=0; i<products.size() && !found;i++) {
			if(products.get(i).getType().getId()==TpId) {
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
	
	public void createOrder(String sBuyer, String sDeliv, String listProd, String obs) {
		
		Client buyer=searchClient(sBuyer);
		Employee deliverer= searchEmployee(sDeliv);
		
		String[] parts= listProd.split(";");
		ArrayList<Product> list= new ArrayList<Product>();
		for(int i=0; i<parts.length;i++) {

			list.add(searchProduct(parts[i]));
		}
		
		Order order= new  Order(buyer,deliverer, list, obs);
		orders.add(order);
		order.setCode(orders.size());


	}
	
	public void updateOrderState(int code, String state) {
		Order order = orders.get(code-1);
		order.updateState(state);
	}
	
	
	

	public boolean createUser(String emplId, String userId, String userName, String password, String unCreatorId){
		boolean created=false;
		User creator;
		Employee employee= searchEmployee(emplId);
		
		if(!searchEmployeeInUsers(employee) && !searchUserName(userName) && !searchUserId(userId)) {

			
			User user=new User(employee, userId, userName, password);
			if(users.isEmpty()) {
				creator=user;
			}
			else {
				creator=searchUser(unCreatorId);
			}
			user.setCreator(creator);

			users.add(user);
			created=true;

		}
		

		return created;
	}
	
	public boolean deleteUser(String userId) {
		boolean deleted=false;
		User user=searchUser(userId);
		if(user!=null) {
			int i=users.indexOf(user);
			users.remove(i);
			deleted=true;

		}
		
		return deleted;
	}
	
	public boolean updateUser(String userId, String newUserId, String emplId, String userName, String password, boolean enabled,String unModifierId) {
		boolean updated=false;
		
		Employee employee= searchEmployee(emplId);

		if(!searchEmployeeInUsers(employee) && !searchUserName(userName) && !searchUserId(newUserId)) {
			User user=searchUser(userId);
			User modifier=searchUser(unModifierId);
			
			user.setUserName(userName);
			user.setPassword(password);
			user.setModifier(modifier);
			user.setEmployee(employee);
			user.setEnabled(enabled);
			user.setId(newUserId);
			updated=true;
		}


		return updated;
	}
	
	
	public User searchUser(String userId) {
		boolean found=false;
		User u=null;
		for(int i=0; i<users.size() && !found;i++ ) {
			if(users.get(i).getId().equals(userId)) {
				u=users.get(i);
				found=true;						
			}
		}
		return u;
	}
	

	//search employee in the list of users
	public boolean searchEmployeeInUsers(Employee empl) {

		boolean found=false;
		for(int i=0; i<users.size() && !found;i++) {
			if(users.get(i).getEmployee()==empl) {
				found=true;
			}

		}
		return found;
	}
	
	
	
	//search the user name in the list of users
	public boolean searchUserName(String userName) {
		boolean found=false;
		for(int i=0; i<users.size() && !found;i++) {
			if(users.get(i).getUserName().equals(userName)) {

				found=true;
			}

		}
		return found;
	}

	//search the user id in the list of users
	public boolean searchUserId(String userId) {
		boolean found=false;
		for(int i=0; i<users.size() && !found;i++) {
			if(users.get(i).getId().equals(userId)) {

				found=true;
			}

		}
		return found;
	}

	public Client searchClient(String name) {
		//boolean found=false;
		Client c=null;
		
		return c;
	}
	
	public Employee searchEmployee(String id) {
		//boolean found=false;
		Employee e=null;
		
		return e;
	}

}
