package entidades;

public class JugadorUno extends Jugador {

	public JugadorUno(String unNombre) {
		super(unNombre);
	}

	@Override
	public void pagarA(Jugador cobrador, int monto) {
		cobrador.cobrarAJugador1(monto);
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
		return 0;
	}

}
