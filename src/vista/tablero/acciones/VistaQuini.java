package vista.tablero.acciones;

import vista.tablero.VistaTablero;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.acciones.Quini;
import javafx.scene.control.Button;

public class VistaQuini extends Button {
	
	private Quini quini;

	public VistaQuini(){
		this.quini = new Quini();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_QUINI, this.quini);

        this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaQuini.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_HORIZONTAL, VistaTablero.ALTO_CASILLA_HORIZONTAL);
	}
}
