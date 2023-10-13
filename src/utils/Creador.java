package utils;

import java.util.Arrays;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Creador {
	//Patrón singleton
	private static Creador instancia;
	
	private BorderPane root;
	private Button btnLuces;
	
	
	private Creador() {}
	
	public static Creador getInstance() {
		if (instancia == null) {
			instancia = new Creador();
		}
		return instancia;
	}
	
	public void dibujar(Stage stage) {
		root = new BorderPane();
		
		Background bg = Utilidades.getBackground(Utilidades.FONDOS.ROJO.getFondo());
		root.setBackground(bg);
		
		dibujarCabecera();
		crearBotonLuces();
		dibujarColores();
		
		Scene scene = new Scene(root,800,600);
		stage.setScene(scene);
		stage.show();
	}
	
	private void crearBotonLuces() {
		VBox contenedor = new VBox();
		btnLuces = new Button();
		btnLuces.setUserData(Utilidades.LUCES.APAGADAS);
		btnLuces.setGraphic(new ImageView(Utilidades.crearImagen("lucesOff.png")));
		btnLuces.setOnAction(e -> alternarLuces(root.getBackground().getImages().get(0)));
		contenedor.getChildren().add(btnLuces);
		VBox.setMargin(btnLuces, new Insets(0, 0, 0, 20));
		root.setLeft(contenedor);
	}
	
	private void alternarLuces(BackgroundImage imgFondo) {
		if (Utilidades.LUCES.APAGADAS.equals(btnLuces.getUserData())) {				
			btnLuces.setGraphic(new ImageView(Utilidades.crearImagen("lucesOn.png")));
			btnLuces.setUserData(Utilidades.LUCES.ENCENDIDAS);
			root.setBackground(Utilidades.getBackground(imgFondo, Utilidades.crearFondo("autoLuz.png")));
		} else {
			btnLuces.setGraphic(new ImageView(Utilidades.crearImagen("lucesOff.png")));
			btnLuces.setUserData(Utilidades.LUCES.APAGADAS);
			root.setBackground(Utilidades.getBackground(imgFondo));
		}
	}
	
	private void dibujarColores() {
		VBox container = new VBox(10);
		container.setAlignment(Pos.CENTER);

		Label label = new Label("Selecciona tu color favorito");
		label.setTextFill(Color.WHITE);
		label.setFont(new Font(20));
		
		FlowPane fpColores = new FlowPane(Orientation.HORIZONTAL);
		fpColores.setAlignment(Pos.CENTER);
		fpColores.setHgap(30);
		fpColores.setPadding(new Insets(0, 0, 20, 0));
		
		Arrays.stream(Utilidades.FONDOS.class.getEnumConstants()).forEach(fon -> {
			Button btnColor = new Button();
			btnColor.setGraphic(new ImageView(fon.getColor()));
			fpColores.getChildren().add(btnColor);
			
			btnColor.setOnAction(event -> {
				if (Utilidades.LUCES.APAGADAS.equals(btnLuces.getUserData())) {					
					root.setBackground(Utilidades.getBackground(fon.getFondo()));
				} else {					
					root.setBackground(Utilidades.getBackground(fon.getFondo(), Utilidades.crearFondo("autoLuz.png")));
				}
			});
		});
		
		container.getChildren().addAll(label, fpColores);
		
		root.setBottom(container);
	}
	
	private void dibujarCabecera() {
		HBox contenedor = new HBox(100);
		contenedor.setAlignment(Pos.CENTER);
		
		ImageView logo = new ImageView(Utilidades.crearImagen("cooperLogo.png"));
		Label label = new Label("CONFIGURA TU MINI COOPER");
		label.setTextFill(Color.WHITE);
		label.setFont(new Font(20));
		
		contenedor.getChildren().addAll(logo, label);
		
		root.setTop(contenedor);
	}

}
