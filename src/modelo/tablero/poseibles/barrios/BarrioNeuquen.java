package modelo.tablero.poseibles.barrios;

import modelo.entidades.Banco;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.comprables.NeuquenComprable;
import modelo.tablero.poseibles.barrios.construcciones.Construccion;


public class BarrioNeuquen extends Barrio {

	public BarrioNeuquen(Jugador propietario) {
		super(propietario);
	}
	
	@Override
	public void valoresDeTerreno(Construccion construccion) {
		construccion.costoCosntruccion(0);
		construccion.precioAlquiler(1800);	
	}

	@Override
	public void valoresDeUnaCasa(Construccion construccion) {
		construccion.costoCosntruccion(4800);
		construccion.precioAlquiler(3800);	
	}

	@Override
	public void valoresDeDosCasas(Construccion construccion) {
	}

	@Override
	public void valoresDeHotel(Construccion construccion) {
	}

	@Override
	public void valoresDeEdificioHistorico(Construccion construccion) {
	}
	
	@Override
	public void vender() {
		NeuquenComprable barrio = new NeuquenComprable();
		while(this.construido.sePuedeVender()){
			this.construido = this.construido.vender();
		}
		this.propietario.quitarBarrio(this);
		Banco.getInstance().pagarA(this.propietario, (int) (barrio.precioDeCompra() * 0.85));
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_NEUQUEN, barrio);
	}

}
