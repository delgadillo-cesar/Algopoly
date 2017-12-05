package vista.tablero.acciones;

import vista.tablero.VistaCasilla;
import modelo.tablero.Tablero;
import modelo.tablero.acciones.Quini;

public class VistaCasillaQuini extends VistaCasilla {

	public VistaCasillaQuini(){
		super();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_QUINI, new Quini());

		this.stringImagen = "file:src/vista/imagenes/CasillaQuini.png";
        this.cambiarEstado(new EstadoAccion());
        this.dibujarCasilla();
	}
}
