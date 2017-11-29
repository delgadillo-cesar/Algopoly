package vista.tablero.comprables;

import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.NeuquenComprable;
import vista.tablero.VistaTablero;
import Controlador.Comprables.NeuquenComprableHandler;
import javafx.scene.control.Button;

public class VistaNeuquenComprable extends Button {
	
	private NeuquenComprable neuquenComprable;
	
	public VistaNeuquenComprable(){
		this.neuquenComprable = new NeuquenComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_NEUQUEN, this.neuquenComprable);

	    this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaNeuquen.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_VERTICAL, VistaTablero.ALTO_CASILLA_VERTICAL);
	
        NeuquenComprableHandler neuquenComprableHandler = new NeuquenComprableHandler(neuquenComprable);
        this.setOnAction(neuquenComprableHandler);
	}
}
