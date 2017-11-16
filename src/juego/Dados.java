package juego;

public class Dados {
	
	private static Dados instanciaDados;
	private int dado1;
	private int dado2;
	
	private Dados() {
		
		dado1 = 4;
		dado2 = 3;
	}
	
	public static Dados getInstance() {
		
		if (instanciaDados == null) {
			instanciaDados = new Dados();
		}
		return instanciaDados;
	}
	
	public void lanzarDados() {
		
		dado1 = (int) (Math.random() * 6) + 1;
		dado2 = (int) (Math.random() * 6) + 1;
	}
	
	public int getValor() {
		
		return dado1 + dado2;
	}
	
	public boolean salieronPares ()	{
		
		return (dado1==dado2);
	}
}
