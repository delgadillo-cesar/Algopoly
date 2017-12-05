package vista.tablero.casilla;

import vista.tablero.estadosComprables.TucumanEstadoComprable;

public class VistaCasillaTucuman extends VistaCasillaBarrio {

	public VistaCasillaTucuman(){
		super();
		this.stringImagen = "file:src/vista/imagenes/CasillaTucuman.png";
		this.dibujarFondo();
        this.cambiarEstado(new TucumanEstadoComprable());
        this.dibujarCasilla();
	}
}
