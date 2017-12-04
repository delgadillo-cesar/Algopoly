package vista.tablero.acciones;

import controlador.CarcelFianzaHandler;
import controlador.CerrarOpcionesHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.entidades.Jugador;
import modelo.juego.Turno;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.acciones.Carcel;

public class VistaOpcionesCarcel extends Stage {

	public VistaOpcionesCarcel(Image imagen){
		
	    this.initModality(Modality.APPLICATION_MODAL);
	    VBox dialogVbox = new VBox();
	    dialogVbox.setPadding(new Insets(180, 20, 50, 20));
	    dialogVbox.setSpacing(10);

	    BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(200, 260, false, false, false, false));
	    dialogVbox.setBackground(new Background(imagenDeFondo));

	    Carcel laCarcel= (Carcel)Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_CARCEL);
	    Jugador unJugador = Turno.getInstance().turnoActual();
	    
	    CerrarOpcionesHandler cerrarOpciones = new CerrarOpcionesHandler(((Stage)this), new CarcelFianzaHandler(unJugador));
	    Button botonFianza = new Button("Pagar fianza");
	    botonFianza.setOnAction(cerrarOpciones);
	    botonFianza.setMaxWidth(Double.MAX_VALUE);
	    botonFianza.setDisable(!laCarcel.puedePagarFianza(unJugador));
	    dialogVbox.getChildren().add(botonFianza);
	    
	    Scene dialogScene = new Scene(dialogVbox, 200, 260);
	    this.setScene(dialogScene);
	    this.setResizable(false);
	}
}
