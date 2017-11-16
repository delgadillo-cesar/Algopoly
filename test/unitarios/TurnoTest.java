package unitarios;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import entidades.Jugador;
import entidades.JugadorConcreto;
import juego.Dados;
import juego.Turno;

public class TurnoTest {

	@Test
	public void testCrearTurnoyNoDevuelveNull() {
		Jugador primerJugador = new JugadorConcreto("Rich Uncle");
		Jugador segundoJugador = new JugadorConcreto("Milburn Pennybags");
		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		Turno turno = new Turno(jugadores);
		Assert.assertNotNull(turno);
	}

	@Test
	public void testCambiarTurnoyJugadorActualEsSegundoJugador() {
		Jugador primerJugador = new JugadorConcreto("Rich Uncle");
		Jugador segundoJugador = new JugadorConcreto("Milburn Pennybags");
		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		Turno turno = new Turno(jugadores);
		do {
			Dados.getInstance().lanzarDados();
		} while (Dados.getInstance().salieronPares());
		Assert.assertEquals(segundoJugador, turno.cambiarTurno());
	}

	@Test
	public void testCambiarTurnoConDadosIgualesyJugadorActualEsPrimerJugador() {
		Jugador primerJugador = new JugadorConcreto("Rich Uncle");
		Jugador segundoJugador = new JugadorConcreto("Milburn Pennybags");
		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		Turno turno = new Turno(jugadores);
		do {
			Dados.getInstance().lanzarDados();
		} while (!Dados.getInstance().salieronPares());
		Assert.assertEquals(primerJugador, turno.cambiarTurno());
	}

	@Test
	public void testCambiarTurnoConDadosIgualesDosVecesyJugadorActualEsSegundoJugador() {
		Jugador primerJugador = new JugadorConcreto("Rich Uncle");
		Jugador segundoJugador = new JugadorConcreto("Milburn Pennybags");
		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		Turno turno = new Turno(jugadores);
		do {
			Dados.getInstance().lanzarDados();
		} while (!Dados.getInstance().salieronPares());
		turno.cambiarTurno();
		Assert.assertEquals(segundoJugador, turno.cambiarTurno());
	}
}
