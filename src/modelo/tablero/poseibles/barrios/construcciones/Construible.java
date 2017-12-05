package modelo.tablero.poseibles.barrios.construcciones;

import modelo.tablero.poseibles.barrios.Barrio;

public interface Construible {

	public void precioAlquiler(int precio);
	public void costoCosntruccion(int costo);
	public String descripcion();
	public Construccion construirEn(Barrio unBarrio);
	public int costoConstruccionEn(Barrio unBarrio);
}
