package vista.tablero.estadosPoseibles;

import controlador.poseibles.CordobaNorteVenderHandler;
import controlador.poseibles.OpcionesBarrioPoseibleHandler;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import modelo.tablero.Tablero;
import modelo.tablero.poseibles.barrios.BarrioCordobaNorte;

public class CordobaNorteEstadoPoseible extends BarrioEstadoVistaPoseible {

	public CordobaNorteEstadoPoseible(){
		this.barrio = (BarrioCordobaNorte) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_CORDOBA_NORTE);
		this.habilitarCasilla = false;
	}
	
	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesBarrioPoseibleHandler(imagen, this.barrio, new CordobaNorteVenderHandler(this.barrio));
	}
}
