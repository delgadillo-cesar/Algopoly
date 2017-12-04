package vista.tablero.poseibles;

import controlador.poseibles.OpcionesBarrioPoseibleHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.barrios.BarrioCordobaNorte;
import vista.tablero.VistaCasilla;
import javafx.scene.image.Image;

public class VistaCordobaNortePoseible extends VistaCasilla {

	private BarrioCordobaNorte cordNorte;
	
	public VistaCordobaNortePoseible(){
		this.cordNorte = (BarrioCordobaNorte) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_CORDOBA_NORTE);

		this.stringImagen = "file:src/vista/imagenes/CasillaCordobaNorte.png";
        this.dibujarCasilla();

        OpcionesBarrioPoseibleHandler opcionesBarrioPoseibleHandler = new OpcionesBarrioPoseibleHandler(imagen, cordNorte);
		this.setOnMouseClicked(opcionesBarrioPoseibleHandler);
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(!(cordNorte.propietario() == unJugador));
	}

}
