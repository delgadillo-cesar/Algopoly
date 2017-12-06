package controlador.Comprables;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.entidades.JugadorSinSaldoException;
import modelo.juego.Turno;
import modelo.tablero.Comprable;
import modelo.tablero.Tablero;
import vista.jugador.AlertaSaldoInsuficiente;
import vista.tablero.VistaTablero;
import vista.tablero.estadosPoseibles.BuenosAiresSurEstadoPoseible;

public class BuenosAiresSurComprableHandler  implements EventHandler<ActionEvent> {


	Comprable unComprable;
	
	public BuenosAiresSurComprableHandler(Comprable unComprable){
		this.unComprable = unComprable;
	}
	
	
    public void handle(ActionEvent actionEvent) {
    	try{
        	this.unComprable.comprar(Turno.getInstance().turnoActual());
        	VistaTablero.getInstance().obtenerCasilla(Tablero.CASILLA_BUENOS_AIRES_SUR).cambiarEstado(new BuenosAiresSurEstadoPoseible());
    	}catch(JugadorSinSaldoException e){
    		new AlertaSaldoInsuficiente();
    	}
    }

}
