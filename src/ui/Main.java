package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.RestauranteLaCasaDorada;

public class Main extends Application {
	
	private RestauranteLaCasaDorada restauranteLaCasaDorada;
	private RestauranteLaCasaDoradaGUI restauranteLaCasaDoradagui;
	
	public Main() {
		restauranteLaCasaDorada= new RestauranteLaCasaDorada();
		restauranteLaCasaDoradagui= new RestauranteLaCasaDoradaGUI(restauranteLaCasaDorada);
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
