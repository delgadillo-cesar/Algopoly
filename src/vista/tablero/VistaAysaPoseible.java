package vista.tablero;

import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.Aysa;
import Controlador.AysaPoseidaHandler;
import javafx.scene.control.Button;

public class VistaAysaPoseible extends Button {

	private Aysa aysa;
	
	public VistaAysaPoseible(){
		this.aysa = (Aysa) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_AYSA);

		this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaAysa.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_HORIZONTAL, VistaTablero.ALTO_CASILLA_HORIZONTAL);

        AysaPoseidaHandler aysaPoseidaHandler = new AysaPoseidaHandler(aysa);
        this.setOnAction(aysaPoseidaHandler);
	}
}
