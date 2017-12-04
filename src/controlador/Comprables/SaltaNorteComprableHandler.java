package controlador.Comprables;

import modelo.juego.Turno;
import modelo.tablero.Comprable;
import vista.tablero.VistaTablero;
import vista.tablero.poseibles.VistaSaltaNortePoseible;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SaltaNorteComprableHandler implements EventHandler<ActionEvent> {

	Comprable unComprable;
	
	public SaltaNorteComprableHandler(Comprable unComprable){
		this.unComprable = unComprable;
	}
	
	
    public void handle(ActionEvent actionEvent) {
    	this.unComprable.comprar(Turno.getInstance().turnoActual());

    	VistaSaltaNortePoseible vistaSaltaNorte = new VistaSaltaNortePoseible();
    	VistaTablero.getInstance().setSaltaNorte(vistaSaltaNorte);
    }

}
