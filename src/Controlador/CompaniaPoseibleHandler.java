package Controlador;

import modelo.tablero.Poseible;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CompaniaPoseibleHandler implements EventHandler<ActionEvent> {

	Poseible unPoseible;
	
	public CompaniaPoseibleHandler(Poseible unPoseible){
		this.unPoseible = unPoseible;
	}
	
	
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("FALTA IMPLEMENTAR");
        alert.setHeaderText("Aysa comprada por: " + this.unPoseible.propietario().nombreJugador());
        String mensaje = "En una compania no creo que vayamos a mostrar opciones";
        alert.setContentText(mensaje);
        alert.show();
/*    	
    	Alert alert = 
    	        new Alert(AlertType.WARNING, 
    	            "The format for dates is year.month.day. " +
    	            "For example, today is " + "algo mas" + ".",
    	             ButtonType.OK, 
    	             ButtonType.CANCEL);
    	alert.setTitle("Date format warning");
    	Optional<ButtonType> result = alert.showAndWait();
*/    
    }

}
