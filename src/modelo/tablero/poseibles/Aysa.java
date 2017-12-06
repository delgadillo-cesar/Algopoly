package modelo.tablero.poseibles;

import modelo.entidades.Banco;
import modelo.entidades.Jugador;
import modelo.juego.Dados;
import modelo.tablero.Tablero;
import modelo.tablero.comprables.AysaComprable;

public class Aysa implements Compania {

	private Jugador propietario;

	public Aysa(Jugador propietario) {
		this.propietario = propietario;
		this.propietario.agregarCompania(this);
	}

	protected int cobrar() {
		int dados = Dados.getInstance().getValor();
		int veces = 300;

		for (Compania compania : this.propietario.obtenerCompanias()) {
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
		return otraCompania.cobrarConAysa();
	}

	public int cobrarConAysa() {
		return 0;
	}

	public int cobrarConEdesur() {
		return 500;
	}

	public int cobrarConTren() {
		return 0;
	}

	public int cobrarConSubte() {
		return 0;
	}

	@Override
	public void vender() {
		AysaComprable aysa = new AysaComprable();
		this.propietario.quitarCompania(this);
		Banco.getInstance().pagarA(this.propietario, (int) (aysa.precioDeCompra() * 0.85));
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_AYSA, aysa);
	}
}
