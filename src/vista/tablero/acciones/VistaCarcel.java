package vista.tablero.acciones;

import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.acciones.Carcel;
import vista.tablero.VistaCasilla;
import vista.tablero.VistaTablero;
import javafx.scene.image.Image;

public class VistaCarcel extends VistaCasilla {

	private Carcel carcel;
	
	public VistaCarcel(){
		this.carcel = new Carcel();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_CARCEL, this.carcel);

	    this.stringImagen = "file:src/vista/imagenes/CasillaCarcel.png";
        this.dibujarCasilla();
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(false);
	}
}
