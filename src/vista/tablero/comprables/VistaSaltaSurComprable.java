package vista.tablero.comprables;

import Controlador.Comprables.SaltaSurComprableHandler;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.SaltaSurComprable;
import vista.tablero.VistaTablero;
import javafx.scene.control.Button;

public class VistaSaltaSurComprable extends Button {
	
	private SaltaSurComprable saltaSurComprable;
	
	public VistaSaltaSurComprable(){
		this.saltaSurComprable = new SaltaSurComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SALTA_SUR, this.saltaSurComprable);

        this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaSaltaSur.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_HORIZONTAL, VistaTablero.ALTO_CASILLA_HORIZONTAL);

        SaltaSurComprableHandler saltaSurComprableHandler = new SaltaSurComprableHandler(saltaSurComprable);
        this.setOnAction(saltaSurComprableHandler);
	}
}
