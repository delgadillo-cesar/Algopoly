package vista.tablero.comprables;

import controlador.Comprables.EdesurComprableHandler;
import controlador.Comprables.OpcionesComprableHandler;
import vista.tablero.VistaCasilla;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.EdesurComprable;
import javafx.scene.image.Image;

public class VistaEdesurComprable extends VistaCasilla {
	
	private EdesurComprable edesurComprable;
	
	public VistaEdesurComprable(){
		this.edesurComprable = new EdesurComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_EDESUR, this.edesurComprable);
	
		this.stringImagen = "file:src/vista/imagenes/CasillaEdesur.png";
        this.dibujarCasilla();

        OpcionesComprableHandler edesurComprableHandler = new OpcionesComprableHandler(imagen, new EdesurComprableHandler(edesurComprable));
		this.setOnMouseClicked(edesurComprableHandler);
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(false);
	}

}
