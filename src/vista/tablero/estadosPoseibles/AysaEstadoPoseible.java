package vista.tablero.estadosPoseibles;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import modelo.tablero.Tablero;
import modelo.tablero.poseibles.compania.Aysa;
import modelo.tablero.poseibles.compania.Compania;
import controlador.poseibles.AysaVenderHandler;
import controlador.poseibles.OpcionesCompaniaPoseibleHandler;
import javafx.event.EventHandler;


public class AysaEstadoPoseible extends CompaniaEstadoVistaPoseible {
	
	public AysaEstadoPoseible(){
		this.poseible = (Aysa) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_AYSA);
		this.habilitarCasilla = false;
	}

	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesCompaniaPoseibleHandler(imagen, (Compania) this.poseible, new AysaVenderHandler(poseible));
	}

}
