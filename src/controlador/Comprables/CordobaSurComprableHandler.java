package controlador.Comprables;

import modelo.entidades.JugadorSinSaldoException;
import modelo.juego.Turno;
import modelo.tablero.Comprable;
import modelo.tablero.Tablero;
import vista.jugador.AlertaSaldoInsuficiente;
import vista.tablero.VistaTablero;
import vista.tablero.estadosPoseibles.CordobaSurEstadoPoseible;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CordobaSurComprableHandler implements EventHandler<ActionEvent> {

	Comprable unComprable;
	
	public CordobaSurComprableHandler(Comprable unComprable){
		this.unComprable = unComprable;
	}
	
	
    public void handle(ActionEvent actionEvent) {
    	try{
        	this.unComprable.comprar(Turno.getInstance().turnoActual());
        	VistaTablero.getInstance().obtenerCasilla(Tablero.CASILLA_CORDOBA_SUR).cambiarEstado(new CordobaSurEstadoPoseible());
    	}catch(JugadorSinSaldoException e){
    		new AlertaSaldoInsuficiente();
    	}
    }

}
