package vista.tablero.estadosPoseibles;

import controlador.poseibles.NeuquenVenderHandler;
import controlador.poseibles.OpcionesBarrioPoseibleHandler;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import modelo.tablero.Tablero;
import modelo.tablero.poseibles.barrios.BarrioNeuquen;

public class NeuquenEstadoPoseible extends BarrioEstadoVistaPoseible {

	public NeuquenEstadoPoseible(){
		this.barrio = (BarrioNeuquen) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_NEUQUEN);
		this.habilitarCasilla = false;
	}
	
	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesBarrioPoseibleHandler(imagen, this.barrio, new NeuquenVenderHandler(this.barrio));
	}
}
