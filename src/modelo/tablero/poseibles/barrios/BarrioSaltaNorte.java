package modelo.tablero.poseibles.barrios;

import modelo.entidades.Banco;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.comprables.SaltaNorteComprable;
import modelo.tablero.poseibles.barrios.construcciones.Construccion;

public class BarrioSaltaNorte extends BarrioDoble {

	public BarrioSaltaNorte(Jugador propietario) {
		super(propietario);
	}
	

	@Override
	public void valoresDeTerreno(Construccion construccion) {
		construccion.costoConstruccion(0);
		construccion.precioAlquiler(2000);	
	}

	@Override
	public void valoresDeUnaCasa(Construccion construccion) {
		construccion.costoConstruccion(4500);
		construccion.precioAlquiler(3250);	
	}

	@Override
	public void valoresDeDosCasas(Construccion construccion) {
		construccion.costoConstruccion(4500);
		construccion.precioAlquiler(3850);	
	}


	@Override
	public void valoresDeHotel(Construccion construccion) {
		construccion.costoConstruccion(7500);
		construccion.precioAlquiler(5500);	
	}

	@Override
	public void valoresDeEdificioHistorico(Construccion construccion) {
		// TODO Auto-generated method stub
		
	}
	
	public void interactuarCon(Barrio otroBarrio){
		otroBarrio.interactuarConSaltaNorte(this);
	}
	
	public void interactuarConSaltaSur(Barrio otroBarrio){
		this.actualizarConstrucciones(otroBarrio);
	}
	
	@Override
	public void vender() {
		SaltaNorteComprable barrio = new SaltaNorteComprable();
		while(this.construido.sePuedeVender()){
			this.construido = this.construido.vender();
		}
		this.propietario.quitarBarrio(this);
		Banco.getInstance().pagarA(this.propietario, (int) (barrio.precioDeCompra() * 0.85));
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SALTA_NORTE, barrio);
		this.chequearComplemento();
	}

}
