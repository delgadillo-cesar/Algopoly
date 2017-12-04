package vista.tablero.comprables;

import controlador.Comprables.OpcionesComprableHandler;
import controlador.Comprables.SantaFeComprableHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.SantaFeComprable;
import vista.tablero.VistaCasilla;
import javafx.scene.image.Image;

public class VistaSantaFeComprable extends VistaCasilla {
	
	private SantaFeComprable santaFeComprable;
	
	public VistaSantaFeComprable(){
		this.santaFeComprable = new SantaFeComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SANTA_FE, this.santaFeComprable);

		this.stringImagen = "file:src/vista/imagenes/CasillaSantaFe.png";
        this.dibujarCasilla();

        OpcionesComprableHandler santaFeComprableHandler = new OpcionesComprableHandler(imagen, new SantaFeComprableHandler(santaFeComprable));
		this.setOnMouseClicked(santaFeComprableHandler);
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(false);
	}
}
