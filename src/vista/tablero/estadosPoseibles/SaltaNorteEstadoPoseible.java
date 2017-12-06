package vista.tablero.estadosPoseibles;

import controlador.poseibles.OpcionesBarrioPoseibleHandler;
import controlador.poseibles.SaltaNorteVenderHandler;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import modelo.tablero.Tablero;
import modelo.tablero.poseibles.barrios.BarrioSaltaNorte;

public class SaltaNorteEstadoPoseible extends BarrioEstadoVistaPoseible {

	public SaltaNorteEstadoPoseible(){
		this.barrio = (BarrioSaltaNorte) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_SALTA_NORTE);
		this.habilitarCasilla = false;
	}
	
	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesBarrioPoseibleHandler(imagen, this.barrio, new SaltaNorteVenderHandler(this.barrio));
	}
}
