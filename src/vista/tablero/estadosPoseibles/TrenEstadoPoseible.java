package vista.tablero.estadosPoseibles;

import controlador.poseibles.OpcionesCompaniaPoseibleHandler;
import controlador.poseibles.TrenVenderHandler;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import modelo.tablero.Tablero;
import modelo.tablero.poseibles.compania.Compania;
import modelo.tablero.poseibles.compania.Tren;

public class TrenEstadoPoseible extends CompaniaEstadoVistaPoseible {

	public TrenEstadoPoseible(){
		this.poseible = (Tren) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_TREN);
		this.habilitarCasilla = false;
	}

	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesCompaniaPoseibleHandler(imagen, (Compania) this.poseible, new TrenVenderHandler(poseible));
	}
}
