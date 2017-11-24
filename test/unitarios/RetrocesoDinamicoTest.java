package unitarios;

import org.junit.Assert;
import org.junit.Test;

import acciones.RetrocesoDinamico;
import barrios.BarrioNeuquen;
import barrios.BarrioTucuman;
import comprables.Barrio;
import entidades.Jugador;
import juego.Dados;
import tablero.PosicionTablero;

public class RetrocesoDinamicoTest {

	@Test
	public void test01retrocesoDinamicoConDadosEntre2Y6AvanzaElEquivalenteAlValorDeLosDadosMenosLaCantidadDePropiedadesJugadorSinPropiedades() {
		Dados dados = Dados.getInstance();
		Jugador unJugadorSinPropiedades = new Jugador("Jugador de Prueba sin propiedades");
		RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

		do {
			dados.lanzarDados();
		} while (!((dados.getValor() >= 2) && (dados.getValor() <= 6)));

		unJugadorSinPropiedades.cambiarPosicion(new PosicionTablero(15));
		Assert.assertEquals(15, unJugadorSinPropiedades.obtenerPosicion().getPosicion());

		retrocesoDinamico.afectar(unJugadorSinPropiedades);

		int posicionEsperada = 15 - dados.getValor();
		
		Assert.assertEquals(posicionEsperada, unJugadorSinPropiedades.obtenerPosicion().getPosicion());
	}

	@Test
	public void test02retrocesoDinamicoConDadosEntre11Y12AvanzaElEquivalenteAlValorDeLosDadosMenosLaCantidadDePropiedadesJugadorConPropiedades() {
		Dados dados = Dados.getInstance();
		RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

		Jugador unJugadorConPropiedades = new Jugador("Jugador de Prueba con propiedades");
		Barrio unBarrio = new BarrioNeuquen();
		unJugadorConPropiedades.comprarPropiedad(unBarrio);
		unBarrio.construir();

		unBarrio = new BarrioTucuman();
		unJugadorConPropiedades.comprarPropiedad(unBarrio);
		unBarrio.construir();

		unJugadorConPropiedades.cambiarPosicion(new PosicionTablero(15));
		Assert.assertEquals(15, unJugadorConPropiedades.obtenerPosicion().getPosicion());

		do{
			dados.lanzarDados();
		}while(!((dados.getValor() >= 11) && (dados.getValor() <= 12)));
		

		retrocesoDinamico.afectar(unJugadorConPropiedades);

		int posicionEsperada = 15 - (dados.getValor() - 2);
		Assert.assertEquals(posicionEsperada, unJugadorConPropiedades.obtenerPosicion().getPosicion());
	}

	@Test
	public void test03retrocesoDinamicoConDadosEntre7Y10AvanzaElEquivalenteASuCantidadDeEfectivoModuloValorDeLosDados() {
		Dados dados = Dados.getInstance();
		Jugador unJugador = new Jugador("Jugador de Prueba");
		RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

		unJugador.cambiarPosicion(new PosicionTablero(15));
		Assert.assertEquals(15, unJugador.obtenerPosicion().getPosicion());

		do {
			dados.lanzarDados();
		} while (!((dados.getValor() >= 7) && (dados.getValor() <= 10)));

		retrocesoDinamico.afectar(unJugador);

		int posicionEsperada = 15 - (unJugador.capital() % dados.getValor());
		Assert.assertEquals(posicionEsperada, unJugador.obtenerPosicion().getPosicion());
	}

	@Test
	public void test04retrocesoDinamicoConDadosEntre11Y12AvanzaElEquivalenteAlValoderDeLosDadosMenos2() {
		Dados dados = Dados.getInstance();
		Jugador unJugador = new Jugador("Jugador de Prueba");
		RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

		unJugador.cambiarPosicion(new PosicionTablero(15));
		Assert.assertEquals(15, unJugador.obtenerPosicion().getPosicion());

		do {
			dados.lanzarDados();
		} while (!((dados.getValor() >= 11) && (dados.getValor() <= 12)));

		retrocesoDinamico.afectar(unJugador);
		Assert.assertEquals((15 - (dados.getValor() - 2)), unJugador.obtenerPosicion().getPosicion());
	}

}
