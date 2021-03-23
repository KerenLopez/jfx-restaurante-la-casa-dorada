package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RestauranteLaCasaDorada{
	
	public final static String USERS_SAVE_PATH_FILE = "data/users.ackl";
	public final static String EMPLOYEES_SAVE_PATH_FILE = "data/employees.ackl";
	public final static String CLIENTS_SAVE_PATH_FILE = "data/clients.ackl";
	public final static String PRODUCTS_SAVE_PATH_FILE = "data/products.ackl";
	public final static String INGREDIENTS_SAVE_PATH_FILE = "data/users.ackl";
	public final static String TYPE_OF_PROD_SAVE_PATH_FILE = "data/users.ackl";
	public final static String ORDERS_SAVE_PATH_FILE = "data/users.ackl";


	
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
		Ingredient ing = searchIngredientById(ingredientId);
		Ingredient ing1 = searchIngredientByName(newName);
		boolean updated=false;
		boolean findIngredient = false;
		
		if(ing!=ing1) {
			if(ing1!=null) {
				findIngredient = true;
			}
		}

		if(!findIngredient) {
			ing.setEnabled(enabled);
			ing.setName(newName);
			ing.setModifier(searchUser(userId));
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
	public Ingredient searchIngredientByName(String ingredientName) {
		boolean found=false;
		Ingredient ing=null;
		for(int i=0; i<ingredients.size() && !found;i++ ) {
			if(ingredients.get(i).getName().equalsIgnoreCase(ingredientName)) {
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
	
	public ArrayList<TypeOfProduct> returnEnabledTypesOfProducts(){
		ArrayList<TypeOfProduct> list = new ArrayList<TypeOfProduct>();
		for(int k=0; k<typesOfProducts.size();k++) {
			if(typesOfProducts.get(k).isEnabled()) {
				list.add(typesOfProducts.get(k));
			}
		}
		return list;
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

	public boolean updateTypeOfProduct(String newName, int TpId, boolean enabled, String userId) {
		TypeOfProduct Tp=searchTypeOfProductById(TpId);
		TypeOfProduct Tp1=searchTypeOfProductByName(newName);
		boolean updated=false;
		boolean findTp = false;
		if(Tp!=Tp1) {
			if(Tp1!=null) {
				findTp=true;
			}
		}

		if(!findTp) {
			Tp.setEnabled(enabled);
			Tp.setName(newName);
			Tp.setModifier(searchUser(userId));
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
	
	public ArrayList<Ingredient> returnEnabledIngredients(){
		ArrayList<Ingredient> list = new ArrayList<Ingredient>();
		for(int k=0; k<ingredients.size();k++) {
			if(ingredients.get(k).isEnabled()) {
				list.add(ingredients.get(k));
			}
		}
		return list;
	}
	public ArrayList<Product> returnEnabledProducts(){
		ArrayList<Product> list = new ArrayList<Product>();
		for(int k=0; k<products.size();k++) {
			if(products.get(k).isEnabled()) {
				list.add(products.get(k));
			}
		}
		return list;
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
		Size find = p.findSize(name);
		boolean added = false;
		if(find==null) {
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
		Size s = p.findSize(newName);
		boolean updated = false;
		boolean findSize =false;
		if(selectedSize!=s) {
			if(s!=null) {
				findSize=true;
			}
		}
		
		if(!findSize) {
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
		boolean findProduct = false;
		Product product = searchProductByName(newName);
		
		if(p!=product) {
			if(product!=null) {
				findProduct =true;
			}
		}
		if(!findProduct) {
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
	
	public Size getSelectedSize(Product selectedProduct) {
		
	}
	
	public int getQuantity(Product selectedProduct){
		
	}
	

	public boolean createUser(Employee empl, String userName, String password, String creatorId) throws IOException{
		boolean created=false;
		
		if(searchEmployeeInUsers(empl)==null && !searchUserName(userName)) {

			
			User user=new User(empl, userName, password);
			
			User creator=searchUser(creatorId);
			
			user.setCreator(creator);

			users.add(user);
			created=true;
			saveDataUsers();

		}
		

		return created;
	}
	
	public boolean deleteUser(User user) throws IOException {
		boolean deleted=false;
		if(!searchUserInCreatedObjects(user)) {
			int i=users.indexOf(user);
			users.remove(i);
			deleted=true;
			saveDataUsers();

		}
		

		return deleted;
	}
	
	public boolean searchUserInCreatedObjects(User user) {
		boolean found=false;
		for(int i=0; i<orders.size() && !found;i++) {
			if(orders.get(i).getCreator()==user ||  orders.get(i).getModifier()==user) {
				found=true;
			}
		}
		if(!found) {
			for(int i=0; i<products.size() && !found;i++) {
				if(products.get(i).getCreator()==user ||  products.get(i).getModifier()==user) {
					found=true;
				}
			}
		}
		
		if(!found) {
			for(int i=0; i<ingredients.size() && !found;i++) {
				if(ingredients.get(i).getCreator()==user ||  ingredients.get(i).getModifier()==user) {
					found=true;
				}
			}
		}
		
		if(!found) {
			for(int i=0; i<typesOfProducts.size() && !found;i++) {
				if(typesOfProducts.get(i).getCreator()==user ||  typesOfProducts.get(i).getModifier()==user) {
					found=true;
				}
			}
		}
		
		if(!found) {
			for(int i=0; i<employees.size() && !found;i++) {
				if(employees.get(i).getCreator()==user ||  employees.get(i).getModifier()==user) {
					found=true;
				}
			}
		}
		
		if(!found) {
			for(int i=0; i<clients.size() && !found;i++) {
				if(clients.get(i).getCreator()==user ||  clients.get(i).getModifier()==user) {
					found=true;
				}
			}
		}
		
		if(!found) {
			for(int i=0; i<users.size() && !found;i++) {
				if(users.get(i).getCreator()==user ||  users.get(i).getModifier()==user) {
					found=true;
				}
			}
		}

		return found;
	}
	
	
	
	public boolean updateUser(String userId,Employee empl, String userName, String password, boolean enabled,String modifierId) throws IOException {
		boolean updated=false;
		
		User user=searchUser(userId);
		User u=null;
		if(user.getEmployee()!=empl) {
			u=searchEmployeeInUsers(empl);
		}
		
		boolean findUName=false;
		if(!user.getUserName().equals(userName)) {
			findUName=searchUserName(userName);
		}
		if(u==null && !findUName) {
			User modifier=searchUser(modifierId);
			
			user.setUserName(userName);
			user.setPassword(password);
			user.setModifier(modifier);
			user.setEmployee(empl);
			user.setEnabled(enabled);
			user.setId(empl.getId());
			updated=true;
			saveDataUsers();
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
	public User searchEmployeeInUsers(Employee empl) {
		User u=null;
		boolean found=false;
		for(int i=0; i<users.size() && !found;i++) {
			if(users.get(i).getEmployee()==empl) {
				found=true;
				u=users.get(i);
			}

		}
		return u;
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

		
	public ArrayList<Client>  returnEnabledClients() {
		ArrayList<Client> clString= new ArrayList<Client>();
		for(int i=0; i<clients.size(); i++) {
			if(clients.get(i).isEnabled()) {
				clString.add(clients.get(i));
			}
		}
		return clString;
	}
	
	public ArrayList<Employee>  enabledEmployees() {
		ArrayList<Employee> empls= new ArrayList<Employee>();
		for(int i=0; i<employees.size(); i++) {
			if(employees.get(i).isEnabled()) {
				empls.add(employees.get(i));

			}
		}
		return empls;
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


	public boolean createEmployee(String id, String name, String lastName, String creatorId) throws IOException {

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
			saveDataEmployees();
			
		}
		


		return created;
	}
	
	public boolean deleteEmployee(String emplId) throws IOException {
		boolean deleted=false;
		Employee employee=searchEmployee(emplId);
		if(searchEmployeeInUsers(employee)==null && searchEmployeeInOrder(employee)==null) {
			int i=employees.indexOf(employee);
			employees.remove(i);
			deleted=true;
			saveDataEmployees();

		}
		
		return deleted;

	}
	public Order searchEmployeeInOrder(Employee empl) {
		Order order=null;
		boolean found=false;
		for(int i=0; i<orders.size() && !found;i++) {
			if(orders.get(i).getDeliverer()==empl) {
				found=true;
				order=orders.get(i);
			}

		}
		return order;
	}
	
	public boolean updateEmployee(String oldEmplId,String newEmplId, String name, String lastName, boolean enabled,String modifierId) throws IOException {
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
			User u= searchEmployeeInUsers(employee);
			employee.setName(name);
			employee.setLastName(lastName);
			employee.setModifier(modifier);
			employee.setEnabled(enabled);
			employee.setId(newEmplId);
			if(u!=null) {
				u.setId(newEmplId);
			}
			updated=true;
			saveDataEmployees();
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
	

	public boolean createClient(String id, String name, String lastName, String address, String phone, String observations, String creatorId) throws IOException {
		boolean created=false;

		Client client= searchClient(id);
		User creator;


		if(client==null) {
			
			creator=searchUser(creatorId);
			
			client= new Client(name,lastName,id,address,phone,observations, creator);
			addSortedClient(client);
			created=true;
			saveDataClients();
			
		}
		


		return created;
	}
	
	public void addSortedClient(Client client) {
		//AGREGAR DE FORMA ORDENADA ALFABETICAMENTE DESCENDENTE APELLIDOS Y NOMBRES 
		Comparator<Client> clientLastNameAndNameComparator=new ClientLastNameAndNameComparator();
		
		if(clients.isEmpty()) {
			clients.add(client);
		}
		else {
			int i=0;
			while(i<clients.size() && clientLastNameAndNameComparator.compare(clients.get(i),client)>0) {
				i++;
			}
			clients.add(i, client);
		}

	}
	
	public Client searchClient(String clientId) {
		boolean found=false;
		
		Client client=null;
		for(int i=0; i<clients.size() && !found;i++ ) {
			if(clients.get(i).getId().equals(clientId)) {
				client=clients.get(i);
				found=true;						
			}
		}
		return client;
		
	}
	
	public boolean deleteClient(Client client) throws IOException {
		boolean deleted=false;
		if(searchClientInOrder(client)==null) {
			int i=clients.indexOf(client);
			clients.remove(i);
			deleted=true;
			saveDataClients();

		}
				
		return deleted;

	}
	
	public Order searchClientInOrder(Client client) {
		Order order=null;
		boolean found=false;
		for(int i=0; i<orders.size() && !found;i++) {
			if(orders.get(i).getBuyer()==client) {
				found=true;
				order=orders.get(i);
			}

		}
		return order;
	}


	public boolean updateClient(Client client, String newClientId, String name, String lastName, String address, String phone, String observations, boolean enabled, String modifierId) throws IOException {
		boolean updated=false;

		Client client2= searchClient(newClientId);

		boolean findClient=false;
		if(client!=client2) {
			if(client2!=null) {
				findClient=true;
			}
		}

		if(!findClient) {
			boolean sortList=false;
			if(!client.getLastName().equals(lastName) || !client.getName().equals(name) ) {
				sortList= true;
			}
			User modifier=searchUser(modifierId);
			client.setName(name);
			client.setLastName(lastName);
			client.setModifier(modifier);
			client.setEnabled(enabled);
			client.setId(newClientId);
			client.setAddress(address);
			client.setPhone(phone);
			client.setObservations(observations);
			
			updated=true;
			
			if(sortList) {
				Comparator<Client> clientLastNameAndNameComparator=new ClientLastNameAndNameComparator();

				Collections.sort(clients,Collections.reverseOrder(clientLastNameAndNameComparator));
			}
			saveDataClients();
		}


		return updated;

	}
	
	public int binarySearchClient(String clientNames, String clientLastNames, int posFind) {
		
		Client client= new Client(clientNames,clientLastNames,null,null,null,null, null);
		Comparator<Client> clientLastNameAndNameComparator=new ClientLastNameAndNameComparator();
		
		int pos = -1;
		int i=0;
		int j=clients.size()-1;
		
		while(i<=j && pos<0){
			int m= (i+j)/2;
			if(m!= posFind && clientLastNameAndNameComparator.compare(clients.get(m),client)==0){
				pos =m;
			}else if(clientLastNameAndNameComparator.compare(clients.get(m),client)<0){
				j=m-1;
			}else{
				i=m+1;
			}
		}
		
		return pos;
	}
	
	public ArrayList<Client> searchClientByName(String clientNames, String clientLastNames){
		ArrayList<Client> clientsByName=new ArrayList<Client>();
		int pos;
		int posFind=-1;
		do {
			pos=binarySearchClient(clientNames,clientLastNames, posFind);

			if(pos>=0) {
				if(clients.get(pos).isEnabled()) {
					clientsByName.add(clients.get(pos));
				}
			}
			posFind=pos;
		}while(pos>=0);

		return clientsByName;
	}
	
	public ArrayList<Ingredient> insertionSortIngredients() {
		ArrayList<Ingredient> listSorted=new ArrayList<Ingredient>(ingredients);
		
		for(int i=1;i<listSorted.size();i++) {
			for(int j=i;j>0 && listSorted.get(j-1).getName().compareTo(listSorted.get(j).getName())<0;j--) {
				Ingredient temp=listSorted.get(j);
				listSorted.set(j, listSorted.get(j-1));
				listSorted.set(j-1, temp);
			}
		}
		return listSorted;
	}
	

	public void saveDataUsers() throws IOException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_SAVE_PATH_FILE));
		oos.writeObject(users);
		oos.close();
	}
	
	public void saveDataEmployees() throws IOException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(EMPLOYEES_SAVE_PATH_FILE));
		oos.writeObject(employees);
		oos.close();
	}
	
	public void saveDataClients() throws IOException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CLIENTS_SAVE_PATH_FILE));
		oos.writeObject(clients);
		oos.close();
	}
	
	public void saveDataProducts() throws IOException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PRODUCTS_SAVE_PATH_FILE));
		oos.writeObject(products);
		oos.close();
	}
	
	public void saveDataIngredients() throws IOException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(INGREDIENTS_SAVE_PATH_FILE));
		oos.writeObject(ingredients);
		oos.close();
	}
	
	public void saveDataTypesOfProducts() throws IOException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(TYPE_OF_PROD_SAVE_PATH_FILE));
		oos.writeObject(typesOfProducts);
		oos.close();
	}
	
	public void saveDataOrders() throws IOException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ORDERS_SAVE_PATH_FILE));
		oos.writeObject(orders);
		oos.close();
	}
	
	@SuppressWarnings("unchecked")
	public boolean loadDataUsers() throws IOException, ClassNotFoundException{
		File f = new File(USERS_SAVE_PATH_FILE);
		boolean loaded = false;
		if(f.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			users = (ArrayList<User>)ois.readObject();
			ois.close();
			loaded = true;
		}
		return loaded;
	}
	
	@SuppressWarnings("unchecked")
	public boolean loadDataEmployees() throws IOException, ClassNotFoundException{
		File f = new File(EMPLOYEES_SAVE_PATH_FILE);
		boolean loaded = false;
		if(f.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			employees = (ArrayList<Employee>)ois.readObject();
			ois.close();
			loaded = true;
		}
		return loaded;
	}
	
	@SuppressWarnings("unchecked")
	public boolean loadDataClients() throws IOException, ClassNotFoundException{
		File f = new File(CLIENTS_SAVE_PATH_FILE);
		boolean loaded = false;
		if(f.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			clients = (ArrayList<Client>)ois.readObject();
			ois.close();
			loaded = true;
		}
		return loaded;
	}
	
	@SuppressWarnings("unchecked")
	public boolean loadDataProducts() throws IOException, ClassNotFoundException{
		File f = new File(PRODUCTS_SAVE_PATH_FILE);
		boolean loaded = false;
		if(f.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			products = (ArrayList<Product>)ois.readObject();
			ois.close();
			loaded = true;
		}
		return loaded;
	}
	
	@SuppressWarnings("unchecked")
	public boolean loadDataIngredients() throws IOException, ClassNotFoundException{
		File f = new File(INGREDIENTS_SAVE_PATH_FILE);
		boolean loaded = false;
		if(f.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			ingredients = (ArrayList<Ingredient>)ois.readObject();
			ois.close();
			loaded = true;
		}
		return loaded;
	}
	
	@SuppressWarnings("unchecked")
	public boolean loadDataTypesOfProducts() throws IOException, ClassNotFoundException{
		File f = new File(CLIENTS_SAVE_PATH_FILE);
		boolean loaded = false;
		if(f.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			typesOfProducts = (ArrayList<TypeOfProduct>)ois.readObject();
			ois.close();
			loaded = true;
		}
		return loaded;
	}
	
	@SuppressWarnings("unchecked")
	public boolean loadDataOrders() throws IOException, ClassNotFoundException{
		File f = new File(CLIENTS_SAVE_PATH_FILE);
		boolean loaded = false;
		if(f.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			orders = (ArrayList<Order>)ois.readObject();
			ois.close();
			loaded = true;
		}
		return loaded;
	}
	


}
