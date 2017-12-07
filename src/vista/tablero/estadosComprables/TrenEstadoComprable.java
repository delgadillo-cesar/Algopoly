package vista.tablero.estadosComprables;

import controlador.Comprables.TrenComprableHandler;
import controlador.Comprables.OpcionesComprableHandler;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import modelo.tablero.Tablero;
import modelo.tablero.comprables.TrenComprable;

public class TrenEstadoComprable extends EstadoVistaComprable {
	
	private TrenComprable trenComprable;
	
	public TrenEstadoComprable(){
		this.trenComprable = new TrenComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_TREN, this.trenComprable);
	}
	public EventHandler<MouseEvent> obtenerHandler(Image imagen){
		return new OpcionesComprableHandler(imagen, trenComprable, new TrenComprableHandler(trenComprable));
	}
}
