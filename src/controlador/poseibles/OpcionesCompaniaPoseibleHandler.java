package controlador.poseibles;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import modelo.tablero.casillas.poseibles.Compania;
import vista.tablero.estadosPoseibles.VistaOpcionesCompaniaPoseible;

public class OpcionesCompaniaPoseibleHandler implements EventHandler<MouseEvent> {

	Compania laCompania;
	private Image laImagen;
	
	public OpcionesCompaniaPoseibleHandler(Image imagen, Compania unaCompania){
		this.laCompania = unaCompania;
		this.laImagen = imagen;
	}

	@Override
	public void handle(MouseEvent arg0) {
		VistaOpcionesCompaniaPoseible opciones = new VistaOpcionesCompaniaPoseible(laImagen, laCompania);
    	opciones.show();
	}


}
