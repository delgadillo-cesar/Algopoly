package vista.tablero.poseibles;

import controlador.poseibles.OpcionesBarrioPoseibleHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.barrios.BarrioBuenosAiresSur;
import vista.tablero.VistaCasilla;
import javafx.scene.image.Image;

public class VistaBuenosAiresSurPoseible extends VistaCasilla {

	private BarrioBuenosAiresSur bueSur;
	
	public VistaBuenosAiresSurPoseible(){
		this.bueSur = (BarrioBuenosAiresSur) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_BUENOS_AIRES_SUR);

		this.stringImagen = "file:src/vista/imagenes/CasillaBuenosAiresSur.png";
        this.dibujarCasilla();

        OpcionesBarrioPoseibleHandler opcionesBarrioPoseibleHandler = new OpcionesBarrioPoseibleHandler(imagen, bueSur);
		this.setOnMouseClicked(opcionesBarrioPoseibleHandler);
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(!(bueSur.propietario() == unJugador));
	}

}
