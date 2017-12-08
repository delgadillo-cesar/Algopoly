package modelo.tablero.poseibles.barrios;

import modelo.entidades.Banco;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.comprables.CordobaSurComprable;
import modelo.tablero.poseibles.barrios.construcciones.Construccion;

public class BarrioCordobaSur extends BarrioDoble {

	public BarrioCordobaSur(Jugador propietario) {
		super(propietario);
	}
	

	@Override
	public void valoresDeTerreno(Construccion construccion) {
		construccion.costoConstruccion(0);
		construccion.precioAlquiler(1000);	
	}

	@Override
	public void valoresDeUnaCasa(Construccion construccion) {
		construccion.costoConstruccion(2000);
		construccion.precioAlquiler(1500);	
	}

	@Override
	public void valoresDeDosCasas(Construccion construccion) {
		construccion.costoConstruccion(2000);
		construccion.precioAlquiler(2500);	
	}


	@Override
	public void valoresDeHotel(Construccion construccion) {
		construccion.costoConstruccion(3000);
		construccion.precioAlquiler(3000);	
	}

	@Override
	public void valoresDeEdificioHistorico(Construccion construccion) {
		// TODO Auto-generated method stub
		
	}
	
	public void interactuarCon(Barrio otroBarrio){
		otroBarrio.interactuarConCordobaSur(this);
	}
	
	public void interactuarConCordobaNorte(Barrio otroBarrio){
		this.actualizarConstrucciones(otroBarrio);
	}
	
	@Override
	public void vender() {
		CordobaSurComprable barrio = new CordobaSurComprable();
		while(this.construido.sePuedeVender()){
			this.construido = this.construido.vender();
		}
		this.propietario.quitarBarrio(this);
		Banco.getInstance().pagarA(this.propietario, (int) (barrio.precioDeCompra() * 0.85));
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_CORDOBA_SUR, barrio);
		this.chequearComplemento();
	}

}