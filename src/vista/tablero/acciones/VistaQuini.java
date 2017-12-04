package vista.tablero.acciones;

import vista.tablero.VistaCasilla;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.acciones.Quini;
import javafx.scene.image.Image;

public class VistaQuini extends VistaCasilla {
	
	private Quini quini;

	public VistaQuini(){
		this.quini = new Quini();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_QUINI, this.quini);

		this.stringImagen = "file:src/vista/imagenes/CasillaQuini.png";
        this.dibujarCasilla();
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(false);
	}
}
