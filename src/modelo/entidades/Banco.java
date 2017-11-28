package modelo.entidades;

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
		cobrador.cobrarABanco(this, monto);
	}

	@Override
	public int cobrarAJugador1(Jugador pagador, int monto) {
		this.capital += pagador.pagar(monto);
		
		return monto;
	}

	@Override
	public int cobrarAJugador2(Jugador pagador, int monto) {
		this.capital += pagador.pagar(monto);
		
		return monto;
	}

	@Override
	public int cobrarAJugador3(Jugador pagador, int monto) {
		this.capital += pagador.pagar(monto);
		
		return monto;
	}

	@Override
	public int cobrarABanco(Jugador pagador, int monto) {
		return 0;
	}
}
