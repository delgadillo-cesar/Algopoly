package vista.tablero.acciones;

import modelo.tablero.Tablero;
import modelo.tablero.casillas.acciones.Salida;
import vista.tablero.VistaCasilla;

public class VistaCasillaSalida  extends VistaCasilla {
	
	public VistaCasillaSalida(){
		super();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SALIDA, new Salida());

		this.stringImagen = "file:src/vista/imagenes/CasillaSalida.png";
        this.dibujarCasilla();
        this.cambiarEstado(new EstadoAccion());
	}
}
