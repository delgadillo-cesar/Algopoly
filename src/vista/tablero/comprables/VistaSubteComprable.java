package vista.tablero.comprables;

import controlador.Comprables.OpcionesComprableHandler;
import controlador.Comprables.SubteComprableHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.SubteComprable;
import vista.tablero.VistaCasilla;
import javafx.scene.image.Image;

public class VistaSubteComprable extends VistaCasilla {

	private SubteComprable subteComprable;
	
	public VistaSubteComprable(){
		this.subteComprable = new SubteComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SUBTE, this.subteComprable);

		this.stringImagen = "file:src/vista/imagenes/CasillaSubte.png";
        this.dibujarCasilla();

        OpcionesComprableHandler subteComprableHandler = new OpcionesComprableHandler(imagen, new SubteComprableHandler(subteComprable));
		this.setOnMouseClicked(subteComprableHandler);
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(false);
	}
}
