package controlador.poseibles;

import vista.tablero.estadosPoseibles.VistaOpcionesBarrioPoseible;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import modelo.tablero.poseibles.barrios.Barrio;

public class OpcionesBarrioPoseibleHandler implements EventHandler<MouseEvent> {

	Barrio elBarrio;
	private Image laImagen;
	private EventHandler<ActionEvent> handlerVenta;
	
	public OpcionesBarrioPoseibleHandler(Image imagen, Barrio unBarrio, EventHandler<ActionEvent> handlerVenta){
		this.elBarrio = unBarrio;
		this.laImagen = imagen;
		this.handlerVenta = handlerVenta;
	}

	@Override
	public void handle(MouseEvent arg0) {
    	VistaOpcionesBarrioPoseible opciones = new VistaOpcionesBarrioPoseible(laImagen, elBarrio, handlerVenta);
    	opciones.show();
	}

}
