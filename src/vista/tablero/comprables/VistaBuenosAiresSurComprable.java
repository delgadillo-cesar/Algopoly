package vista.tablero.comprables;

import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.BuenosAiresSurComprable;
import vista.tablero.VistaTablero;
import Controlador.Comprables.BuenosAiresSurComprableHandler;
import javafx.scene.control.Button;

public class VistaBuenosAiresSurComprable extends Button {
	
	private BuenosAiresSurComprable buenosAiresSurComprable;
	
	public VistaBuenosAiresSurComprable(){
		this.buenosAiresSurComprable = new BuenosAiresSurComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_BUENOS_AIRES_SUR, this.buenosAiresSurComprable);

	    this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaBuenosAiresSur.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_HORIZONTAL, VistaTablero.ALTO_CASILLA_HORIZONTAL);
	
        BuenosAiresSurComprableHandler buenosAiresSurComprableHandler = new BuenosAiresSurComprableHandler(buenosAiresSurComprable);
        this.setOnAction(buenosAiresSurComprableHandler);
	}
}
