package vista.tablero.casilla;

import vista.tablero.estadosComprables.NeuquenEstadoComprable;

public class VistaCasillaNeuquen extends VistaCasillaBarrio {

	public VistaCasillaNeuquen(){
		super();
		this.stringImagen = "file:src/vista/imagenes/CasillaNeuquen.png";
		this.dibujarFondo();
        this.cambiarEstado(new NeuquenEstadoComprable());
        this.dibujarCasilla();
	}
}
