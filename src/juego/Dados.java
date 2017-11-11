package juego;

public class Dados {
	
	private static Dados instancia;
	private int dado1;
	private int dado2;
	
	private Dados() {
		
		dado1 = 4;
		dado2 = 3;
	}
	
	public static Dados getInstance() {
		
		if (instancia == null) {
			instancia = new Dados();
		}
		return instancia;
	}
	
	public void lanzarDados() {
		
		dado1 = (int) (Math.random() * 6) + 1;
		dado2 = (int) (Math.random() * 6) + 1;
	}
	
	public int getValor() {
		
		return dado1 + dado2;
	}
	
}
