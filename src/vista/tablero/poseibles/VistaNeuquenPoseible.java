package vista.tablero.poseibles;

import controlador.poseibles.OpcionesBarrioPoseibleHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.barrios.BarrioNeuquen;
import vista.tablero.VistaCasilla;
import javafx.scene.image.Image;

public class VistaNeuquenPoseible extends VistaCasilla {

	private BarrioNeuquen neuquen;
	
	public VistaNeuquenPoseible(){
		this.neuquen = (BarrioNeuquen) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_NEUQUEN);

		this.stringImagen = "file:src/vista/imagenes/CasillaNeuquen.png";
        this.dibujarCasilla();

        OpcionesBarrioPoseibleHandler opcionesBarrioPoseibleHandler = new OpcionesBarrioPoseibleHandler(imagen, neuquen);
		this.setOnMouseClicked(opcionesBarrioPoseibleHandler);
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(!(neuquen.propietario() == unJugador));
	}
}
