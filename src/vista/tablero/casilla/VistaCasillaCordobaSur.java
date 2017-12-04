package vista.tablero.casilla;

import vista.tablero.VistaCasilla;
import vista.tablero.estadosComprables.CordobaSurEstadoComprable;

public class VistaCasillaCordobaSur extends VistaCasilla {
	
	public VistaCasillaCordobaSur(){
		super();
		this.stringImagen = "file:src/vista/imagenes/CasillaCordobaSur.png";
        this.dibujarCasilla();
        this.cambiarEstado(new CordobaSurEstadoComprable());
	}

}
