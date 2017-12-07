package vista.tablero.estadosComprables;

import controlador.Comprables.NeuquenComprableHandler;
import controlador.Comprables.OpcionesComprableHandler;
import modelo.tablero.Tablero;
import modelo.tablero.comprables.NeuquenComprable;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class NeuquenEstadoComprable extends EstadoVistaComprable {
	
	private NeuquenComprable neuquenComprable;
	
	public NeuquenEstadoComprable(){
		this.neuquenComprable = new NeuquenComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_NEUQUEN, this.neuquenComprable);
	}

	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesComprableHandler(imagen, neuquenComprable, new NeuquenComprableHandler(neuquenComprable));
	}
}
