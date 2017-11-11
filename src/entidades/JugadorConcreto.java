package entidades;

public class Jugador {

	private String nombre;
	private int capital;
	
	public Jugador(String unNombre) {
		
		nombre = unNombre;
		capital = 100000;
	}

	public int capital() {
		
		return capital;
	}

	public void cobrar(int unMonto) {
		
		capital += unMonto;
		
	}

}
