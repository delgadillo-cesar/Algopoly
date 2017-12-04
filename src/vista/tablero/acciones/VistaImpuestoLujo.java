package vista.tablero.acciones;

import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.acciones.ImpuestoLujo;
import vista.tablero.VistaCasilla;
import javafx.scene.image.Image;

public class VistaImpuestoLujo extends VistaCasilla {

	private ImpuestoLujo impuestoLujo;
	
	public VistaImpuestoLujo(){
		this.impuestoLujo = new ImpuestoLujo();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_IMPUESTO_DE_LUJO, this.impuestoLujo);

		this.stringImagen = "file:src/vista/imagenes/CasillaImpuestoLujo.png";
        this.dibujarCasilla();
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(false);
	}
}
