package Controlador.Comprables;

import vista.tablero.VistaTablero;
import vista.tablero.comprables.VistaOpcionesComprable;
import vista.tablero.poseibles.VistaAysaPoseible;
import modelo.juego.Turno;
import modelo.tablero.Comprable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AysaComprableHandler implements EventHandler<ActionEvent> {

	Comprable unComprable;
	
	public AysaComprableHandler(Comprable unComprable){
		this.unComprable = unComprable;
	}
	
	
    public void handle(ActionEvent actionEvent) {
    	this.unComprable.comprar(Turno.getInstance().turnoActual());

    	VistaAysaPoseible vistaAysa = new VistaAysaPoseible();
    	VistaTablero.getInstance().setAysa(vistaAysa);
    	Turno.getInstance().cambiarTurno(); /*QUITAR*/
    }

}
