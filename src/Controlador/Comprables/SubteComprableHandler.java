package Controlador.Comprables;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import modelo.juego.Turno;
import modelo.tablero.Comprable;
import vista.tablero.VistaTablero;
import vista.tablero.poseibles.VistaSubtePoseible;

public class SubteComprableHandler implements EventHandler<ActionEvent> {

	Comprable unComprable;
	
	public SubteComprableHandler(Comprable unComprable){
		this.unComprable = unComprable;
	}
	
	
    public void handle(ActionEvent actionEvent) {
    	this.unComprable.comprar(Turno.getInstance().turnoActual());

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("FALTA IMPLEMENTAR");
        alert.setHeaderText("Opciones de una casilla comprable");
        String mensaje = "Por el momento se dispara a la accion de comprar en forma automatica";
        alert.setContentText(mensaje);
        alert.show();

    	
    	
    	VistaSubtePoseible vistaSubte = new VistaSubtePoseible();
    	VistaTablero.getInstance().setSubte(vistaSubte);
    	Turno.getInstance().cambiarTurno(); /*QUITAR*/
    }
}
