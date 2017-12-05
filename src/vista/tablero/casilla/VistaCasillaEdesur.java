package vista.tablero.casilla;

import vista.tablero.VistaCasilla;
import vista.tablero.estadosComprables.EdesurEstadoComprable;

public class VistaCasillaEdesur extends VistaCasilla {

	public VistaCasillaEdesur(){
		super();
		this.stringImagen = "file:src/vista/imagenes/CasillaEdesur.png";
		this.dibujarFondo();
        this.cambiarEstado(new EdesurEstadoComprable());
        this.dibujarCasilla();
	}
}
