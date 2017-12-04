package vista.tablero.comprables;

import controlador.Comprables.OpcionesComprableHandler;
import controlador.Comprables.SaltaSurComprableHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.SaltaSurComprable;
import vista.tablero.VistaCasilla;
import javafx.scene.image.Image;

public class VistaSaltaSurComprable extends VistaCasilla {
	
	private SaltaSurComprable saltaSurComprable;
	
	public VistaSaltaSurComprable(){
		this.saltaSurComprable = new SaltaSurComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SALTA_SUR, this.saltaSurComprable);

		this.stringImagen = "file:src/vista/imagenes/CasillaSaltaSur.png";
        this.dibujarCasilla();

        OpcionesComprableHandler saltaSurComprableHandler = new OpcionesComprableHandler(imagen, new SaltaSurComprableHandler(saltaSurComprable));
		this.setOnMouseClicked(saltaSurComprableHandler);
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(false);
	}
}
