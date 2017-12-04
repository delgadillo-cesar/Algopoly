package vista.tablero.acciones;

import modelo.tablero.Tablero;
import modelo.tablero.casillas.acciones.Carcel;
import vista.tablero.VistaCasilla;

public class VistaCasillaCarcel extends VistaCasilla {
	
	public VistaCasillaCarcel(){
		super();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_CARCEL, new Carcel());

		this.stringImagen = "file:src/vista/imagenes/CasillaCarcel.png";
        this.dibujarCasilla();
        this.cambiarEstado(new EstadoAccion());
	}
}
