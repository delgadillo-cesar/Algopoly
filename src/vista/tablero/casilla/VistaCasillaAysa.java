package vista.tablero.casilla;

import vista.tablero.VistaCasilla;
import vista.tablero.estadosComprables.AysaEstadoComprable;

public class VistaCasillaAysa extends VistaCasilla {

	public VistaCasillaAysa(){
		super();
		this.stringImagen = "file:src/vista/imagenes/CasillaAysa.png";
		this.dibujarFondo();
        this.cambiarEstado(new AysaEstadoComprable());
        this.dibujarCasilla();
	}
}
