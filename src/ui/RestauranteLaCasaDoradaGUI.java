package ui;

import java.io.File;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import model.Employee;
import model.Ingredient;
import model.Product;
import model.RestauranteLaCasaDorada;
import model.TypeOfProduct;
import model.User;

public class RestauranteLaCasaDoradaGUI {
	
	private RestauranteLaCasaDorada restauranteLaCasaDorada;
	
	@FXML
	private BorderPane mainPanel;

	@FXML
	private TextField txtIngredientName;
	
	@FXML
    private TextField txtTypeOfProductName;
	
	@FXML
	private TextField txtProductName;
	
	@FXML
	private Label lbUserName;
	
	@FXML
    private Label lbObjectId;
	
	@FXML
	private Label lbUserId;

	@FXML
	private ComboBox<TypeOfProduct> cmbxTypeOfProduct;
	
	@FXML
    private TableView<Ingredient> tvOfIngredients;

	@FXML
    private TableColumn<Ingredient, Integer> colIdIngredient;

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
    private TableColumn<TypeOfProduct, Integer> colIdTypeOfProduct;

    @FXML
    private TableColumn<TypeOfProduct, String> colNameTypeOfProduct;

    @FXML
    private TableColumn<TypeOfProduct, String> colStatusTypeOfProduct;

    @FXML
    private TableColumn<TypeOfProduct, String> colCreatorTypeOfProduct;

    @FXML
    private TableColumn<TypeOfProduct, String> colModifierTypeOfProduct;

	@FXML
	private CheckBox ckbxDisable;

	@FXML
    private Label lbManageProduct;
	
	@FXML
    private Button btUpdate;
	
	@FXML
    private Button btDelete;

    @FXML
    private Button btAdd;
    
    @FXML
    private Button btSaveIngredients;
    
    @FXML
	private TextField txtUserName;
    
    @FXML
    private TextField txtId;


	@FXML
	private PasswordField passwordField;

	@FXML
	private ComboBox<String> cbEmployee;

	
	@FXML
	private TableView<User> tvListUsers;

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
	
	@FXML
    public void manageAClient(ActionEvent event) {

    }
	
	private void initializeListViewOfProducts() {
    	ObservableList<Product> observableList;
    	observableList = FXCollections.observableArrayList(restauranteLaCasaDorada.getProducts());
    	lvProducts.setItems(observableList);
    	lvProducts.setVisible(true);
    	lvProducts.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}

    @FXML
    public void manageAProduct(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-product.fxml"));
		fxmlLoader.setController(this);
		Parent menuPane = fxmlLoader.load();
		mainPanel.getChildren().clear();
		mainPanel.setCenter(menuPane);
		mainPanel.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");
		initializeListViewOfProducts();
		ObservableList<TypeOfProduct> typesOfProductsList = FXCollections.observableArrayList(restauranteLaCasaDorada.getTypesOfProducts());
    	cmbxTypeOfProduct.setItems(typesOfProductsList);
		if (lvProducts.getSelectionModel().getSelectedItem() != null) {
    		btDelete.setDisable(false);
    		btUpdate.setDisable(false);
    		ckbxDisable.setDisable(false);
    		btAdd.setDisable(true);
    		txtIngredientName.setEditable(false);
    	}
    }
    
    private void initializeListViewOfAddedIngredients() {
    	ObservableList<Ingredient> observableList;
    	observableList = FXCollections.observableArrayList(restauranteLaCasaDorada.getIngredients());
    	lvAddedIngredients.setItems(observableList);
    	lvAddedIngredients.setVisible(true);
    	lvAddedIngredients.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}

    @FXML
    public void chooseIngredients(ActionEvent event) {
    	initializeListViewOfAddedIngredients();
    	btSaveIngredients.setDisable(true);
    }
    
    @FXML
    public void saveIngredients(ActionEvent event) {
    	ObservableList<Ingredient> selectedItems =  lvAddedIngredients.getSelectionModel().getSelectedItems();
    	initializeListViewOfProducts();
    }
    
    @FXML
    public void addProduct(ActionEvent event) {
    	if (!txtProductName.getText().equals("") && cmbxTypeOfProduct.getValue()!=null) {

    	}else {
    		showValidationErrorAlert();
    	}
    }
    
    @FXML
    public void deleteProduct(ActionEvent event) {
    	if (lvProducts.getSelectionModel().getSelectedItem() != null) {


    	}
    }

    @FXML
    public void updateProduct(ActionEvent event) {
    	if (lvProducts.getSelectionModel().getSelectedItem() != null) {


    	}
    }
    
    private void initializeTableViewOfTypesOfProducts() {
    	ObservableList<TypeOfProduct> observableList;
    	observableList = FXCollections.observableArrayList(restauranteLaCasaDorada.getTypesOfProducts());
    	tvOfTypeOfProducts.setItems(observableList);
    	colIdTypeOfProduct.setCellValueFactory(new PropertyValueFactory<TypeOfProduct, Integer>("Id"));
    	colNameTypeOfProduct.setCellValueFactory(new PropertyValueFactory<TypeOfProduct, String>("Name"));
    	colStatusTypeOfProduct.setCellValueFactory(new PropertyValueFactory<TypeOfProduct, String>("Status"));
    	colCreatorTypeOfProduct.setCellValueFactory(new PropertyValueFactory<TypeOfProduct, String>("CreatorName"));
    	colModifierTypeOfProduct.setCellValueFactory(new PropertyValueFactory<TypeOfProduct, String>("ModifierName"));
    	tvOfTypeOfProducts.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
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
		if (tvOfTypeOfProducts.getSelectionModel().getSelectedItem() != null) {
    		btDelete.setDisable(false);
    		btUpdate.setDisable(false);
    		ckbxDisable.setDisable(false);
    		btAdd.setDisable(true);
    		TypeOfProduct selectedTypeOfProduct = tvOfTypeOfProducts.getSelectionModel().getSelectedItem();
    		lbObjectId.setText(""+selectedTypeOfProduct.getId());
    		txtTypeOfProductName.setText(selectedTypeOfProduct.getName());
    		if(selectedTypeOfProduct.getEnabled()==false) {
    			ckbxDisable.setSelected(true);
    		}
    	}
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
    	if (result.get() == ButtonType.YES){
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
    		boolean updated = restauranteLaCasaDorada.updateIngredient(newName, TpId, enabled, userID);
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
    	}else {
    		showValidationErrorAlert();
    	}
    }
 
   
    
    private void initializeTableViewOfIngredients() {
    	ObservableList<Ingredient> observableList;
    	observableList = FXCollections.observableArrayList(restauranteLaCasaDorada.getIngredients());
    	tvOfIngredients.setItems(observableList);
    	colIdIngredient.setCellValueFactory(new PropertyValueFactory<Ingredient, Integer>("Id"));
    	colNameIngredient.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("Name"));
    	colStatusIngredient.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("Status"));
    	colCreatorIngredient.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("CreatorName"));
    	colModifierIngredient.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("ModifierName"));
    	tvOfIngredients.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
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
		if (tvOfIngredients.getSelectionModel().getSelectedItem() != null) {
    		btDelete.setDisable(false);
    		btUpdate.setDisable(false);
    		ckbxDisable.setDisable(false);
    		btAdd.setDisable(true);
    		Ingredient selectedIng = tvOfIngredients.getSelectionModel().getSelectedItem();
    		lbObjectId.setText(""+selectedIng.getId());
    		txtIngredientName.setText(selectedIng.getName());
    		if(selectedIng.getEnabled()==false) {
    			ckbxDisable.setSelected(true);
    		}
    	}
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
    	if (result.get() == ButtonType.YES){
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
    	}else {
    		showValidationErrorAlert();
    	}
    }

    @FXML
    public void manageAnOrder(ActionEvent event) {

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
    public void signOutOfSystem(ActionEvent event) {

    }
    
    @FXML
    public void returnToMenu(ActionEvent event) throws IOException {
    	showMenu(); 
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @FXML
    public void manageAUser(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("manage-user.fxml"));
    	fxmlLoader.setController(this);
    	Parent menuPane = fxmlLoader.load();
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(menuPane);
    	mainPanel.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");
    	initializeTableViewUsers();
    	initializeComboBoxEmployees();
    	
    	if (tvListUsers.getSelectionModel().getSelectedItem() != null) {
    		btDelete.setDisable(false);
    		btUpdate.setDisable(false);
    		ckbxDisable.setDisable(false);
    		btAdd.setDisable(true);
    		User selectedUser = tvListUsers.getSelectionModel().getSelectedItem();
    		lbObjectId.setText(selectedUser.getId());
    		txtUserName.setText(selectedUser.getUserName());
    		passwordField.setText(selectedUser.getPassword());
    		txtId.setText(selectedUser.getId());
    		cbEmployee.setValue(selectedUser.getEmployee().idAndName());

    		
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
    
    public void initializeComboBoxEmployees() {
    	ObservableList<String> options = 
    			FXCollections.observableArrayList(restauranteLaCasaDorada.employeesToString());
    	cbEmployee.setValue("Escoja un empleado");
    	cbEmployee.setItems(options);
    }


    	

    @FXML
    void createUser(ActionEvent event) {
    	if (!cbEmployee.getSelectionModel().getSelectedItem().equals("Escoja un empleado") && !txtUserName.getText().isEmpty() && !passwordField.getText().isEmpty() && !txtId.getText().isEmpty()) {
    		String[] emplIdAndName=cbEmployee.getSelectionModel().getSelectedItem().split("\\|");
    		
    		boolean added = restauranteLaCasaDorada.createUser(emplIdAndName[0],txtId.getText(),txtUserName.getText().toLowerCase(),passwordField.getText(), lbUserId.getText());
    		if(added) {
    			Alert alert1 = new Alert(AlertType.INFORMATION);
        		alert1.setTitle("Informacion");
        		alert1.setHeaderText(null);
        		alert1.setContentText("El usuario ha sido creado exitosamente!");
        		alert1.showAndWait();
        		
        		txtUserName.clear();
            	passwordField.clear();
            	txtId.clear();
            	cbEmployee.setValue("Escoja un empleado");
        		
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
    void deleteUser(ActionEvent event) {
    	Alert alert1 = new Alert(AlertType.CONFIRMATION);
    	alert1.setTitle("Confirmacion de proceso");
    	alert1.setHeaderText(null);
    	alert1.setContentText("¿Esta seguro de que quiere eliminar el usuario escogido?");
    	Optional<ButtonType> result = alert1.showAndWait();
    	if (result.get() == ButtonType.YES){
        	restauranteLaCasaDorada.deleteUser(lbObjectId.getText());
        	Alert alert2 = new Alert(AlertType.INFORMATION);
        	alert2.setTitle("Informacion");
        	alert2.setHeaderText(null);

        	alert2.setContentText("El usuario ha sido eliminado exitosamente");
        	alert2.showAndWait();

    	} 
    	
    }



    @FXML
    void updateUser(ActionEvent event) {
    	
    	if (!cbEmployee.getSelectionModel().getSelectedItem().equals("Escoja un empleado") && !txtUserName.getText().isEmpty() && !passwordField.getText().isEmpty() && !txtId.getText().isEmpty()) {
    		String[] emplIdAndName=cbEmployee.getSelectionModel().getSelectedItem().split("\\|");

    		boolean updated = restauranteLaCasaDorada.updateUser(lbObjectId.getText(),txtId.getText(),emplIdAndName[0] ,txtUserName.getText().toLowerCase(),passwordField.getText(), !ckbxDisable.isSelected(), lbUserId.getText());
    		if(updated) {
    			Alert alert1 = new Alert(AlertType.INFORMATION);
        		alert1.setTitle("Informacion");
        		alert1.setHeaderText(null);
        		alert1.setContentText("El usuario ha sido actualizado exitosamente!");
        		alert1.showAndWait();
        		
        		
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
				lbUserName.setText(txtUserName.getText());

				lbUserId.setText(id);

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
    	Parent menuPane = fxmlLoader.load();
    	mainPanel.getChildren().clear();
    	mainPanel.setCenter(menuPane);
    	mainPanel.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");
    	initializeTableViewEmployees();
    	
    	if (tvListEmployees.getSelectionModel().getSelectedItem() != null) {
    		btDelete.setDisable(false);
    		btUpdate.setDisable(false);
    		ckbxDisable.setDisable(false);
    		btAdd.setDisable(true);
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
    void createEmployee(ActionEvent event) {
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
    void deleteEmployee(ActionEvent event) {

    }

   

    @FXML
    void updateEmployee(ActionEvent event) {

    }

    
    

}