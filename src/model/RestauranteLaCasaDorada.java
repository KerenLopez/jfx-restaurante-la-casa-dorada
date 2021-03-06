package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RestauranteLaCasaDorada {
	
	public final static String USERS_SAVE_PATH_FILE = "data/users.ackl";
	public final static String EMPLOYEES_SAVE_PATH_FILE = "data/employees.ackl";
	public final static String CLIENTS_SAVE_PATH_FILE = "data/clients.ackl";
	public final static String PRODUCTS_SAVE_PATH_FILE = "data/products.ackl";
	public final static String INGREDIENTS_SAVE_PATH_FILE = "data/ingredients.ackl";
	public final static String TYPE_OF_PROD_SAVE_PATH_FILE = "data/type-of-prods.ackl";
	public final static String ORDERS_SAVE_PATH_FILE = "data/orders.ackl";


	public final static String SEPARATOR = ";";
	private List<Order> orders;
	private List<Product> products;
	private List<Ingredient> ingredients;
	private List<TypeOfProduct> typesOfProducts;
	private List<Employee> employees;
	private List<Client> clients;
	private List<User> users;
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

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public List<TypeOfProduct> getTypesOfProducts() {
		return typesOfProducts;
	}

	public void setTypesOfProducts(List<TypeOfProduct> typesOfProducts) {
		this.typesOfProducts = typesOfProducts;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public boolean addIngredient(String name, String userId) throws IOException {
		Ingredient ingredient=searchIngredientByName(name);
		User creator=searchUser(userId);

		boolean added=false;
		if(ingredient==null) {
			ingredient= new Ingredient(name, creator, idIngredient);
			ingredients.add(ingredient);
			idIngredient++;
			added=true;
			saveDataIngredients();

		}

		return added;
	}

	public boolean deleteIngredient(int ingredientId) throws IOException {
		boolean deleted=false;
		Ingredient ing=searchIngredientById(ingredientId);
		if(ing!=null) {
			if(!searchProductIngredient(ingredientId)){
				int i=ingredients.indexOf(ing);
				ingredients.remove(i);
				deleted=true;
				saveDataIngredients();
			}
		}
		return deleted;
	}
	
	public boolean updateIngredient(String newName, int ingredientId, boolean enabled, String userId) throws IOException {
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
			saveDataIngredients();
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
	
	public List<TypeOfProduct> returnEnabledTypesOfProducts(){
		List<TypeOfProduct> list = new ArrayList<TypeOfProduct>();
		for(int k=0; k<typesOfProducts.size();k++) {
			if(typesOfProducts.get(k).isEnabled()) {
				list.add(typesOfProducts.get(k));
			}
		}
		return list;
	}

	public boolean addTypeOfProduct(String name, String userId) throws IOException {
		TypeOfProduct top=searchTypeOfProductByName(name);
		User creator=searchUser(userId);

		boolean added=false;
		if(top==null) {
			top= new  TypeOfProduct(name, creator, idTypeOfProduct);
			typesOfProducts.add(top);
			idTypeOfProduct++;
			added=true;
			saveDataTypesOfProducts();
		}
		return added;
	}
	
	public boolean deleteTypeOfProduct(int TpId) throws IOException {
		boolean deleted=false;
		TypeOfProduct top=searchTypeOfProductById(TpId);
		if(top!=null) {
			if(!searchProductTypeOfProduct(TpId)){
				int i=typesOfProducts.indexOf(top);
				typesOfProducts.remove(i);
				deleted=true;
				saveDataTypesOfProducts();
			}
		}
		return deleted;
	}

	public boolean updateTypeOfProduct(String newName, int TpId, boolean enabled, String userId) throws IOException {
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
			saveDataTypesOfProducts();
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
	
	public List<Ingredient> returnEnabledIngredients(){
		List<Ingredient> list = new ArrayList<Ingredient>();
		for(int k=0; k<ingredients.size();k++) {
			if(ingredients.get(k).isEnabled()) {
				list.add(ingredients.get(k));
			}
		}
		return list;
	}
	public List<Product> returnEnabledProducts(){
		List<Product> list = new ArrayList<Product>();
		for(int k=0; k<products.size();k++) {
			if(products.get(k).isEnabled()) {
				list.add(products.get(k));
			}
		}
		return list;
	}
	
	public boolean addProduct(String name, int type, String userId) throws IOException {
		Product p=searchProductByName(name);
		User creator=searchUser(userId);
		TypeOfProduct tp=searchTypeOfProductById(type);
		boolean added=false;
		if(p==null) {
			p= new Product(name, creator, tp, idProduct);
			products.add(p);
			idProduct++;
			added=true;
			saveDataProducts();
		}
		return added;
	}
	
	public boolean addIngredientToAProduct(Product p, Ingredient ing, String userId) throws IOException{
		List<Ingredient> list = p.getListOfIngredients();
		User modifier = searchUser(userId);
		boolean find = p.findIngredient(ing.getId());
		boolean added = false;
		if(find==false) {
			list.add(ing);
			p.setModifier(modifier);
			added = true;
			saveDataProducts();
		}
		return added;
	}
	
	public void deleteAnIngredientOfAProduct(Product p, Ingredient ing, String userId) throws IOException {
		User modifier = searchUser(userId);
		List<Ingredient> list = p.getListOfIngredients();
		list.remove(list.indexOf(ing));
		p.setModifier(modifier);
		saveDataProducts();
	}
	
	public boolean addSizeOfAProduct(Product p, String name, double price, String userId) throws IOException {
		List<Size> list = p.getSizes();
		User modifier = searchUser(userId);
		Size find = p.findSize(name);
		boolean added = false;
		if(find==null) {
			Size size = new Size(name, price, idSize);
			list.add(size);
			idSize++;
			p.setModifier(modifier);
			p.sortSizes();
			saveDataProducts();
			added = true;
		}
		return added;
	}
	
	public void deleteSizeOfAProduct(Product p, Size s) throws IOException {
		List<Size> list = p.getSizes();
		list.remove(list.indexOf(s));
		saveDataProducts();
	}
	
	public boolean updateSizeOfAProduct(Product p, Size selectedSize, String newName, double newPrice, String userId) throws IOException {
		User modifier = searchUser(userId);
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
			p.setModifier(modifier);
			saveDataProducts();
			updated = true;
		}
		return updated;
	}

	public boolean deleteProduct(Product product) throws IOException {
		boolean deleted = false;
		boolean stop = false; 
		boolean find = false;
		for(int k=0; k<orders.size() && !stop;k++) {
			find = orders.get(k).findProduct(product.getId());
			if(find==true) {
				stop = true;
			}
		}
		if(find==false) {
			int i=products.indexOf(product);
			products.remove(i);
			deleted = true;
			saveDataProducts();
		}
		return deleted;
	}

	public boolean updateProduct(Product p, String newName, boolean enabled, int TpId, String userId) throws IOException {
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
			saveDataProducts();
			updated=true;
		}
		return updated;
	}


	//search a product in the list of products by its name
	public Product searchProductByName(String pName) {
		boolean found=false;
		Product p=null;
		for(int i=0; i<products.size() && !found;i++ ) {
			if(products.get(i).getName().equalsIgnoreCase(pName)) {
				p=products.get(i);
				found=true;						
			}
		}
		return p;
	}
	
	//Bubble sorting
	public List<Product> sortingPricesOfProducts() {
    	List<Product> copyOfProducts = new ArrayList<Product>(products);
    	for(int i=1;i<copyOfProducts.size();i++) {
			for(int j=0;j<copyOfProducts.size()-i;j++) {
				if(!copyOfProducts.get(j).getSizes().isEmpty() && !copyOfProducts.get(j+1).getSizes().isEmpty()&& copyOfProducts.get(j).getSizes().get(0).getPrice()>copyOfProducts.get(j+1).getSizes().get(0).getPrice()) {
					Product temp = copyOfProducts.get(j);
					copyOfProducts.set(j, copyOfProducts.get(j+1));
					copyOfProducts.set(j+1, temp);
				}
			}
		}
		return copyOfProducts;
    }
	
	public void createOrder(Client sBuyer, Employee sDeliv, String obs, String userId) throws IOException {
		User creator = searchUser(userId);
		Client buyer=searchClient(sBuyer.getId());
		Employee deliverer= searchEmployee(sDeliv.getId());
		Order order= new  Order(buyer,deliverer,obs,creator);
		orders.add(order);
		int codeNum = ThreadLocalRandom.current().nextInt(1000, 10000);
		String code = codeNum+"-"+orders.size();
		order.setCode(code);
		saveDataOrders();
	}
	
	public boolean addProductsToAnOrder(Order selectedOrder, Product selectedProduct, Size selectedSize, int quantity, String userId) throws IOException {
		boolean added = false;
		User modifier = searchUser(userId);
		boolean findP = selectedOrder.findProduct(selectedProduct.getId());
		Size findS = selectedOrder.findSize(selectedOrder.getListOfSizes().indexOf(selectedSize));
		if(findP==false || findS==null) {
			selectedOrder.getListOfProducts().add(selectedProduct);
			selectedOrder.getListOfQuantity().add(quantity);
			selectedOrder.getListOfSizes().add(selectedSize);
			selectedOrder.setModifier(modifier);
			added = true;
			saveDataOrders();
		}
		return added;
	}
	
	public void deleteProductsOfAnOrder(Order selectedOrder, Product selectedProduct, String userId) throws IOException {
		User modifier = searchUser(userId);
		int indexOfOrder = selectedOrder.getListOfProducts().indexOf(selectedProduct);
		selectedOrder.getListOfProducts().remove(indexOfOrder);
		selectedOrder.getListOfQuantity().remove(indexOfOrder);
		selectedOrder.getListOfSizes().remove(indexOfOrder);
		selectedOrder.setModifier(modifier);
		saveDataOrders();
	}
	
	public void updateStateOfAnOrder(Order selectedOrder, String newState) throws IOException {
		selectedOrder.updateState(newState);
		if(newState.equals(State.ENTREGADO.name())) {
			selectedOrder.getDeliverer().setNumberOrders((selectedOrder.getDeliverer().getNumberOrders())+1);
			selectedOrder.getDeliverer().setSumTotalOrders((selectedOrder.getDeliverer().getSumTotalOrders())+(selectedOrder.getOrderTotalPrice()));
		}
		saveDataOrders();
	}
	
	public void updateOrder(Order selectedOrder, Client selectedClient, Employee selectedEmployee, String obs, String userId) throws IOException {
		User modifier = searchUser(userId);
		selectedOrder.setModifier(modifier);
		selectedOrder.setBuyer(selectedClient);
		selectedOrder.setDeliverer(selectedEmployee);
		selectedOrder.setObservations(obs);
		saveDataOrders();
	}
	
	public Size getSelectedSize(Order selectedOrder, Product selectedProduct) {
		int indexProduct = selectedOrder.getListOfProducts().indexOf(selectedProduct);
		Size selectedSize = selectedOrder.findSize(indexProduct);
		return selectedSize;
	}
	
	public int getQuantity(Order selectedOrder, Product selectedProduct){
		int indexProduct = selectedOrder.getListOfProducts().indexOf(selectedProduct);
		int quantity = selectedOrder.findQuantity(indexProduct);
		return quantity;
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
			if(users.get(i).getEmployee().getId().equals(empl.getId())) {
				
				u=users.get(i);
				found=true;
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

		
	public List<Client>  returnEnabledClients() {
		List<Client> clString= new ArrayList<Client>();
		for(int i=0; i<clients.size(); i++) {
			if(clients.get(i).isEnabled()) {
				clString.add(clients.get(i));
			}
		}
		return clString;
	}
	
	public List<Employee>  enabledEmployees() {
		List<Employee> empls= new ArrayList<Employee>();
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
					if(!users.get(i).isEnabled()) {
						id="";
					}
				}
			}

		}
		return id;
	}
	
	public List<String> getHours(){
		List<String> allHours = new ArrayList<String>();
		String[] hours = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
		allHours = Arrays.asList(hours);
		return allHours;
	}
	
	public List<String> getMinutes(){
		List<String> allMinutes = new ArrayList<String>();
		String[] minutes = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59"};
		allMinutes = Arrays.asList(minutes);
		return allMinutes;
	}
	
	public List<Order> sortByDateAndTime() {
		List<Order> copyOfOrders = new ArrayList<Order>(orders);
		Collections.sort(copyOfOrders);
		return copyOfOrders;
	}
	
	public List<Order> selectedOrders(String initialTime, String finalTime){
		boolean correct = false;
		List<Order> selectedOrders = new ArrayList<Order>();
		List<Order> sortingOrders = sortByDateAndTime();
		for(int k=0; k<sortingOrders.size();k++) {
			correct = compareWithInitialAndFinalDate(sortingOrders.get(k),initialTime,finalTime);
			if(correct==true){
				selectedOrders.add(sortingOrders.get(k));
			}
		}
		return selectedOrders;
	}
	
	public List<Order> selectDeliveredOrders(String initialTime, String finalTime){
		boolean correct = false;
		List<Order> selectedOrders = new ArrayList<Order>();
		List<Order> sortingOrders = sortByDateAndTime();
		for(int k=0; k<sortingOrders.size();k++) {
			correct = compareWithInitialAndFinalDate(sortingOrders.get(k),initialTime,finalTime);
			if(correct==true && sortingOrders.get(k).getStateOfOrder().name().equals("ENTREGADO")){
				Order ord = sortingOrders.get(k);
				for(int j=0;j<ord.getListOfProducts().size();j++) {
					Product p = ord.getListOfProducts().get(j);
					p.setNumTimesAddedOrders((p.getNumTimesAddedOrders())+(ord.getListOfQuantity().get(j)));
					p.setTotalPriceAddedOrders((p.getTotalPriceAddedOrders())+(ord.getListOfQuantity().get(j)*ord.getListOfSizes().get(j).getPrice()));
				}
				selectedOrders.add(ord);
			}
		}
		return selectedOrders;
	}
	
	public boolean compareWithInitialAndFinalDate(Order order, String initialTime, String finalTime) {
		boolean correct = false;
		Date date1 = null;
		Date date2 = null;
		Date dateOrder = null;
		String strFormat = "yyyy-MM-dd HH:mm";
		SimpleDateFormat formato = new SimpleDateFormat(strFormat);
		try {
			date1 = formato.parse(initialTime);
			date2 = formato.parse(finalTime);
			dateOrder = formato.parse(order.getDateAndHour());
			int result1 = dateOrder.compareTo(date1);
			int result2 = dateOrder.compareTo(date2);
			if((result1>0 || result1==0)&&(result2<0||result2==0)) {
				correct = true;
			}
		} catch (ParseException ex) {
			ex.printStackTrace();
		} 
		return correct;
	}
	
	public void exportOrdersReport(String fn, String initialTime, String finalTime, String separator) throws FileNotFoundException {
		List<Order> ordersS = selectedOrders(initialTime,finalTime);
		PrintWriter pw = new PrintWriter(fn);
		String info ="";
		String nameColumns = "C?digo"+separator+"Estado"+separator+"Fecha y hora"+separator+"Observaciones"+separator+"Nombre del cliente"+separator+"Direccion del cliente"+separator+"Telefono del cliente"+separator+"Empleado"+separator+"Producto(s): Nombre, cantidad, tamanio y valor";
		for(int i=0;i<ordersS.size();i++){
			Order objOrder = ordersS.get(i);
			info+=objOrder.getCode()+separator+objOrder.getStateOfOrder().name()+separator+objOrder.getDateAndHour()+separator+objOrder.getObservations()+separator+objOrder.getClientName()+separator+objOrder.getBuyer().getAddress()+separator+objOrder.getBuyer().getPhone()+separator+objOrder.getEmployeeName()+separator;
			for(int k=0;k<objOrder.getListOfProducts().size();k++) {
				info += objOrder.getListOfProducts().get(k).getName()+separator;
				info += objOrder.getListOfQuantity().get(k)+separator;
				info += objOrder.getListOfSizes().get(k).getName()+separator; 
				info += objOrder.getListOfSizes().get(k).getPrice(); 
				int listSize = objOrder.getListOfProducts().size();
				if(k<listSize) {
					info+=separator;
				}
			}
			if(i!=ordersS.size()-1) {
				info+="\n";
			}
		}
		pw.println(nameColumns);
		pw.print(info);
		pw.close();
	}
	
	public void exportEmployeesReport(String fn, String initialTime, String finalTime) throws FileNotFoundException {
		int totalOrders=0;
		int totalMoney=0;
		List<Order> ordersS = selectDeliveredOrders(initialTime,finalTime);
		
		PrintWriter pw = new PrintWriter(fn);
		String nameColumns = "Empleado"+SEPARATOR+"Identificacion"+SEPARATOR+"N?mero de ordenes entregadas"+SEPARATOR+"Precio total de las ordenes entregadas";
		pw.println(nameColumns);
		
		for(int k=0;k<ordersS.size();k++) {
			ordersS.get(k).getDeliverer().setCont(0);
		}
		for(int i=0;i<ordersS.size();i++){
			Order objOrder = ordersS.get(i);
			objOrder.getDeliverer().setCont((objOrder.getDeliverer().getCont())+1);

			if(objOrder.getDeliverer().getCont()==1) {
				pw.println(objOrder.getDeliverer().getName()+SEPARATOR+objOrder.getDeliverer().getId()+SEPARATOR+objOrder.getDeliverer().getNumberOrders()+SEPARATOR+objOrder.getDeliverer().getSumTotalOrders());
				totalOrders+=objOrder.getDeliverer().getNumberOrders();
				totalMoney+=objOrder.getDeliverer().getSumTotalOrders();
			}
		}
		pw.println(SEPARATOR+"Total"+SEPARATOR+totalOrders+SEPARATOR+totalMoney);

		pw.close();
		
		
	}
	
	public void exportProductsReport(String fn, String initialTime, String finalTime) throws FileNotFoundException {
		int totalOrders=0;
		int totalMoney=0;
		List<Order> ordersS = selectDeliveredOrders(initialTime,finalTime);
		PrintWriter pw = new PrintWriter(fn);
		String nameColumns = "Nombre del producto"+SEPARATOR+"Numero total de veces que fue pedido"+SEPARATOR+"Cantidad de total de dinero recaudado";
		pw.println(nameColumns);
		for(int i=0;i<ordersS.size();i++){
			Order objOrder = ordersS.get(i);
			for(int k=0;k<objOrder.getListOfProducts().size();k++) {
				Product pd = objOrder.getListOfProducts().get(k);
				pd.setCont((pd.getCont())+1);
				if(pd.getCont()==1) {
					pw.println(pd.getName()+SEPARATOR+pd.getNumTimesAddedOrders()+SEPARATOR+pd.getTotalPriceAddedOrders());
					totalOrders+=pd.getNumTimesAddedOrders();
					totalMoney+=pd.getTotalPriceAddedOrders();
				}
			}
		}
		pw.println("Total"+SEPARATOR+totalOrders+SEPARATOR+totalMoney);

		pw.close();
		for(int j=0;j<ordersS.size();j++) {
			Order ord = ordersS.get(j);
			for(int k=0;k<ord.getListOfProducts().size();k++) {
				Product p = ord.getListOfProducts().get(k);
				p.setNumTimesAddedOrders(0);
				p.setTotalPriceAddedOrders(0);
				p.setCont(0);
			}
		}
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
		User userEmpl=searchEmployeeInUsers(employee);
		Order orderEmpl=searchEmployeeInOrder(employee);
		if(userEmpl==null && orderEmpl==null) {
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
			if(orders.get(i).getDeliverer().getId().equals(empl.getId())) {
								
				order=orders.get(i);
				found=true;
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
			if(orders.get(i).getBuyer().getId().equals(client.getId())) {
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
	
	public int binarySearchClient(String clientNames, String clientLastNames) {
		
		Client client= new Client(clientNames,clientLastNames,null,null,null,null, null);
		Comparator<Client> clientLastNameAndNameComparator=new ClientLastNameAndNameComparator();
		
		int pos = -1;
		int i=0;
		int j=clients.size()-1;
		
		while(i<=j && pos<0){
			int m= (i+j)/2;
			
			if(clientLastNameAndNameComparator.compare(clients.get(m),client)==0){
				pos =m;
			}else if(clientLastNameAndNameComparator.compare(clients.get(m),client)<0){
				j=m-1;
			}else{
				i=m+1;
			}
			
		
		}
		
		return pos;
	}
	
	public List<Client> searchClientByName(String clientNames, String clientLastNames){
		Comparator<Client> clientLastNameAndNameComparator=new ClientLastNameAndNameComparator();
		List<Client> clientsByName=new ArrayList<Client>();
		int pos;

		pos=binarySearchClient(clientNames,clientLastNames);
		int sameUp=1;
		int sameDown=1;
		if(pos>=0) {
			if(clients.get(pos).isEnabled()) {
				clientsByName.add(clients.get(pos));
			}
			
			boolean same=false;
			do {
				same=false;
				if((pos-sameDown)>=0 && clientLastNameAndNameComparator.compare(clients.get(pos), clients.get(pos-sameDown))==0) {
					if(clients.get(pos-sameDown).isEnabled()) {
						clientsByName.add(clients.get(pos-sameDown));
						sameDown++;
						same=true;
					}
				}

				if((pos+sameUp)<=clients.size()-1 && clientLastNameAndNameComparator.compare(clients.get(pos), clients.get(pos+sameUp))==0) {
					if(clients.get(pos+sameUp).isEnabled()) {
						clientsByName.add(clients.get(pos+sameUp));
						sameUp++;
						same=true;
					}
				}
			}while(same);
					
		}

		return clientsByName;
	}
	
	public List<Ingredient> insertionSortIngredients() {
		List<Ingredient> listSorted=new ArrayList<Ingredient>(ingredients);
		
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
			users = (List<User>)ois.readObject();
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
			employees = (List<Employee>)ois.readObject();
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
			clients = (List<Client>)ois.readObject();
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
			products = (List<Product>)ois.readObject();
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
			ingredients = (List<Ingredient>)ois.readObject();
			ois.close();
			loaded = true;
		}
		return loaded;
	}
	
	@SuppressWarnings("unchecked")
	public boolean loadDataTypesOfProducts() throws IOException, ClassNotFoundException{
		File f = new File(TYPE_OF_PROD_SAVE_PATH_FILE);
		boolean loaded = false;
		if(f.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			typesOfProducts = (List<TypeOfProduct>)ois.readObject();
			ois.close();
			loaded = true;
		}
		return loaded;
	}
	
	@SuppressWarnings("unchecked")
	public boolean loadDataOrders() throws IOException, ClassNotFoundException{
		File f = new File(ORDERS_SAVE_PATH_FILE);
		boolean loaded = false;
		if(f.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			orders = (List<Order>)ois.readObject();
			ois.close();
			loaded = true;
		}
		return loaded;
	}
	
	public void importClientsData(String fileName) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();
		while(line!=null){
			String[] parts = line.split(";");
			if(!parts[0].equals("id")) {

				createClient( parts[0],  parts[1].toUpperCase(),  parts[2].toUpperCase(),  parts[3],  parts[4],  parts[5],  "");
			}
			
			line = br.readLine();
		}
	    br.close();
	}
	
	
	public void importProductsData(String fileName) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();
		String creator="";
		while(line!=null){
			String[] parts = line.split(";");
			if(!parts[0].equals("productName")) {
				addTypeOfProduct(parts[1],creator);
				TypeOfProduct top=searchTypeOfProductByName(parts[1]);
				Product prod=new Product(parts[0], null, top, idProduct);
				this.products.add(prod);
				idProduct++;
				String[] ingredients=parts[2].split("-");

				for(int i=0; i<ingredients.length;i++) {
					Ingredient ing= new Ingredient(ingredients[i], null, idIngredient);
					this.ingredients.add(ing);
					idIngredient++;
					
					addIngredientToAProduct( prod,  ing,  creator);

				}
				double price= Double.parseDouble(parts[4]);
				addSizeOfAProduct( prod,  parts[3],  price,creator); 

			}
			
			line = br.readLine();
		}
	    br.close();
	    saveDataIngredients();

	}

	public void importOrdersData(String fileName) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();
		String creator="";
		while(line!=null){
			String[] parts = line.split(SEPARATOR);
			if(!parts[0].equals("clientId")) {
				
				Client buyer=new Client(parts[1].toUpperCase(), parts[2].toUpperCase(), parts[0], parts[3], parts[4], parts[5], null);
				addSortedClient(buyer);
				Employee deliverer=searchEmployee(parts[6]);
				if(deliverer==null) {
					createEmployee( parts[6],  parts[7].toUpperCase(),  parts[8].toUpperCase(),  creator);
					deliverer=searchEmployee(parts[6]);

				}
				
				Order order=new Order(buyer, deliverer, parts[9], null);
				orders.add(order);
				int codeNum = ThreadLocalRandom.current().nextInt(1000, 10000);
				String code = codeNum+"-"+orders.size();
				order.setCode(code);

				addTypeOfProduct(parts[11],creator);
				TypeOfProduct top=searchTypeOfProductByName(parts[11]);
				Product prod=new Product(parts[10], null, top, idProduct);
				products.add(prod);
				idProduct++;

				Ingredient ing= new Ingredient(parts[12], null, idIngredient);
				ingredients.add(ing);
				idIngredient++;

				addIngredientToAProduct( prod,  ing,  creator);

				double price= Double.parseDouble(parts[14]);

				addSizeOfAProduct( prod,  parts[13],  price,creator); 
				int quantity=Integer.parseInt(parts[15]);
				addProductsToAnOrder(order, prod, prod.getSizes().get(0), quantity, creator);
				saveDataOrders();
				saveDataIngredients();
				saveDataProducts();
				saveDataTypesOfProducts();
				saveDataEmployees();
				saveDataClients();

			}
			line = br.readLine();
		}
	    br.close();
	}

	public int getIdIngredient() {
		return idIngredient;
	}


	public void setIdIngredient(int idIngredient) {
		this.idIngredient = idIngredient;
	}


	public int getIdProduct() {
		return idProduct;
	}


	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}


	public int getIdTypeOfProduct() {
		return idTypeOfProduct;
	}


	public void setIdTypeOfProduct(int idTypeOfProduct) {
		this.idTypeOfProduct = idTypeOfProduct;
	}


	public int getIdSize() {
		return idSize;
	}


	public void setIdSize(int idSize) {
		this.idSize = idSize;
	}

}

