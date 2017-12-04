package vista.tablero.casilla;

import vista.tablero.VistaCasilla;
import vista.tablero.estadosComprables.SaltaSurEstadoComprable;

public class VistaCasillaSaltaSur extends VistaCasilla {

	public VistaCasillaSaltaSur(){
		super();
		this.stringImagen = "file:src/vista/imagenes/CasillaSaltaSur.png";
        this.dibujarCasilla();
        this.cambiarEstado(new SaltaSurEstadoComprable());
	}
}
