package vista.tablero.estadosComprables;

import controlador.Comprables.OpcionesComprableHandler;
import controlador.Comprables.SaltaNorteComprableHandler;
import modelo.tablero.Tablero;
import modelo.tablero.comprables.SaltaNorteComprable;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class SaltaNorteEstadoComprable extends EstadoVistaComprable {
	
	private SaltaNorteComprable saltaNorteComprable;
	
	public SaltaNorteEstadoComprable(){
		this.saltaNorteComprable = new SaltaNorteComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SALTA_NORTE, this.saltaNorteComprable);
	}

	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesComprableHandler(imagen, saltaNorteComprable, new SaltaNorteComprableHandler(saltaNorteComprable));
	}
}
