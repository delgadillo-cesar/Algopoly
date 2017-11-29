package vista.tablero.comprables;

import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.BuenosAiresNorteComprable;
import vista.tablero.VistaTablero;
import Controlador.Comprables.BuenosAiresNorteComprableHandler;
import Controlador.Comprables.OpcionesComprableHandler;
import javafx.scene.control.Button;

public class VistaBuenosAiresNorteComprable extends Button {
	
	private BuenosAiresNorteComprable buenosAiresNorteComprable;
	
	public VistaBuenosAiresNorteComprable(){
		this.buenosAiresNorteComprable = new BuenosAiresNorteComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_BUENOS_AIRES_NORTE, this.buenosAiresNorteComprable);

	    this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaBuenosAiresNorte.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_HORIZONTAL, VistaTablero.ALTO_CASILLA_HORIZONTAL);
	
        OpcionesComprableHandler buenosAiresNorteComprableHandler = new OpcionesComprableHandler(new BuenosAiresNorteComprableHandler(buenosAiresNorteComprable));
//        BuenosAiresNorteComprableHandler buenosAiresNorteComprableHandler = new BuenosAiresNorteComprableHandler(buenosAiresNorteComprable);
        this.setOnAction(buenosAiresNorteComprableHandler);
	}
}
