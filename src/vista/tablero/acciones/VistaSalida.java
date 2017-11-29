package vista.tablero.acciones;

import javafx.scene.control.Button;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.acciones.Salida;
import vista.tablero.VistaTablero;

public class VistaSalida  extends Button {
	private Salida salida;
	
	public VistaSalida(){
		this.salida = new Salida();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SALIDA, this.salida);

		this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaSalida.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_VERTICAL, VistaTablero.ALTO_CASILLA_HORIZONTAL);
	}
}
