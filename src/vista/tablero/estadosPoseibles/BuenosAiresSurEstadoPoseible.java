package vista.tablero.estadosPoseibles;

import controlador.poseibles.BuenosAiresSurVenderHandler;
import controlador.poseibles.OpcionesBarrioPoseibleHandler;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import modelo.tablero.Tablero;
import modelo.tablero.poseibles.barrios.BarrioBuenosAiresSur;

public class BuenosAiresSurEstadoPoseible extends BarrioEstadoVistaPoseible {

	public BuenosAiresSurEstadoPoseible(){
		this.barrio = (BarrioBuenosAiresSur) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_BUENOS_AIRES_SUR);
		this.habilitarCasilla = false;
	}
	
	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesBarrioPoseibleHandler(imagen, this.barrio, new BuenosAiresSurVenderHandler(this.barrio));
	}
}
