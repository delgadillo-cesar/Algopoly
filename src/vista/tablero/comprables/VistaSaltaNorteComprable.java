package vista.tablero.comprables;

import controlador.Comprables.OpcionesComprableHandler;
import controlador.Comprables.SaltaNorteComprableHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.SaltaNorteComprable;
import vista.tablero.VistaCasilla;
import javafx.scene.image.Image;

public class VistaSaltaNorteComprable extends VistaCasilla {
	
	private SaltaNorteComprable saltaNorteComprable;
	
	public VistaSaltaNorteComprable(){
		this.saltaNorteComprable = new SaltaNorteComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SALTA_NORTE, this.saltaNorteComprable);

		this.stringImagen = "file:src/vista/imagenes/CasillaSaltaNorte.png";
        this.dibujarCasilla();

        OpcionesComprableHandler saltaNorteComprableHandler = new OpcionesComprableHandler(imagen, new SaltaNorteComprableHandler(saltaNorteComprable));
		this.setOnMouseClicked(saltaNorteComprableHandler);
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(false);
	}
}
