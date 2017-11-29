package vista.tablero.acciones;

import modelo.tablero.Tablero;
import modelo.tablero.casillas.acciones.ImpuestoLujo;
import vista.tablero.VistaTablero;
import javafx.scene.control.Button;

public class VistaImpuestoLujo extends Button {

	private ImpuestoLujo impuestoLujo;
	
	public VistaImpuestoLujo(){
		this.impuestoLujo = new ImpuestoLujo();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_IMPUESTO_DE_LUJO, this.impuestoLujo);

        this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaImpuestoLujo.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_VERTICAL, VistaTablero.ALTO_CASILLA_HORIZONTAL);
	}



}
