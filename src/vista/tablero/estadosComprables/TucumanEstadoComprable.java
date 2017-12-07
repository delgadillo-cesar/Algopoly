package vista.tablero.estadosComprables;

import controlador.Comprables.OpcionesComprableHandler;
import controlador.Comprables.TucumanComprableHandler;
import modelo.tablero.Tablero;
import modelo.tablero.comprables.TucumanComprable;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class TucumanEstadoComprable extends EstadoVistaComprable {
	
	private TucumanComprable tucumanComprable;
	
	public TucumanEstadoComprable(){
		this.tucumanComprable = new TucumanComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_TUCUMAN, this.tucumanComprable);
	}

	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesComprableHandler(imagen, tucumanComprable, new TucumanComprableHandler(tucumanComprable));
	}
}
