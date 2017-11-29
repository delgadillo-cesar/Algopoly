package vista.tablero.comprables;

import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.TucumanComprable;
import vista.tablero.VistaTablero;
import Controlador.Comprables.TucumanComprableHandler;
import javafx.scene.control.Button;

public class VistaTucumanComprable extends Button {
	
	private TucumanComprable tucumanComprable;
	
	public VistaTucumanComprable(){
		this.tucumanComprable = new TucumanComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_TUCUMAN, this.tucumanComprable);

        this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaTucuman.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_VERTICAL, VistaTablero.ALTO_CASILLA_VERTICAL);
	
        TucumanComprableHandler tucumanComprableHandler = new TucumanComprableHandler(tucumanComprable);
        this.setOnAction(tucumanComprableHandler);
	}
}
