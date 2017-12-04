package vista.tablero.casilla;

import vista.tablero.VistaCasilla;
import vista.tablero.estadosComprables.SantaFeEstadoComprable;

public class VistaCasillaSantaFe extends VistaCasilla {

	public VistaCasillaSantaFe(){
		super();
		this.stringImagen = "file:src/vista/imagenes/CasillaSantaFe.png";
        this.dibujarCasilla();
        this.cambiarEstado(new SantaFeEstadoComprable());
	}
}
