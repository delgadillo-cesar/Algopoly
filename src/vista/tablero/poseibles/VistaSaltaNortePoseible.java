package vista.tablero.poseibles;

import controlador.poseibles.OpcionesBarrioPoseibleHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.barrios.BarrioSaltaNorte;
import vista.tablero.VistaCasilla;
import javafx.scene.image.Image;

public class VistaSaltaNortePoseible extends VistaCasilla {

	private BarrioSaltaNorte saltaNorte;
	
	public VistaSaltaNortePoseible(){
		this.saltaNorte = (BarrioSaltaNorte) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_SALTA_NORTE);

		this.stringImagen = "file:src/vista/imagenes/CasillaSaltaNorte.png";
        this.dibujarCasilla();

        OpcionesBarrioPoseibleHandler opcionesBarrioPoseibleHandler = new OpcionesBarrioPoseibleHandler(imagen, saltaNorte);
		this.setOnMouseClicked(opcionesBarrioPoseibleHandler);
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(!(saltaNorte.propietario() == unJugador));
	}

}
