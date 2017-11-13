package entrega1;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import acciones.Carcel;
import entidades.Jugador;
import entidades.JugadorConcreto;
import juego.Turno;
import tablero.Casilla;

public class InteraccionCarcelTest {

	@Test
	public void testLuegoDeCaerEnLaCarcelElJugadorNoPuedeDesplazarse() {

		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(new JugadorConcreto("Juan"));
		jugadores.add(new JugadorConcreto("Pepe"));
		jugadores.add(new JugadorConcreto("Luis"));
		Turno turno = new Turno(jugadores);
		Casilla carcel = new Carcel();

		carcel.afectar(jugadores.get(0));

		Jugador jugadorSiguiente = turno.cambiarTurno();
		Assert.assertEquals(jugadorSiguiente, jugadores.get(1));

	}

	@Test
	public void testJugadorEncarceladoPuedePagarFianzaYAlPagarlaPuedeMoverse() {

		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(new JugadorConcreto("Juan"));
		jugadores.add(new JugadorConcreto("Pepe"));
		jugadores.add(new JugadorConcreto("Luis"));
		Turno turno = new Turno(jugadores);
		Casilla carcel = new Carcel();

		carcel.afectar(jugadores.get(0));
		carcel.pagarFianza(jugadores.get(0));

		Jugador jugadorSiguiente = turno.cambiarTurno();
		Assert.assertEquals(jugadorSiguiente, jugadores.get(1));

	}

	@Test
	public void testJugadorEncarceladoNoPuedePagarFianzaPorFaltaDeCapitalEntoncesNoPuedeMoverse() {

		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(new JugadorConcreto("Juan"));
		jugadores.add(new JugadorConcreto("Pepe"));
		jugadores.add(new JugadorConcreto("Luis"));
		Turno turno = new Turno(jugadores);
		Casilla carcel = new Carcel();

		carcel.afectar(jugadores.get(0));
		carcel.pagarFianza(jugadores.get(0));

		Jugador jugadorSiguiente = turno.cambiarTurno();
		Assert.assertEquals(jugadorSiguiente, jugadores.get(1));

	}

}
