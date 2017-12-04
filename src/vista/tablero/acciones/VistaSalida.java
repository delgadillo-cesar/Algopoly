package vista.tablero.acciones;

import javafx.scene.image.Image;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.acciones.Salida;
import vista.tablero.VistaCasilla;

public class VistaSalida  extends VistaCasilla {
	private Salida salida;
	
	public VistaSalida(){
		this.salida = new Salida();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SALIDA, this.salida);

		this.stringImagen = "file:src/vista/imagenes/CasillaSalida.png";
        this.dibujarCasilla();
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(false);
	}
}
