package vista.tablero.comprables;

import vista.tablero.VistaTablero;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.EdesurComprable;
import Controlador.Comprables.EdesurComprableHandler;
import javafx.scene.control.Button;

public class VistaEdesurComprable extends Button {
	
	private EdesurComprable edesurComprable;
	
	public VistaEdesurComprable(){
		this.edesurComprable = new EdesurComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_EDESUR, this.edesurComprable);

		this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaEdesur.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_HORIZONTAL, VistaTablero.ALTO_CASILLA_HORIZONTAL);
	
        EdesurComprableHandler edesurComprableHandler = new EdesurComprableHandler(edesurComprable);
        this.setOnAction(edesurComprableHandler);
	}

}
