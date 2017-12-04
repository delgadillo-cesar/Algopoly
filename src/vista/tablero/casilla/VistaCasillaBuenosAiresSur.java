package vista.tablero.casilla;

import vista.tablero.VistaCasilla;
import vista.tablero.estadosComprables.BuenosAiresSurEstadoComprable;

public class VistaCasillaBuenosAiresSur extends VistaCasilla {

	public VistaCasillaBuenosAiresSur(){
		super();
		this.stringImagen = "file:src/vista/imagenes/CasillaBuenosAiresSur.png";
        this.dibujarCasilla();
        this.cambiarEstado(new BuenosAiresSurEstadoComprable());
	}
}
