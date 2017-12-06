package controlador.Comprables;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.entidades.JugadorSinSaldoException;
import modelo.juego.Turno;
import modelo.tablero.Comprable;
import modelo.tablero.Tablero;
import vista.jugador.AlertaSaldoInsuficiente;
import vista.tablero.VistaTablero;
import vista.tablero.estadosPoseibles.BuenosAiresNorteEstadoPoseible;

public class BuenosAiresNorteComprableHandler implements EventHandler<ActionEvent> {
	Comprable unComprable;
	
	public BuenosAiresNorteComprableHandler(Comprable unComprable){
		this.unComprable = unComprable;
	}
	
	
    public void handle(ActionEvent actionEvent) {
    	try{
        	this.unComprable.comprar(Turno.getInstance().turnoActual());
        	VistaTablero.getInstance().obtenerCasilla(Tablero.CASILLA_BUENOS_AIRES_NORTE).cambiarEstado(new BuenosAiresNorteEstadoPoseible());
    	}catch(JugadorSinSaldoException e){
    		new AlertaSaldoInsuficiente();
    	}
    }
}
