package utils;

import java.util.Arrays;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;

public class Utilidades {
	public enum FONDOS {
		ROJO(Utilidades.crearFondo("coches/miniBlazingRed.png"), Utilidades.crearImagen("colores/colorBlazingRed.jpg")),
		AZUL_ELECTRICO(Utilidades.crearFondo("coches/miniElectricBlue.png"), Utilidades.crearImagen("colores/colorElectricBlue.jpg")),
		AZUL_LUJO(Utilidades.crearFondo("coches/miniLapisluxuryBlue.png"), Utilidades.crearImagen("colores/colorLapisluxuryBlue.jpg")),
		NEGRO(Utilidades.crearFondo("coches/miniMidnightBlack.png"), Utilidades.crearImagen("colores/colorMidnightBlack.jpg")),
		GRIS_CAMINAR_LUNA(Utilidades.crearFondo("coches/miniMoonwalkGrey.png"), Utilidades.crearImagen("colores/colorMoonwalkGrey.jpg")),
		BLANCO(Utilidades.crearFondo("coches/miniPepperWhite.png"), Utilidades.crearImagen("colores/colorPepperWhite.jpg")),
		GRIS_RAYO(Utilidades.crearFondo("coches/miniPepperWhite.png"), Utilidades.crearImagen("colores/colorThunderGray.jpg")),
		NARANJA(Utilidades.crearFondo("coches/miniVolcaninOrange.png"), Utilidades.crearImagen("colores/colorVolcaninOrange.jpg"));
		
		private BackgroundImage fondo;
		private Image color;
		private FONDOS(BackgroundImage fondo, Image color) {
			this.fondo = fondo;
			this.color = color;
		}
		public BackgroundImage getFondo() {
			return fondo;
		}
		public Image getColor() {
			return color;
		}
	}
	
	public enum LUCES {
		ENCENDIDAS(Utilidades.crearImagen("lucesOn.png")),
		APAGADAS(Utilidades.crearImagen("lucesOff.png"));
		
		private Image imagen;
		private LUCES(Image imagen) {
			this.imagen = imagen;
		}
		
		public Image getImagen() {
			return imagen;
		}
	}

	private Utilidades() {
		throw new UnsupportedOperationException("Clase de utilidad");
	}

	public static BackgroundImage crearFondo(String imagen) {
		return new BackgroundImage(Utilidades.crearImagen(imagen),
				BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER,
				new BackgroundSize(1.0, 1.0, false, false, true, false));
	}

	public static Image crearImagen(String imagen) {
		return new Image(Creador.class.getResourceAsStream("/imagenes/" + imagen));
	}
	
	public static Background getBackground(BackgroundImage... image) {
		return new Background(Arrays.asList(new BackgroundFill(javafx.scene.paint.Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)), Arrays.asList(image));
	}
	
}
