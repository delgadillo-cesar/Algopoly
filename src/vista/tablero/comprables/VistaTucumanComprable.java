package vista.tablero.comprables;

import controlador.Comprables.OpcionesComprableHandler;
import controlador.Comprables.TucumanComprableHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.TucumanComprable;
import vista.tablero.VistaCasilla;
import javafx.scene.image.Image;

public class VistaTucumanComprable extends VistaCasilla {
	
	private TucumanComprable tucumanComprable;
	
	public VistaTucumanComprable(){
		this.tucumanComprable = new TucumanComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_TUCUMAN, this.tucumanComprable);

		this.stringImagen = "file:src/vista/imagenes/CasillaTucuman.png";
        this.dibujarCasilla();

        OpcionesComprableHandler tucumanComprableHandler = new OpcionesComprableHandler(imagen, new TucumanComprableHandler(tucumanComprable));
		this.setOnMouseClicked(tucumanComprableHandler);
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(false);
	}
}
