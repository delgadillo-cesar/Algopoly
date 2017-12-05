package vista.tablero.estadosComprables;

import controlador.Comprables.EdesurComprableHandler;
import controlador.Comprables.OpcionesComprableHandler;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import modelo.tablero.Tablero;
import modelo.tablero.comprables.EdesurComprable;

public class EdesurEstadoComprable extends EstadoVistaComprable {
	
	private EdesurComprable edesurComprable;
	
	public EdesurEstadoComprable(){
		this.edesurComprable = new EdesurComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_EDESUR, this.edesurComprable);
	}
	
	public EventHandler<MouseEvent> obtenerHandler(Image imagen){
		return new OpcionesComprableHandler(imagen, new EdesurComprableHandler(edesurComprable));
	}
}
