package unitarios;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import entidades.Jugador;
import juego.Dados;
import juego.Turno;

public class TurnoTest {

	@Test
	public void testCrearTurnoyNoDevuelveNull() {
		Jugador primerJugador = new Jugador("Rich Uncle");
		Jugador segundoJugador = new Jugador("Milburn Pennybags");
		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		Turno turno = new Turno(jugadores);
		Assert.assertNotNull(turno);
	}

	@Test
	public void testCambiarTurnoyJugadorActualEsSegundoJugador() {
		Jugador primerJugador = new Jugador("Rich Uncle");
		Jugador segundoJugador = new Jugador("Milburn Pennybags");
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
	public void testCambiarTurnoDosVecesyJugadorActualEsPrimerJugador() {
		Jugador primerJugador = new Jugador("Rich Uncle");
		Jugador segundoJugador = new Jugador("Milburn Pennybags");
		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		Turno turno = new Turno(jugadores);
		do {
			Dados.getInstance().lanzarDados();
		} while (Dados.getInstance().salieronPares());
		turno.cambiarTurno();
		Assert.assertEquals(primerJugador, turno.cambiarTurno());
	}

	@Test
	public void testCambiarTurnoConDadosIgualesyJugadorActualEsPrimerJugador() {
		Jugador primerJugador = new Jugador("Rich Uncle");
		Jugador segundoJugador = new Jugador("Milburn Pennybags");
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
		Jugador primerJugador = new Jugador("Rich Uncle");
		Jugador segundoJugador = new Jugador("Milburn Pennybags");
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
