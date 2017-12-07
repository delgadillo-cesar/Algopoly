package vista.tablero.estadosPoseibles;

import controlador.poseibles.EdesurVenderHandler;
import controlador.poseibles.OpcionesCompaniaPoseibleHandler;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import modelo.tablero.Tablero;
import modelo.tablero.poseibles.compania.Compania;
import modelo.tablero.poseibles.compania.Edesur;

public class EdesurEstadoPoseible extends CompaniaEstadoVistaPoseible {

	public EdesurEstadoPoseible(){
		this.poseible = (Edesur) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_EDESUR);
		this.habilitarCasilla = false;
	}


	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesCompaniaPoseibleHandler(imagen, (Compania) this.poseible, new EdesurVenderHandler(poseible));
	}
}
