package vista.tablero.poseibles;

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
import modelo.tablero.casillas.poseibles.Compania;
import controlador.CerrarOpcionesHandler;
import controlador.poseibles.CompaniaVenderHandler;

public class VistaOpcionesCompaniaPoseible extends Stage{

	public VistaOpcionesCompaniaPoseible(Image imagen, Compania unaCompania){
		
	    this.initModality(Modality.APPLICATION_MODAL);
	    VBox dialogVbox = new VBox();
	    dialogVbox.setPadding(new Insets(180, 20, 50, 20));
	    dialogVbox.setSpacing(10);

	    BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(200, 260, false, false, false, false));
	    dialogVbox.setBackground(new Background(imagenDeFondo));
	    
	    CerrarOpcionesHandler cerrarOpciones = new CerrarOpcionesHandler(((Stage)this), new CompaniaVenderHandler(unaCompania));
	    Button botonVender = new Button("Vender");
	    botonVender.setDisable(true);
	    botonVender.setOnAction(cerrarOpciones);
	    botonVender.setMaxWidth(Double.MAX_VALUE);
	    dialogVbox.getChildren().add(botonVender);
	    
	    Scene dialogScene = new Scene(dialogVbox, 200, 260);
	    this.setScene(dialogScene);
	    this.setResizable(false);
	}
}
