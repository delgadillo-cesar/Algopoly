package controlador.Comprables;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import vista.tablero.comprables.VistaOpcionesComprable;

public class OpcionesComprableHandler implements EventHandler<MouseEvent> {

	EventHandler<ActionEvent> elEventHandler;
	private Image laImagen;
	
	public OpcionesComprableHandler(Image imagen, EventHandler<ActionEvent> unEventHandler){
		this.elEventHandler = unEventHandler;
		this.laImagen = imagen;
	}

	@Override
	public void handle(MouseEvent arg0) {
    	VistaOpcionesComprable opciones = new VistaOpcionesComprable(laImagen, elEventHandler);
    	opciones.show();
	}

}
