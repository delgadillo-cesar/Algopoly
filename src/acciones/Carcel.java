package acciones;

import java.util.HashMap;

import entidades.Jugador;
import entidades.JugadorConcreto;

public class Carcel extends Accion {

	private HashMap<Jugador, Integer> diasRestantes;
	private final Integer sentencia = Integer.valueOf(3);

	public Carcel() {
		this.diasRestantes = new HashMap<Jugador, Integer>();
	}

	public void pagarFianza(Jugador jugador) {
		// falta implementar
	}

	@Override
	public void afectar(Jugador jugador) {
		if (this.diasRestantes.get(jugador) == null) {
			this.diasRestantes.put(jugador, this.sentencia);
		} else {
			this.diasRestantes.put(jugador, this.diasRestantes.get(jugador) - 1);
			this.diasRestantes.remove(jugador, Integer.valueOf(0));
		}

	}

	@Override
	public Jugador propietario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int numeroDeCasillerosAAvanzar(JugadorConcreto jugador, int numero) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numeroDeCasillerosARetroceder(JugadorConcreto jugador, int numero) {
		// TODO Auto-generated method stub
		return 0;
	}

}
