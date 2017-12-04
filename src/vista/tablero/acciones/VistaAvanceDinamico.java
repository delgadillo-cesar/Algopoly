package vista.tablero.acciones;

import vista.tablero.VistaCasilla;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.acciones.AvanceDinamico;
import javafx.scene.image.Image;

public class VistaAvanceDinamico extends VistaCasilla {

	private AvanceDinamico avanceDinamico;
	
	public VistaAvanceDinamico(){
		this.avanceDinamico = new AvanceDinamico();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_AVANCE_DINAMICO, this.avanceDinamico);

		this.stringImagen = "file:src/vista/imagenes/CasillaAvanceDinamico.png";
        this.dibujarCasilla();
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(false);
	}
}
