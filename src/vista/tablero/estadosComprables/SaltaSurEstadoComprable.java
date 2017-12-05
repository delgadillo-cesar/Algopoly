package vista.tablero.estadosComprables;

import controlador.Comprables.OpcionesComprableHandler;
import controlador.Comprables.SaltaSurComprableHandler;
import modelo.tablero.Tablero;
import modelo.tablero.comprables.SaltaSurComprable;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class SaltaSurEstadoComprable extends EstadoVistaComprable {
	
	private SaltaSurComprable saltaSurComprable;
	
	public SaltaSurEstadoComprable(){
		this.saltaSurComprable = new SaltaSurComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SALTA_SUR, this.saltaSurComprable);
	}

	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesComprableHandler(imagen, new SaltaSurComprableHandler(saltaSurComprable));
	}
}
