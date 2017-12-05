package modelo.tablero.poseibles;

import modelo.entidades.Jugador;
import modelo.juego.Dados;

public class Tren implements Compania {

	private Jugador propietario;
	
	public Tren(Jugador propietario){
		this.propietario = propietario;
		this.propietario.agregarCompania(this);
	}

	protected int cobrar() {
		int dados = Dados.getInstance().getValor();
		int veces = 450;
		
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
		return otraCompania.cobrarConTren();
	}

	public int cobrarConAysa() {
		return 0;
	}

	public int cobrarConEdesur() {
		return 0;
	}

	public int cobrarConTren() {
		return 0;
	}

	public int cobrarConSubte() {
		return 500;
	}
}
