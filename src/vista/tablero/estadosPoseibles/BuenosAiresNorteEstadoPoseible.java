package vista.tablero.estadosPoseibles;

import controlador.poseibles.BuenosAiresNorteVenderHandler;
import controlador.poseibles.OpcionesBarrioPoseibleHandler;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import modelo.tablero.Tablero;
import modelo.tablero.poseibles.barrios.BarrioBuenosAiresNorte;

public class BuenosAiresNorteEstadoPoseible extends BarrioEstadoVistaPoseible {
	
	public BuenosAiresNorteEstadoPoseible(){
		this.barrio = (BarrioBuenosAiresNorte) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_BUENOS_AIRES_NORTE);
		this.habilitarCasilla = false;
	}
	
	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesBarrioPoseibleHandler(imagen, this.barrio, new BuenosAiresNorteVenderHandler(this.barrio));
	}
}
