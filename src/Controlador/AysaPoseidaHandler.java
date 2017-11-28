package Controlador;

import modelo.juego.Turno;
import modelo.tablero.casillas.comprables.AysaComprable;
import modelo.tablero.casillas.poseibles.Aysa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AysaPoseidaHandler implements EventHandler<ActionEvent> {

	Aysa aysa;
	
	public AysaPoseidaHandler(Aysa aysa){
		this.aysa = aysa;
	}
	
	
    public void handle(ActionEvent actionEvent) {
//    	this.aysaComprable.comprar(Turno.getInstance().turnoActual());

        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("FALTA IMPLEMENTAR");
        alert.setHeaderText("Aysa comprada por: " + this.aysa.propietario().nombreJugador());
        String mensaje = "En una compania no creo que vayamos a mostrar opciones";
        alert.setContentText(mensaje);
        alert.show();
    	
    }


}
