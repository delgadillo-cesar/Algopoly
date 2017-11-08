import org.junit.Test;

public class TestDado {

	
/***********************************************/	

	@Test
	public void test01Lanzar() {
		
		int i,resultado;
		Dado dado1 = new Dado();
		for (i=0;i<100;i++)
			{
				resultado = dado1.lanzar();
				System.out.print(resultado);
			}
	}

}
