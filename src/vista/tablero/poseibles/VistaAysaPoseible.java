package vista.tablero.poseibles;

import controlador.poseibles.OpcionesCompaniaPoseibleHandler;
import vista.tablero.VistaCasilla;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.Aysa;
import javafx.scene.image.Image;

public class VistaAysaPoseible extends VistaCasilla {

	private Aysa aysa;
	
	public VistaAysaPoseible(){
		this.aysa = (Aysa) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_AYSA);

		this.stringImagen = "file:src/vista/imagenes/CasillaAysa.png";
        this.dibujarCasilla();

        OpcionesCompaniaPoseibleHandler opcionesCompaniaPoseibleHandler = new OpcionesCompaniaPoseibleHandler(imagen, aysa);
		this.setOnMouseClicked(opcionesCompaniaPoseibleHandler);
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(!(aysa.propietario() == unJugador));
	}
}
