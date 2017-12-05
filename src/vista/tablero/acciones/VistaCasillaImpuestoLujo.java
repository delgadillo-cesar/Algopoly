package vista.tablero.acciones;

import modelo.tablero.Tablero;
import modelo.tablero.acciones.ImpuestoLujo;
import vista.tablero.VistaCasilla;

public class VistaCasillaImpuestoLujo extends VistaCasilla {

	public VistaCasillaImpuestoLujo(){
		super();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_IMPUESTO_DE_LUJO, new ImpuestoLujo());

		this.stringImagen = "file:src/vista/imagenes/CasillaImpuestoLujo.png";
        this.cambiarEstado(new EstadoAccion());
        this.dibujarCasilla();
	}
}
