package poseibles;

import entidades.Jugador;
import juego.Dados;

public class Subte implements Compania {

	private Jugador propietario;
	
	public Subte(Jugador propietario){
		this.propietario = propietario;
	}

	protected int cobrar() {
		int dados = Dados.getInstance().getValor();
		int veces = 600;
		
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
		return otraCompania.cobrarConSubte();
	}

	public int cobrarConAysa() {
		return 0;
	}

	public int cobrarConEdesur() {
		return 0;
	}

	public int cobrarConTren() {
		return 500;
	}

	public int cobrarConSubte() {
		return 0;
	}
}
