package vista.tablero.comprables;

import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.TrenComprable;
import vista.tablero.VistaTablero;
import Controlador.Comprables.TrenComprableHandler;
import javafx.scene.control.Button;

public class VistaTrenComprable extends Button {
	
	private TrenComprable trenComprable;
	
	public VistaTrenComprable(){
		this.trenComprable = new TrenComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_TREN, this.trenComprable);

		this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaTren.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_VERTICAL, VistaTablero.ALTO_CASILLA_VERTICAL);
	
        TrenComprableHandler trenComprableHandler = new TrenComprableHandler(trenComprable);
        this.setOnAction(trenComprableHandler);
	}
}
