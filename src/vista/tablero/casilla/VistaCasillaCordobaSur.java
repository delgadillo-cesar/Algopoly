package vista.tablero.casilla;

import vista.tablero.estadosComprables.CordobaSurEstadoComprable;

public class VistaCasillaCordobaSur extends VistaCasillaBarrio {
	
	public VistaCasillaCordobaSur(){
		super();
		this.stringImagen = "file:src/vista/imagenes/CasillaCordobaSur.png";
		this.dibujarFondo();
        this.cambiarEstado(new CordobaSurEstadoComprable());
        this.dibujarCasilla();
	}

}
