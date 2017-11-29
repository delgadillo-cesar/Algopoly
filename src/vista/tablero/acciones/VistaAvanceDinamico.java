package vista.tablero.acciones;

import vista.tablero.VistaTablero;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.acciones.AvanceDinamico;
import javafx.scene.control.Button;

public class VistaAvanceDinamico extends Button {

	private AvanceDinamico avanceDinamico;
	
	public VistaAvanceDinamico(){
		this.avanceDinamico = new AvanceDinamico();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_AVANCE_DINAMICO, this.avanceDinamico);

	    this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaAvanceDinamico.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_VERTICAL, VistaTablero.ALTO_CASILLA_VERTICAL);
	}
}
