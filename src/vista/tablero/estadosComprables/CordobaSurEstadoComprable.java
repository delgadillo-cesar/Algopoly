package vista.tablero.estadosComprables;

import controlador.Comprables.CordobaSurComprableHandler;
import controlador.Comprables.OpcionesComprableHandler;
import modelo.tablero.Tablero;
import modelo.tablero.comprables.CordobaSurComprable;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class CordobaSurEstadoComprable extends EstadoVistaComprable {
	
	private CordobaSurComprable cordobaSurComprable;
	
	public CordobaSurEstadoComprable(){
		this.cordobaSurComprable = new CordobaSurComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_CORDOBA_SUR, this.cordobaSurComprable);
	}

	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesComprableHandler(imagen, cordobaSurComprable, new CordobaSurComprableHandler(cordobaSurComprable));
	}
}
