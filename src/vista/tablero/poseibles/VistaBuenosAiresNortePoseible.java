package vista.tablero.poseibles;

import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.barrios.BarrioBuenosAiresNorte;
import vista.tablero.VistaTablero;
import Controlador.BarrioPoseibleHandler;
import Controlador.CompaniaPoseibleHandler;
import javafx.scene.control.Button;

public class VistaBuenosAiresNortePoseible extends Button {

	private BarrioBuenosAiresNorte bueNor;
	
	public VistaBuenosAiresNortePoseible(){
		this.bueNor = (BarrioBuenosAiresNorte) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_BUENOS_AIRES_NORTE);
		this.setText(bueNor.propietario().nombreJugador());

		this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaBuenosAiresNorte.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_HORIZONTAL, VistaTablero.ALTO_CASILLA_HORIZONTAL);

        BarrioPoseibleHandler buenosAiresNortePoseidaHandler = new BarrioPoseibleHandler(bueNor);
        this.setOnAction(buenosAiresNortePoseidaHandler);
	}
}
