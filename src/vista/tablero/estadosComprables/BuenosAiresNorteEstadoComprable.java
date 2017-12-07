package vista.tablero.estadosComprables;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import controlador.Comprables.BuenosAiresNorteComprableHandler;
import controlador.Comprables.OpcionesComprableHandler;
import modelo.tablero.Tablero;
import modelo.tablero.comprables.BuenosAiresNorteComprable;

public class BuenosAiresNorteEstadoComprable extends EstadoVistaComprable {
	
	private BuenosAiresNorteComprable buenosAiresNorteComprable;
	
	public BuenosAiresNorteEstadoComprable(){
		this.buenosAiresNorteComprable = new BuenosAiresNorteComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_BUENOS_AIRES_NORTE, this.buenosAiresNorteComprable);
	}
	
	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesComprableHandler(imagen, buenosAiresNorteComprable, new BuenosAiresNorteComprableHandler(buenosAiresNorteComprable));
	}
}
