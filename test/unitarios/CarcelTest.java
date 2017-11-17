package unitarios;

import org.junit.Assert;
import org.junit.Test;

import acciones.Carcel;
import entidades.Jugador;

public class CarcelTest {

	@Test
	public void testCrearCarcelyNoDevuelveNull() {
		Carcel carcel = new Carcel();
		Assert.assertNotNull(carcel);
	}

	@Test
	public void testEncarcelarJugadoryVerificarEncarcelamiento() {
		Jugador jugador = new Jugador("Rich Uncle-Milburn Pennybags");
		Carcel carcel = new Carcel();
		carcel.afectar(jugador);
		Assert.assertTrue(carcel.estaPreso(jugador));
	}

	@Test
	public void testCrearJugadoryVerificarQueNoEsteEncarcelado() {
		Jugador jugador = new Jugador("Rich Uncle-Milburn Pennybags");
		Carcel carcel = new Carcel();
		Assert.assertFalse(carcel.estaPreso(jugador));
	}

	@Test
	public void testEncarcelarJugadoryVerificarQueNoPuedaPagarFianza() {
		Jugador jugador = new Jugador("Rich Uncle-Milburn Pennybags");
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
		Jugador jugador = new Jugador("Rich Uncle-Milburn Pennybags");
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
		Jugador jugador = new Jugador("Rich Uncle-Milburn Pennybags");
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
		Jugador jugador = new Jugador("Rich Uncle-Milburn Pennybags");
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
		Jugador jugador = new Jugador("Rich Uncle-Milburn Pennybags");
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
		Jugador jugador = new Jugador("Rich Uncle-Milburn Pennybags");
		Carcel carcel = new Carcel();
		carcel.afectar(jugador);
		carcel.estaPreso(jugador);
		carcel.estaPreso(jugador);
		carcel.estaPreso(jugador);
		Assert.assertFalse(carcel.estaPreso(jugador));
	}
}
