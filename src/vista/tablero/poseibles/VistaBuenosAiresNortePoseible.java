package vista.tablero.poseibles;

import controlador.poseibles.OpcionesBarrioPoseibleHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.barrios.BarrioBuenosAiresNorte;
import vista.tablero.VistaCasilla;
import javafx.scene.image.Image;

public class VistaBuenosAiresNortePoseible extends VistaCasilla {

	private BarrioBuenosAiresNorte bueNor;
	
	public VistaBuenosAiresNortePoseible(){
		this.bueNor = (BarrioBuenosAiresNorte) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_BUENOS_AIRES_NORTE);

		this.stringImagen = "file:src/vista/imagenes/CasillaBuenosAiresNorte.png";
        this.dibujarCasilla();

        OpcionesBarrioPoseibleHandler opcionesBarrioPoseibleHandler = new OpcionesBarrioPoseibleHandler(imagen, bueNor);
		this.setOnMouseClicked(opcionesBarrioPoseibleHandler);
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(!(bueNor.propietario() == unJugador));
	}
}
