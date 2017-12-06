package controlador.Comprables;

import modelo.juego.Turno;
import modelo.tablero.Comprable;
import modelo.tablero.Tablero;
import vista.tablero.VistaTablero;
import vista.tablero.estadosPoseibles.EdesurEstadoPoseible;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class EdesurComprableHandler implements EventHandler<ActionEvent> {


	Comprable unComprable;
	
	public EdesurComprableHandler(Comprable unComprable){
		this.unComprable = unComprable;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
    	this.unComprable.comprar(Turno.getInstance().turnoActual());
    	VistaTablero.getInstance().obtenerCasilla(Tablero.CASILLA_EDESUR).cambiarEstado(new EdesurEstadoPoseible());
	}
}
