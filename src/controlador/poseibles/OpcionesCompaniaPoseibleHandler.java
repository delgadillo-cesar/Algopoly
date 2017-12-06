package controlador.poseibles;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import modelo.tablero.poseibles.Compania;
import vista.tablero.estadosPoseibles.VistaOpcionesCompaniaPoseible;

public class OpcionesCompaniaPoseibleHandler implements EventHandler<MouseEvent> {

	Compania laCompania;
	private Image laImagen;
	private EventHandler<ActionEvent> handlerVenta;
	
	public OpcionesCompaniaPoseibleHandler(Image imagen, Compania unaCompania, EventHandler<ActionEvent> handlerVenta){
		this.laCompania = unaCompania;
		this.laImagen = imagen;
		this.handlerVenta = handlerVenta;
	}

	@Override
	public void handle(MouseEvent arg0) {
		VistaOpcionesCompaniaPoseible opciones = new VistaOpcionesCompaniaPoseible(laImagen, laCompania, handlerVenta);
    	opciones.show();
	}


}
