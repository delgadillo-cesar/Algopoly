package vista.tablero.casilla;

import vista.tablero.estadosComprables.BuenosAiresNorteEstadoComprable;

public class VistaCasillaBuenosAiresNorte extends VistaCasillaBarrio {

	public VistaCasillaBuenosAiresNorte(){
		super();
		this.stringImagen = "file:src/vista/imagenes/CasillaBuenosAiresNorte.png";
		this.dibujarFondo();
        this.cambiarEstado(new BuenosAiresNorteEstadoComprable());
        this.dibujarCasilla();
	}
}
