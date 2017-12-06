package controlador.Comprables;

import modelo.entidades.JugadorSinSaldoException;
import modelo.juego.Turno;
import modelo.tablero.Comprable;
import modelo.tablero.Tablero;
import vista.jugador.AlertaSaldoInsuficiente;
import vista.tablero.VistaTablero;
import vista.tablero.estadosPoseibles.CordobaNorteEstadoPoseible;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CordobaNorteComprableHandler implements EventHandler<ActionEvent> {

	Comprable unComprable;
	
	public CordobaNorteComprableHandler(Comprable unComprable){
		this.unComprable = unComprable;
	}
	
	
    public void handle(ActionEvent actionEvent) {
    	try{
        	this.unComprable.comprar(Turno.getInstance().turnoActual());
        	VistaTablero.getInstance().obtenerCasilla(Tablero.CASILLA_CORDOBA_NORTE).cambiarEstado(new CordobaNorteEstadoPoseible());
    	}catch(JugadorSinSaldoException e){
    		new AlertaSaldoInsuficiente();
    	}
    }

}
