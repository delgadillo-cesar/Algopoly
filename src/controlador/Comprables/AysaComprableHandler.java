package controlador.Comprables;

import vista.tablero.VistaTablero;
import vista.tablero.estadosPoseibles.AysaEstadoPoseible;
import modelo.juego.Turno;
import modelo.tablero.Comprable;
import modelo.tablero.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AysaComprableHandler implements EventHandler<ActionEvent> {

	Comprable unComprable;
	
	public AysaComprableHandler(Comprable unComprable){
		this.unComprable = unComprable;
	}
	
	
    public void handle(ActionEvent actionEvent) {
    	this.unComprable.comprar(Turno.getInstance().turnoActual());

    	AysaEstadoPoseible aysaPoseible = new AysaEstadoPoseible();
    	VistaTablero.getInstance().obtenerCasilla(Tablero.CASILLA_AYSA).cambiarEstado(aysaPoseible);
    }

}
