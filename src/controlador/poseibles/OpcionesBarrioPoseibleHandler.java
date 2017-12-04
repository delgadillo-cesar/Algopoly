package controlador.poseibles;

import modelo.tablero.casillas.poseibles.barrios.Barrio;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import vista.tablero.poseibles.VistaOpcionesBarrioPoseible;

public class OpcionesBarrioPoseibleHandler implements EventHandler<MouseEvent> {

	Barrio elBarrio;
	private Image laImagen;
	
	public OpcionesBarrioPoseibleHandler(Image imagen, Barrio unBarrio){
		this.elBarrio = unBarrio;
		this.laImagen = imagen;
	}

	@Override
	public void handle(MouseEvent arg0) {
    	VistaOpcionesBarrioPoseible opciones = new VistaOpcionesBarrioPoseible(laImagen, elBarrio);
    	opciones.show();
	}

}
