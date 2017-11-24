package barrios;

import comprables.Barrio;
import comprables.Construccion;

public interface Construible {

	public int precioAlquiler();
	public int costoConstruccion();
	public String descripcion();
	public Construccion construirEn(Barrio unBarrio);
}
