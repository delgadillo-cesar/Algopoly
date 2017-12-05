package vista.tablero.casilla;

import vista.tablero.estadosComprables.CordobaNorteEstadoComprable;

public class VistaCasillaCordobaNorte extends VistaCasillaBarrio {
	
	public VistaCasillaCordobaNorte(){
		super();
		this.stringImagen = "file:src/vista/imagenes/CasillaCordobaNorte.png";
		this.dibujarFondo();
        this.cambiarEstado(new CordobaNorteEstadoComprable());
        this.dibujarCasilla();
	}

}
