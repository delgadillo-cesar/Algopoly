package vista.tablero.casilla;

import vista.tablero.estadosComprables.SaltaNorteEstadoComprable;

public class VistaCasillaSaltaNorte extends VistaCasillaBarrio {
	
	public VistaCasillaSaltaNorte(){
		super();
		this.stringImagen = "file:src/vista/imagenes/CasillaSaltaNorte.png";
		this.dibujarFondo();
        this.cambiarEstado(new SaltaNorteEstadoComprable());
        this.dibujarCasilla();
	}
}
