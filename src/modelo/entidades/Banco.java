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
	public int cobrarAJugador(JugadorUno pagador, int monto) {
		this.capital += pagador.pagar(monto);
		
		return monto;
	}

	@Override
	public int cobrarAJugador(JugadorDos pagador, int monto) {
		this.capital += pagador.pagar(monto);
		
		return monto;
	}

	@Override
	public int cobrarAJugador(JugadorTres pagador, int monto) {
		this.capital += pagador.pagar(monto);
		
		return monto;
	}

	@Override
	public int cobrarABanco(Banco pagador, int monto) {
		return 0;
	}
}
