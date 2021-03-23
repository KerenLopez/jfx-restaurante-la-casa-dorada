package ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.RestauranteLaCasaDorada;

public class Main extends Application {
	
	private RestauranteLaCasaDorada restauranteLaCasaDorada;
	private RestauranteLaCasaDoradaGUI restauranteLaCasaDoradagui;
	
	public Main() {
		restauranteLaCasaDorada= new RestauranteLaCasaDorada();
		restauranteLaCasaDoradagui= new RestauranteLaCasaDoradaGUI(restauranteLaCasaDorada);
		boolean loadData;
		try {
			loadData=restauranteLaCasaDorada.loadDataUsers();
			loadData=restauranteLaCasaDorada.loadDataEmployees();
			loadData=restauranteLaCasaDorada.loadDataClients();
			loadData=restauranteLaCasaDorada.loadDataProducts();
			loadData=restauranteLaCasaDorada.loadDataIngredients();
			loadData=restauranteLaCasaDorada.loadDataTypesOfProducts();
			loadData=restauranteLaCasaDorada.loadDataOrders();

		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			loadData=false;
			
		} 
		
		if(!loadData) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Restaurante La Casa Dorada");
			alert.setHeaderText(null);
			alert.setContentText("Error al cargar datos de archivo");

			alert.showAndWait();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-pane.fxml"));
		
		fxmlLoader.setController(restauranteLaCasaDoradagui);
		Parent root= fxmlLoader.load();
		
		Scene scene= new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Restaurante La Casa Dorada");
		primaryStage.show();
		
		if (restauranteLaCasaDorada.getEmployees().isEmpty()){
			restauranteLaCasaDoradagui.manageAnEmployee(null);

		}else if(restauranteLaCasaDorada.getUsers().isEmpty()){
			restauranteLaCasaDoradagui.manageAUser(null);

		}
		else {
		
			restauranteLaCasaDoradagui.loadLogIn(null);

		}

		
	
	}

}
