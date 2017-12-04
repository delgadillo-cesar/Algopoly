package vista.tablero.poseibles;

import controlador.poseibles.OpcionesBarrioPoseibleHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.barrios.BarrioSantaFe;
import vista.tablero.VistaCasilla;
import javafx.scene.image.Image;

public class VistaSantaFePoseible extends VistaCasilla {

	private BarrioSantaFe santaFe;
	
	public VistaSantaFePoseible(){
		this.santaFe = (BarrioSantaFe) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_SANTA_FE);

		this.stringImagen = "file:src/vista/imagenes/CasillaSantaFe.png";
        this.dibujarCasilla();

        OpcionesBarrioPoseibleHandler opcionesBarrioPoseibleHandler = new OpcionesBarrioPoseibleHandler(imagen, santaFe);
		this.setOnMouseClicked(opcionesBarrioPoseibleHandler);
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(!(santaFe.propietario() == unJugador));
	}
}
