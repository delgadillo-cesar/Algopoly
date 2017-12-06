package controlador;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import vista.tablero.acciones.VistaOpcionesCarcel;

public class OpcionesCarcelHandler implements EventHandler<MouseEvent> {

	private Image laImagen;

	public OpcionesCarcelHandler(Image imagen) {
		this.laImagen = imagen;
	}

	@Override
	public void handle(MouseEvent event) {
    	VistaOpcionesCarcel opciones = new VistaOpcionesCarcel(laImagen);
    	opciones.show();
	}

}
