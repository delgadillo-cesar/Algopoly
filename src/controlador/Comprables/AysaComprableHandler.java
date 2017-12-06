package controlador.Comprables;

import vista.jugador.AlertaSaldoInsuficiente;
import vista.tablero.VistaTablero;
import vista.tablero.estadosPoseibles.AysaEstadoPoseible;
import modelo.entidades.JugadorSinSaldoException;
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
    	try{
        	this.unComprable.comprar(Turno.getInstance().turnoActual());

        	AysaEstadoPoseible aysaPoseible = new AysaEstadoPoseible();
        	VistaTablero.getInstance().obtenerCasilla(Tablero.CASILLA_AYSA).cambiarEstado(aysaPoseible);
    	}catch(JugadorSinSaldoException e){
    		new AlertaSaldoInsuficiente();
    	}
    }

}
