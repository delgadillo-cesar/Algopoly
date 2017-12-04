package vista.tablero.comprables;

import controlador.Comprables.CordobaSurComprableHandler;
import controlador.Comprables.OpcionesComprableHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.CordobaSurComprable;
import vista.tablero.VistaCasilla;
import javafx.scene.image.Image;

public class VistaCordobaSurComprable extends VistaCasilla {
	
	private CordobaSurComprable cordobaSurComprable;
	
	public VistaCordobaSurComprable(){
		this.cordobaSurComprable = new CordobaSurComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_CORDOBA_SUR, this.cordobaSurComprable);
	
		this.stringImagen = "file:src/vista/imagenes/CasillaCordobaSur.png";
        this.dibujarCasilla();

        OpcionesComprableHandler cordobaSurComprableHandler = new OpcionesComprableHandler(imagen, new CordobaSurComprableHandler(cordobaSurComprable));
		this.setOnMouseClicked(cordobaSurComprableHandler);
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(false);
	}
}
