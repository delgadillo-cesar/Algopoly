package vista.tablero.casilla;

import vista.tablero.VistaCasilla;
import vista.tablero.estadosComprables.TucumanEstadoComprable;

public class VistaCasillaTucuman extends VistaCasilla {

	public VistaCasillaTucuman(){
		super();
		this.stringImagen = "file:src/vista/imagenes/CasillaTucuman.png";
        this.dibujarCasilla();
        this.cambiarEstado(new TucumanEstadoComprable());
	}
}
