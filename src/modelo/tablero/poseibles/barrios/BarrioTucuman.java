package modelo.tablero.poseibles.barrios;

import modelo.entidades.Banco;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.comprables.TucumanComprable;
import modelo.tablero.poseibles.barrios.construcciones.Construccion;
import modelo.tablero.poseibles.barrios.construcciones.Edificio;
import modelo.tablero.poseibles.barrios.construcciones.NadaParaConstruirException;


public class BarrioTucuman  extends Barrio {

	public BarrioTucuman(Jugador propietario) {
		super(propietario);
	}
	
	public void construir() throws NadaParaConstruirException{
		this.construido = this.construido.construirEnBarrioHistorico(this);
	}
	
	public int costoConstruccion() throws NadaParaConstruirException{
		return this.construido.costoConstruirEnBarrioHistorico(this);
	}

	@Override
	public void valoresDeTerreno(Construccion construccion) {
		construccion.costoCosntruccion(0);
		construccion.precioAlquiler(1800);	
	}

	@Override
	public void valoresDeUnaCasa(Construccion construccion) {
		// TODO Auto-generated method stub
		
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
		construccion.costoCosntruccion(7000);
		construccion.precioAlquiler(4500);
		((Edificio) construccion).nombreEdificioHistorico("la casita de Tucumán");
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
