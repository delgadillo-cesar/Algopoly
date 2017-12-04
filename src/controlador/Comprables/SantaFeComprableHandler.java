package controlador.Comprables;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.juego.Turno;
import modelo.tablero.Comprable;
import modelo.tablero.Tablero;
import vista.tablero.VistaTablero;
import vista.tablero.estadosPoseibles.SantaFeEstadoPoseible;

public class SantaFeComprableHandler implements EventHandler<ActionEvent> {

	Comprable unComprable;
	
	public SantaFeComprableHandler(Comprable unComprable){
		this.unComprable = unComprable;
	}
	
	
    public void handle(ActionEvent actionEvent) {
    	this.unComprable.comprar(Turno.getInstance().turnoActual());
    	VistaTablero.getInstance().obtenerCasilla(Tablero.CASILLA_SANTA_FE).cambiarEstado(new SantaFeEstadoPoseible());
    }

}
