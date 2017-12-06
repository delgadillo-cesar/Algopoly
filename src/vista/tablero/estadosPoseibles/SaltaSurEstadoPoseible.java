package vista.tablero.estadosPoseibles;

import controlador.poseibles.OpcionesBarrioPoseibleHandler;
import controlador.poseibles.SaltaSurVenderHandler;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import modelo.tablero.Tablero;
import modelo.tablero.poseibles.barrios.BarrioSaltaSur;

public class SaltaSurEstadoPoseible extends BarrioEstadoVistaPoseible {

	public SaltaSurEstadoPoseible(){
		this.barrio = (BarrioSaltaSur) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_SALTA_SUR);
		this.habilitarCasilla = false;
	}
	
	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesBarrioPoseibleHandler(imagen, this.barrio, new SaltaSurVenderHandler(this.barrio));
	}
}
