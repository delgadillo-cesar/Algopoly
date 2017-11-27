package entidades;

public class JugadorUno extends Jugador {

	public JugadorUno(String unNombre) {
		super(unNombre);
	}

	@Override
	public void pagarA(Jugador cobrador, int monto) {
		cobrador.cobrarAJugador1(this, monto);
	}

	@Override
	public int cobrarAJugador1(Jugador pagador, int monto) {
		return 0;
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
		this.capital += pagador.pagar(monto);
		
		return monto;
	}

}
