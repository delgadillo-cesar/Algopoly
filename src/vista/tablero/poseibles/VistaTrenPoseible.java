package vista.tablero.poseibles;

import controlador.poseibles.OpcionesCompaniaPoseibleHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.Tren;
import vista.tablero.VistaCasilla;
import javafx.scene.image.Image;

public class VistaTrenPoseible extends VistaCasilla {

	private Tren tren;
	
	public VistaTrenPoseible(){
		this.tren = (Tren) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_TREN);

		this.stringImagen = "file:src/vista/imagenes/CasillaTren.png";
        this.dibujarCasilla();

        OpcionesCompaniaPoseibleHandler opcionesCompaniaPoseibleHandler = new OpcionesCompaniaPoseibleHandler(imagen, tren);
		this.setOnMouseClicked(opcionesCompaniaPoseibleHandler);
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(!(tren.propietario() == unJugador));
	}
}
