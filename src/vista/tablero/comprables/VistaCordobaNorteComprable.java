package vista.tablero.comprables;

import Controlador.Comprables.CordobaNorteComprableHandler;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.CordobaNorteComprable;
import vista.tablero.VistaTablero;
import javafx.scene.control.Button;

public class VistaCordobaNorteComprable extends Button {
	
	private CordobaNorteComprable cordobaNorteComprable;
	
	public VistaCordobaNorteComprable(){
		this.cordobaNorteComprable = new CordobaNorteComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_BUENOS_AIRES_NORTE, this.cordobaNorteComprable);

	    this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaCordobaNorte.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_VERTICAL, VistaTablero.ALTO_CASILLA_VERTICAL);
	
        CordobaNorteComprableHandler cordobaNorteComprableHandler = new CordobaNorteComprableHandler(cordobaNorteComprable);
        this.setOnAction(cordobaNorteComprableHandler);
	}
}
