package vista.tablero.acciones;

import modelo.tablero.Tablero;
import modelo.tablero.casillas.acciones.Policia;
import vista.tablero.VistaCasilla;

public class VistaCasillaPolicia extends VistaCasilla {

	public VistaCasillaPolicia(){
		super();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_POLICIA, new Policia());

		this.stringImagen = "file:src/vista/imagenes/CasillaPolicia.png";
        this.dibujarCasilla();
        this.cambiarEstado(new EstadoAccion());
	}
}
