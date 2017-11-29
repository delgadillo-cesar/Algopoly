package vista.tablero.comprables;

import Controlador.Comprables.CordobaSurComprableHandler;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.CordobaSurComprable;
import vista.tablero.VistaTablero;
import javafx.scene.control.Button;

public class VistaCordobaSurComprable extends Button {
	
	private CordobaSurComprable cordobaSurComprable;
	
	public VistaCordobaSurComprable(){
		this.cordobaSurComprable = new CordobaSurComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_BUENOS_AIRES_SUR, this.cordobaSurComprable);

	    this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaCordobaSur.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_VERTICAL, VistaTablero.ALTO_CASILLA_VERTICAL);
	
        CordobaSurComprableHandler cordobaSurComprableHandler = new CordobaSurComprableHandler(cordobaSurComprable);
        this.setOnAction(cordobaSurComprableHandler);
	}
}
