package unitarios;

import org.junit.Assert;
import org.junit.Test;

import juego.Dados;

public class DadosTest {

	@Test
	public void testObtenerDadosNoEsNull() {

		Dados dados = Dados.getInstance();

		Assert.assertNotNull(dados);
	}

	@Test
	public void testDadosGetInstanceSiempreDevuelveLaMismaInstancia() {

		Dados dados1 = Dados.getInstance();
		Dados dados2 = Dados.getInstance();

		Assert.assertEquals(dados1, dados2);

		dados1.lanzarDados();

		Assert.assertEquals(dados1.getValor(), dados2.getValor());

		dados1.lanzarDados();
		dados2 = Dados.getInstance();

		Assert.assertEquals(dados1.getValor(), dados2.getValor());
		Assert.assertEquals(dados1, dados2);

	}

	@Test
	public void testDiezMilTiradasSiempreSaleEntreDosYDoce() {

		Dados dados = Dados.getInstance();

		for (int i = 0; i < 10000; i++) {

			dados.lanzarDados();
			int resultado = dados.getValor();
			Assert.assertTrue(resultado >= 2);
			Assert.assertTrue(resultado <= 12);
		}
	}

	@Test
	public void testDadosIgualesSiSale2o12TienenQueSerIguales() {

		Dados dados = Dados.getInstance();

		while ((dados.getValor() != 2) && (dados.getValor() != 12)) {
			dados.lanzarDados();
		}

		Assert.assertTrue(dados.salieronPares());
	}

	@Test
	public void testDadosDistintosSiSaleImparSonDistintos() {

		Dados dados = Dados.getInstance();

		while ((dados.getValor() != 3) && (dados.getValor() != 5)
				&& (dados.getValor() != 7) && (dados.getValor() != 9)
				&& (dados.getValor() != 11)) {
			dados.lanzarDados();
		}

		
		Assert.assertFalse(dados.salieronPares());
	}
}
