package unitarios;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import modelo.entidades.Jugador;
import modelo.entidades.JugadorUno;
import modelo.juego.Dados;
import modelo.juego.Turno;

public class TurnoTest {

	@Test
	public void testCrearTurnoyNoDevuelveNull() {
		Jugador primerJugador = new JugadorUno("Rich Uncle");
		Jugador segundoJugador = new JugadorUno("Milburn Pennybags");
		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		Turno turno = Turno.inicializarTurno(jugadores);
		Assert.assertNotNull(turno);
	}

	@Test
	public void testCambiarTurnoyJugadorActualEsSegundoJugador() {
		Jugador primerJugador = new JugadorUno("Rich Uncle");
		Jugador segundoJugador = new JugadorUno("Milburn Pennybags");
		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		Turno turno = Turno.inicializarTurno(jugadores);
		do {
			Dados.getInstance().lanzarDados();
		} while (Dados.getInstance().salieronPares());
		Assert.assertEquals(segundoJugador, turno.cambiarTurno());
	}

	@Test
	public void testCambiarTurnoDosVecesyJugadorActualEsPrimerJugador() {
		Jugador primerJugador = new JugadorUno("Rich Uncle");
		Jugador segundoJugador = new JugadorUno("Milburn Pennybags");
		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		Turno turno = Turno.inicializarTurno(jugadores);
		do {
			Dados.getInstance().lanzarDados();
		} while (Dados.getInstance().salieronPares());
		turno.cambiarTurno();
		Assert.assertEquals(primerJugador, turno.cambiarTurno());
	}

	@Test
	public void testCambiarTurnoConDadosIgualesyJugadorActualEsPrimerJugador() {
		Jugador primerJugador = new JugadorUno("Rich Uncle");
		Jugador segundoJugador = new JugadorUno("Milburn Pennybags");
		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		Turno turno = Turno.inicializarTurno(jugadores);
		do {
			Dados.getInstance().lanzarDados();
		} while (!Dados.getInstance().salieronPares());
		Assert.assertEquals(primerJugador, turno.cambiarTurno());
	}

	@Test
	public void testCambiarTurnoConDadosIgualesDosVecesyJugadorActualEsSegundoJugador() {
		Jugador primerJugador = new JugadorUno("Rich Uncle");
		Jugador segundoJugador = new JugadorUno("Milburn Pennybags");
		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		Turno turno = Turno.inicializarTurno(jugadores);
		do {
			Dados.getInstance().lanzarDados();
		} while (!Dados.getInstance().salieronPares());
		turno.cambiarTurno();
		Assert.assertEquals(segundoJugador, turno.cambiarTurno());
	}
}
