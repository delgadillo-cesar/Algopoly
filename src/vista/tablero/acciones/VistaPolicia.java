package vista.tablero.acciones;

import modelo.tablero.Tablero;
import modelo.tablero.casillas.acciones.Policia;
import vista.tablero.VistaTablero;
import javafx.scene.control.Button;

public class VistaPolicia extends Button {

	private Policia policia;
	
	public VistaPolicia(){
		this.policia = new Policia();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_POLICIA, this.policia);

		this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaPolicia.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_VERTICAL, VistaTablero.ALTO_CASILLA_HORIZONTAL);
	}
}
