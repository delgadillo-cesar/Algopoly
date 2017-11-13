package acciones;

import java.util.HashMap;

import entidades.Jugador;

public class Carcel extends Accion {

	private HashMap<Jugador, Integer> diasRestantes;
	private final Integer sentencia = Integer.valueOf(3);
	private final Integer diasSinFianza = Integer.valueOf(1);
	private final Integer fianza = Integer.valueOf(45000);
	

	public Carcel() {
		this.diasRestantes = new HashMap<Jugador, Integer>();
	}

	
	public void encarcelar(Jugador unJugador){
		this.diasRestantes.put(unJugador, this.sentencia);
	}
	
	
	private void revizarCondena(Jugador unJugador){
		if (diasRestantes.containsKey(unJugador)){
			Integer condenaRestante = diasRestantes.get(unJugador);
			
			diasRestantes.remove(unJugador);
			if (condenaRestante > 0) diasRestantes.put(unJugador, condenaRestante--);
		}
	}
	

	public boolean estaPreso(Jugador unJugador){
		this.revizarCondena(unJugador);
		
		return (diasRestantes.containsKey(unJugador));
	}
	
	
	public boolean puedePagarFianza(Jugador unJugador){
		Boolean fianzaDisponible = false;
		
		if (diasRestantes.containsKey(unJugador)){
			Integer condenaRestante = diasRestantes.get(unJugador);
			if (condenaRestante <= sentencia- diasSinFianza) fianzaDisponible = true;
		}
		
		return fianzaDisponible;
	}

	
	public void pagarFianza(Jugador unJugador){
		unJugador.pagar(this.fianza);
		diasRestantes.remove(unJugador);		
	}
	
	
	@Override
	public void afectar(Jugador jugador) {
		this.encarcelar(jugador);

/*
		if (this.diasRestantes.get(jugador) == null) {
			this.diasRestantes.put(jugador, this.sentencia);
		} else {
			this.diasRestantes.put(jugador, this.diasRestantes.get(jugador) - 1);
			this.diasRestantes.remove(jugador, Integer.valueOf(0));
		}
*/
	}

}
