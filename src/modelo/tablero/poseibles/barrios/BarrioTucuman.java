package modelo.tablero.poseibles.barrios;

import modelo.entidades.Banco;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.comprables.TucumanComprable;
import modelo.tablero.poseibles.barrios.construcciones.Construible;
import modelo.tablero.poseibles.barrios.construcciones.EdificioHistoricoConstruible;
import modelo.tablero.poseibles.barrios.construcciones.SoloCasa;


public class BarrioTucuman  extends Barrio {

	public BarrioTucuman(Jugador propietario) {
		super(propietario);

		this.construcciones = new SoloCasa();
	}
	
	@Override
	public void valoresDeTerreno(Construible unConstruible) {
		unConstruible.costoCosntruccion(0);
		unConstruible.precioAlquiler(1800);	
	}

	@Override
	public void valoresDeUnaCasa(Construible unConstruible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valoresDeDosCasas(Construible unConstruible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valoresDeHotel(Construible unConstruible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valoresDeEdificioHistorico(Construible unConstruible) {
		unConstruible.costoCosntruccion(7000);
		unConstruible.precioAlquiler(4500);
		((EdificioHistoricoConstruible) unConstruible).nombreEdificioHistorico("la casita de Tucumán");
	}
	
	@Override
	public void vender() {
		TucumanComprable barrio = new TucumanComprable();
		while(this.construido.sePuedeVender()){
			this.construido = this.construido.vender();
		}
		this.propietario.quitarBarrio(this);
		Banco.getInstance().pagarA(this.propietario, (int) (barrio.precioDeCompra() * 0.85));
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_TUCUMAN, barrio);
	}
}
