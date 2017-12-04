package vista.tablero.acciones;

import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.acciones.RetrocesoDinamico;
import vista.tablero.VistaCasilla;
import javafx.scene.image.Image;

public class VistaRetrocesoDinamico extends VistaCasilla {

	private RetrocesoDinamico retrocesoDinamico;
	
	public VistaRetrocesoDinamico(){
		this.retrocesoDinamico = new RetrocesoDinamico();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_RETROCESO_DINAMICO, this.retrocesoDinamico);

		this.stringImagen = "file:src/vista/imagenes/CasillaRetrocesoDinamico.png";
        this.dibujarCasilla();
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(false);
	}
}
