package modelo.tablero.poseibles.barrios;

import modelo.entidades.Banco;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.comprables.SantaFeComprable;
import modelo.tablero.poseibles.barrios.construcciones.Construccion;


public class BarrioSantaFe extends Barrio {

	public BarrioSantaFe(Jugador propietario) {
		super(propietario);
	}

	@Override
	public void valoresDeTerreno(Construccion construccion) {
		construccion.costoConstruccion(0);
		construccion.precioAlquiler(1500);	
	}

	@Override
	public void valoresDeUnaCasa(Construccion construccion) {
		construccion.costoConstruccion(4000);
		construccion.precioAlquiler(3500);	
	}

	@Override
	public void valoresDeDosCasas(Construccion construccion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valoresDeHotel(Construccion construccion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valoresDeEdificioHistorico(Construccion construccion) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void vender() {
		SantaFeComprable barrio = new SantaFeComprable();
		while(this.construido.sePuedeVender()){
			this.construido = this.construido.vender();
		}
		this.propietario.quitarBarrio(this);
		Banco.getInstance().pagarA(this.propietario, (int) (barrio.precioDeCompra() * 0.85));
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SANTA_FE, barrio);
	}
}
