package Controlador;

import modelo.tablero.casillas.poseibles.barrios.Barrio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BarrioPoseibleHandler  implements EventHandler<ActionEvent> {
	Barrio unBarrio;
	
	public BarrioPoseibleHandler(Barrio unBarrio){
		this.unBarrio = unBarrio;
	}
	
	
    public void handle(ActionEvent actionEvent) {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        VBox dialogVbox = new VBox();
        dialogVbox.getChildren().add(new Text("This is a Dialog"));
        Scene dialogScene = new Scene(dialogVbox, 200, 260);

        dialog.setScene(dialogScene);
        dialog.setResizable(false);
        dialog.show();
    }

}
