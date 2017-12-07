package modelo.tablero.poseibles.compania;

import modelo.entidades.Banco;
import modelo.entidades.Jugador;
import modelo.juego.Dados;
import modelo.tablero.Tablero;
import modelo.tablero.comprables.EdesurComprable;


public class Edesur implements Compania {

	private Jugador propietario;
	
	public Edesur(Jugador propietario){
		this.propietario = propietario;
		this.propietario.agregarCompania(this);
	}

	protected int cobrar() {
		int dados = Dados.getInstance().getValor();
		int veces = 500;
		
		for(Compania compania : this.propietario.obtenerCompanias()){
			veces += this.cobrarCon(compania);
		}
		
		return (dados * veces);
	}

	public Jugador propietario() {
		return this.propietario;
	}

	public void afectar(Jugador jugador) {
		jugador.pagarA(this.propietario, this.cobrar());
	}

	public int cobrarCon(Compania otraCompania) {
		return otraCompania.cobrarConEdesur();
	}

	public int cobrarConAysa() {
		return 200;
	}

	public int cobrarConEdesur() {
		return 0;
	}

	public int cobrarConTren() {
		return 0;
	}

	public int cobrarConSubte() {
		return 0;
	}
	
	@Override
	public void vender() {
		EdesurComprable edesur = new EdesurComprable();
		this.propietario.quitarCompania(this);
		Banco.getInstance().pagarA(this.propietario, (int) (edesur.precioDeCompra() * 0.85));
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_EDESUR, edesur);
	}

}
