package vista.tablero.acciones;

import modelo.tablero.Tablero;
import modelo.tablero.casillas.acciones.Carcel;
import vista.tablero.VistaTablero;
import javafx.scene.control.Button;

public class VistaCarcel extends Button {

	private Carcel carcel;
	
	public VistaCarcel(){
		this.carcel = new Carcel();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_CARCEL, this.carcel);

	    this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaCarcel.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_VERTICAL, VistaTablero.ALTO_CASILLA_HORIZONTAL);
	}
}
