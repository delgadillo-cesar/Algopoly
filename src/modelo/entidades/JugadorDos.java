package modelo.entidades;

public class JugadorDos extends Jugador {

	public JugadorDos(String unNombre) {
		super(unNombre);
	}

	@Override
	public void pagarA(Jugador cobrador, int monto) {
		cobrador.cobrarAJugador(this, monto);
	}

	@Override
	public int cobrarAJugador(JugadorUno pagador, int monto) {
		this.capital += pagador.pagar(monto);
		
		return monto;
	}

	@Override
	public int cobrarAJugador(JugadorDos pagador, int monto) {
		return 0;
	}

	@Override
	public int cobrarAJugador(JugadorTres pagador, int monto) {
		this.capital += pagador.pagar(monto);
		
		return monto;
	}

	@Override
	public int cobrarABanco(Banco pagador, int monto) {
		this.capital += pagador.pagar(monto);
		
		return monto;
	}

}
