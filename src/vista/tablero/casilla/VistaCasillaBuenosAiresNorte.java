package vista.tablero.casilla;

import vista.tablero.VistaCasilla;
import vista.tablero.estadosComprables.BuenosAiresNorteEstadoComprable;

public class VistaCasillaBuenosAiresNorte extends VistaCasilla {

	public VistaCasillaBuenosAiresNorte(){
		super();
		this.stringImagen = "file:src/vista/imagenes/CasillaBuenosAiresNorte.png";
        this.dibujarCasilla();
        this.cambiarEstado(new BuenosAiresNorteEstadoComprable());
	}
}
