package vista.tablero.comprables;

import Controlador.Comprables.SantaFeComprableHandler;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.SantaFeComprable;
import vista.tablero.VistaTablero;
import javafx.scene.control.Button;

public class VistaSantaFeComprable extends Button {
	
	private SantaFeComprable santaFeComprable;
	
	public VistaSantaFeComprable(){
		this.santaFeComprable = new SantaFeComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SANTA_FE, this.santaFeComprable);

	    this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaSantaFe.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_HORIZONTAL, VistaTablero.ALTO_CASILLA_HORIZONTAL);
	
        SantaFeComprableHandler santaFeComprableHandler = new SantaFeComprableHandler(santaFeComprable);
        this.setOnAction(santaFeComprableHandler);
	}
}
