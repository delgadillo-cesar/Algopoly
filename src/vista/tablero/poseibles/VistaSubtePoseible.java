package vista.tablero.poseibles;

import javafx.scene.control.Button;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.Subte;
import vista.tablero.VistaTablero;
import Controlador.CompaniaPoseibleHandler;

public class VistaSubtePoseible  extends Button {

	private Subte subte;
	
	public VistaSubtePoseible(){
		this.subte = (Subte) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_SUBTE);
		this.setText(subte.propietario().nombreJugador());

		this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaSubte.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_VERTICAL, VistaTablero.ALTO_CASILLA_VERTICAL);

        CompaniaPoseibleHandler subtePoseidaHandler = new CompaniaPoseibleHandler(subte);
        this.setOnAction(subtePoseidaHandler);
	}
}
