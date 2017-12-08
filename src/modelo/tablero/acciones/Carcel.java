package modelo.tablero.acciones;

import java.util.HashMap;

import modelo.entidades.*;
import modelo.tablero.Casilla;



public class Carcel implements Casilla {

	private HashMap<Jugador, Condena> condenados;
	private HashMap<Condena, Condena> cicloDeCondenas;
	private final int fianza = 45000;
	Condena turnoActual;
	Condena primerTurno;
	Condena segundoTurno;
	Condena tercerTurno;
	Condena libre;

	public Carcel() {
		
		cicloDeCondenas = new HashMap <Condena, Condena> ();
		condenados = new HashMap <Jugador, Condena> ();
		
		turnoActual = new CondenaRealSinFianza(0);
		primerTurno = new CondenaRealSinFianza(1);
		segundoTurno = new CondenaRealConFianza(2);
		tercerTurno = new CondenaRealConFianza(3);
		libre = new NoCondena(4);
		
		cicloDeCondenas.put(turnoActual, primerTurno);
		cicloDeCondenas.put(primerTurno, segundoTurno);
		cicloDeCondenas.put(segundoTurno, tercerTurno);
		cicloDeCondenas.put(tercerTurno, libre);
		cicloDeCondenas.put(libre, libre);
	}

	public void encarcelar(Jugador unJugador) {		
		
		condenados.put(unJugador, turnoActual);
		primerTurno.afectarJugador(unJugador);
	}

	public void revisarCondena(Jugador unJugador) {
		
		if (!condenados.containsKey(unJugador)) return;
		
		Condena siguiente = cicloDeCondenas.get(condenados.get(unJugador));
		condenados.put(unJugador, siguiente);
		siguiente.afectarJugador(unJugador);
		
	}

	public boolean estaPreso(Jugador unJugador) {
		
		Condena condena = condenados.get(unJugador);
		return (condena != libre) && (condena != null);
	}

	public boolean puedePagarFianza(Jugador unJugador) {
		
		return condenados.get(unJugador).fianzaDisponible();
	}

	public void pagarFianzaDeJugador(Jugador unJugador) {
		
		Condena condena = condenados.get(unJugador);
		condena.pagarFianzaDeJugadorEnCarcel(unJugador, this);
		
	}

	
	public void afectar(Jugador jugador) {
		this.encarcelar(jugador);
	}

	public void liberar(Jugador unJugador) {
		
		unJugador.pagarA(Banco.getInstance(),this.fianza);
		condenados.remove(unJugador);
		libre.afectarJugador(unJugador);
	}

}
