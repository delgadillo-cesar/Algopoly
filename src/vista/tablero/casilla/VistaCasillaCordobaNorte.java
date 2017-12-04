package vista.tablero.casilla;

import vista.tablero.VistaCasilla;
import vista.tablero.estadosComprables.CordobaNorteEstadoComprable;

public class VistaCasillaCordobaNorte extends VistaCasilla {
	
	public VistaCasillaCordobaNorte(){
		super();
		this.stringImagen = "file:src/vista/imagenes/CasillaCordobaNorte.png";
        this.dibujarCasilla();
        this.cambiarEstado(new CordobaNorteEstadoComprable());
	}

}
