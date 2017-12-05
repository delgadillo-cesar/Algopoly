package vista.tablero.casilla;

import vista.tablero.estadosComprables.SantaFeEstadoComprable;

public class VistaCasillaSantaFe extends VistaCasillaBarrio {

	public VistaCasillaSantaFe(){
		super();
		this.stringImagen = "file:src/vista/imagenes/CasillaSantaFe.png";
		this.dibujarFondo();
        this.cambiarEstado(new SantaFeEstadoComprable());
        this.dibujarCasilla();
	}
}
