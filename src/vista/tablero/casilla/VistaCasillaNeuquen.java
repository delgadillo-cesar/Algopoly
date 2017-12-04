package vista.tablero.casilla;

import vista.tablero.VistaCasilla;
import vista.tablero.estadosComprables.NeuquenEstadoComprable;

public class VistaCasillaNeuquen extends VistaCasilla {

	public VistaCasillaNeuquen(){
		super();
		this.stringImagen = "file:src/vista/imagenes/CasillaNeuquen.png";
        this.dibujarCasilla();
        this.cambiarEstado(new NeuquenEstadoComprable());
	}
}
