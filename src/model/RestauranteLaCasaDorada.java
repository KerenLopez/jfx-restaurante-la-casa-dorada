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
	private int idIngredient;
	private int idProduct;
	private int idTypeOfProduct;
	private int idSize;

	public RestauranteLaCasaDorada() {
		orders= new ArrayList<Order>();
		products= new ArrayList<Product>() ;
		ingredients= new ArrayList<Ingredient>();
		typesOfProducts= new ArrayList<TypeOfProduct>() ;
		employees= new ArrayList<Employee>() ;
		clients= new ArrayList<Client>(); 	
		users= new ArrayList<User>() ;
		idIngredient = 1;
		idProduct = 1;
		idTypeOfProduct = 1;
		idSize = 1;
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
			ingredient= new Ingredient(name, creator, idIngredient);
			ingredients.add(ingredient);
			idIngredient++;
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
			top= new  TypeOfProduct(name, creator, idTypeOfProduct);
			typesOfProducts.add(top);
			idTypeOfProduct++;
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
	
	public boolean addProduct(String name, int type, String userId) {
		Product p=searchProductByName(name);
		User creator=searchUser(userId);
		TypeOfProduct tp=searchTypeOfProductById(type);
		boolean added=false;
		if(p==null) {
			p= new Product(name, creator, tp, idProduct);
			products.add(p);
			idProduct++;
			added=true;
		}
		return added;
	}
	
	public boolean addIngredientToAProduct(Product p, Ingredient ing) {
		ArrayList<Ingredient> list = p.getListOfIngredients();
		boolean find = searchProductIngredient(ing.getId());
		boolean added = false;
		if(find==false) {
			list.add(ing);
			added = true;
		}
		return added;
	}
	
	public void deleteAnIngredientOfAProduct(Product p, Ingredient ing) {
		ArrayList<Ingredient> list = p.getListOfIngredients();
		list.remove(list.indexOf(ing));
	}
	
	public boolean addSizeOfAProduct(Product p, String name, double price) {
		ArrayList<Size> list = p.getSizes();
		boolean find = p.findSize(name);
		boolean added = false;
		if(find==false) {
			Size size = new Size(name, price, idSize);
			list.add(size);
			idSize++;
			added = true;
		}
		return added;
	}
	
	public void deleteSizeOfAProduct(Product p, Size s) {
		ArrayList<Size> list = p.getSizes();
		list.remove(list.indexOf(s));
	}
	
	public boolean updateSizeOfAProduct(Product p, Size selectedSize, String newName, double newPrice) {
		boolean find = p.findSize(newName);
		boolean updated = false;
		if(find==false) {
			selectedSize.setName(newName);
			selectedSize.setPrice(newPrice);
			updated = true;
		}
		return updated;
	}

	public void deleteProduct(Product product) {
		int i=products.indexOf(product);
		products.remove(i);
	}

	public boolean updateProduct(Product p, String newName, boolean enabled, int TpId, String userId) {
		boolean updated=false;
		Product product = searchProductByName(newName);
		if(product==null) {
			p.setName(newName);
			p.setEnabled(enabled);
			p.setType(searchTypeOfProductById(TpId));
			p.setModifier(searchUser(userId));
			updated=true;
		}
		return updated;
	}


	//search a product in the list of products by its name
	public Product searchProductByName(String pName) {
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
	
	/*public void createOrder(String sBuyer, String sDeliv, String listProd, String obs) {
		
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
	*/
	
	

	public boolean createUser(String emplId, String userName, String password, String creatorId){
		boolean created=false;
		User creator;
		Employee employee= searchEmployee(emplId);
		
		if(!searchEmployeeInUsers(employee) && !searchUserName(userName)) {

			
			User user=new User(employee, userName, password);
			if(users.isEmpty()) {
				creator=user;
			}
			else {
				creator=searchUser(creatorId);
			}
			user.setCreator(creator);

			users.add(user);
			created=true;

		}
		

		return created;
	}
	
	public void deleteUser(String userId) {
		User user=searchUser(userId);
		int i=users.indexOf(user);
		users.remove(i);


	}
	
	public boolean updateUser(String userId,String emplId, String userName, String password, boolean enabled,String modifierId) {
		boolean updated=false;
		
		Employee employee= searchEmployee(emplId);
		User user=searchUser(userId);
		boolean findUserEmpl=false;
		if(user.getEmployee()!=employee) {
			findUserEmpl=searchEmployeeInUsers(employee);
		}

		if(!findUserEmpl && !searchUserName(userName)) {
			User modifier=searchUser(modifierId);
			
			user.setUserName(userName);
			user.setPassword(password);
			user.setModifier(modifier);
			user.setEmployee(employee);
			user.setEnabled(enabled);
			user.setId(emplId);
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
	
	
	
	public ArrayList<String>  employeesToString() {
		ArrayList<String> emplString= new ArrayList<String>();
		for(int i=0; i<employees.size(); i++) {
			if(employees.get(i).isEnabled()) {
				emplString.add(employees.get(i).idAndName());

			}
		}
		return emplString;
	}
	
	public String logInUser(String userName, String password) {
		boolean logIn=false;
		String id="";
		for(int i=0; i<users.size() && !logIn; i++) {
			
			if(users.get(i).getUserName().equalsIgnoreCase(userName)){
				logIn=true;
				
				if(users.get(i).getPassword().equals(password)) {
					id=users.get(i).getId();
				}
			}

		}
		return id;
	}


	public boolean createEmployee(String id, String name, String lastName, String creatorId) {

		boolean created=false;

		Employee employee= searchEmployee(id);
		User creator;


		if(employee==null) {
			
			if(creatorId.equals("id")) {
				creator=null;
			}
			else {
				creator=searchUser(creatorId);
			}
			employee= new Employee(name,lastName,id, creator);
			employees.add(employee);
			created=true;
			
		}
		


		return created;
	}
	
	public boolean deleteEmployee(String emplId) {
		boolean deleted=false;
		Employee employee=searchEmployee(emplId);
		if(!searchEmployeeInUsers(employee)) {
			int i=employees.indexOf(employee);
			employees.remove(i);
			deleted=true;
		}
		
		return deleted;

	}
	
	public boolean updateEmployee(String oldEmplId,String newEmplId, String name, String lastName, boolean enabled,String modifierId) {
		boolean updated=false;
		
		Employee employee= searchEmployee(oldEmplId);
		Employee employee2= searchEmployee(newEmplId);
		
		boolean findEmpl=false;
		if(employee!=employee2) {
			if(employee2!=null) {
				findEmpl=true;
			}
		}

		if(!findEmpl) {
			User modifier=searchUser(modifierId);
			
			employee.setName(name);
			employee.setLastName(lastName);
			employee.setModifier(modifier);
			employee.setEnabled(enabled);
			employee.setId(newEmplId);
			updated=true;
		}


		return updated;
	}

	public Employee searchEmployee(String emplId) {
		boolean found=false;
		
		Employee empl=null;
		for(int i=0; i<employees.size() && !found;i++ ) {
			if(employees.get(i).getId().equals(emplId)) {
				empl=employees.get(i);
				found=true;						
			}
		}
		return empl;
		
		
	}

}
