package controlador.Comprables;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.juego.Turno;
import modelo.tablero.Comprable;
import vista.tablero.VistaTablero;
import vista.tablero.poseibles.VistaSantaFePoseible;

public class SantaFeComprableHandler implements EventHandler<ActionEvent> {

	Comprable unComprable;
	
	public SantaFeComprableHandler(Comprable unComprable){
		this.unComprable = unComprable;
	}
	
	
    public void handle(ActionEvent actionEvent) {
    	this.unComprable.comprar(Turno.getInstance().turnoActual());

    	VistaSantaFePoseible vistaSantaFe = new VistaSantaFePoseible();
    	VistaTablero.getInstance().setSantaFe(vistaSantaFe);
    }

}
