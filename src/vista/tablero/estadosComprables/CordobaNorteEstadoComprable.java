package vista.tablero.estadosComprables;

import controlador.Comprables.CordobaNorteComprableHandler;
import controlador.Comprables.OpcionesComprableHandler;
import modelo.tablero.Tablero;
import modelo.tablero.comprables.CordobaNorteComprable;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class CordobaNorteEstadoComprable extends EstadoVistaComprable {
	
	private CordobaNorteComprable cordobaNorteComprable;
	
	public CordobaNorteEstadoComprable(){
		this.cordobaNorteComprable = new CordobaNorteComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_CORDOBA_NORTE, this.cordobaNorteComprable);
	}

	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesComprableHandler(imagen, cordobaNorteComprable, new CordobaNorteComprableHandler(cordobaNorteComprable));
	}
}
