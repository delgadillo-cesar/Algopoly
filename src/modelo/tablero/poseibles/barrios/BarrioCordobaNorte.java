package modelo.tablero.poseibles.barrios;

import modelo.entidades.Banco;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.comprables.CordobaNorteComprable;
import modelo.tablero.poseibles.barrios.construcciones.Construccion;

public class BarrioCordobaNorte extends BarrioDoble {

	public BarrioCordobaNorte(Jugador propietario) {
		super(propietario);
	}
	

	@Override
	public void valoresDeTerreno(Construccion construccion) {
		construccion.costoCosntruccion(0);
		construccion.precioAlquiler(1300);	
	}

	@Override
	public void valoresDeUnaCasa(Construccion construccion) {
		construccion.costoCosntruccion(2200);
		construccion.precioAlquiler(1800);	
	}

	@Override
	public void valoresDeDosCasas(Construccion construccion) {
		construccion.costoCosntruccion(2200);
		construccion.precioAlquiler(2900);	
	}


	@Override
	public void valoresDeHotel(Construccion construccion) {
		construccion.costoCosntruccion(3500);
		construccion.precioAlquiler(3500);	
	}

	@Override
	public void valoresDeEdificioHistorico(Construccion construccion) {
		// TODO Auto-generated method stub
		
	}
	
	public void interactuarCon(Barrio otroBarrio){
		otroBarrio.interactuarConCordobaNorte(this);
	}
	
	public void interactuarConCordobaSur(Barrio otroBarrio){
		this.actualizarConstrucciones(otroBarrio);
	}
	
	@Override
	public void vender() {
		CordobaNorteComprable barrio = new CordobaNorteComprable();
		while(this.construido.sePuedeVender()){
			this.construido = this.construido.vender();
		}
		this.propietario.quitarBarrio(this);
		Banco.getInstance().pagarA(this.propietario, (int) (barrio.precioDeCompra() * 0.85));
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_CORDOBA_NORTE, barrio);
		this.chequearComplemento();
	}

}
