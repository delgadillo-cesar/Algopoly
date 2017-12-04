package vista.tablero.comprables;

import controlador.Comprables.OpcionesComprableHandler;
import controlador.Comprables.TrenComprableHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.TrenComprable;
import vista.tablero.VistaCasilla;
import javafx.scene.image.Image;

public class VistaTrenComprable extends VistaCasilla {
	
	private TrenComprable trenComprable;
	
	public VistaTrenComprable(){
		this.trenComprable = new TrenComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_TREN, this.trenComprable);

		this.stringImagen = "file:src/vista/imagenes/CasillaTren.png";
        this.dibujarCasilla();

        OpcionesComprableHandler trenComprableHandler = new OpcionesComprableHandler(imagen, new TrenComprableHandler(trenComprable));
		this.setOnMouseClicked(trenComprableHandler);
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(false);
	}
}
