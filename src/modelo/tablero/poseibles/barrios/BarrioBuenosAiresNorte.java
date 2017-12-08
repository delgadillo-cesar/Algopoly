package modelo.tablero.poseibles.barrios;

import modelo.entidades.Banco;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.comprables.BuenosAiresNorteComprable;
import modelo.tablero.poseibles.barrios.construcciones.Construccion;

public class BarrioBuenosAiresNorte extends BarrioDoble {

	public BarrioBuenosAiresNorte(Jugador propietario) {
		super(propietario);
	}

	@Override
	public void valoresDeTerreno(Construccion construccion) {
		construccion.costoConstruccion(0);
		construccion.precioAlquiler(2500);	
	}

	@Override
	public void valoresDeUnaCasa(Construccion construccion) {
		construccion.costoConstruccion(5500);
		construccion.precioAlquiler(3500);	
	}

	@Override
	public void valoresDeDosCasas(Construccion construccion) {
		construccion.costoConstruccion(5500);
		construccion.precioAlquiler(4000);	
	}


	@Override
	public void valoresDeHotel(Construccion construccion) {
		construccion.costoConstruccion(9000);
		construccion.precioAlquiler(6000);	
	}

	@Override
	public void valoresDeEdificioHistorico(Construccion construccion) {
		// TODO Auto-generated method stub
		
	}
	
	public void interactuarCon(Barrio otroBarrio){
		otroBarrio.interactuarConBuenosAiresNorte(this);
	}
	
	public void interactuarConBuenosAiresSur(Barrio otroBarrio){
		this.actualizarConstrucciones(otroBarrio);
	}
	
	@Override
	public void vender() {
		BuenosAiresNorteComprable barrio = new BuenosAiresNorteComprable();
		while(this.construido.sePuedeVender()){
			this.construido = this.construido.vender();
		}
		this.propietario.quitarBarrio(this);
		Banco.getInstance().pagarA(this.propietario, (int) (barrio.precioDeCompra() * 0.85));
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_BUENOS_AIRES_NORTE, barrio);
		this.chequearComplemento();
	}
}
