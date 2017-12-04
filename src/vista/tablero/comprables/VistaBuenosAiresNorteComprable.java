package vista.tablero.comprables;

import javafx.scene.image.Image;
import controlador.Comprables.BuenosAiresNorteComprableHandler;
import controlador.Comprables.OpcionesComprableHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.BuenosAiresNorteComprable;
import vista.tablero.VistaCasilla;

public class VistaBuenosAiresNorteComprable extends VistaCasilla {
	
	private BuenosAiresNorteComprable buenosAiresNorteComprable;
	
	public VistaBuenosAiresNorteComprable(){
		this.buenosAiresNorteComprable = new BuenosAiresNorteComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_BUENOS_AIRES_NORTE, this.buenosAiresNorteComprable);

		this.stringImagen = "file:src/vista/imagenes/CasillaBuenosAiresNorte.png";
        this.dibujarCasilla();

        OpcionesComprableHandler buenosAiresNorteComprableHandler = new OpcionesComprableHandler(imagen, new BuenosAiresNorteComprableHandler(buenosAiresNorteComprable));
		this.setOnMouseClicked(buenosAiresNorteComprableHandler);
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
	}
}
