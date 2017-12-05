package vista.tablero.acciones;

import modelo.tablero.Tablero;
import modelo.tablero.acciones.RetrocesoDinamico;
import vista.tablero.VistaCasilla;

public class VistaCasillaRetrocesoDinamico extends VistaCasilla {

	public VistaCasillaRetrocesoDinamico(){
		super();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_RETROCESO_DINAMICO, new RetrocesoDinamico());

		this.stringImagen = "file:src/vista/imagenes/CasillaRetrocesoDinamico.png";
        this.cambiarEstado(new EstadoAccion());
        this.dibujarCasilla();
	}
}
