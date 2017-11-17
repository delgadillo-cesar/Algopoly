package unitarios;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import entidades.JugadorAbstracto;
import entidades.JugadorConcreto;
import juego.Dados;
import juego.Turno;

public class TurnoTest {

	@Test
	public void testCrearTurnoyNoDevuelveNull() {
		JugadorAbstracto primerJugador = new JugadorConcreto("Rich Uncle");
		JugadorAbstracto segundoJugador = new JugadorConcreto("Milburn Pennybags");
		LinkedList<JugadorAbstracto> jugadores = new LinkedList<JugadorAbstracto>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		Turno turno = new Turno(jugadores);
		Assert.assertNotNull(turno);
	}

	@Test
	public void testCambiarTurnoyJugadorActualEsSegundoJugador() {
		JugadorAbstracto primerJugador = new JugadorConcreto("Rich Uncle");
		JugadorAbstracto segundoJugador = new JugadorConcreto("Milburn Pennybags");
		LinkedList<JugadorAbstracto> jugadores = new LinkedList<JugadorAbstracto>();
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
		JugadorAbstracto primerJugador = new JugadorConcreto("Rich Uncle");
		JugadorAbstracto segundoJugador = new JugadorConcreto("Milburn Pennybags");
		LinkedList<JugadorAbstracto> jugadores = new LinkedList<JugadorAbstracto>();
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
		JugadorAbstracto primerJugador = new JugadorConcreto("Rich Uncle");
		JugadorAbstracto segundoJugador = new JugadorConcreto("Milburn Pennybags");
		LinkedList<JugadorAbstracto> jugadores = new LinkedList<JugadorAbstracto>();
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
		JugadorAbstracto primerJugador = new JugadorConcreto("Rich Uncle");
		JugadorAbstracto segundoJugador = new JugadorConcreto("Milburn Pennybags");
		LinkedList<JugadorAbstracto> jugadores = new LinkedList<JugadorAbstracto>();
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
