package modelo.tablero.poseibles.barrios;

import modelo.entidades.Banco;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.comprables.BuenosAiresSurComprable;
import modelo.tablero.poseibles.barrios.construcciones.Construccion;

public class BarrioBuenosAiresSur extends BarrioDoble {

	public BarrioBuenosAiresSur(Jugador propietario) {
		super(propietario);
	}

	@Override
	public void valoresDeTerreno(Construccion construccion) {
		construccion.costoCosntruccion(0);
		construccion.precioAlquiler(2500);	
	}

	@Override
	public void valoresDeUnaCasa(Construccion construccion) {
		construccion.costoCosntruccion(5500);
		construccion.precioAlquiler(3500);	
	}

	@Override
	public void valoresDeDosCasas(Construccion construccion) {
		construccion.costoCosntruccion(5500);
		construccion.precioAlquiler(4000);	
	}


	@Override
	public void valoresDeHotel(Construccion construccion) {
		construccion.costoCosntruccion(9000);
		construccion.precioAlquiler(6000);	
	}

	@Override
	public void valoresDeEdificioHistorico(Construccion construccion) {
		// TODO Auto-generated method stub
		
	}
	
	public void interactuarCon(Barrio otroBarrio){
		otroBarrio.interactuarConBuenosAiresSur(this);
	}
	
	public void interactuarConBuenosAiresNorte(Barrio otroBarrio){
		this.actualizarConstrucciones(otroBarrio);
	}
	
	@Override
	public void vender() {
		BuenosAiresSurComprable barrio = new BuenosAiresSurComprable();
		while(this.construido.sePuedeVender()){
			this.construido = this.construido.vender();
		}
		this.propietario.quitarBarrio(this);
		Banco.getInstance().pagarA(this.propietario, (int) (barrio.precioDeCompra() * 0.85));
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_BUENOS_AIRES_SUR, barrio);
		this.chequearComplemento();
	}

}
