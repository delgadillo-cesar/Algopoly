package vista.tablero.acciones;

import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.acciones.Policia;
import vista.tablero.VistaCasilla;
import javafx.scene.image.Image;

public class VistaPolicia extends VistaCasilla {

	private Policia policia;
	
	public VistaPolicia(){
		this.policia = new Policia();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_POLICIA, this.policia);

		this.stringImagen = "file:src/vista/imagenes/CasillaPolicia.png";
        this.dibujarCasilla();
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(false);
	}
}
