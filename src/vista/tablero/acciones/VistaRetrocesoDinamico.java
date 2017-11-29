package vista.tablero.acciones;

import modelo.tablero.Tablero;
import modelo.tablero.casillas.acciones.RetrocesoDinamico;
import vista.tablero.VistaTablero;
import javafx.scene.control.Button;

public class VistaRetrocesoDinamico extends Button {

	private RetrocesoDinamico retrocesoDinamico;
	
	public VistaRetrocesoDinamico(){
		this.retrocesoDinamico = new RetrocesoDinamico();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_RETROCESO_DINAMICO, this.retrocesoDinamico);

	    this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaRetrocesoDinamico.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_VERTICAL, VistaTablero.ALTO_CASILLA_VERTICAL);
	}
}
