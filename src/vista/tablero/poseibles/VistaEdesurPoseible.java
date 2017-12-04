package vista.tablero.poseibles;

import controlador.poseibles.OpcionesCompaniaPoseibleHandler;
import vista.tablero.VistaCasilla;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.Edesur;
import javafx.scene.image.Image;

public class VistaEdesurPoseible extends VistaCasilla {

	private Edesur edesur;
	
	public VistaEdesurPoseible(){
		this.edesur = (Edesur) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_EDESUR);

		this.stringImagen = "file:src/vista/imagenes/CasillaSaltaNorte.png";
        this.dibujarCasilla();

        OpcionesCompaniaPoseibleHandler opcionesCompaniaPoseibleHandler = new OpcionesCompaniaPoseibleHandler(imagen, edesur);
		this.setOnMouseClicked(opcionesCompaniaPoseibleHandler);
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(!(edesur.propietario() == unJugador));
	}

}
