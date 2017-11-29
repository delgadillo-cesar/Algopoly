package vista.tablero.comprables;

import Controlador.Comprables.SaltaNorteComprableHandler;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.SaltaNorteComprable;
import vista.tablero.VistaTablero;
import javafx.scene.control.Button;

public class VistaSaltaNorteComprable extends Button {
	
	private SaltaNorteComprable saltaNorteComprable;
	
	public VistaSaltaNorteComprable(){
		this.saltaNorteComprable = new SaltaNorteComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SALTA_NORTE, this.saltaNorteComprable);

        this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaSaltaNorte.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_HORIZONTAL, VistaTablero.ALTO_CASILLA_HORIZONTAL);

        SaltaNorteComprableHandler saltaNorteComprableHandler = new SaltaNorteComprableHandler(saltaNorteComprable);
        this.setOnAction(saltaNorteComprableHandler);
	}
}
