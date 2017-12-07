package modelo.entidades;

public class JugadorDos extends Jugador {

	public JugadorDos(String unNombre) {
		super(unNombre);
	}

	@Override
	public void pagarA(Jugador cobrador, int monto) {
		cobrador.cobrarAJugador2(this, monto);
	}

	@Override
	public int cobrarAJugador1(Jugador pagador, int monto) {
		this.capital += pagador.pagar(monto);
		
		return monto;
	}

	@Override
	public int cobrarAJugador2(Jugador pagador, int monto) {
		return 0;
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
