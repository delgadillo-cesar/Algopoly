package barrios;

import poseibles.Barrio;
import poseibles.Construccion;

public interface Construible {

	public int precioAlquiler();
	public int costoConstruccion();
	public String descripcion();
	public Construccion construirEn(Barrio unBarrio);
}
