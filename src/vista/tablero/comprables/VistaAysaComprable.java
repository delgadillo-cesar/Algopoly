package vista.tablero.comprables;

import controlador.Comprables.AysaComprableHandler;
import controlador.Comprables.OpcionesComprableHandler;
import vista.tablero.VistaCasilla;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.AysaComprable;
import javafx.scene.image.Image;

public class VistaAysaComprable extends VistaCasilla {
	
	private AysaComprable aysaComprable;
	
	public VistaAysaComprable(){
		this.aysaComprable = new AysaComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_AYSA, this.aysaComprable);

		this.stringImagen = "file:src/vista/imagenes/CasillaAysa.png";
        this.dibujarCasilla();

        OpcionesComprableHandler aysaComprableHandler = new OpcionesComprableHandler(imagen, new AysaComprableHandler(aysaComprable));
		this.setOnMouseClicked(aysaComprableHandler);
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(false);
	}
}
