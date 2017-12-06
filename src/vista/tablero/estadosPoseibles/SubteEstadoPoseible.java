package vista.tablero.estadosPoseibles;

import controlador.poseibles.OpcionesCompaniaPoseibleHandler;
import controlador.poseibles.SubteVenderHandler;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import modelo.tablero.Tablero;
import modelo.tablero.poseibles.Compania;
import modelo.tablero.poseibles.Subte;

public class SubteEstadoPoseible extends CompaniaEstadoVistaPoseible {

	public SubteEstadoPoseible(){
		this.poseible = (Subte) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_SUBTE);
		this.habilitarCasilla = false;
	}

	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesCompaniaPoseibleHandler(imagen, (Compania) this.poseible, new SubteVenderHandler(poseible));
	}
}
