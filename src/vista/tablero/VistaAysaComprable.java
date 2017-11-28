package vista.tablero;

import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.AysaComprable;
import Controlador.AysaComprableHandler;
import javafx.scene.control.Button;

public class VistaAysaComprable extends Button {
	
	private AysaComprable aysaComprable;
	
	public VistaAysaComprable(){
		this.aysaComprable = new AysaComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_AYSA, this.aysaComprable);

		this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaAysa.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_HORIZONTAL, VistaTablero.ALTO_CASILLA_HORIZONTAL);
	
        AysaComprableHandler aysaComprableHandler = new AysaComprableHandler(aysaComprable);
        this.setOnAction(aysaComprableHandler);
	}
}
