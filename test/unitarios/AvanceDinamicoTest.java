package unitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.entidades.JugadorUno;
import modelo.juego.Dados;
import modelo.tablero.PosicionTablero;
import modelo.tablero.acciones.AvanceDinamico;
import modelo.tablero.comprables.NeuquenComprable;
import modelo.tablero.comprables.TucumanComprable;
import modelo.tablero.poseibles.barrios.Barrio;

public class AvanceDinamicoTest {

/***********************************************/
	
	@Test
	public void test01AvanceDinamicoConDadosEntre2Y6AvanzaElEquivalenteAlValoderDeLosDadosMenos2() {		
		Dados dados = Dados.getInstance();
		JugadorUno unJugador = new JugadorUno ("Jugador de Prueba");
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
		JugadorUno unJugador = new JugadorUno ("Jugador de Prueba");
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
		JugadorUno unJugadorSinPropiedades = new JugadorUno ("Jugador de Prueba sin propiedades");
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

		JugadorUno unJugadorConPropiedades = new JugadorUno ("Jugador de Prueba con propiedades");

		NeuquenComprable neuquen = new NeuquenComprable(); 
		neuquen.comprar(unJugadorConPropiedades);

		TucumanComprable tucuman = new TucumanComprable();
		tucuman.comprar(unJugadorConPropiedades);

		for (Barrio unBarrio : unJugadorConPropiedades.obtenerBarrios()){
			unBarrio.construir();
		}

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
