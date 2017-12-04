package vista.tablero.comprables;

import controlador.Comprables.NeuquenComprableHandler;
import controlador.Comprables.OpcionesComprableHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.NeuquenComprable;
import vista.tablero.VistaCasilla;
import javafx.scene.image.Image;

public class VistaNeuquenComprable extends VistaCasilla {
	
	private NeuquenComprable neuquenComprable;
	
	public VistaNeuquenComprable(){
		this.neuquenComprable = new NeuquenComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_NEUQUEN, this.neuquenComprable);

		this.stringImagen = "file:src/vista/imagenes/CasillaNeuquen.png";
        this.dibujarCasilla();

        OpcionesComprableHandler neuquenComprableHandler = new OpcionesComprableHandler(imagen, new NeuquenComprableHandler(neuquenComprable));
		this.setOnMouseClicked(neuquenComprableHandler);
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(false);
	}
}
