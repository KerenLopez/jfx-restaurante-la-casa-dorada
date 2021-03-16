package ui;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import model.Ingredient;
import model.Product;
import model.RestauranteLaCasaDorada;
import model.TypeOfProduct;

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
	private ComboBox<TypeOfProduct> cmbxTypeOfProduct;

	@FXML
	private CheckBox ckbxDisable;

	@FXML
	private ListView<Ingredient> lvOfIngredients;

	@FXML
	private ListView<TypeOfProduct> lvOfTypeOfProducts;
	
	@FXML
	private ListView<Product> lvProducts;

	@FXML
	private ListView<Ingredient> lvAddedIngredients;

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
    
    private void initializeListViewOfTypesOfProducts() {
    	ObservableList<TypeOfProduct> observableList;
    	observableList = FXCollections.observableArrayList(restauranteLaCasaDorada.getTypesOfProducts());
    	lvOfTypeOfProducts.setItems(observableList);
    	lvOfTypeOfProducts.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}

    @FXML
    public void manageATypeOfProduct(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-type-of-product.fxml"));
		fxmlLoader.setController(this);
		Parent menuPane = fxmlLoader.load();
		mainPanel.getChildren().clear();
		mainPanel.setCenter(menuPane);
		mainPanel.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");
		initializeListViewOfTypesOfProducts(); 
		if (lvOfTypeOfProducts.getSelectionModel().getSelectedItem() != null) {
    		btDelete.setDisable(false);
    		btUpdate.setDisable(false);
    		ckbxDisable.setDisable(false);
    		btAdd.setDisable(true);
    		txtIngredientName.setEditable(false);
    	}
    }
    
    @FXML
    public void addTypeOfProduct(ActionEvent event) {
    	if (!txtTypeOfProductName.getText().equals("")) {

    	}else {
    		showValidationErrorAlert();
    	}
    }

    @FXML
    public void deleteTypeOfProduct(ActionEvent event) {
    	if (lvOfTypeOfProducts.getSelectionModel().getSelectedItem() != null) {


    	}
    }

    @FXML
    public void updateTypeOfProduct(ActionEvent event) {
    	if (lvOfTypeOfProducts.getSelectionModel().getSelectedItem() != null) {


    	}
    }

    @FXML
    public void manageAUser(ActionEvent event) {

    }

    @FXML
    public void manageAnEmployee(ActionEvent event) {

    }
    
    private void initializeListViewOfIngredients() {
    	ObservableList<Ingredient> observableList;
    	observableList = FXCollections.observableArrayList(restauranteLaCasaDorada.getIngredients());
    	lvOfIngredients.setItems(observableList);
    	lvOfIngredients.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}

    @FXML
    public void manageAnIngredient(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-ingredient.fxml"));
		fxmlLoader.setController(this);
		Parent menuPane = fxmlLoader.load();
		mainPanel.getChildren().clear();
		mainPanel.setCenter(menuPane);
		mainPanel.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");
		initializeListViewOfIngredients();
		if (lvOfIngredients.getSelectionModel().getSelectedItem() != null) {
    		btDelete.setDisable(false);
    		btUpdate.setDisable(false);
    		ckbxDisable.setDisable(false);
    		btAdd.setDisable(true);
    		txtIngredientName.setEditable(false);
    	}
    }
    
    @FXML
    public void addIngredient(ActionEvent event) {
    	if (!txtIngredientName.getText().equals("")) {
    		
    	}else {
    		showValidationErrorAlert();
    	}
    }

    @FXML
    public void deleteIngredient(ActionEvent event) {
    	if (lvOfIngredients.getSelectionModel().getSelectedItem() != null) {
    		
    		
    	}
    }

    @FXML
    public void updateIngredient(ActionEvent event) {
    	if (lvOfIngredients.getSelectionModel().getSelectedItem() != null) {
    		
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

}
