package vista.tablero.casilla;

import java.util.HashMap;

import javafx.scene.image.Image;
import modelo.tablero.Casilla;
import modelo.tablero.poseibles.barrios.construcciones.*;
import vista.tablero.VistaCasilla;
import vista.tablero.VistaTablero;

public class VistaCasillaBarrio extends VistaCasilla {

	private HashMap<Class<? extends Construccion>, Image> construccionImagen;
	private Construccion construccion;
	private static int MARGEN_LATERAL = 30;

	
	public VistaCasillaBarrio(){
		int ancho = VistaTablero.ANCHO_CASILLA - (2 * MARGEN_LATERAL);
		this.construccionImagen = new HashMap<Class<? extends Construccion>, Image>();
		this.construccionImagen.put(TerrenoConstruido.class, new Image("file:src/vista/imagenes/TerrenoTablero.png", ancho, 0, false, false));
		this.construccionImagen.put(UnaCasaConstruida.class, new Image("file:src/vista/imagenes/CasaTablero.png", ancho, 50, false, false));
		this.construccionImagen.put(DosCasasConstruida.class, new Image("file:src/vista/imagenes/DosCasasTablero.png", ancho, 50, false, false));
		this.construccionImagen.put(HotelConstruido.class, new Image("file:src/vista/imagenes/HotelTablero.png", ancho, 50, false, false));
		this.construccionImagen.put(EdificioHistoricoConstruido.class, new Image("file:src/vista/imagenes/CasaTablero.png", ancho, 50, false, false));
	}
	
	public void setConstruccion(Construccion unaConstruccion){
		this.construccion = unaConstruccion;
	}
	
	public void dibujarConstruccion(){
		if (construccion != null) this.canvas.getGraphicsContext2D().drawImage(this.construccionImagen.get(this.construccion.getClass()), 30, 20);
	}	
}
