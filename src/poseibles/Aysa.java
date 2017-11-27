package poseibles;

import entidades.Jugador;
import tablero.*;
import juego.Dados;

public class Aysa implements Compania {

	private Jugador propietario;
	
	public Aysa(Jugador propietario){
		this.propietario = propietario;
	}

	protected int cobrar() {
		int dados = Dados.getInstance().getValor();
		int veces = 300;
		
		for(Compania compania : this.propietario.obtenerCompanias()){
			veces += this.cobrarCon(compania);
		}
		
		return (dados * veces);
	}

	public Jugador propietario() {
		return this.propietario;
	}

	public void afectar(Jugador jugador) {
		this.propietario.cobrar(jugador.pagar(this.cobrar()));
	}

	public int cobrarCon(Compania otraCompania) {
		return otraCompania.cobrarConAysa();
	}

	public int cobrarConAysa() {
		return 0;
	}

	public int cobrarConEdesur() {
		return 200;
	}

	public int cobrarConTren() {
		return 0;
	}

	public int cobrarConSubte() {
		return 0;
	}
}
