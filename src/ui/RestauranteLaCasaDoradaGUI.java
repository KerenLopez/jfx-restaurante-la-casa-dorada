package ui;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.DatePicker;
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
import javafx.stage.FileChooser;
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
	private Label lbExportTitle;

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
    private TableColumn<Product, String> colProductSizes;

    @FXML
    private TableColumn<Product, Double> colProductPrices;

    @FXML
    private TableColumn<Product, String> colProductIngredients;

    @FXML
    private TableColumn<Product, String> colNameProduct;
    
    @FXML
    private TableColumn<Product, String> colTypeProduct;

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
    private TableColumn<Order, String> colOrderTotalPrice;

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
    private TableView<Product> tvOfOrderProductsN;

    @FXML
    private TableColumn<Product, String> colNameOrderProduct;

    @FXML
    private TableView<Order> tvOfOrderProductsS;

    @FXML
    private TableColumn<Order, String> colSizeOrderProduct;
    
    @FXML
    private TableView<Order> tvOfOrderProductsQ;

    @FXML
    private TableColumn<Order, String> colQuantityOrderProduct;
    
    @FXML
    private TableColumn<Order, String> colProductsInOrder;

	@FXML
	private CheckBox ckbxDisable;

	@FXML
    private Label lbManageProduct;
	
    @FXML
    private Label lbManageOrder;
	
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
    private Button btSortProductPrices;
    
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
    
    @FXML
    private DatePicker dtPickerInitialDate;

    @FXML
    private DatePicker dtPickerFinalDate;

    @FXML
    private ComboBox<String> cmbxInitialHour;

    @FXML
    private ComboBox<String> cmbxInitialMinute;

    @FXML
    private ComboBox<String> cmbxFinalHour;

    @FXML
    private ComboBox<String> cmbxFinalMinute;

    @FXML
    private TextField txtSeparator;
    
    @FXML
    private TextField txtClientSearchedName;

    @FXML
    private TextField txtClientSearchedLastName;

    
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
    	colTypeProduct.setCellValueFactory(new PropertyValueFactory<Product, String>("TypeName"));
    	colProductSizes.setCellValueFactory(new PropertyValueFactory<Product, String>("AllSizes"));
    	colProductPrices.setCellValueFactory(new PropertyValueFactory<Product, Double>("AllPrices"));
    	colProductIngredients.setCellValueFactory(new PropertyValueFactory<Product, String>("AllIngredients"));
    	colStatusProduct.setCellValueFactory(new PropertyValueFactory<Product, String>("Status"));
    	colCreatorProduct.setCellValueFactory(new PropertyValueFactory<Product, String>("CreatorName"));
    	colModifierProduct.setCellValueFactory(new PropertyValueFactory<Product, String>("ModifierName"));
    	tvOfProducts.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    	tvOfProducts.setVisible(true);
    	if(!restauranteLaCasaDorada.getProducts().isEmpty()) {
    		btSortProductPrices.setDisable(false);
    	}
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
    	if (tvOfAddedIngredients.getSelectionModel().getSelectedItem()!=null) {
    		btAddIngredient.setDisable(false);
    		btDeleteIngredient.setDisable(true);
    		Ingredient selectedIngredient= tvOfAddedIngredients.getSelectionModel().getSelectedItem();
    		txtIngredientName.setText(selectedIngredient.getName());
    	}
    }
    
    @FXML
    public void clickOnTableViewOfIngredientsInAProduct(MouseEvent event) {
    	if (tvOfIngredientsInAProduct.getSelectionModel().getSelectedItem()!=null) {
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
    	btSortProductPrices.setVisible(false);

    }
    
    @FXML
    public void addIngredientToAProduct(ActionEvent event) throws IOException {
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
    public void deleteAnIngredientOfAProduct(ActionEvent event) throws IOException {
    	Product p =  tvOfProducts.getSelectionModel().getSelectedItem();
    	Ingredient selectedIngredient= tvOfIngredientsInAProduct.getSelectionModel().getSelectedItem();
    	String userId = lbUserId.getText();
    	Alert alert1 = new Alert(AlertType.CONFIRMATION);
    	alert1.setTitle("Confirmacion de proceso");
    	alert1.setHeaderText(null);
    	alert1.setContentText("?Esta seguro de que quiere eliminar este ingrediente del producto?");
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
    	tvOfIngredientsInAProduct.getItems().clear();
    	initializeTableViewOfIngredientsInAProduct();
    	btDeleteIngredient.setDisable(true);
		btAddIngredient.setDisable(false);
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
    	if (tvOfSizes.getSelectionModel().getSelectedItem()!=null) {
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
    	lbManageProduct.setText("Lista de tama?os agregados");
    	tvOfProducts.setVisible(false);
    	initializeTableViewOfSizes();
    	btSortProductPrices.setVisible(false);
    }
    
    @FXML
    public void addSizeOfAProduct(ActionEvent event) throws IOException {
    	Product p =  tvOfProducts.getSelectionModel().getSelectedItem();
    	String userId = lbUserId.getText();
    	Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("Error de validacion");
		alert1.setHeaderText(null);
    	if(!txtSizeName.getText().equals("") && !txtSizePrice.getText().equals("")) {
    		try {
    			String name = txtSizeName.getText();
    			double price = Double.parseDouble(txtSizePrice.getText());
    			boolean added = restauranteLaCasaDorada.addSizeOfAProduct(p, name, price, userId);
    			if(added==false) {

    				alert1.setContentText("El tama?o ya se encuentra agregado en la lista de tama?os del producto, intentelo nuevamente");
    				alert1.showAndWait();
    			}else {
    				Alert alert2 = new Alert(AlertType.INFORMATION);
    				alert2.setTitle("Informacion");
    				alert2.setHeaderText(null);
    				alert2.setContentText("El tama?o ha sido agregado exitosamente a la lista de tama?os del producto");
    				alert2.showAndWait();
    			}
    			txtSizeName.clear();
    			txtSizePrice.clear();
    			initializeTableViewOfSizes();
    		}catch(NumberFormatException nfe) {
    			alert1.setContentText("El precio debe darse en formato num?rico");
				alert1.showAndWait();
    		}
    	}else {
    		showValidationErrorAlert();
    	}
    }
   
    @FXML
    public void deleteSizeOfAProduct(ActionEvent event) throws IOException {
    	Product p =  tvOfProducts.getSelectionModel().getSelectedItem();
    	Size selectedSize= tvOfSizes.getSelectionModel().getSelectedItem();
    	Alert alert1 = new Alert(AlertType.CONFIRMATION);
    	alert1.setTitle("Confirmacion de proceso");
    	alert1.setHeaderText(null);
    	alert1.setContentText("?Esta seguro de que quiere eliminar este tama?o del producto?");
    	Optional<ButtonType> result = alert1.showAndWait();
    	if (result.get() == ButtonType.OK && selectedSize!=null){
    		restauranteLaCasaDorada.deleteSizeOfAProduct(p, selectedSize);
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Informacion");
    		alert2.setHeaderText(null);
    		alert2.setContentText("El tama?o ha sido eliminado exitosamente de la lista de tama?os del producto");
    		alert2.showAndWait();
    		txtSizeName.clear();
    		txtSizePrice.clear();
    		initializeTableViewOfSizes();
    	}
    }
    
    @FXML
    public void updateSizeOfAProduct(ActionEvent event) throws IOException {
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
    			alert1.setContentText("Ya existe un tama?o con el nombre ingresado, intentelo nuevamente");
    			alert1.showAndWait();
    		}else {
    			Alert alert2 = new Alert(AlertType.INFORMATION);
        		alert2.setTitle("Informacion");
        		alert2.setHeaderText(null);
        		alert2.setContentText("El tama?o ha sido actualizado exitosamente de la lista de tama?os del producto");
        		alert2.showAndWait();
    		}
    		txtSizeName.clear();
    		txtSizePrice.clear();
    		tvOfSizes.getItems().clear();
    		initializeTableViewOfSizes();
    		btDeleteSize.setDisable(true);
    		btAddSize.setDisable(false);
    		btUpdateSize.setDisable(true);
    	}else {
    		showValidationErrorAlert();
    	}
    }
    
    @FXML
    public void addProduct(ActionEvent event) throws IOException {
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
    public void deleteProduct(ActionEvent event) throws IOException {
    	Product selectedProduct = tvOfProducts.getSelectionModel().getSelectedItem();
    	Alert alert1 = new Alert(AlertType.CONFIRMATION);
    	alert1.setTitle("Confirmacion de proceso");
    	alert1.setHeaderText(null);
    	alert1.setContentText("?Esta seguro de que quiere eliminar este producto?");
    	Optional<ButtonType> result = alert1.showAndWait();
    	if (result.get() == ButtonType.OK && selectedProduct!=null){
        	boolean deleted = restauranteLaCasaDorada.deleteProduct(selectedProduct);
        	Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Informacion");
    		alert2.setHeaderText(null);
        	if(deleted==true) {
        		alert2.setContentText("El producto ha sido eliminado exitosamente");
        		alert2.showAndWait();
        	}else {
        		alert2.setContentText("El producto no pudo ser eliminado debido a que se encuentra dentro de un pedido");
        		alert2.showAndWait();
        	}
        	txtProductName.clear();
        	cmbxTypeOfProduct.getItems().clear();
        	cmbxTypeOfProduct.setPromptText("Elija uno");
        	ckbxDisable.setSelected(false);
        	tvOfProducts.getItems().clear();
        	initializeTableViewOfProducts(); 
        	disableButtons();
    	} 
    }

    @FXML
    public void updateProduct(ActionEvent event) throws IOException {
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
    
    @FXML
    public void sortingPricesOfProducts(ActionEvent event) {
    	ObservableList<Product> observableList;
    	observableList = FXCollections.observableArrayList(restauranteLaCasaDorada.sortingPricesOfProducts());
    	tvOfProducts.setItems(observableList);
    	colNameProduct.setCellValueFactory(new PropertyValueFactory<Product, String>("Name"));
    	colTypeProduct.setCellValueFactory(new PropertyValueFactory<Product, String>("TypeName"));
    	colProductSizes.setCellValueFactory(new PropertyValueFactory<Product, String>("AllSizes"));
    	colProductPrices.setCellValueFactory(new PropertyValueFactory<Product, Double>("AllPrices"));
    	colProductIngredients.setCellValueFactory(new PropertyValueFactory<Product, String>("AllIngredients"));
    	colStatusProduct.setCellValueFactory(new PropertyValueFactory<Product, String>("Status"));
    	colCreatorProduct.setCellValueFactory(new PropertyValueFactory<Product, String>("CreatorName"));
    	colModifierProduct.setCellValueFactory(new PropertyValueFactory<Product, String>("ModifierName"));
    	tvOfProducts.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    	tvOfProducts.setVisible(true);
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
    	if (tvOfTypeOfProducts.getSelectionModel().getSelectedItem()!=null) {
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
    public void addTypeOfProduct(ActionEvent event) throws IOException {
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
    public void deleteTypeOfProduct(ActionEvent event) throws IOException {
    	Alert alert1 = new Alert(AlertType.CONFIRMATION);
    	alert1.setTitle("Confirmacion de proceso");
    	alert1.setHeaderText(null);
    	alert1.setContentText("?Esta seguro de que quiere eliminar este tipo de ingrediente?");
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
        	disableButtons();
    	} 
    }

    @FXML
    public void updateTypeOfProduct(ActionEvent event) throws IOException {
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
    public void addIngredient(ActionEvent event) throws IOException {
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
    public void deleteIngredient(ActionEvent event) throws IOException {
    	Alert alert1 = new Alert(AlertType.CONFIRMATION);
    	alert1.setTitle("Confirmacion de proceso");
    	alert1.setHeaderText(null);
    	alert1.setContentText("?Esta seguro de que quiere eliminar este ingrediente?");
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
        	disableButtons();
    	} 
    }

    @FXML
    public void updateIngredient(ActionEvent event) throws IOException {
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
    
    @FXML
    public void sortListIngredients(ActionEvent event) {
    	ObservableList<Ingredient> observableList;
    	observableList = FXCollections.observableArrayList(restauranteLaCasaDorada.insertionSortIngredients());
    	tvOfIngredients.setItems(observableList);
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
    	colProductsInOrder.setCellValueFactory(new PropertyValueFactory<Order, String>("AllProducts"));
    	colOrderTotalPrice.setCellValueFactory(new PropertyValueFactory<Order, String>("OrderTotalPrice"));
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
    public void showFormStateOfAnOrder(ActionEvent event) {
    	createOrderForm.setVisible(false);
    	updateStateForm.setVisible(true);
    	tvOfOrders.setMouseTransparent(true);
    	Order selectedOrder = tvOfOrders.getSelectionModel().getSelectedItem();
    	switch(selectedOrder.getStateOfOrder().name()) {
    	case "SOLICITADO":
    		rbSent.setDisable(false);
    		rbDelivered.setDisable(false);
    		rbCancelled.setDisable(false);
    		rbInProcess.setDisable(false);
    		break;
    	case "EN_PROCESO":
    		rbSent.setDisable(false);
   		 	rbDelivered.setDisable(false);
   		 	rbCancelled.setDisable(false);
   		 	break;
    	case "ENVIADO":
   		 	rbDelivered.setDisable(false);
   		 	break;
    	}
    }
    
    @FXML
    public void changeStateOfAnOrder(ActionEvent event) throws IOException {
    	Order selectedOrder = tvOfOrders.getSelectionModel().getSelectedItem();
    	String newState = getRadioButtonState();
    	if(!newState.equals("")) {
    		restauranteLaCasaDorada.updateStateOfAnOrder(selectedOrder,newState);
        	Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Informacion");
    		alert2.setHeaderText(null);
    		alert2.setContentText("El estado de la orden ha sido actualizado exitosamente");
    		alert2.showAndWait();
    		tvOfOrders.getItems().clear();
    		initializeTableViewOfOrders();
    		returnToManageAnOrder(null);
    	}else {
    		showValidationErrorAlert();
    	}
    }
    
    public String getRadioButtonState() {
    	String state = "";
    	if(rbSent.isSelected()) {
    		state = "ENVIADO";
    	} else if (rbDelivered.isSelected()) {
    		state = "ENTREGADO";
    	}else if (rbCancelled.isSelected()) {
    		state = "CANCELADO";
    	} else if(rbInProcess.isSelected()){
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
    
    private void initializeTableViewOfOrderProductsN() {
    	ObservableList<Product> observableList;
    	if(!tvOfOrders.getSelectionModel().getSelectedItem().getListOfProducts().isEmpty()) {
    		observableList = FXCollections.observableArrayList(tvOfOrders.getSelectionModel().getSelectedItem().getListOfProducts());
    		tvOfOrderProductsN.setItems(observableList);
    		colNameOrderProduct.setCellValueFactory(new PropertyValueFactory<Product, String>("Name"));
    		tvOfOrderProductsN.setVisible(true);
    	}
	}
    
    private void initializeTableViewOfOrderProductsS() {
    	ObservableList<Order> observableList;
    	if(!tvOfOrders.getSelectionModel().getSelectedItem().getListOfProducts().isEmpty()) {
    		observableList = FXCollections.observableArrayList(tvOfOrders.getSelectionModel().getSelectedItem());
    		tvOfOrderProductsS.setItems(observableList);
    		colSizeOrderProduct.setCellValueFactory(new PropertyValueFactory<Order, String>("AllSizes"));
    		tvOfOrderProductsS.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    		tvOfOrderProductsS.setVisible(true);
    	}
	}
    
    private void initializeTableViewOfOrderProductsQ() {
    	ObservableList<Order> observableList;
    	if(!tvOfOrders.getSelectionModel().getSelectedItem().getListOfQuantity().isEmpty()) {
    		observableList = FXCollections.observableArrayList(tvOfOrders.getSelectionModel().getSelectedItem());
    		tvOfOrderProductsQ.setItems(observableList);
    		colQuantityOrderProduct.setCellValueFactory(new PropertyValueFactory<Order, String>("AllQuantities"));
    		tvOfOrderProductsQ.setVisible(true);
    	}
	}

    @FXML
    public void chooseProductsOfAnOrder(ActionEvent event) {
    	createOrderForm.setVisible(false);
    	tvOfOrders.setVisible(false);
    	lbManageOrder.setVisible(false);
    	addIngredientsToAnOrderForm.setVisible(true);
    	initializeTableViewOfAddedProducts();
    	initializeTableViewOfOrderProductsN();
    	initializeTableViewOfOrderProductsS();
    	initializeTableViewOfOrderProductsQ();
    }

    @FXML
    public void clickOnTableViewOfOrders(MouseEvent event) {
    	if ((tvOfOrders.getSelectionModel().getSelectedItem() != null) && (!tvOfOrders.getSelectionModel().getSelectedItem().getStateOfOrder().name().equals("CANCELADO")&& (!tvOfOrders.getSelectionModel().getSelectedItem().getStateOfOrder().name().equals("ENTREGADO")))) {
    		String state = tvOfOrders.getSelectionModel().getSelectedItem().getStateOfOrder().name();
    		
    		btChangeState.setDisable(false);	
    		btUpdate.setDisable(false);
    		btAdd.setDisable(true);
    		if(state.equals("ENVIADO")) {
    			btAddProductsOrder.setDisable(true);
    			cmbxClients.setDisable(true);
    			txtAreaObservations.setDisable(true);
    			
    		}else {
        		btAddProductsOrder.setDisable(false);
        		cmbxClients.setDisable(false);
    			cbEmployee.setDisable(false);
    			txtAreaObservations.setDisable(false);

    		}
    		Order selectedOrder = tvOfOrders.getSelectionModel().getSelectedItem();
    		lbObjectId.setText(""+selectedOrder.getCode());
    		cmbxClients.setValue(selectedOrder.getBuyer());
    		cbEmployee.setValue(selectedOrder.getDeliverer());
    		txtAreaObservations.setText(selectedOrder.getObservations());
    	}else {
    		if((tvOfOrders.getSelectionModel().getSelectedItem() != null)) {
    			btUpdate.setDisable(true);
    			btAddProductsOrder.setDisable(true);
    			btChangeState.setDisable(true);
    			cmbxClients.setDisable(true);
    			cbEmployee.setDisable(true);
    			txtAreaObservations.setDisable(true);
    			btAdd.setDisable(true);
    		}
	
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
    		cmbxProductSizes.setPromptText("Elija un Tama?o");
    	}
    }
    
    @FXML
    public void clickOnTableViewOfOrderProducts(MouseEvent event) {
    	Order selectedOrder = tvOfOrders.getSelectionModel().getSelectedItem();
    	Product selectedProduct = tvOfOrderProductsN.getSelectionModel().getSelectedItem();
    	if (selectedProduct!= null) {
    		btDeleteProduct.setDisable(false);
    		txtNameProductOrder.setText(selectedProduct.getName());
    		cmbxProductSizes.setValue(restauranteLaCasaDorada.getSelectedSize(selectedOrder,selectedProduct));
    		txtProductQuantity.setText(""+restauranteLaCasaDorada.getQuantity(selectedOrder,selectedProduct));
    	}
    }
   
    @FXML
    public void addProductToAnOrder(ActionEvent event) throws IOException {
    	Order selectedOrder = tvOfOrders.getSelectionModel().getSelectedItem();
    	Product selectedProduct = tvOfAddedProducts.getSelectionModel().getSelectedItem();
    	String userId = lbUserId.getText();
    	Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("Error de validacion");
		alert1.setHeaderText(null);
    	if (selectedProduct!= null) {
    		if (!txtProductQuantity.getText().equals("") && cmbxProductSizes.getValue()!=null) {
    			try {
    				Size selectedSize = cmbxProductSizes.getValue();
    				int quantity = Integer.parseInt(txtProductQuantity.getText());
    				if(quantity>0) {
    					boolean added = restauranteLaCasaDorada.addProductsToAnOrder(selectedOrder,selectedProduct,selectedSize,quantity, userId);
    					if(added==false) {
    						
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
    					tvOfOrderProductsN.getItems().clear();
    					tvOfOrderProductsS.getItems().clear();
    					tvOfOrderProductsQ.getItems().clear();
    					initializeTableViewOfOrderProductsN();
    					initializeTableViewOfOrderProductsS();
    					initializeTableViewOfOrderProductsQ();
    				}else {
    					
    					alert1.setContentText("La cantidad del producto no puede ser cero o un n?mero negativo, intentelo nuevamente");
    					alert1.showAndWait();
    				}
    			}catch(NumberFormatException nfe){
    				
					alert1.setContentText("La cantidad del producto debe darse en formato num?rico");
					alert1.showAndWait();
    			}
    		}else {
    		    showValidationErrorAlert();
    		}
    	}
    }
    
    @FXML
    public void deleteProductOfAnOrder(ActionEvent event) throws IOException {
    	Order selectedOrder = tvOfOrders.getSelectionModel().getSelectedItem();
    	Product selectedProduct = tvOfOrderProductsN.getSelectionModel().getSelectedItem();
    	String userId = lbUserId.getText();
    	Alert alert1 = new Alert(AlertType.CONFIRMATION);
    	alert1.setTitle("Confirmacion de proceso");
    	alert1.setHeaderText(null);
    	alert1.setContentText("?Esta seguro de que quiere eliminar este producto de la orden?");
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
		tvOfOrderProductsN.getItems().clear();
		tvOfOrderProductsS.getItems().clear();
		tvOfOrderProductsQ.getItems().clear();
    	initializeTableViewOfOrderProductsN();
    	initializeTableViewOfOrderProductsS();
    	initializeTableViewOfOrderProductsQ();
    	btDeleteProduct.setDisable(true);
    	cmbxProductSizes.setPromptText("Elija un tama?o");
    }
    
    @FXML
    public void addOrder(ActionEvent event) throws IOException {
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
    		initializeComboBoxOfClients();
    		initializeComboBoxEmployees();
    		initializeTableViewOfOrders();
    	}else {
    		showValidationErrorAlert();
    	}
    }

    @FXML
    public void updateOrder(ActionEvent event) throws IOException {
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
    		initializeComboBoxOfClients();
    		initializeComboBoxEmployees();
    	}else {
    		showValidationErrorAlert();
    	}
    }
    
    @FXML
    public void searchClientByName(ActionEvent event) {
    	Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(null);
    	if(!txtClientSearchedName.getText().isEmpty() && !txtClientSearchedLastName.getText().isEmpty()) {
    	    long start= System.nanoTime();
    		ObservableList<Client> clientsList = FXCollections.observableArrayList(restauranteLaCasaDorada.searchClientByName(txtClientSearchedName.getText().toUpperCase(),txtClientSearchedLastName.getText().toUpperCase()));
    	    long end = System.nanoTime();
    	    long time=end-start;
    		cmbxClients.setItems(clientsList);
    		if(clientsList.isEmpty()) {
    			alert.setHeaderText("No se encontr? al cliente "+txtClientSearchedName.getText().toUpperCase()+" "+txtClientSearchedLastName.getText().toUpperCase());

    			alert.setContentText("Tiempo que tard? la b?squeda: "+time+" nanosegundos");
        		alert.showAndWait();
        		initializeComboBoxOfClients();
        		txtClientSearchedName.clear();
        		txtClientSearchedLastName.clear();

    		}else {
    			Alert alert2 = new Alert(AlertType.INFORMATION);
    		    alert2.setTitle("Cliente(s) encontrado(s)");
    		    alert2.setHeaderText("Puede desplegar la lista para seleccionar al cliente buscado");
    		    alert2.setContentText("Tiempo que tard? la b?squeda: "+time+" nanosegundos");
    		    alert2.showAndWait();
    			txtClientSearchedName.clear();
        		txtClientSearchedLastName.clear();
    		}
    	}else {
    		
    		alert.setContentText("Debe ingresar nombre y apellido para buscar el cliente");
    		alert.showAndWait();
    		initializeComboBoxOfClients();

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
	    alert.setHeaderText("Cr?ditos");
	    alert.setContentText("Keren L?pez Cordoba y Ang?lica Corrales Quevedo\nEstudiantes de Ingenier?a de Sistemas\nAlgoritmos y programaci?n II, Universidad Icesi.");
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
    public void returnToManageAProduct(ActionEvent event) throws IOException {
    	manageAProduct(null);
    }
    
    @FXML
    public void returnToMenu(ActionEvent event) throws IOException {
    	lbObjectId.setText("");
    	showMenu(); 
    	lbUserNameMenu.setText(lbUserName.getText());
    	lbUserIdMenu.setText(lbUserId.getText());
    }
    
    private void initializeComboBoxOfHours() {
		ObservableList<String> hoursList = FXCollections.observableArrayList(restauranteLaCasaDorada.getHours());
		cmbxInitialHour.setItems(hoursList);
		cmbxInitialHour.setValue("00");
		cmbxFinalHour.setItems(hoursList);
		cmbxFinalHour.setValue("23");
	}
    
    private void initializeComboBoxOfMinutes() {
		ObservableList<String> minutesList = FXCollections.observableArrayList(restauranteLaCasaDorada.getMinutes());
		cmbxInitialMinute.setItems(minutesList);
		cmbxInitialMinute.setValue("00");
		cmbxFinalMinute.setItems(minutesList);
		cmbxFinalMinute.setValue("59");
	}
    
    @FXML
    public void exportOrdersReport(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("exportOrdersReport.fxml"));
		fxmlLoader.setController(this);
		Parent menuPane = fxmlLoader.load();
		mainPanel.getChildren().clear();
		mainPanel.setCenter(menuPane);
		mainPanel.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");
		initializeComboBoxOfHours();
		initializeComboBoxOfMinutes();
		dtPickerInitialDate.setValue(LocalDate.now());
		dtPickerFinalDate.setValue(LocalDate.now());
		lbUserName.setText(lbUserNameMenu.getText());
    	lbUserId.setText(lbUserIdMenu.getText()); 
    }
    
    @FXML
    public void exportEmployeesReport(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("exportEmployeesReport.fxml"));
		fxmlLoader.setController(this);
		Parent menuPane = fxmlLoader.load();
		mainPanel.getChildren().clear();
		mainPanel.setCenter(menuPane);
		mainPanel.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");
		initializeComboBoxOfHours();
		initializeComboBoxOfMinutes();
		dtPickerInitialDate.setValue(LocalDate.now());
		dtPickerFinalDate.setValue(LocalDate.now());
		lbUserName.setText(lbUserNameMenu.getText());
    	lbUserId.setText(lbUserIdMenu.getText()); 
    }
    
    @FXML
    public void exportProductsReport(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("exportProductsReport.fxml"));
		fxmlLoader.setController(this);
		Parent menuPane = fxmlLoader.load();
		mainPanel.getChildren().clear();
		mainPanel.setCenter(menuPane);
		mainPanel.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");
		initializeComboBoxOfHours();
		initializeComboBoxOfMinutes();
		dtPickerInitialDate.setValue(LocalDate.now());
		dtPickerFinalDate.setValue(LocalDate.now());
		lbUserName.setText(lbUserNameMenu.getText());
    	lbUserId.setText(lbUserIdMenu.getText()); 
    }
    
    @FXML
    public void generateOrdersReport(ActionEvent event) {
    	if(dtPickerInitialDate.getValue()!=null && dtPickerFinalDate.getValue()!=null && cmbxInitialHour.getValue()!=null && cmbxInitialMinute.getValue()!=null && cmbxFinalHour.getValue()!=null && cmbxFinalMinute.getValue()!=null && !txtSeparator.getText().equals("")) {
    		LocalDate initialDate = dtPickerInitialDate.getValue();
    		LocalDate finalDate = dtPickerFinalDate.getValue();
    		String separator = txtSeparator.getText();
    		String iniDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(initialDate).toString();
    		String finDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(finalDate).toString();
    		String initialTime = iniDate+" "+cmbxInitialHour.getValue().toString()+":"+cmbxInitialMinute.getValue().toString();
    		String finalTime = finDate+" "+cmbxFinalHour.getValue().toString()+":"+cmbxFinalMinute.getValue().toString();
    		FileChooser fileChooser = new FileChooser();
        	fileChooser.setTitle("Elija el archivo en donde se va a guardar el reporte");
        	File fExp= fileChooser.showSaveDialog(mainPanel.getScene().getWindow());
        	if(fExp!=null) {
        		Alert alert = new Alert(AlertType.INFORMATION);
    		    alert.setTitle("Exportar reporte sobre ordenes");
    		    try {
    				restauranteLaCasaDorada.exportOrdersReport(fExp.getAbsolutePath(),initialTime,finalTime,separator);
    			    alert.setHeaderText(null);
    			    alert.setContentText("El reporte de ordenes ha sido exportado exitosamente");
    			    alert.showAndWait();
    			} catch (IOException e) {
    				alert.setHeaderText(null);
    			    alert.setContentText("Lo sentimos, ha ocurrido un error en el proceso");
    				e.printStackTrace();
    			}
        	}
    	}else {
    		showValidationErrorAlert();
    	}
    }
    
    @FXML
    public void generateEmployeesReport(ActionEvent event) {
    	if(dtPickerInitialDate.getValue()!=null && dtPickerFinalDate.getValue()!=null && cmbxInitialHour.getValue()!=null && cmbxInitialMinute.getValue()!=null && cmbxFinalHour.getValue()!=null && cmbxFinalMinute.getValue()!=null) {
    		LocalDate initialDate = dtPickerInitialDate.getValue();
    		LocalDate finalDate = dtPickerFinalDate.getValue();
    		String iniDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(initialDate).toString();
    		String finDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(finalDate).toString();
    		String initialTime = iniDate+" "+cmbxInitialHour.getValue().toString()+":"+cmbxInitialMinute.getValue().toString();
    		String finalTime = finDate+" "+cmbxFinalHour.getValue().toString()+":"+cmbxFinalMinute.getValue().toString();
    		FileChooser fileChooser = new FileChooser();
        	fileChooser.setTitle("Elija el archivo en donde se va a guardar el reporte");
        	File fExp= fileChooser.showSaveDialog(mainPanel.getScene().getWindow());
        	if(fExp!=null) {
        		Alert alert = new Alert(AlertType.INFORMATION);
    		    alert.setTitle("Exportar reporte sobre empleados");
    		    try {
    				restauranteLaCasaDorada.exportEmployeesReport(fExp.getAbsolutePath(),initialTime,finalTime);
    			    alert.setHeaderText(null);
    			    alert.setContentText("El reporte de empleados ha sido exportado exitosamente");
    			    alert.showAndWait();
    			} catch (IOException e) {
    				alert.setHeaderText(null);
    			    alert.setContentText("Lo sentimos, ha ocurrido un error en el proceso");
    				e.printStackTrace();
    			}
        	}
    	}else {
    		showValidationErrorAlert();
    	}
    }
    

    @FXML
    public void generateProductsReport(ActionEvent event) {
    	if(dtPickerInitialDate.getValue()!=null && dtPickerFinalDate.getValue()!=null && cmbxInitialHour.getValue()!=null && cmbxInitialMinute.getValue()!=null && cmbxFinalHour.getValue()!=null && cmbxFinalMinute.getValue()!=null) {
    		LocalDate initialDate = dtPickerInitialDate.getValue();
    		LocalDate finalDate = dtPickerFinalDate.getValue();
    		String iniDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(initialDate).toString();
    		String finDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(finalDate).toString();
    		String initialTime = iniDate+" "+cmbxInitialHour.getValue().toString()+":"+cmbxInitialMinute.getValue().toString();
    		String finalTime = finDate+" "+cmbxFinalHour.getValue().toString()+":"+cmbxFinalMinute.getValue().toString();
    		FileChooser fileChooser = new FileChooser();
        	fileChooser.setTitle("Elija el archivo en donde se va a guardar el reporte");
        	File fExp= fileChooser.showSaveDialog(mainPanel.getScene().getWindow());
        	if(fExp!=null) {
        		Alert alert = new Alert(AlertType.INFORMATION);
    		    alert.setTitle("Exportar reporte sobre productos");
    		    try {
    				restauranteLaCasaDorada.exportProductsReport(fExp.getAbsolutePath(),initialTime,finalTime);
    			    alert.setHeaderText(null);
    			    alert.setContentText("El reporte de productos ha sido exportado exitosamente");
    			    alert.showAndWait();
    			} catch (IOException e) {
    				alert.setHeaderText(null);
    			    alert.setContentText("Lo sentimos, ha ocurrido un error en el proceso");
    				e.printStackTrace();
    			}
        	}
    	}else {
    		showValidationErrorAlert();
    	}
    }
    
    @FXML
    public void importClientsData(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setTitle("Importante");
		alert.setContentText("Esta accion puede tomar unos minutos...");
		alert.showAndWait();
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Abrir el archivo");
    	File f=fileChooser.showOpenDialog(mainPanel.getScene().getWindow());
    	if(f!=null) {
    		

			alert.setTitle("Importar clientes");
    		
    		try {
    			
    			restauranteLaCasaDorada.importClientsData(f.getAbsolutePath());
        		alert.setContentText("Los clientes fueron importados exitosamente");
        		alert.showAndWait();
    		}catch(IOException e){
        		alert.setContentText("Los clientes no se importaron. Ocurri? un error");
        		alert.showAndWait();
    		}
    	}
    }
    
    @FXML
    public void importProductsData(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setTitle("Importante");
		alert.setContentText("Esta accion puede tomar unos minutos...");
		alert.showAndWait();
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Abrir el archivo");
    	File f=fileChooser.showOpenDialog(mainPanel.getScene().getWindow());
    	if(f!=null) {
    		
			alert.setTitle("Importar productos");
    		
    		try {
    			
    			restauranteLaCasaDorada.importProductsData(f.getAbsolutePath());
        		alert.setContentText("Los productos fueron importados exitosamente");
        		alert.showAndWait();
    		}catch(IOException e){
        		alert.setContentText("Los productos no se importaron. Ocurri? un error");
        		alert.showAndWait();
    		}
    	}
    }
    
    @FXML
    public void importOrdersData(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setTitle("Importante");
		alert.setContentText("Esta accion puede tomar unos minutos...");
		alert.showAndWait();
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Abrir el archivo");
    	File f=fileChooser.showOpenDialog(mainPanel.getScene().getWindow());
    	if(f!=null) {
			alert.setTitle("Importar pedidos");
    		try {
    			
    			restauranteLaCasaDorada.importOrdersData(f.getAbsolutePath());
        		alert.setContentText("Los pedidos fueron importados exitosamente");
        		alert.showAndWait();
    		}catch(IOException e){
        		alert.setContentText("Los pedidos no se importaron. Ocurri? un error");
        		alert.showAndWait();
    		}
    	}
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
            	cbEmployee.setValue(null);
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
    	alert1.setContentText("?Esta seguro de que quiere eliminar el usuario escogido?");
    	Optional<ButtonType> result = alert1.showAndWait();

    	Alert alert2 = new Alert(AlertType.INFORMATION);

    	if (result.get() == ButtonType.OK){

    		boolean deleted=false;
    		if(!lbUserId.getText().equals(lbObjectId.getText())){
    			deleted=restauranteLaCasaDorada.deleteUser(tvListUsers.getSelectionModel().getSelectedItem() );

    		}

    		alert2.setTitle("Informacion");
    		alert2.setHeaderText(null);
    		if(deleted) {
    			alert2.setContentText("El usuario ha sido eliminado exitosamente");


    			initializeTableViewUsers();

    			
    		}else {
    			alert2.setContentText("El usuario no se pudo eliminar");

    		}

    		alert2.showAndWait();
    		lbObjectId.setText("");
			txtUserName.clear();
			passwordField.clear();
			cbEmployee.setValue(null);
        	cbEmployee.setPromptText("Elija un empleado");
        	disableButtons();

    	}


    } 


    @FXML
    public void updateUser(ActionEvent event) throws IOException {
    	
    	if (cbEmployee.getSelectionModel().getSelectedItem()!=null && !txtUserName.getText().isEmpty() && !passwordField.getText().isEmpty()) {
			Alert alert2 = new Alert(AlertType.ERROR);
			alert2.setTitle("Error de validacion");
			alert2.setHeaderText(null);

    		boolean sameUserDisabled=false;
    		if(lbUserId.getText().equals(lbObjectId.getText())){
    			if(ckbxDisable.isSelected()) {
    				sameUserDisabled=true;
    			}
    		}
    		if(sameUserDisabled) {
    			alert2.setContentText("No puede deshabilitar el usuario con el que inici? sesi?n");
    			alert2.showAndWait();
    		}else {
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
        			alert2.setContentText("No se pudo actualizar el usuario, intentelo nuevamente");
        			alert2.showAndWait();
        		}
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
				alert.setTitle("No se pudo iniciar sesi?n");
				alert.setContentText("El usuario o la contrase?a son incorrectos. Intente nuevamente");

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
    public void deleteEmployee(ActionEvent event) throws IOException {
    	
    	Alert alert1 = new Alert(AlertType.CONFIRMATION);
    	alert1.setTitle("Confirmacion de proceso");
    	alert1.setHeaderText(null);
    	alert1.setContentText("?Esta seguro de que quiere eliminar el empleado escogido?");
    	Optional<ButtonType> result = alert1.showAndWait();
    	if (result.get() == ButtonType.OK){
        	
    		boolean deleted= restauranteLaCasaDorada.deleteEmployee(lbObjectId.getText());
        	Alert alert2 = new Alert(AlertType.INFORMATION);
        	alert2.setTitle("Informacion");
        	alert2.setHeaderText(null);
        	
        	if(deleted) {
        		alert2.setContentText("El empleado ha sido eliminado exitosamente");
        		
            	           	
            	initializeTableViewEmployees();
            	
        	}else {
        		alert2.setContentText("El empleado no se pudo eliminar");
        		
        	}
        	alert2.showAndWait();
        	lbObjectId.setText("");
    		txtName.clear();
    		txtLastName.clear();
        	txtId.clear();
        	disableButtons();
        	
    	}
    	
    }

   

    @FXML
    public void updateEmployee(ActionEvent event) throws IOException {
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
    	

    	tvListClients.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

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
    public void createClient(ActionEvent event) throws IOException {
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
    public void deleteClient(ActionEvent event) throws IOException {
    	Alert alert1 = new Alert(AlertType.CONFIRMATION);
    	alert1.setTitle("Confirmacion de proceso");
    	alert1.setHeaderText(null);
    	alert1.setContentText("?Esta seguro de que quiere eliminar el cliente escogido?");
    	Optional<ButtonType> result = alert1.showAndWait();
    	if (result.get() == ButtonType.OK){
        	
    		boolean deleted= restauranteLaCasaDorada.deleteClient(tvListClients.getSelectionModel().getSelectedItem() );
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
        		alert2.setContentText("El cliente no se pudo eliminar");

        	}
        	alert2.showAndWait();
        	
        	disableButtons();
    	}
    	
    }


    @FXML
    public void updateClient(ActionEvent event) throws IOException {
    	if (!txtId.getText().isEmpty() && !txtName.getText().isEmpty() && !txtLastName.getText().isEmpty() && !txtAddress.getText().isEmpty() && !txtPhone.getText().isEmpty() && !txtObservations.getText().isEmpty()) {

    		boolean updated = restauranteLaCasaDorada.updateClient(tvListClients.getSelectionModel().getSelectedItem(), txtId.getText(),txtName.getText().toUpperCase(),txtLastName.getText().toUpperCase(), txtAddress.getText().toUpperCase(),txtPhone.getText(),txtObservations.getText(), !ckbxDisable.isSelected(),lbUserId.getText());

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