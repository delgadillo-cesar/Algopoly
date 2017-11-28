package Controlador;

import vista.tablero.VistaAysaPoseible;
import vista.tablero.VistaTablero;
import modelo.juego.Turno;
import modelo.tablero.casillas.comprables.AysaComprable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AysaComprableHandler implements EventHandler<ActionEvent> {

	AysaComprable aysaComprable;
	
	public AysaComprableHandler(AysaComprable aysaComprable){
		this.aysaComprable = aysaComprable;
	}
	
	
    public void handle(ActionEvent actionEvent) {
    	this.aysaComprable.comprar(Turno.getInstance().turnoActual());

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("FALTA IMPLEMENTAR");
        alert.setHeaderText("Opciones de una casilla comprable");
        String mensaje = "Por el momento se dispara a la accion de comprar en forma automatica";
        alert.setContentText(mensaje);
        alert.show();

    	
    	
    	VistaAysaPoseible vistaAysa = new VistaAysaPoseible();
    	VistaTablero.getInstance().setBotonAysa(vistaAysa);
    }

}
