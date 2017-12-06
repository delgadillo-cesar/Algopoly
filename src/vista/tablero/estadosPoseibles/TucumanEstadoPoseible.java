package vista.tablero.estadosPoseibles;

import controlador.poseibles.OpcionesBarrioPoseibleHandler;
import controlador.poseibles.TucumanVenderHandler;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import modelo.tablero.Tablero;
import modelo.tablero.poseibles.barrios.BarrioTucuman;

public class TucumanEstadoPoseible extends BarrioEstadoVistaPoseible {

	public TucumanEstadoPoseible(){
		this.barrio = (BarrioTucuman) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_TUCUMAN);
		this.habilitarCasilla = false;
	}
	
	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesBarrioPoseibleHandler(imagen, this.barrio, new TucumanVenderHandler(this.barrio));
	}
}
