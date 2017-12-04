package vista.tablero.casilla;

import vista.tablero.VistaCasilla;
import vista.tablero.estadosComprables.SubteEstadoComprable;

public class VistaCasillaSubte extends VistaCasilla {

	public VistaCasillaSubte(){
		super();
		this.stringImagen = "file:src/vista/imagenes/CasillaSubte.png";
        this.dibujarCasilla();
        this.cambiarEstado(new SubteEstadoComprable());
	}

}
