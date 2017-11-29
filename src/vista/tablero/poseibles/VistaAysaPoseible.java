package vista.tablero.poseibles;

import vista.tablero.VistaTablero;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.Aysa;
import Controlador.CompaniaPoseibleHandler;
import javafx.scene.control.Button;

public class VistaAysaPoseible extends Button {

	private Aysa aysa;
	
	public VistaAysaPoseible(){
		this.aysa = (Aysa) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_AYSA);
		this.setText(aysa.propietario().nombreJugador());

		this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaAysa.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_HORIZONTAL, VistaTablero.ALTO_CASILLA_HORIZONTAL);

        CompaniaPoseibleHandler aysaPoseidaHandler = new CompaniaPoseibleHandler(aysa);
        this.setOnAction(aysaPoseidaHandler);
	}
}
