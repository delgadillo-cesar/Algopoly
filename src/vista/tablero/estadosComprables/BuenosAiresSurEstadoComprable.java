package vista.tablero.estadosComprables;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import controlador.Comprables.BuenosAiresSurComprableHandler;
import controlador.Comprables.OpcionesComprableHandler;
import modelo.tablero.Tablero;
import modelo.tablero.comprables.BuenosAiresSurComprable;

public class BuenosAiresSurEstadoComprable extends EstadoVistaComprable {
	
	private BuenosAiresSurComprable buenosAiresSurComprable;
	
	public BuenosAiresSurEstadoComprable(){
		this.buenosAiresSurComprable = new BuenosAiresSurComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_BUENOS_AIRES_SUR, this.buenosAiresSurComprable);
	}

	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesComprableHandler(imagen, buenosAiresSurComprable, new BuenosAiresSurComprableHandler(buenosAiresSurComprable));
	}
}
