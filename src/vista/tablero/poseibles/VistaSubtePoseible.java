package vista.tablero.poseibles;

import controlador.poseibles.OpcionesCompaniaPoseibleHandler;
import javafx.scene.image.Image;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.Subte;
import vista.tablero.VistaCasilla;

public class VistaSubtePoseible  extends VistaCasilla {

	private Subte subte;
	
	public VistaSubtePoseible(){
		this.subte = (Subte) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_SUBTE);

		this.stringImagen = "file:src/vista/imagenes/CasillaSubte.png";
        this.dibujarCasilla();

        OpcionesCompaniaPoseibleHandler opcionesCompaniaPoseibleHandler = new OpcionesCompaniaPoseibleHandler(imagen, subte);
		this.setOnMouseClicked(opcionesCompaniaPoseibleHandler);
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(!(subte.propietario() == unJugador));
	}
}
