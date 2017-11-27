package entidades;

public class Banco extends Jugador {

	private static Banco elBanco;
	
	private Banco() {
		super("BANCO");
	}

	public static Banco getInstance(){
		if(elBanco == null){
			elBanco = new Banco();
		}
		return elBanco;
	}

	@Override
	public void pagarA(Jugador cobrador, int monto) {
		cobrador.cobrarABanco(monto);
	}

	@Override
	public int cobrarAJugador1(int monto) {
		return 0;
	}

	@Override
	public int cobrarAJugador2(int monto) {
		return 0;
	}

	@Override
	public int cobrarAJugador3(int monto) {
		return 0;
	}

	@Override
	public int cobrarABanco(int monto) {
		return monto;
	}

}
