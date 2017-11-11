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
	public void testDiezMilTiradasSiempreSaleEntreUnoYDoce() {
		
		Dados dados = Dados.getInstance();
		
		for (int i = 0; i < 10000; i++) {
			
			dados.lanzarDados();
			int resultado = dados.getValor();
			Assert.assertTrue(resultado > 1);
			Assert.assertTrue(resultado < 13);
		}
		
		
	}
}
