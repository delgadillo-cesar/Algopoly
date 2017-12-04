package vista.tablero.casilla;

import vista.tablero.VistaCasilla;
import vista.tablero.estadosComprables.SaltaNorteEstadoComprable;

public class VistaCasillaSaltaNorte extends VistaCasilla {
	
	public VistaCasillaSaltaNorte(){
		super();
		this.stringImagen = "file:src/vista/imagenes/CasillaSaltaNorte.png";
        this.dibujarCasilla();
        this.cambiarEstado(new SaltaNorteEstadoComprable());
	}
}
