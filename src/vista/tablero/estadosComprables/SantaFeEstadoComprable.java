package vista.tablero.estadosComprables;

import controlador.Comprables.OpcionesComprableHandler;
import controlador.Comprables.SantaFeComprableHandler;
import modelo.tablero.Tablero;
import modelo.tablero.comprables.SantaFeComprable;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class SantaFeEstadoComprable extends EstadoVistaComprable {
	
	private SantaFeComprable santaFeComprable;
	
	public SantaFeEstadoComprable(){
		this.santaFeComprable = new SantaFeComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SANTA_FE, this.santaFeComprable);
	}

	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesComprableHandler(imagen, santaFeComprable, new SantaFeComprableHandler(santaFeComprable));
	}
}
