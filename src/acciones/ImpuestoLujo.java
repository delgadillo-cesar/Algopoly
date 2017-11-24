package acciones;

import entidades.Jugador;

public class ImpuestoLujo extends Accion {

	private static String tag = "IMPUESTO_LUJO";
	
	private final Double porcentajeImpuesto = Double.valueOf(0.10);

	public ImpuestoLujo(){
		this.descripcion = "IMPUESTO AL LUJO";
	}
	
	@Override
	public void afectar(Jugador jugador) {
		jugador.pagar((int) (jugador.capital() * porcentajeImpuesto));
	}
	
	public static String getTag(){
		return tag;
	}
}
