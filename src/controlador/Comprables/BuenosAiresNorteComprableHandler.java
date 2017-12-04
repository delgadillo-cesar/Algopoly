package controlador.Comprables;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.juego.Turno;
import modelo.tablero.Comprable;
import vista.tablero.VistaTablero;
import vista.tablero.poseibles.VistaBuenosAiresNortePoseible;

public class BuenosAiresNorteComprableHandler implements EventHandler<ActionEvent> {
	Comprable unComprable;
	
	public BuenosAiresNorteComprableHandler(Comprable unComprable){
		this.unComprable = unComprable;
	}
	
	
    public void handle(ActionEvent actionEvent) {
    	this.unComprable.comprar(Turno.getInstance().turnoActual());

    	VistaBuenosAiresNortePoseible vistaBuenosAiresNorter = new VistaBuenosAiresNortePoseible();
    	VistaTablero.getInstance().setBuenosAiresNorte(vistaBuenosAiresNorter);
    }
}
