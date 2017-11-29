package vista.tablero.poseibles;

import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.barrios.BarrioSaltaNorte;
import vista.tablero.VistaTablero;
import Controlador.CompaniaPoseibleHandler;
import javafx.scene.control.Button;

public class VistaSaltaNortePoseible extends Button {

	private BarrioSaltaNorte saltaNorte;
	
	public VistaSaltaNortePoseible(){
		this.saltaNorte = (BarrioSaltaNorte) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_SALTA_NORTE);
		this.setText(saltaNorte.propietario().nombreJugador());

        this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaSaltaNorte.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_HORIZONTAL, VistaTablero.ALTO_CASILLA_HORIZONTAL);

        CompaniaPoseibleHandler edesurPoseidaHandler = new CompaniaPoseibleHandler(saltaNorte);
        this.setOnAction(edesurPoseidaHandler);
	}

}
