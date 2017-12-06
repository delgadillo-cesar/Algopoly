package vista.tablero.estadosPoseibles;

import controlador.poseibles.OpcionesBarrioPoseibleHandler;
import controlador.poseibles.SantaFeVenderHandler;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import modelo.tablero.Tablero;
import modelo.tablero.poseibles.barrios.BarrioSantaFe;

public class SantaFeEstadoPoseible extends BarrioEstadoVistaPoseible {

	public SantaFeEstadoPoseible(){
		this.barrio = (BarrioSantaFe) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_SANTA_FE);
		this.habilitarCasilla = false;
	}
	
	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesBarrioPoseibleHandler(imagen, this.barrio, new SantaFeVenderHandler(this.barrio));
	}
}
