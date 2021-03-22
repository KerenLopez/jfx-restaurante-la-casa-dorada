package ui;

import java.io.IOException;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import model.Client;
import model.Employee;
import model.Ingredient;
import model.Order;
import model.Product;
import model.RestauranteLaCasaDorada;
import model.Size;
import model.TypeOfProduct;
import model.User;

public class RestauranteLaCasaDoradaGUI {
	
	private RestauranteLaCasaDorada restauranteLaCasaDorada;
	
	@FXML
	private BorderPane mainPanel;
	
	@FXML
	private VBox createProductForm;
	
	@FXML
    private VBox sizeForm;
	
	@FXML
    private VBox ingredientForm;
	
	@FXML
    private VBox createOrderForm;

	@FXML
	private TextField txtIngredientName;
	
	@FXML
    private TextField txtTypeOfProductName;
	
	@FXML
	private TextField txtProductName;
	
	@FXML
    private TextField txtSizeName;

    @FXML
    private TextField txtSizePrice;
    
    @FXML
    private TextArea txtAreaObservations;
    
    @FXML
    private TextField txtProductQuantity;
	
	@FXML
	private Label lbUserName;
	
	@FXML
    private Label lbObjectId;
	
	@FXML
	private Label lbUserId;

	@FXML
	private ComboBox<TypeOfProduct> cmbxTypeOfProduct;

	@FXML
	private ComboBox<Client> cmbxClients;

	@FXML
    private TableView<Ingredient> tvOfIngredients;

    @FXML
    private TableColumn<Ingredient, String> colNameIngredient;

    @FXML
    private TableColumn<Ingredient, String> colStatusIngredient;

    @FXML
    private TableColumn<Ingredient, String> colCreatorIngredient;

    @FXML
    private TableColumn<Ingredient, String> colModifierIngredient;
    
    @FXML
    private TableView<TypeOfProduct> tvOfTypeOfProducts;

    @FXML
    private TableColumn<TypeOfProduct, String> colNameTypeOfProduct;

    @FXML
    private TableColumn<TypeOfProduct, String> colStatusTypeOfProduct;

    @FXML
    private TableColumn<TypeOfProduct, String> colCreatorTypeOfProduct;

    @FXML
    private TableColumn<TypeOfProduct, String> colModifierTypeOfProduct;
    
    @FXML
    private TableView<Product> tvOfProducts;

    @FXML
    private TableColumn<Product, String> colNameProduct;

    @FXML
    private TableColumn<Product, String> colStatusProduct;

    @FXML
    private TableColumn<Product, String> colCreatorProduct;

    @FXML
    private TableColumn<Product, String> colModifierProduct;

    @FXML
    private TableView<Size> tvOfSizes;

    @FXML
    private TableColumn<Size, String> colNameSize;

    @FXML
    private TableColumn<Size, Double> colSizePrice;
    
    @FXML
    private TableView<Product> tvOfAddedProducts;

    @FXML
    private TableColumn<Product, String> colNameAddedProduct;

    @FXML
    private TableView<Order> tvOfOrders;

    @FXML
    private TableColumn<Order, String> colCodeOrder;

    @FXML
    private TableColumn<Order, String> colStateOrder;

    @FXML
    private TableColumn<Order, String> colDateandTimeOrder;

    @FXML
    private TableColumn<Order, String> colClientOrder;

    @FXML
    private TableColumn<Order, String> colEmployeeOrder;

    @FXML
    private TableColumn<Order, String> colCreatorOrder;

    @FXML
    private TableColumn<Order, String> colModifierOrder;

    @FXML
    private TableColumn<Order, String> colObservationsOrder;
    
    @FXML
    private TableView<Product> tvOfOrderProducts;

    @FXML
    private TableColumn<Product, String> colNameOrderProduct;

    @FXML
    private TableColumn<Product, String> colSizeOrderProduct;
    
    @FXML
    private TableView<Integer> tvOfOrderProductsQ;

    @FXML
    private TableColumn<Integer, Integer> colQuantityOrderProduct;

	@FXML
	private CheckBox ckbxDisable;

	@FXML
    private Label lbManageProduct;
	
	@FXML
    private Button btAddProductsOrder;
	
	@FXML
    private Button btUpdate;
	
	@FXML
    private Button btDelete;

    @FXML
    private Button btAdd;
    
    @FXML
    private Button btIngredients;
    
    @FXML
    private Button btSizes;
    
    @FXML
    private Button btUpdateSize;

    @FXML
    private Button btDeleteSize;

    @FXML
    private Button btAddSize;
    
    @FXML
    private Button btDeleteIngredient;

    @FXML
    private Button btAddIngredient;
    
    @FXML
	private TextField txtUserName;
    
    @FXML
    private TextField txtId;
    
	@FXML
	private PasswordField passwordField;

	@FXML
	private ComboBox<Employee> cbEmployee;
	
	@FXML
	private TableView<User> tvListUsers;

    @FXML
    private ComboBox<Size> cmbxProductSizes;

	@FXML
	private TableColumn<User, String> colNameUser;

	@FXML
	private TableColumn<User, String> colLastNameUser;

	@FXML
	private TableColumn<User, String> colIdUser;

	@FXML
	private TableColumn<User, String> colEnabledUser;

	@FXML
	private TableColumn<User, String> colUserName;

	@FXML
	private TableColumn<User, String> colPassword;

	@FXML
	private TableColumn<User, String> colCreatorUser;

	@FXML
	private TableColumn<User, String> colModifierUser;
	
	@FXML
	private TextField txtName;

	@FXML
	private TextField txtLastName;

	@FXML
	private TableView<Employee> tvListEmployees;

	@FXML
	private TableColumn<Employee, String> colNameEmployee;

	@FXML
	private TableColumn<Employee, String> colLastNameEmployee;

	@FXML
	private TableColumn<Employee, String> colIdEmployee;

	@FXML
	private TableColumn<Employee, String> colEnabledEmployee;

	@FXML
	private TableColumn<Employee, String> colCreatorEmployee;

	@FXML
	private TableColumn<Employee, String> colModifierEmployee;
	
	@FXML
    private TableView<Ingredient> tvOfAddedIngredients;

    @FXML
    private TableColumn<Ingredient, String> colNameAddedIngredients;
    
    @FXML
    private TableView<Ingredient> tvOfIngredientsInAProduct;

    @FXML
    private TableColumn<Ingredient, String> colNameIngredientsOfAProduct;
	
	@FXML
	private Button btReturnToMenu;
	
	@FXML
	private Label lbUserNameMenu;

	@FXML
	private Label lbUserIdMenu;
	
	@FXML
	private TextField txtAddress;

	@FXML
	private TextField txtPhone;

	@FXML
	private TextArea txtObservations;

	@FXML
	private TableView<Client> tvListClients;

	@FXML
	private TableColumn<Client, String> colNameClient;

	@FXML
	private TableColumn<Client, String> colLastNameClient;

	@FXML
	private TableColumn<Client, String> colIdClient;

	@FXML
	private TableColumn<Client, String> colAddressClient;

	@FXML
	private TableColumn<Client, String> colPhoneClient;

	@FXML
	private TableColumn<Client, String> colObsClient;

	@FXML
	private TableColumn<Client, String> colEnabledClient;

	@FXML
	private TableColumn<Client, String> colCreatorClient;

	@FXML
	private TableColumn<Client, String> colModifierClient;
	
	@FXML
    private VBox addIngredientsToAnOrderForm;

    @FXML
    private TextField txtNameProductOrder;

    @FXML
    private Button btDeleteProduct;

    @FXML
    private Button btAddProduct;

    @FXML
    private VBox updateStateForm;

    @FXML
    private RadioButton rbInProcess;

    @FXML
    private ToggleGroup rbStateOrder;

    @FXML
    private RadioButton rbSent;

    @FXML
    private RadioButton rbDelivered;

    @FXML
    private RadioButton rbCancelled;

    @FXML
    private Button btChangeState;

    
	public RestauranteLaCasaDoradaGUI(RestauranteLaCasaDorada rlcd) {
		this.restauranteLaCasaDorada=rlcd;
	}
	
	public void showMenu() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
		fxmlLoader.setController(this);
		Parent menuPane = fxmlLoader.load();
		mainPanel.getChildren().clear();
		mainPanel.setCenter(menuPane);
		mainPanel.setStyle("-fx-background-image: url(/ui/fondo1.jpg)");
	}
	
		
	private void initializeTableViewOfProducts() {
    	ObservableList<Product> observableList;
    	observableList = FXCollections.observableArrayList(restauranteLaCasaDorada.getProducts());
    	tvOfProducts.setItems(observableList);
    	colNameProduct.setCellValueFactory(new PropertyValueFactory<Product, String>("Name"));
    	colStatusProduct.setCellValueFactory(new PropertyValueFactory<Product, String>("Status"));
    	colCreatorProduct.setCellValueFactory(new PropertyValueFactory<Product, String>("CreatorName"));
    	colModifierProduct.setCellValueFactory(new PropertyValueFactory<Product, String>("ModifierName"));
    	tvOfProducts.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    	tvOfProducts.setVisible(true);
	}
	
	private void showComboBoxOfTypesOfProducts() {
		ObservableList<TypeOfProduct> typesOfProductsList = FXCollections.observableArrayList(restauranteLaCasaDorada.returnEnabledTypesOfProducts());
    	cmbxTypeOfProduct.setItems(typesOfProductsList);
    	cmbxTypeOfProduct.setPromptText("Elija uno");
	}
	
    @FXML
    public void manageAProduct(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("manage-product.fxml"));
		fxmlLoader.setController(this);
		Parent menuPane = fxmlLoader.load();
		mainPanel.getChildren().clear();
		mainPanel.setCenter(menuPane);
		mainPanel.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");
		createProductForm.setVisible(true);
		initializeTableViewOfProducts();
		showComboBoxOfTypesOfProducts();
		lbUserName.setText(lbUserNameMenu.getText());
    	lbUserId.setText(lbUserIdMenu.getText());  
    }

    @FXML
    public void clickOnTableViewOfProducts(MouseEvent event) {
    	if (tvOfProducts.getSelectionModel().getSelectedItem() != null) {
    		enableButtons();
    		Product selectedProduct = tvOfProducts.getSelectionModel().getSelectedItem();
    		lbObjectId.setText(""+selectedProduct.getId());
    		txtProductName.setText(selectedProduct.getName());
    		cmbxTypeOfProduct.setValue(selectedProduct.getType());
    		ckbxDisable.setSelected(!selectedProduct.isEnabled());
    		btIngredients.setDisable(false);
    		btSizes.setDisable(false);
    	}
    }
   
	private void initializeTableViewOfAddedIngredients() {
    	ObservableList<Ingredient> observableList;
    	observableList = FXCollections.observableArrayList(restauranteLaCasaDorada.returnEnabledIngredients());
    	tvOfAddedIngredients.setItems(observableList);
    	colNameAddedIngredients.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("Name"));
    	tvOfAddedIngredients.setVisible(true);
    	tvOfAddedIngredients.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}
	
	private void initializeTableViewOfIngredientsInAProduct() {
    	ObservableList<Ingredient> observableList;
    	if(!tvOfProducts.getSelectionModel().getSelectedItem().getListOfIngredients().isEmpty()) {
    		observableList = FXCollections.observableArrayList(tvOfProducts.getSelectionModel().getSelectedItem().getListOfIngredients());
        	tvOfIngredientsInAProduct.setItems(observableList);
        	colNameIngredientsOfAProduct.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("Name"));
        	tvOfIngredientsInAProduct.setVisible(true);
        	tvOfIngredientsInAProduct.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    	}
	}
    
    @FXML
    public void clickOnTableViewOfAddedIngredients(MouseEvent event) {
    	if (tvOfAddedIngredients.getSelectionModel().getSelectedItems()!=null) {
    		btAddIngredient.setDisable(false);
    		btDeleteIngredient.setDisable(true);
    		Ingredient selectedIngredient= tvOfAddedIngredients.getSelectionModel().getSelectedItem();
    		txtIngredientName.setText(selectedIngredient.getName());
    	}
    }
    
    @FXML
    public void clickOnTableViewOfIngredientsInAProduct(MouseEvent event) {
    	if (tvOfIngredientsInAProduct.getSelectionModel().getSelectedItems()!=null) {
    		btDeleteIngredient.setDisable(false);
    		btAddIngredient.setDisable(true);
    		Ingredient selectedIngredient= tvOfIngredientsInAProduct.getSelectionModel().getSelectedItem();
    		txtIngredientName.setText(selectedIngredient.getName());
    	}
    }

    @FXML
    public void chooseIngredients(ActionEvent event) {
    	tvOfProducts.setVisible(false);
    	createProductForm.setVisible(false);
    	lbManageProduct.setText(" ");
    	ingredientForm.setVisible(true);
    	initializeTableViewOfAddedIngredients();
    	initializeTableViewOfIngredientsInAProduct();
    }
    
    @FXML
    public void addIngredientToAProduct(ActionEvent event) {
    	Product p =  tvOfProducts.getSelectionModel().getSelectedItem();
    	Ingredient selectedIngredient= tvOfAddedIngredients.getSelectionModel().getSelectedItem();
    	String userId = lbUserId.getText();
    	if(selectedIngredient!=null) {
    		boolean added = restauranteLaCasaDorada.addIngredientToAProduct(p, selectedIngredient,userId);
    		if(added==false) {
    			Alert alert1 = new Alert(AlertType.ERROR);
    			alert1.setTitle("Error de validacion");
    			alert1.setHeaderText(null);
    			alert1.setContentText("El ingrediente ya se encuentra agregado en la lista de ingredientes del producto, intentelo nuevamente");
    			alert1.showAndWait();
    		}else {
    			Alert alert2 = new Alert(AlertType.INFORMATION);
        		alert2.setTitle("Informacion");
        		alert2.setHeaderText(null);
        		alert2.setContentText("El ingrediente ha sido agregado exitosamente a la lista de ingredientes del producto");
        		alert2.showAndWait();
    		}
    		txtIngredientName.clear();
        	initializeTableViewOfIngredientsInAProduct();
    	}
    }
    
    @FXML
    public void deleteAnIngredientOfAProduct(ActionEvent event) {
    	Product p =  tvOfProducts.getSelectionModel().getSelectedItem();
    	Ingredient selectedIngredient= tvOfIngredientsInAProduct.getSelectionModel().getSelectedItem();
    	String userId = lbUserId.getText();
    	Alert alert1 = new Alert(AlertType.CONFIRMATION);
    	alert1.setTitle("Confirmacion de proceso");
    	alert1.setHeaderText(null);
    	alert1.setContentText("¿Esta seguro de que quiere eliminar este ingrediente del producto?");
    	Optional<ButtonType> result = alert1.showAndWait();
    	if (result.get() == ButtonType.OK && selectedIngredient!=null){
    		restauranteLaCasaDorada.deleteAnIngredientOfAProduct(p, selectedIngredient, userId);
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Informacion");
    		alert2.setHeaderText(null);
    		alert2.setContentText("El ingrediente ha sido eliminado exitosamente de la lista de ingredientes del producto");
    		alert2.showAndWait();
    	}
    	txtIngredientName.clear();
    	initializeTableViewOfIngredientsInAProduct();
    }
    
    private void initializeTableViewOfSizes() {
    	ObservableList<Size> observableList;
    	observableList = FXCollections.observableArrayList(tvOfProducts.getSelectionModel().getSelectedItem().getSizes());
    	tvOfSizes.setItems(observableList);
    	colNameSize.setCellValueFactory(new PropertyValueFactory<Size, String>("Name"));
    	colSizePrice.setCellValueFactory(new PropertyValueFactory<Size, Double>("Price"));
    	tvOfSizes.setVisible(true);
    	tvOfSizes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}
    
    @FXML
    public void clickOnTableViewOfSizes(MouseEvent event) {
    	if (tvOfSizes.getSelectionModel().getSelectedItems()!=null) {
    		btDeleteSize.setDisable(false);
    		btAddSize.setDisable(true);
    		btUpdateSize.setDisable(false);
    		Size selectedSize= tvOfSizes.getSelectionModel().getSelectedItem();
    		txtSizeName.setText(selectedSize.getName());
    		txtSizePrice.setText(""+selectedSize.getPrice());
    	}
    }
    
    @FXML
    public void manageSizes(ActionEvent event) {
    	createProductForm.setVisible(false);
    	sizeForm.setVisible(true);
    	lbManageProduct.setText("Lista de tamaños agregados");
    	tvOfProducts.setVisible(false);
    	initializeTableViewOfSizes();
    }
    
    @FXML
    public void addSizeOfAProduct(ActionEvent event) {
    	Product p =  tvOfProducts.getSelectionModel().getSelectedItem();
    	String userId = lbUserId.getText();
    	if(!txtSizeName.getText().equals("") && !txtSizePrice.getText().equals("")) {
    		String name = txtSizeName.getText();
    		double price = Double.parseDouble(txtSizePrice.getText());
    		boolean added = restauranteLaCasaDorada.addSizeOfAProduct(p, name, price, userId);
    		if(added==false) {
    			Alert alert1 = new Alert(AlertType.ERROR);
    			alert1.setTitle("Error de validacion");
    			alert1.setHeaderText(null);
    			alert1.setContentText("El tamaño ya se encuentra agregado en la lista de tamaños del producto, intentelo nuevamente");
    			alert1.showAndWait();
    		}else {
    			Alert alert2 = new Alert(AlertType.INFORMATION);
        		alert2.setTitle("Informacion");
        		alert2.setHeaderText(null);
        		alert2.setContentText("El tamaño ha sido agregado exitosamente a la lista de tamaños del producto");
        		alert2.showAndWait();
    		}
    		txtSizeName.clear();
    		txtSizePrice.clear();
    		initializeTableViewOfSizes();
    	}else {
    		showValidationErrorAlert();
    	}
    }
   
    @FXML
    public void deleteSizeOfAProduct(ActionEvent event) {
    	Product p =  tvOfProducts.getSelectionModel().getSelectedItem();
    	Size selectedSize= tvOfSizes.getSelectionModel().getSelectedItem();
    	Alert alert1 = new Alert(AlertType.CONFIRMATION);
    	alert1.setTitle("Confirmacion de proceso");
    	alert1.setHeaderText(null);
    	alert1.setContentText("¿Esta seguro de que quiere eliminar este tamaño del producto?");
    	Optional<ButtonType> result = alert1.showAndWait();
    	if (result.get() == ButtonType.OK && selectedSize!=null){
    		restauranteLaCasaDorada.deleteSizeOfAProduct(p, selectedSize);
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Informacion");
    		alert2.setHeaderText(null);
    		alert2.setContentText("El tamaño ha sido eliminado exitosamente de la lista de tamaños del producto");
    		alert2.showAndWait();
    		txtSizeName.clear();
    		txtSizePrice.clear();
    		initializeTableViewOfSizes();
    	}
    }
    
    @FXML
    public void updateSizeOfAProduct(ActionEvent event) {
    	Product p =  tvOfProducts.getSelectionModel().getSelectedItem();
    	Size selectedSize= tvOfSizes.getSelectionModel().getSelectedItem();
    	String userId = lbUserId.getText();
    	if(selectedSize!=null && !txtSizeName.getText().equals("") && !txtSizePrice.getText().equals("")) {
    		String newName = txtSizeName.getText();
    		double newPrice =  Double.parseDouble(txtSizePrice.getText());
    		boolean updated = restauranteLaCasaDorada.updateSizeOfAProduct(p, selectedSize ,newName, newPrice, userId);
    		if(updated==false) {
    			Alert alert1 = new Alert(AlertType.ERROR);
    			alert1.setTitle("Error de validacion");
    			alert1.setHeaderText(null);
    			alert1.setContentText("Ya existe un tamaño con el nombre ingresado, intentelo nuevamente");
    			alert1.showAndWait();
    		}else {
    			Alert alert2 = new Alert(AlertType.INFORMATION);
        		alert2.setTitle("Informacion");
        		alert2.setHeaderText(null);
        		alert2.setContentText("El tamaño ha sido actualizado exitosamente de la lista de tamaños del producto");
        		alert2.showAndWait();
    		}
    		txtSizeName.clear();
    		txtSizePrice.clear();
    		tvOfSizes.getItems().clear();
    		initializeTableViewOfSizes();
    	}else {
    		showValidationErrorAlert();
    	}
    }
    
    @FXML
    public void addProduct(ActionEvent event) {
    	if (!txtProductName.getText().equals("") && cmbxTypeOfProduct.getValue()!=null) {
    		String pN = txtProductName.getText();
    		int Tp = cmbxTypeOfProduct.getValue().getId();
    		String userId = lbUserId.getText();
    		boolean added = restauranteLaCasaDorada.addProduct(pN, Tp, userId);
    		if(added==false) {
    			Alert alert1 = new Alert(AlertType.ERROR);
    			alert1.setTitle("Error de validacion");
    			alert1.setHeaderText(null);
    			alert1.setContentText("Ya existe un producto agregado con dicho nombre, intentelo nuevamente");
    			alert1.showAndWait();
    		}else {
    			Alert alert2 = new Alert(AlertType.INFORMATION);
        		alert2.setTitle("Informacion");
        		alert2.setHeaderText(null);
        		alert2.setContentText("El producto ha sido creado exitosamente");
        		alert2.showAndWait();
    		}
    		txtProductName.clear();
    		cmbxTypeOfProduct.getItems().clear();
    		showComboBoxOfTypesOfProducts();
    		ckbxDisable.setSelected(false);
    		initializeTableViewOfProducts();
    	}else {
    		showValidationErrorAlert();
    	}
    }
    
    @FXML
    public void deleteProduct(ActionEvent event) {
    	Product selectedProduct = tvOfProducts.getSelectionModel().getSelectedItem();
    	Alert alert1 = new Alert(AlertType.CONFIRMATION);
    	alert1.setTitle("Confirmacion de proceso");
    	alert1.setHeaderText(null);
    	alert1.setContentText("¿Esta seguro de que quiere eliminar este producto?");
    	Optional<ButtonType> result = alert1.showAndWait();
    	if (result.get() == ButtonType.OK && selectedProduct!=null){
        	restauranteLaCasaDorada.deleteProduct(selectedProduct);
        	Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Informacion");
    		alert.setHeaderText(null);
        	alert.setContentText("El producto ha sido eliminado exitosamente");
        	alert.showAndWait();
        	txtProductName.clear();
        	cmbxTypeOfProduct.getItems().clear();
        	cmbxTypeOfProduct.setPromptText("Elija uno");
        	ckbxDisable.setSelected(false);
        	tvOfProducts.getItems().clear();
        	initializeTableViewOfProducts(); 
    	} 
    }

    @FXML
    public void updateProduct(ActionEvent event) {
    	Product selectedProduct = tvOfProducts.getSelectionModel().getSelectedItem();
    	if (!txtProductName.getText().equals("") && cmbxTypeOfProduct.getValue()!=null) {
    		String newName = txtProductName.getText();
    		int newTp = cmbxTypeOfProduct.getValue().getId();
    		String userId = lbUserId.getText();
    		boolean enabled = true;
    		if(ckbxDisable.isSelected()) {
    			enabled = false;
    		}
    		boolean added = restauranteLaCasaDorada.updateProduct(selectedProduct, newName, enabled, newTp, userId);
    		if(added==false) {
    			Alert alert1 = new Alert(AlertType.ERROR);
    			alert1.setTitle("Error de validacion");
    			alert1.setHeaderText(null);
    			alert1.setContentText("Ya existe un producto agregado con dicho nombre, intentelo nuevamente");
    			alert1.showAndWait();
    		}else {
    			Alert alert2 = new Alert(AlertType.INFORMATION);
        		alert2.setTitle("Informacion");
        		alert2.setHeaderText(null);
        		alert2.setContentText("El producto ha sido actualizado exitosamente");
        		alert2.showAndWait();
    		}
    		txtProductName.clear();
    		cmbxTypeOfProduct.getItems().clear();
    		showComboBoxOfTypesOfProducts();
    		ckbxDisable.setSelected(false);
    		tvOfProducts.getItems().clear();
    		initializeTableViewOfProducts();
    	}else {
    		showValidationErrorAlert();
    	}
    }
    
    private void initializeTableViewOfTypesOfProducts() {
    	ObservableList<TypeOfProduct> observableList;
    	observableList = FXCollections.observableArrayList(restauranteLaCasaDorada.getTypesOfProducts());
    	tvOfTypeOfProducts.setItems(observableList);
    	colNameTypeOfProduct.setCellValueFactory(new PropertyValueFactory<TypeOfProduct, String>("Name"));
    	colStatusTypeOfProduct.setCellValueFactory(new PropertyValueFactory<TypeOfProduct, String>("Status"));
    	colCreatorTypeOfProduct.setCellValueFactory(new PropertyValueFactory<TypeOfProduct, String>("CreatorName"));
    	colModifierTypeOfProduct.setCellValueFactory(new PropertyValueFactory<TypeOfProduct, String>("ModifierName"));
    	tvOfTypeOfProducts.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}
    
    @FXML
    public void clickOnTableViewOfTypeOfProducts(MouseEvent event) {
    	if (tvOfTypeOfProducts.getSelectionModel().getSelectedItems()!=null) {
    		enableButtons();
    		TypeOfProduct selectedTypeOfProduct = tvOfTypeOfProducts.getSelectionModel().getSelectedItem();
    		lbObjectId.setText(""+selectedTypeOfProduct.getId());
    		txtTypeOfProductName.setText(selectedTypeOfProduct.getName());
    		ckbxDisable.setSelected(!selectedTypeOfProduct.isEnabled());
    	}
    }

    @FXML
    public void manageATypeOfProduct(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("manage-type-of-product.fxml"));
		fxmlLoader.setController(this);
		Parent menuPane = fxmlLoader.load();
		mainPanel.getChildren().clear();
		mainPanel.setCenter(menuPane);
		mainPanel.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");
		initializeTableViewOfTypesOfProducts(); 
		lbUserName.setText(lbUserNameMenu.getText());
    	lbUserId.setText(lbUserIdMenu.getText());  
    }
    
    @FXML
    public void addTypeOfProduct(ActionEvent event) {
    	if (!txtTypeOfProductName.getText().equals("")) {
    		String newTP = txtTypeOfProductName.getText();
    		String userID = lbUserId.getText();
    		boolean added = restauranteLaCasaDorada.addTypeOfProduct(newTP, userID);
    		if(added==false) {
    			Alert alert1 = new Alert(AlertType.ERROR);
    			alert1.setTitle("Error de validacion");
    			alert1.setHeaderText(null);
    			alert1.setContentText("Ya existe un tipo de ingrediente agregado con dicho nombre, intentelo nuevamente");
    			alert1.showAndWait();
    		}else {
    			Alert alert2 = new Alert(AlertType.INFORMATION);
        		alert2.setTitle("Informacion");
        		alert2.setHeaderText(null);
        		alert2.setContentText("El tipo de ingrediente ha sido creado exitosamente");
        		alert2.showAndWait();
    		}
    		txtTypeOfProductName.clear();
    		tvOfTypeOfProducts.getItems().clear();
    		initializeTableViewOfTypesOfProducts();
    	}else {
    		showValidationErrorAlert();
    	}
    }

    @FXML
    public void deleteTypeOfProduct(ActionEvent event) {
    	Alert alert1 = new Alert(AlertType.CONFIRMATION);
    	alert1.setTitle("Confirmacion de proceso");
    	alert1.setHeaderText(null);
    	alert1.setContentText("¿Esta seguro de que quiere eliminar este tipo de ingrediente?");
    	Optional<ButtonType> result = alert1.showAndWait();
    	if (result.get() == ButtonType.OK){
    		int TpId = Integer.parseInt(lbObjectId.getText());
        	boolean deleted = restauranteLaCasaDorada.deleteTypeOfProduct(TpId);
        	Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Informacion");
    		alert2.setHeaderText(null);
        	if(deleted==true) {
        		alert2.setContentText("El tipo de ingrediente ha sido eliminado exitosamente");
        		alert2.showAndWait();
        	}else {
        		alert2.setContentText("El tipo de ingrediente no pudo ser eliminado debido a que esta siendo implementado por un producto");
        		alert2.showAndWait();
        	}
        	txtTypeOfProductName.clear();
    		ckbxDisable.setSelected(false);
    		tvOfTypeOfProducts.getItems().clear();
        	initializeTableViewOfTypesOfProducts();
    	} 
    }

    @FXML
    public void updateTypeOfProduct(ActionEvent event) {
    	if (!txtTypeOfProductName.getText().equals("")) {
    		String newName = txtTypeOfProductName.getText();
    		String userID = lbUserId.getText();
    		int TpId = Integer.parseInt(lbObjectId.getText());
    		boolean enabled = true;
    		if(ckbxDisable.isSelected()) {
    			enabled = false;
    		}
    		boolean updated = restauranteLaCasaDorada.updateTypeOfProduct(newName, TpId, enabled, userID);
    		if(updated==false) {
    			Alert alert1 = new Alert(AlertType.ERROR);
    			alert1.setTitle("Error de validacion");
    			alert1.setHeaderText(null);
    			alert1.setContentText("Ya existe un tipo de ingrediente agregado con dicho nombre, intentelo nuevamente");
    			alert1.showAndWait();
    		}else {
    			Alert alert2 = new Alert(AlertType.INFORMATION);
        		alert2.setTitle("Informacion");
        		alert2.setHeaderText(null);
        		alert2.setContentText("El tipo de ingrediente ha sido actualizado exitosamente");
        		alert2.showAndWait();
    		}
    		txtTypeOfProductName.clear();
    		ckbxDisable.setSelected(false);
    		tvOfTypeOfProducts.getItems().clear();
    		initializeTableViewOfTypesOfProducts();
    	}else {
    		showValidationErrorAlert();
    	}
    }
 
    private void initializeTableViewOfIngredients() {
    	ObservableList<Ingredient> observableList;
    	observableList = FXCollections.observableArrayList(restauranteLaCasaDorada.getIngredients());
    	tvOfIngredients.setItems(observableList);
    	colNameIngredient.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("Name"));
    	colStatusIngredient.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("Status"));
    	colCreatorIngredient.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("CreatorName"));
    	colModifierIngredient.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("ModifierName"));
    	tvOfIngredients.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}
    
    @FXML
    public void clickOnTableViewOfIngredients(MouseEvent event) {
    	if (tvOfIngredients.getSelectionModel().getSelectedItem() != null) {
    		enableButtons();
    		Ingredient selectedIng = tvOfIngredients.getSelectionModel().getSelectedItem();
    		lbObjectId.setText(""+selectedIng.getId());
    		txtIngredientName.setText(selectedIng.getName());
    		ckbxDisable.setSelected(!selectedIng.isEnabled());
    	}
    }

    @FXML
    public void manageAnIngredient(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("manage-ingredient.fxml"));
		fxmlLoader.setController(this);
		Parent menuPane = fxmlLoader.load();
		mainPanel.getChildren().clear();
		mainPanel.setCenter(menuPane);
		mainPanel.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");
		initializeTableViewOfIngredients();
		lbUserName.setText(lbUserNameMenu.getText());
    	lbUserId.setText(lbUserIdMenu.getText());  
    }
    
    @FXML
    public void addIngredient(ActionEvent event) {
    	if (!txtIngredientName.getText().equals("")) {
    		String newIng = txtIngredientName.getText();
    		String userID = lbUserId.getText();
    		boolean added = restauranteLaCasaDorada.addIngredient(newIng, userID);
    		if(added==false) {
    			Alert alert1 = new Alert(AlertType.ERROR);
    			alert1.setTitle("Error de validacion");
    			alert1.setHeaderText(null);
    			alert1.setContentText("Ya existe un ingrediente agregado con dicho nombre, intentelo nuevamente");
    			alert1.showAndWait();
    		}else {
    			Alert alert2 = new Alert(AlertType.INFORMATION);
        		alert2.setTitle("Informacion");
        		alert2.setHeaderText(null);
        		alert2.setContentText("El ingrediente ha sido creado exitosamente");
        		alert2.showAndWait();
    		}
    		txtIngredientName.clear();
    		tvOfIngredients.getItems().clear();
    		initializeTableViewOfIngredients();
    	}else {
    		showValidationErrorAlert();
    	}
    }

    @FXML
    public void deleteIngredient(ActionEvent event) {
    	Alert alert1 = new Alert(AlertType.CONFIRMATION);
    	alert1.setTitle("Confirmacion de proceso");
    	alert1.setHeaderText(null);
    	alert1.setContentText("¿Esta seguro de que quiere eliminar este ingrediente?");
    	Optional<ButtonType> result = alert1.showAndWait();
    	if (result.get() == ButtonType.OK){
    		int ingId = Integer.parseInt(lbObjectId.getText());
        	boolean deleted = restauranteLaCasaDorada.deleteIngredient(ingId);
        	Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Informacion");
    		alert2.setHeaderText(null);
        	if(deleted==true) {
        		alert2.setContentText("El ingrediente ha sido eliminado exitosamente");
        		alert2.showAndWait();
        	}else {
        		alert2.setContentText("El ingrediente no pudo ser eliminado debido a que esta siendo implementado por un producto");
        		alert2.showAndWait();
        	}
        	txtIngredientName.clear();
    		ckbxDisable.setSelected(false);
    		tvOfIngredients.getItems().clear();
        	initializeTableViewOfIngredients();
    	} 
    }

    @FXML
    public void updateIngredient(ActionEvent event) {
    	if (!txtIngredientName.getText().equals("")) {
    		String newName = txtIngredientName.getText();
    		String userID = lbUserId.getText();
    		int ingId = Integer.parseInt(lbObjectId.getText());
    		boolean enabled = true;
    		if(ckbxDisable.isSelected()) {
    			enabled = false;
    		}
    		boolean updated = restauranteLaCasaDorada.updateIngredient(newName, ingId, enabled, userID);
    		if(updated==false) {
    			Alert alert1 = new Alert(AlertType.ERROR);
    			alert1.setTitle("Error de validacion");
    			alert1.setHeaderText(null);
    			alert1.setContentText("Ya existe un ingrediente agregado con dicho nombre, intentelo nuevamente");
    			alert1.showAndWait();
    		}else {
    			Alert alert2 = new Alert(AlertType.INFORMATION);
        		alert2.setTitle("Informacion");
        		alert2.setHeaderText(null);
        		alert2.setContentText("El ingrediente ha sido actualizado exitosamente");
        		alert2.showAndWait();
    		}
    		txtIngredientName.clear();
    		ckbxDisable.setSelected(false);
    		tvOfIngredients.getItems().clear();
    		initializeTableViewOfIngredients();
    	}else {
    		showValidationErrorAlert();
    	}
    }
    
    private void initializeTableViewOfOrders() {
    	ObservableList<Order> observableList;
    	observableList = FXCollections.observableArrayList(restauranteLaCasaDorada.getOrders());
    	tvOfOrders.setItems(observableList);
    	colCodeOrder.setCellValueFactory(new PropertyValueFactory<Order, String>("Code"));
    	colStateOrder.setCellValueFactory(new PropertyValueFactory<Order, String>("StateOfOrder"));
    	colDateandTimeOrder.setCellValueFactory(new PropertyValueFactory<Order, String>("DateAndHour"));
    	colClientOrder.setCellValueFactory(new PropertyValueFactory<Order, String>("ClientName"));
    	colEmployeeOrder.setCellValueFactory(new PropertyValueFactory<Order, String>("EmployeeName"));
    	colCreatorOrder.setCellValueFactory(new PropertyValueFactory<Order, String>("CreatorName"));
    	colModifierOrder.setCellValueFactory(new PropertyValueFactory<Order, String>("ModifierName"));
    	colObservationsOrder.setCellValueFactory(new PropertyValueFactory<Order, String>("Observations"));
    	tvOfOrders.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    	tvOfOrders.setVisible(true);
	}
    
    private void initializeComboBoxOfClients() {
		ObservableList<Client> clientsList = FXCollections.observableArrayList(restauranteLaCasaDorada.returnEnabledClients());
		cmbxClients.setItems(clientsList);
		cmbxClients.setPromptText("Elija un cliente");
	}
    
    @FXML
    public void manageAnOrder(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("order.fxml"));
		fxmlLoader.setController(this);
		Parent menuPane = fxmlLoader.load();
		mainPanel.getChildren().clear();
		mainPanel.setCenter(menuPane);
		mainPanel.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");
		initializeComboBoxOfClients();
		initializeComboBoxEmployees();
		initializeTableViewOfOrders();
		createOrderForm.setVisible(true);
		btAddProductsOrder.setDisable(true);
		lbUserName.setText(lbUserNameMenu.getText());
    	lbUserId.setText(lbUserIdMenu.getText()); 
    }

    @FXML
    public void changeStateOfAnOrder(ActionEvent event) {
    	createOrderForm.setVisible(false);
    	updateStateForm.setVisible(true);
    	Order selectedOrder = tvOfOrders.getSelectionModel().getSelectedItem();
    	switch(selectedOrder.getStateOfOrder().name()) {
    	case "SOLICITADO":
    		rbSent.setDisable(true);
    		rbDelivered.setDisable(true);
    		rbCancelled.setDisable(true);
    		rbInProcess.setDisable(true);
    		break;
    	case "EN_PROCESO":
    		rbSent.setDisable(true);
   		 	rbDelivered.setDisable(true);
   		 	rbCancelled.setDisable(true);
   		 	break;
    	case "ENVIADO":
   		 	rbDelivered.setDisable(true);
   		 	break;
    	}
    	String newState = getRadioButtonState();
    	restauranteLaCasaDorada.updateStateOfAnOrder(selectedOrder,newState);
    }
    
    public String getRadioButtonState() {
    	String state = "";
    	if(rbSent.isSelected()) {
    		state = "ENVIADO";
    	} else if (rbDelivered.isSelected()) {
    		state = "ENTREGADO";
    	}else if (rbCancelled.isSelected()) {
    		state = "CANCELADO";
    	} else {
    		state = "EN_PROCESO";
    	}
    	return state;
    }
    
    private void initializeTableViewOfAddedProducts() {
    	ObservableList<Product> observableList;
    	observableList = FXCollections.observableArrayList(restauranteLaCasaDorada.returnEnabledProducts());
    	tvOfAddedProducts.setItems(observableList);
    	colNameAddedProduct.setCellValueFactory(new PropertyValueFactory<Product, String>("Name"));
    	tvOfAddedProducts.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    	tvOfAddedProducts.setVisible(true);
	}
    
    private void initializeTableViewOfOrderProducts() {
    	ObservableList<Product> observableList;
    	if(!tvOfOrders.getSelectionModel().getSelectedItem().getListOfProducts().isEmpty()) {
    		observableList = FXCollections.observableArrayList(tvOfOrders.getSelectionModel().getSelectedItem().getListOfProducts());
    		tvOfOrderProducts.setItems(observableList);
    		colNameOrderProduct.setCellValueFactory(new PropertyValueFactory<Product, String>("Name"));
    		colSizeOrderProduct.setCellValueFactory(new PropertyValueFactory<Product, String>("AllSizes"));
    		tvOfOrderProducts.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    		tvOfOrderProducts.setVisible(true);
    	}
	}
    
    private void initializeTableViewOfOrderProductsQ() {
    	ObservableList<Integer> observableList;
    	if(!tvOfOrders.getSelectionModel().getSelectedItem().getListOfQuantity().isEmpty()) {
    		observableList = FXCollections.observableArrayList(tvOfOrders.getSelectionModel().getSelectedItem().getListOfQuantity());
    		tvOfOrderProductsQ.setItems(observableList);
    		colQuantityOrderProduct.setCellValueFactory(new PropertyValueFactory<Integer, Integer>("ListOfQuantity"));
    		tvOfOrderProductsQ.setVisible(true);
    	}
	}

    @FXML
    public void chooseProductsOfAnOrder(ActionEvent event) {
    	createOrderForm.setVisible(false);
    	tvOfOrders.setVisible(false);
    	addIngredientsToAnOrderForm.setVisible(true);
    	initializeTableViewOfAddedProducts();
    	initializeTableViewOfOrderProducts();
    	initializeTableViewOfOrderProductsQ();
    }

    @FXML
    public void clickOnTableViewOfOrders(MouseEvent event) {
    	if (tvOfOrders.getSelectionModel().getSelectedItem() != null) {
    		String state = tvOfOrders.getSelectionModel().getSelectedItem().getStateOfOrder().name();
    		if((!state.equals("ENTREGADO"))||(!state.equals("CANCELADO"))){
    			btChangeState.setDisable(false);
    		}
    		btAddProductsOrder.setDisable(false);
    		btAdd.setDisable(true);
    		btUpdate.setDisable(false);
    		Order selectedOrder = tvOfOrders.getSelectionModel().getSelectedItem();
    		lbObjectId.setText(""+selectedOrder.getCode());
    		cmbxClients.setValue(selectedOrder.getBuyer());
    		cbEmployee.setValue(selectedOrder.getDeliverer());
    		txtAreaObservations.setText(selectedOrder.getObservations());
    	}
    }

    @FXML
    public void clickOnTableViewOfAddedProducts(MouseEvent event) {
    	if (tvOfAddedProducts.getSelectionModel().getSelectedItem() != null) {
    		btAddProduct.setDisable(false);
    		Product selectedProduct = tvOfAddedProducts.getSelectionModel().getSelectedItem();
    		txtNameProductOrder.setText(selectedProduct.getName());
    		ObservableList<Size> sizesList = FXCollections.observableArrayList(tvOfAddedProducts.getSelectionModel().getSelectedItem().getSizes());
    		cmbxProductSizes.setItems(sizesList);
    		cmbxProductSizes.setPromptText("Elija un Tamaño");
    	}
    }
    
    @FXML
    public void clickOnTableViewOfOrderProducts(MouseEvent event) {
    	Order selectedOrder = tvOfOrders.getSelectionModel().getSelectedItem();
    	Product selectedProduct = tvOfOrderProducts.getSelectionModel().getSelectedItem();
    	if (selectedProduct!= null) {
    		btDeleteProduct.setDisable(false);
    		txtNameProductOrder.setText(selectedProduct.getName());
    		cmbxProductSizes.setValue(restauranteLaCasaDorada.getSelectedSize(selectedOrder,selectedProduct));
    		txtProductQuantity.setText(""+restauranteLaCasaDorada.getQuantity(selectedOrder,selectedProduct));
    	}
    }
   
    @FXML
    public void addProductToAnOrder(ActionEvent event) {
    	Order selectedOrder = tvOfOrders.getSelectionModel().getSelectedItem();
    	Product selectedProduct = tvOfAddedProducts.getSelectionModel().getSelectedItem();
    	String userId = lbUserId.getText();
    	if (selectedProduct!= null) {
    		if (!txtProductQuantity.getText().equals("") && cmbxProductSizes.getValue()!=null) {
    			Size selectedSize = cmbxProductSizes.getValue();
        		int quantity = Integer.parseInt(txtProductQuantity.getText());
        		boolean added = restauranteLaCasaDorada.addProductsToAnOrder(selectedOrder,selectedProduct,selectedSize,quantity, userId);
        		if(added==false) {
        			Alert alert1 = new Alert(AlertType.ERROR);
        			alert1.setTitle("Error de validacion");
        			alert1.setHeaderText(null);
        			alert1.setContentText("El producto ya se encuentra agregado en la lista de productos de la orden, intentelo nuevamente");
        			alert1.showAndWait();
        		}else {
        			Alert alert2 = new Alert(AlertType.INFORMATION);
            		alert2.setTitle("Informacion");
            		alert2.setHeaderText(null);
            		alert2.setContentText("El producto ha sido agregado exitosamente a la lista de productos de la orden");
            		alert2.showAndWait();
        		}
        		txtNameProductOrder.clear();
        		txtProductQuantity.clear();
        		cmbxProductSizes.getItems().clear();
        		initializeTableViewOfOrderProducts();
        		initializeTableViewOfOrderProductsQ();
    		}else {
    		    showValidationErrorAlert();
    		}
    	}
    }
    
    @FXML
    public void deleteProductOfAnOrder(ActionEvent event) {
    	Order selectedOrder = tvOfOrders.getSelectionModel().getSelectedItem();
    	Product selectedProduct = tvOfOrderProducts.getSelectionModel().getSelectedItem();
    	String userId = lbUserId.getText();
    	Alert alert1 = new Alert(AlertType.CONFIRMATION);
    	alert1.setTitle("Confirmacion de proceso");
    	alert1.setHeaderText(null);
    	alert1.setContentText("¿Esta seguro de que quiere eliminar este producto de la orden?");
    	Optional<ButtonType> result = alert1.showAndWait();
    	if (result.get() == ButtonType.OK && selectedProduct!=null){
    		restauranteLaCasaDorada.deleteProductsOfAnOrder(selectedOrder,selectedProduct, userId);
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Informacion");
    		alert2.setHeaderText(null);
    		alert2.setContentText("El producto ha sido eliminado exitosamente de la lista de productos de la orden");
    		alert2.showAndWait();
    	}
    	txtNameProductOrder.clear();
    	txtProductQuantity.clear();
    	cmbxProductSizes.getItems().clear();
    	initializeTableViewOfOrderProducts();
    	initializeTableViewOfOrderProductsQ();
    }
    
    @FXML
    public void addOrder(ActionEvent event) {
    	if (cmbxClients.getValue()!=null && cbEmployee.getValue()!=null && !txtAreaObservations.getText().equals("")) {
    		Client selectedClient = cmbxClients.getValue();
    		Employee selectedEmployee = cbEmployee.getValue();
    		String userId = lbUserId.getText();
    		String obs = txtAreaObservations.getText();
    		restauranteLaCasaDorada.createOrder(selectedClient, selectedEmployee, obs, userId);
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Informacion");
    		alert2.setHeaderText(null);
    		alert2.setContentText("La orden ha sido creada exitosamente");
    		alert2.showAndWait();
    		cmbxClients.getItems().clear();
    		cbEmployee.getItems().clear();
    		txtAreaObservations.clear();
    		initializeTableViewOfOrders();
    	}else {
    		showValidationErrorAlert();
    	}
    }

    @FXML
    public void updateOrder(ActionEvent event) {
    	Order selectedOrder = tvOfOrders.getSelectionModel().getSelectedItem();
    	if (cmbxClients.getValue()!=null && cbEmployee.getValue()!=null && !txtAreaObservations.getText().equals("")) {
    		Client selectedClient = cmbxClients.getValue();
    		Employee selectedEmployee = cbEmployee.getValue();
    		String userId = lbUserId.getText();
    		String obs = txtAreaObservations.getText();
    		restauranteLaCasaDorada.updateOrder(selectedOrder,selectedClient, selectedEmployee, obs, userId);
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Informacion");
    		alert2.setHeaderText(null);
    		alert2.setContentText("La orden ha sido actualizada exitosamente");
    		alert2.showAndWait();
    		cmbxClients.getItems().clear();
    		cbEmployee.getItems().clear();
    		txtAreaObservations.clear();
    		tvOfOrders.getItems().clear();
    		initializeTableViewOfOrders();
    	}else {
    		showValidationErrorAlert();
    	}
    }

    @FXML
    public void returnToManageAnOrder(ActionEvent event) throws IOException {
    	manageAnOrder(null);
    }
    
    @FXML
    public void showAboutCreators(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Restaurante La Casa Dorada");
	    alert.setHeaderText("Créditos:");
	    alert.setContentText("Keren Lopez Cordoba y Angelica Corrales Quevedo\nEstudiantes de Ingenieria de Sistemas\nAlgoritmos y programación II, Universidad Icesi.");
	    alert.showAndWait();
    }
    
    public void showValidationErrorAlert() {
    	Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error de validacion");
		alert.setHeaderText(null);
		alert.setContentText("Recuerde diligenciar cada uno de los campos");
		alert.showAndWait();
    }

    @FXML
    public void signOutOfSystem(ActionEvent event) throws IOException {
		loadLogIn(null);

    }
    
    @FXML
    void returnToManageAProduct(ActionEvent event) throws IOException {
    	manageAProduct(null);
    }
    
    @FXML
    public void returnToMenu(ActionEvent event) throws IOException {
    	lbObjectId.setText("");
    	showMenu(); 
    	lbUserNameMenu.setText(lbUserName.getText());
    	lbUserIdMenu.setText(lbUserId.getText());
    }
    
    
    
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void enableButtons() {
    	btDelete.setDisable(false);
		btUpdate.setDisable(false);
		ckbxDisable.setDisable(false);
		btAdd.setDisable(true);
    }
    
    public void disableButtons() {
    	btDelete.setDisable(true);
		btUpdate.setDisable(true);
		ckbxDisable.setDisable(true);
		btAdd.setDisable(false);
    }
    
    @FXML
    public void manageAUser(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("manage-user.fxml"));
    	fxmlLoader.setController(this);
    	Parent userPane = fxmlLoader.load();
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(userPane);
    	mainPanel.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");
    	initializeTableViewUsers();
    	initializeComboBoxEmployees();
    	if(!restauranteLaCasaDorada.getUsers().isEmpty()) {

    		lbUserName.setText(lbUserNameMenu.getText());

    		lbUserId.setText(lbUserIdMenu.getText());
    	}
    	
    	if(restauranteLaCasaDorada.getUsers().isEmpty()) {
    		btReturnToMenu.setDisable(true);
    	}
    }
    
    
    
    @FXML
    public void clickOnTableViewUsers(MouseEvent event) {
    	if (tvListUsers.getSelectionModel().getSelectedItem() != null) {
    		enableButtons();
    		User selectedUser = tvListUsers.getSelectionModel().getSelectedItem();
    		lbObjectId.setText(selectedUser.getId());
    		txtUserName.setText(selectedUser.getUserName());
    		passwordField.setText(selectedUser.getPassword());
    		txtId.setText(selectedUser.getId());
    		cbEmployee.setValue(selectedUser.getEmployee());

    		
    		ckbxDisable.setSelected(!selectedUser.isEnabled());
    	}
    }

    private void initializeTableViewUsers(){
    	ObservableList<User> observableList;
    	observableList = FXCollections.observableArrayList(restauranteLaCasaDorada.getUsers());
    	tvListUsers.setItems(observableList);
    	
    	colNameUser.setCellValueFactory(new PropertyValueFactory<User, String>("employeeName"));
    	colLastNameUser.setCellValueFactory(new PropertyValueFactory<User, String>("employeeLastName"));
    	colIdUser.setCellValueFactory(new PropertyValueFactory<User, String>("id"));
    	colEnabledUser.setCellValueFactory(new PropertyValueFactory<User, String>("status"));
    	colUserName.setCellValueFactory(new PropertyValueFactory<User, String>("userName"));
    	colPassword.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
    	colCreatorUser.setCellValueFactory(new PropertyValueFactory<User, String>("creatorName"));
    	colModifierUser.setCellValueFactory(new PropertyValueFactory<User, String>("modifierName"));
    	

    	tvListUsers.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }
    
    private void initializeComboBoxEmployees() {
    	ObservableList<Employee> options = FXCollections.observableArrayList(restauranteLaCasaDorada.enabledEmployees());
    	cbEmployee.setPromptText("Elija un empleado");
    	cbEmployee.setItems(options);
    }

    @FXML
    public void createUser(ActionEvent event) throws IOException {
    	if (cbEmployee.getSelectionModel().getSelectedItem()!=null && !txtUserName.getText().isEmpty() && !passwordField.getText().isEmpty()) {
    		
    		
    		boolean added = restauranteLaCasaDorada.createUser(cbEmployee.getSelectionModel().getSelectedItem(),txtUserName.getText().toLowerCase(),passwordField.getText(), lbUserId.getText());
    		if(added) {
    			Alert alert1 = new Alert(AlertType.INFORMATION);
        		alert1.setTitle("Informacion");
        		alert1.setHeaderText(null);
        		alert1.setContentText("El usuario ha sido creado exitosamente!");
        		alert1.showAndWait();
        		
        		txtUserName.clear();
            	passwordField.clear();
            	cbEmployee.setPromptText("Elija un empleado");
            	
            	initializeTableViewUsers();
            	
            	if (lbUserId.getText().equals("id")){
            		loadLogIn(null);
            	}
        		
    		}else {
    			
        		Alert alert2 = new Alert(AlertType.ERROR);
    			alert2.setTitle("Error de validacion");
    			alert2.setHeaderText(null);
    			alert2.setContentText("No se pudo crear el usuario, intentelo nuevamente");
    			alert2.showAndWait();
    		}
    	}else {
    		showValidationErrorAlert();
    	}
    }

    @FXML
    public void deleteUser(ActionEvent event) throws IOException {
    	
    	Alert alert1 = new Alert(AlertType.CONFIRMATION);
    	alert1.setTitle("Confirmacion de proceso");
    	alert1.setHeaderText(null);
    	alert1.setContentText("¿Esta seguro de que quiere eliminar el usuario escogido?");
    	Optional<ButtonType> result = alert1.showAndWait();
    	if (result.get() == ButtonType.OK){
        	restauranteLaCasaDorada.deleteUser(lbObjectId.getText());
        	
        	Alert alert2 = new Alert(AlertType.INFORMATION);
        	alert2.setTitle("Informacion");
        	alert2.setHeaderText(null);

        	alert2.setContentText("El usuario ha sido eliminado exitosamente");
        	alert2.showAndWait();
        	if(lbUserId.getText().equals(lbObjectId.getText())) {
        		
        		if(restauranteLaCasaDorada.getUsers().isEmpty()){
        			manageAUser(null);
            		btReturnToMenu.setDisable(true);

        		}
        		else {
        		
        			loadLogIn(null);

        		}
        	}
        	
        	initializeTableViewUsers();
        	
        	lbObjectId.setText("");
        	txtUserName.clear();
        	passwordField.clear();
        	cbEmployee.setPromptText("Elija un empleado");
        	disableButtons();
        	
        	

    	} 
    	
    }



    @FXML
    public void updateUser(ActionEvent event) {
    	
    	if (cbEmployee.getSelectionModel().getSelectedItem()!=null && !txtUserName.getText().isEmpty() && !passwordField.getText().isEmpty()) {
    		
    		boolean updated = restauranteLaCasaDorada.updateUser(lbObjectId.getText(),cbEmployee.getSelectionModel().getSelectedItem() ,txtUserName.getText().toLowerCase(),passwordField.getText(), !ckbxDisable.isSelected(), lbUserId.getText());
    		if(updated) {
    			Alert alert1 = new Alert(AlertType.INFORMATION);
        		alert1.setTitle("Informacion");
        		alert1.setHeaderText(null);
        		alert1.setContentText("El usuario ha sido actualizado exitosamente!");
        		alert1.showAndWait();
        		tvListUsers.getItems().clear();

        		initializeTableViewUsers();
        		if(lbUserId.getText().equals(lbObjectId.getText())) {
            		lbUserName.setText(txtUserName.getText().toLowerCase());
            	}
            	lbObjectId.setText("");
            	txtUserName.clear();
            	passwordField.clear();
            	cbEmployee.setValue(null);
            	cbEmployee.setPromptText("Elija un empleado");
            	disableButtons();
            	
        		
        		
    		}else {
    			Alert alert2 = new Alert(AlertType.ERROR);
    			alert2.setTitle("Error de validacion");
    			alert2.setHeaderText(null);
    			alert2.setContentText("No se pudo actualizar el usuario, intentelo nuevamente");
    			alert2.showAndWait();
    		}
    	}else {
    		showValidationErrorAlert();
    	}
    }
    
    
    @FXML
    public void loadLogIn(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("userLogin.fxml"));

		fxmlLoader.setController(this);
    	Parent login= fxmlLoader.load();
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(login);
		mainPanel.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");

    }
    
    @FXML
    public void logIn(ActionEvent event) throws IOException {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText(null);

		if(txtUserName.getText().isEmpty() && passwordField.getText().isEmpty()) {
    		showValidationErrorAlert();

		}
		else {
			String id=restauranteLaCasaDorada.logInUser(txtUserName.getText(), passwordField.getText());
			if(!id.isEmpty()){

				
				
				showMenu();
				lbUserNameMenu.setText(txtUserName.getText());

				lbUserIdMenu.setText(id);

			}
			else {
				alert.setTitle("No se pudo iniciar sesión");
				alert.setContentText("El usuario o la contraseña son incorrectos. Intente nuevamente");

				alert.showAndWait();
			}
		}
		
		txtUserName.clear();
    	passwordField.clear();
		
    }
    
    
    @FXML
    public void manageAnEmployee(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("manage-employee.fxml"));
    	fxmlLoader.setController(this);

    	Parent emplPane = fxmlLoader.load();

    	mainPanel.getChildren().clear();

    	mainPanel.setCenter(emplPane);

    	mainPanel.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");
    	initializeTableViewEmployees();
    	if(!restauranteLaCasaDorada.getEmployees().isEmpty()) {

    		lbUserName.setText(lbUserNameMenu.getText());

    		lbUserId.setText(lbUserIdMenu.getText());
    	}
    	
    	if(restauranteLaCasaDorada.getEmployees().isEmpty()) {
    		btReturnToMenu.setDisable(true);
    	}

    	
    }
    
    @FXML
    public void clickOnTableViewEmployees(MouseEvent event) {
    	if (tvListEmployees.getSelectionModel().getSelectedItem() != null) {
    		enableButtons();
    		Employee selectedEmployee = tvListEmployees.getSelectionModel().getSelectedItem();
    		lbObjectId.setText(selectedEmployee.getId());
    		txtName.setText(selectedEmployee.getName());
    		txtLastName.setText(selectedEmployee.getLastName());
    		txtId.setText(selectedEmployee.getId());
   		
    		ckbxDisable.setSelected(!selectedEmployee.isEnabled());
    	}
    }
    
    private void initializeTableViewEmployees(){
    	ObservableList<Employee> observableList;
    	observableList = FXCollections.observableArrayList(restauranteLaCasaDorada.getEmployees());
    	tvListEmployees.setItems(observableList);
    	
    	colNameEmployee.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
    	colLastNameEmployee.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
    	colIdEmployee.setCellValueFactory(new PropertyValueFactory<Employee, String>("id"));
    	colEnabledEmployee.setCellValueFactory(new PropertyValueFactory<Employee, String>("status"));
    	colCreatorEmployee.setCellValueFactory(new PropertyValueFactory<Employee, String>("creatorName"));
    	colModifierEmployee.setCellValueFactory(new PropertyValueFactory<Employee, String>("modifierName"));
    	

    	tvListEmployees.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }
    

   
   

    @FXML
    public void createEmployee(ActionEvent event) throws IOException {
    	if (!txtName.getText().isEmpty() && !txtLastName.getText().isEmpty() && !txtId.getText().isEmpty()) {
    		
    		boolean added = restauranteLaCasaDorada.createEmployee(txtId.getText(),txtName.getText().toUpperCase(),txtLastName.getText().toUpperCase(), lbUserId.getText());
    		if(added) {
    			Alert alert1 = new Alert(AlertType.INFORMATION);
        		alert1.setTitle("Informacion");
        		alert1.setHeaderText(null);
        		alert1.setContentText("El empleado ha sido creado exitosamente!");
        		alert1.showAndWait();
        		
        		txtName.clear();
        		txtLastName.clear();
            	txtId.clear();
            	
            	initializeTableViewEmployees();

            	
            	if (lbUserId.getText().equals("id")){
            		manageAUser(null);
            	}
        		
    		}else {
    			
        		Alert alert2 = new Alert(AlertType.ERROR);
    			alert2.setTitle("Error de validacion");
    			alert2.setHeaderText(null);
    			alert2.setContentText("No se pudo crear el empleado, intentelo nuevamente");
    			alert2.showAndWait();
    		}
    	}else {
    		showValidationErrorAlert();
    	}
    }

    @FXML
    public void deleteEmployee(ActionEvent event) {
    	
    	Alert alert1 = new Alert(AlertType.CONFIRMATION);
    	alert1.setTitle("Confirmacion de proceso");
    	alert1.setHeaderText(null);
    	alert1.setContentText("¿Esta seguro de que quiere eliminar el empleado escogido?");
    	Optional<ButtonType> result = alert1.showAndWait();
    	if (result.get() == ButtonType.OK){
        	
    		boolean deleted= restauranteLaCasaDorada.deleteEmployee(lbObjectId.getText());
        	Alert alert2 = new Alert(AlertType.INFORMATION);
        	alert2.setTitle("Informacion");
        	alert2.setHeaderText(null);
        	
        	if(deleted) {
        		alert2.setContentText("El empleado ha sido eliminado exitosamente");
        		lbObjectId.setText("");
        		txtName.clear();
        		txtLastName.clear();
            	txtId.clear();
            	disableButtons();

            	
            	initializeTableViewEmployees();
            	
            	

            	
        	}else {
        		alert2.setContentText("El empleado no pudo ser eliminado debido a que tienen una cuenta de usuario");

        	}
        	alert2.showAndWait();
        	
        	
    	}
    	
    }

   

    @FXML
    public void updateEmployee(ActionEvent event) {
    	if (!txtName.getText().isEmpty() && !txtLastName.getText().isEmpty() && !txtId.getText().isEmpty()) {

    		boolean updated = restauranteLaCasaDorada.updateEmployee(lbObjectId.getText(),txtId.getText() ,txtName.getText().toUpperCase(),txtLastName.getText().toUpperCase(), !ckbxDisable.isSelected(), lbUserId.getText());
    		if(updated) {
            	

    			Alert alert1 = new Alert(AlertType.INFORMATION);
        		alert1.setTitle("Informacion");
        		alert1.setHeaderText(null);
        		alert1.setContentText("El empleado ha sido actualizado exitosamente!");
        		alert1.showAndWait();

        		lbObjectId.setText("");
        		txtName.clear();
        		txtLastName.clear();
            	txtId.clear();

            	disableButtons();
            	tvListEmployees.getItems().clear();

            	initializeTableViewEmployees();


        		
    		}else {
    			Alert alert2 = new Alert(AlertType.ERROR);
    			alert2.setTitle("Error de validacion");
    			alert2.setHeaderText(null);
    			alert2.setContentText("No se pudo actualizar el empleado, intentelo nuevamente");
    			alert2.showAndWait();
    		}

    	}else {
    		showValidationErrorAlert();
    	}
    }
    
    
    @FXML
    public void manageAClient(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("manage-client.fxml"));
    	fxmlLoader.setController(this);

    	Parent clientPane = fxmlLoader.load();

    	mainPanel.getChildren().clear();

    	mainPanel.setCenter(clientPane);

    	mainPanel.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");
    	initializeTableViewClients();

    	lbUserName.setText(lbUserNameMenu.getText());

    	lbUserId.setText(lbUserIdMenu.getText());  	

    }
    
    private void initializeTableViewClients(){
    	ObservableList<Client> observableList;
    	observableList = FXCollections.observableArrayList(restauranteLaCasaDorada.getClients());
    	tvListClients.setItems(observableList);
    	
    	colNameClient.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
    	colLastNameClient.setCellValueFactory(new PropertyValueFactory<Client, String>("lastName"));
    	colIdClient.setCellValueFactory(new PropertyValueFactory<Client, String>("id"));
    	colAddressClient.setCellValueFactory(new PropertyValueFactory<Client, String>("address"));
    	colPhoneClient.setCellValueFactory(new PropertyValueFactory<Client, String>("phone"));
    	colObsClient.setCellValueFactory(new PropertyValueFactory<Client, String>("observations"));
    	colEnabledClient.setCellValueFactory(new PropertyValueFactory<Client, String>("status"));
    	colCreatorClient.setCellValueFactory(new PropertyValueFactory<Client, String>("creatorName"));
    	colModifierClient.setCellValueFactory(new PropertyValueFactory<Client, String>("modifierName"));
    	

    	tvListEmployees.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }

    
    @FXML
    public void clickOnTableViewClients(MouseEvent event) {
    	if (tvListClients.getSelectionModel().getSelectedItem() != null) {
    		enableButtons();
    		Client selectedClient = tvListClients.getSelectionModel().getSelectedItem();
    		lbObjectId.setText(selectedClient.getId());
    		txtName.setText(selectedClient.getName());
    		txtLastName.setText(selectedClient.getLastName());
    		txtId.setText(selectedClient.getId());
    		txtAddress.setText(selectedClient.getAddress());
    		txtPhone.setText(selectedClient.getPhone());
    		txtObservations.setText(selectedClient.getObservations());

   		
    		ckbxDisable.setSelected(!selectedClient.isEnabled());
    	}
    }

    @FXML
    public void createClient(ActionEvent event) {
    	if (!txtId.getText().isEmpty() && !txtName.getText().isEmpty() && !txtLastName.getText().isEmpty() && !txtAddress.getText().isEmpty() && !txtPhone.getText().isEmpty() && !txtObservations.getText().isEmpty()) {

    		boolean added = restauranteLaCasaDorada.createClient(txtId.getText(),txtName.getText().toUpperCase(),txtLastName.getText().toUpperCase(), txtAddress.getText().toUpperCase(),txtPhone.getText(),txtObservations.getText(), lbUserId.getText());
    		if(added) {
    			Alert alert1 = new Alert(AlertType.INFORMATION);
    			alert1.setTitle("Informacion");
    			alert1.setHeaderText(null);
    			alert1.setContentText("El cliente ha sido creado exitosamente!");
    			alert1.showAndWait();

    			txtName.clear();
    			txtLastName.clear();
    			txtId.clear();
    			txtAddress.clear();
    			txtPhone.clear();
    			txtObservations.clear();


    			initializeTableViewClients();

    		}else {

    			Alert alert2 = new Alert(AlertType.ERROR);
    			alert2.setTitle("Error de validacion");
    			alert2.setHeaderText(null);
    			alert2.setContentText("No se pudo crear el cliente, intentelo nuevamente");
    			alert2.showAndWait();
    		}
    	}else {
    		showValidationErrorAlert();
    	}
    }

    @FXML
    public void deleteClient(ActionEvent event) {
    	Alert alert1 = new Alert(AlertType.CONFIRMATION);
    	alert1.setTitle("Confirmacion de proceso");
    	alert1.setHeaderText(null);
    	alert1.setContentText("¿Esta seguro de que quiere eliminar el cliente escogido?");
    	Optional<ButtonType> result = alert1.showAndWait();
    	if (result.get() == ButtonType.OK){
        	
    		boolean deleted= restauranteLaCasaDorada.deleteClient(lbObjectId.getText());
        	Alert alert2 = new Alert(AlertType.INFORMATION);
        	alert2.setTitle("Informacion");
        	alert2.setHeaderText(null);
        	
        	if(deleted) {
        		alert2.setContentText("El cliente ha sido eliminado exitosamente");
        		lbObjectId.setText("");
        		txtName.clear();
        		txtLastName.clear();
            	txtId.clear();
            	txtPhone.clear();
            	txtAddress.clear();
            	txtObservations.clear();

            	disableButtons();

            	
            	initializeTableViewClients();
            	
            	           	
        	}else {
        		alert2.setContentText("El cliente no pudo ser eliminado");

        	}
        	alert2.showAndWait();
        	
        	
    	}
    	
    }


    @FXML
    public void updateClient(ActionEvent event) {
    	if (!txtId.getText().isEmpty() && !txtName.getText().isEmpty() && !txtLastName.getText().isEmpty() && !txtAddress.getText().isEmpty() && !txtPhone.getText().isEmpty() && !txtObservations.getText().isEmpty()) {

    		boolean updated = restauranteLaCasaDorada.updateClient(lbObjectId.getText(), txtId.getText(),txtName.getText().toUpperCase(),txtLastName.getText().toUpperCase(), txtAddress.getText().toUpperCase(),txtPhone.getText(),txtObservations.getText(), !ckbxDisable.isSelected(),lbUserId.getText());

    		if(updated) {
            	

    			Alert alert1 = new Alert(AlertType.INFORMATION);
        		alert1.setTitle("Informacion");
        		alert1.setHeaderText(null);
        		alert1.setContentText("El empleado ha sido actualizado exitosamente!");
        		alert1.showAndWait();

        		lbObjectId.setText("");
        		txtName.clear();
        		txtLastName.clear();
            	txtId.clear();
            	txtPhone.clear();
            	txtAddress.clear();
            	txtObservations.clear();

            	disableButtons();
            	tvListClients.getItems().clear();

            	initializeTableViewClients();
        		
    		}else {
    			Alert alert2 = new Alert(AlertType.ERROR);
    			alert2.setTitle("Error de validacion");
    			alert2.setHeaderText(null);
    			alert2.setContentText("No se pudo actualizar el empleado, intentelo nuevamente");
    			alert2.showAndWait();
    		}

    	}else {
    		showValidationErrorAlert();
    	}
    	
    }

    
    

}