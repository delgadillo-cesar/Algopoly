package unitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.entidades.Jugador;
import modelo.entidades.JugadorUno;
import modelo.tablero.acciones.Carcel;

public class CarcelTest {

	@Test
	public void testCrearCarcelyNoDevuelveNull() {
		Carcel carcel = new Carcel();
		Assert.assertNotNull(carcel);
	}

	@Test
	public void testEncarcelarJugadoryVerificarEncarcelamiento() {
		Jugador jugador = new JugadorUno("Rich Uncle-Milburn Pennybags");
		Carcel carcel = new Carcel();
		carcel.afectar(jugador);
		Assert.assertTrue(carcel.estaPreso(jugador));
	}

	@Test
	public void testCrearJugadoryVerificarQueNoEsteEncarcelado() {
		Jugador jugador = new JugadorUno("Rich Uncle-Milburn Pennybags");
		Carcel carcel = new Carcel();
		Assert.assertFalse(carcel.estaPreso(jugador));
	}

	@Test
	public void testEncarcelarJugadoryVerificarQueNoPuedaPagarFianza() {
		Jugador jugador = new JugadorUno("Rich Uncle-Milburn Pennybags");
		Carcel carcel = new Carcel();
		carcel.afectar(jugador);
		Assert.assertFalse(carcel.puedePagarFianza(jugador));
	}

	/*
	 * Cuando se ve si esta preso, se le quita un dia de sentencia al jugador. Esto
	 * equivale al paso de un turno en prision.
	 */
	@Test
	public void testEncarcelarJugadorVerSiEstaPresoyVerificarQueNoPuedaPagarFianza() {
		Jugador jugador = new JugadorUno("Rich Uncle-Milburn Pennybags");
		Carcel carcel = new Carcel();
		carcel.afectar(jugador);
		carcel.estaPreso(jugador);
		Assert.assertFalse(carcel.puedePagarFianza(jugador));
	}

	/*
	 * Cuando se ve si esta preso, se le quita un dia de sentencia al jugador. Esto
	 * equivale al paso de un turno en prision. Se revisa dos veces porque la fianza
	 * se puede pagar a partir del segundo dia.
	 */
	@Test
	public void testEncarcelarJugadorVerSiEstaPresoDosVecesyVerificarQuePuedaPagarFianza() {
		Jugador jugador = new JugadorUno("Rich Uncle-Milburn Pennybags");
		Carcel carcel = new Carcel();
		carcel.afectar(jugador);
		carcel.estaPreso(jugador);
		carcel.estaPreso(jugador);
		Assert.assertTrue(carcel.puedePagarFianza(jugador));
	}

	/*
	 * Cuando se ve si esta preso, se le quita un dia de sentencia al jugador. Esto
	 * equivale al paso de un turno en prision. Se revisa dos veces porque la fianza
	 * se puede pagar a partir del segundo dia.
	 */
	@Test
	public void testEncarcelarJugadorVerSiEstaPresoDosVecesPagarFianzayVerQueEsteLibre() {
		Jugador jugador = new JugadorUno("Rich Uncle-Milburn Pennybags");
		Carcel carcel = new Carcel();
		carcel.afectar(jugador);
		carcel.estaPreso(jugador);
		carcel.estaPreso(jugador);
		if (carcel.puedePagarFianza(jugador)) {
			carcel.pagarFianza(jugador);
		}
		Assert.assertFalse(carcel.estaPreso(jugador));
	}

	/*
	 * Cuando se ve si esta preso, se le quita un dia de sentencia al jugador. Esto
	 * equivale al paso de un turno en prision. Se revisa tres veces porque es la
	 * cantidad de turnos que el jugador debe estar preso.
	 */
	@Test
	public void testEncarcelarJugadorVerSiEstaPresoDosVecesyVerificarQueLaTerceraSigaPreso() {
		Jugador jugador = new JugadorUno("Rich Uncle-Milburn Pennybags");
		Carcel carcel = new Carcel();
		carcel.afectar(jugador);
		carcel.estaPreso(jugador);
		carcel.estaPreso(jugador);
		Assert.assertTrue(carcel.estaPreso(jugador));
	}

	/*
	 * Cuando se ve si esta preso, se le quita un dia de sentencia al jugador. Esto
	 * equivale al paso de un turno en prision. Se revisa tres veces porque es la
	 * cantidad de turnos de sentencia. Entonces al revisar por 4ta vez ya deberia
	 * estar libre.
	 */
	@Test
	public void testEncarcelarJugadorVerSiEstaPresoTresVecesyVerificarQueLaCuartaEsteLibre() {
		Jugador jugador = new JugadorUno("Rich Uncle-Milburn Pennybags");
		Carcel carcel = new Carcel();
		carcel.afectar(jugador);
		carcel.estaPreso(jugador);
		carcel.estaPreso(jugador);
		carcel.estaPreso(jugador);
		Assert.assertFalse(carcel.estaPreso(jugador));
	}
}
