package vista.tablero.casilla;

import vista.tablero.VistaCasilla;
import vista.tablero.estadosComprables.TrenEstadoComprable;

public class VistaCasillaTren extends VistaCasilla {
	
	public VistaCasillaTren(){
		super();
		this.stringImagen = "file:src/vista/imagenes/CasillaTren.png";
		this.dibujarFondo();
        this.cambiarEstado(new TrenEstadoComprable());
        this.dibujarCasilla();
	}
}
