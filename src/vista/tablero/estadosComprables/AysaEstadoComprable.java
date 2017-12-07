package vista.tablero.estadosComprables;

import controlador.Comprables.AysaComprableHandler;
import controlador.Comprables.OpcionesComprableHandler;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import modelo.tablero.Tablero;
import modelo.tablero.comprables.AysaComprable;

public class AysaEstadoComprable extends EstadoVistaComprable {
	
	private AysaComprable aysaComprable;
	
	public AysaEstadoComprable(){
		this.aysaComprable = new AysaComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_AYSA, this.aysaComprable);
	}
	
	public EventHandler<MouseEvent> obtenerHandler(Image imagen){
		return new OpcionesComprableHandler(imagen, aysaComprable, new AysaComprableHandler(aysaComprable));
	}
}
