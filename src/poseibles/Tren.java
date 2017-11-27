package poseibles;

import entidades.Jugador;
import juego.Dados;

public class Tren implements Compania {

	private Jugador propietario;
	
	public Tren(Jugador propietario){
		this.propietario = propietario;
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
		return 350;
	}
}
