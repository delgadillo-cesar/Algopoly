package vista.tablero.casilla;

import vista.tablero.estadosComprables.BuenosAiresSurEstadoComprable;

public class VistaCasillaBuenosAiresSur extends VistaCasillaBarrio {

	public VistaCasillaBuenosAiresSur(){
		super();
		this.stringImagen = "file:src/vista/imagenes/CasillaBuenosAiresSur.png";
		this.dibujarFondo();
        this.cambiarEstado(new BuenosAiresSurEstadoComprable());
        this.dibujarCasilla();
	}
}
