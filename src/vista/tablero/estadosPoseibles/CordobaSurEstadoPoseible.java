package vista.tablero.estadosPoseibles;

import controlador.poseibles.CordobaSurVenderHandler;
import controlador.poseibles.OpcionesBarrioPoseibleHandler;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import modelo.tablero.Tablero;
import modelo.tablero.poseibles.barrios.BarrioCordobaSur;

public class CordobaSurEstadoPoseible extends BarrioEstadoVistaPoseible {

	public CordobaSurEstadoPoseible(){
		this.barrio = (BarrioCordobaSur) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_CORDOBA_SUR);
		this.habilitarCasilla = false;
	}
	
	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesBarrioPoseibleHandler(imagen, this.barrio, new CordobaSurVenderHandler(this.barrio));
	}
}
