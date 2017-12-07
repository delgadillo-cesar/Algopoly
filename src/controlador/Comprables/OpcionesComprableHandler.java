package controlador.Comprables;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import modelo.tablero.Comprable;
import vista.tablero.estadosComprables.VistaOpcionesComprable;

public class OpcionesComprableHandler implements EventHandler<MouseEvent> {

	EventHandler<ActionEvent> elEventHandler;
	private Image laImagen;
	private Comprable elComprable;
	
	public OpcionesComprableHandler(Image imagen, Comprable unComprable, EventHandler<ActionEvent> unEventHandler){
		this.elEventHandler = unEventHandler;
		this.laImagen = imagen;
		this.elComprable = unComprable;
	}

	@Override
	public void handle(MouseEvent arg0) {
		VistaOpcionesComprable opciones = new VistaOpcionesComprable(laImagen, elComprable, elEventHandler);
    	opciones.show();
	}

}
