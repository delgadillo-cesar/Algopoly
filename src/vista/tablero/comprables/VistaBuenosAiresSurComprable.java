package vista.tablero.comprables;

import controlador.Comprables.BuenosAiresSurComprableHandler;
import controlador.Comprables.OpcionesComprableHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.BuenosAiresSurComprable;
import vista.tablero.VistaCasilla;
import javafx.scene.image.Image;

public class VistaBuenosAiresSurComprable extends VistaCasilla {
	
	private BuenosAiresSurComprable buenosAiresSurComprable;
	
	public VistaBuenosAiresSurComprable(){
		this.buenosAiresSurComprable = new BuenosAiresSurComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_BUENOS_AIRES_SUR, this.buenosAiresSurComprable);

		this.stringImagen = "file:src/vista/imagenes/CasillaBuenosAiresSur.png";
        this.dibujarCasilla();

        OpcionesComprableHandler buenosAiresSurComprableHandler = new OpcionesComprableHandler(imagen, new BuenosAiresSurComprableHandler(buenosAiresSurComprable));
		this.setOnMouseClicked(buenosAiresSurComprableHandler);
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(false);
	}
}
