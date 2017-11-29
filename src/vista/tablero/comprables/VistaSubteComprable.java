package vista.tablero.comprables;

import Controlador.Comprables.SubteComprableHandler;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.SubteComprable;
import vista.tablero.VistaTablero;
import javafx.scene.control.Button;

public class VistaSubteComprable extends Button {

	private SubteComprable subteComprable;
	
	public VistaSubteComprable(){
		this.subteComprable = new SubteComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SUBTE, this.subteComprable);

		this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaSubte.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_VERTICAL, VistaTablero.ALTO_CASILLA_VERTICAL);
	
        SubteComprableHandler subteComprableHandler = new SubteComprableHandler(subteComprable);
        this.setOnAction(subteComprableHandler);
	}
}
