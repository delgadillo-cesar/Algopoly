package vista.tablero.estadosComprables;

import controlador.Comprables.SubteComprableHandler;
import controlador.Comprables.OpcionesComprableHandler;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import modelo.tablero.Tablero;
import modelo.tablero.comprables.SubteComprable;

public class SubteEstadoComprable extends EstadoVistaComprable {
	
	private SubteComprable subteComprable;
	
	public SubteEstadoComprable(){
		this.subteComprable = new SubteComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SUBTE, this.subteComprable);
	}
	
	public EventHandler<MouseEvent> obtenerHandler(Image imagen){
		return new OpcionesComprableHandler(imagen, new SubteComprableHandler(subteComprable));
	}
}
