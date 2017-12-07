package modelo.tablero.poseibles.barrios;

import modelo.entidades.Banco;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.comprables.SaltaSurComprable;
import modelo.tablero.poseibles.barrios.construcciones.Construccion;

public class BarrioSaltaSur extends BarrioDoble {

	public BarrioSaltaSur(Jugador propietario) {
		super(propietario);
	}
	

	@Override
	public void valoresDeTerreno(Construccion construccion) {
		construccion.costoCosntruccion(0);
		construccion.precioAlquiler(2000);	
	}

	@Override
	public void valoresDeUnaCasa(Construccion construccion) {
		construccion.costoCosntruccion(4500);
		construccion.precioAlquiler(3250);	
	}

	@Override
	public void valoresDeDosCasas(Construccion construccion) {
		construccion.costoCosntruccion(4500);
		construccion.precioAlquiler(3850);	
	}


	@Override
	public void valoresDeHotel(Construccion construccion) {
		construccion.costoCosntruccion(7500);
		construccion.precioAlquiler(5500);	
	}

	@Override
	public void valoresDeEdificioHistorico(Construccion construccion) {
		// TODO Auto-generated method stub
		
	}
	
	public void interactuarCon(Barrio otroBarrio){
		otroBarrio.interactuarConSaltaSur(this);
	}
	
	public void interactuarConSaltaNorte(Barrio otroBarrio){
		this.actualizarConstrucciones(otroBarrio);
	}
	
	@Override
	public void vender() {
		SaltaSurComprable barrio = new SaltaSurComprable();
		while(this.construido.sePuedeVender()){
			this.construido = this.construido.vender();
		}
		this.propietario.quitarBarrio(this);
		Banco.getInstance().pagarA(this.propietario, (int) (barrio.precioDeCompra() * 0.85));
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SALTA_SUR, barrio);
		this.chequearComplemento();
	}

}
