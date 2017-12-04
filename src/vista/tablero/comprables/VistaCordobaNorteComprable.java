package vista.tablero.comprables;

import controlador.Comprables.CordobaNorteComprableHandler;
import controlador.Comprables.OpcionesComprableHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.CordobaNorteComprable;
import vista.tablero.VistaCasilla;
import javafx.scene.image.Image;

public class VistaCordobaNorteComprable extends VistaCasilla {
	
	private CordobaNorteComprable cordobaNorteComprable;
	
	public VistaCordobaNorteComprable(){
		this.cordobaNorteComprable = new CordobaNorteComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_CORDOBA_NORTE, this.cordobaNorteComprable);

		this.stringImagen = "file:src/vista/imagenes/CasillaCordobaNorte.png";
        this.dibujarCasilla();

        OpcionesComprableHandler cordobaNorteComprableHandler = new OpcionesComprableHandler(imagen, new CordobaNorteComprableHandler(cordobaNorteComprable));
		this.setOnMouseClicked(cordobaNorteComprableHandler);
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(false);
	}
}
