package unitarios;

import org.junit.Assert;
import org.junit.Test;

import acciones.AvanceDinamico;
import barrios.BarrioNeuquen;
import barrios.BarrioTucuman;
import comprables.Barrio;
import entidades.Jugador;
import juego.Dados;
import tablero.PosicionTablero;

public class AvanceDinamicoTest {

/***********************************************/
	
	@Test
	public void test01AvanceDinamicoConDadosEntre2Y6AvanzaElEquivalenteAlValoderDeLosDadosMenos2() {		
		Dados dados = Dados.getInstance();
		Jugador unJugador = new Jugador ("Jugador de Prueba");
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		
		unJugador.cambiarPosicion(new PosicionTablero());
		Assert.assertEquals(1, unJugador.obtenerPosicion().getPosicion());
		
		do{
			dados.lanzarDados();
		}while(!((dados.getValor() >= 2) && (dados.getValor() <= 6)));
		
		avanceDinamico.afectar(unJugador);
		Assert.assertEquals((1 + (dados.getValor() -2)), unJugador.obtenerPosicion().getPosicion());
	}
	
	@Test
	public void test02AvanceDinamicoConDadosEntr7Y10AvanzaElEquivalenteASuCantidadDeEfectivoModuloValorDeLosDados() {		
		Dados dados = Dados.getInstance();
		Jugador unJugador = new Jugador ("Jugador de Prueba");
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		
		unJugador.cambiarPosicion(new PosicionTablero());
		Assert.assertEquals(1, unJugador.obtenerPosicion().getPosicion());
		
		do{
			dados.lanzarDados();
		}while(!((dados.getValor() >= 7) && (dados.getValor() <= 10)));
		
		avanceDinamico.afectar(unJugador);
		
		int posicionEsperada = 1 + (unJugador.capital() % dados.getValor());
		Assert.assertEquals(posicionEsperada, unJugador.obtenerPosicion().getPosicion());
	}

	@Test
	public void test03AvanceDinamicoConDadosEntr11Y12AvanzaElEquivalenteAlValorDeLosDadosMenosLaCantidadDePropiedadesJugadorSinPropiedades() {		
		Dados dados = Dados.getInstance();
		Jugador unJugadorSinPropiedades = new Jugador ("Jugador de Prueba sin propiedades");
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		do{
			dados.lanzarDados();
		}while(!((dados.getValor() >= 11) && (dados.getValor() <= 12)));
		
		
		unJugadorSinPropiedades.cambiarPosicion(new PosicionTablero());
		Assert.assertEquals(1, unJugadorSinPropiedades.obtenerPosicion().getPosicion());
		
		avanceDinamico.afectar(unJugadorSinPropiedades);
		
		int posicionEsperada = 1 + dados.getValor();
		Assert.assertEquals(posicionEsperada, unJugadorSinPropiedades.obtenerPosicion().getPosicion());
	}
	
	@Test
	public void test04AvanceDinamicoConDadosEntre11Y12AvanzaElEquivalenteAlValorDeLosDadosMenosLaCantidadDePropiedadesJugadorConPropiedades() {		
		Dados dados = Dados.getInstance();
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		Jugador unJugadorConPropiedades = new Jugador ("Jugador de Prueba con propiedades");
		Barrio unBarrio = new BarrioNeuquen();
		unJugadorConPropiedades.comprarPropiedad(unBarrio);
		unBarrio.construir();
		
		unBarrio = new BarrioTucuman();
		unJugadorConPropiedades.comprarPropiedad(unBarrio);
		unBarrio.construir();

		unJugadorConPropiedades.cambiarPosicion(new PosicionTablero());
		Assert.assertEquals(1, unJugadorConPropiedades.obtenerPosicion().getPosicion());

		do{
			dados.lanzarDados();
		}while(!((dados.getValor() >= 11) && (dados.getValor() <= 12)));

		avanceDinamico.afectar(unJugadorConPropiedades);

		int posicionEsperada = 1 + (dados.getValor() - 2);
		Assert.assertEquals(posicionEsperada, unJugadorConPropiedades.obtenerPosicion().getPosicion());
	}
}
