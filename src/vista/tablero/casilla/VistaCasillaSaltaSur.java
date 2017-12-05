package vista.tablero.casilla;

import vista.tablero.estadosComprables.SaltaSurEstadoComprable;

public class VistaCasillaSaltaSur extends VistaCasillaBarrio {

	public VistaCasillaSaltaSur(){
		super();
		this.stringImagen = "file:src/vista/imagenes/CasillaSaltaSur.png";
		this.dibujarFondo();
        this.cambiarEstado(new SaltaSurEstadoComprable());
        this.dibujarCasilla();
	}
}
