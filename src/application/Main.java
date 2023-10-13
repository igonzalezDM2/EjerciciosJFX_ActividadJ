package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import utils.Creador;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Creador creador = Creador.getInstance();
			creador.dibujar(primaryStage);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
