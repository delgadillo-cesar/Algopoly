package acciones;

import java.util.HashMap;

import entidades.Banco;
import entidades.Jugador;
import entidades.MovimientoEncarcelado;
import tablero.Casilla;


public class Carcel implements Casilla {

	private HashMap<Jugador, Integer> diasRestantes;
	private final Integer sentencia = Integer.valueOf(3);
	private final Integer diasSinFianza = Integer.valueOf(1);
	private final Integer fianza = Integer.valueOf(45000);

	public Carcel() {
		this.diasRestantes = new HashMap<Jugador, Integer>();
	}

	public void encarcelar(Jugador unJugador) {
		this.diasRestantes.put(unJugador, this.sentencia);
		unJugador.cambiarTipoDeMovimiento(new MovimientoEncarcelado());
	}

	private void revizarCondena(Jugador unJugador) {
		if (diasRestantes.containsKey(unJugador)) {
			Integer condenaRestante = diasRestantes.get(unJugador);

			diasRestantes.remove(unJugador);
			if (condenaRestante > 0)
				diasRestantes.put(unJugador, --condenaRestante);
		}
	}

	public boolean estaPreso(Jugador unJugador) {
		this.revizarCondena(unJugador);

		return (diasRestantes.containsKey(unJugador));
	}

	public boolean puedePagarFianza(Jugador unJugador) {
		Boolean fianzaDisponible = false;

		if (diasRestantes.containsKey(unJugador)) {
			Integer condenaRestante = diasRestantes.get(unJugador);
			if (condenaRestante < sentencia - diasSinFianza)
				fianzaDisponible = true;
		}

		return fianzaDisponible;
	}

	public void pagarFianza(Jugador unJugador) {
		unJugador.pagarA(Banco.getInstance(),this.fianza);
		diasRestantes.remove(unJugador);
	}

	
	public void afectar(Jugador jugador) {
		this.encarcelar(jugador);
	}

}
