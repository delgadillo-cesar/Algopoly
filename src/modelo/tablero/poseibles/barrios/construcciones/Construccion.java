package modelo.tablero.poseibles.barrios.construcciones;

import modelo.entidades.Jugador;
import modelo.tablero.poseibles.barrios.Barrio;

public interface Construccion {

	public void costoCosntruccion(int costo);
	public int costoCosntruccion(Barrio unBarrio);
	public void precioAlquiler(int precio);
	public int precioAlquiler(Barrio unBarrio);

	public int costoConstruirEnBarrioSimple(Barrio unBarrio);
	public Construccion construirEnBarrioSimple(Barrio unBarrio);

	public int	costoConstruirEnBarrioDoble(Barrio unBarrio);
	public Construccion construirEnBarrioDoble(Barrio unBarrio);

	public int	costoConstruirEnBarrioHistorico(Barrio unBarrio);
	public Construccion construirEnBarrioHistorico(Barrio unBarrio);
	
	public void cobrarAlquiler(Jugador propietario, Jugador unVisitante);
	public String descripcion();
	public int cantidadDePropiedades();	
	public abstract boolean sePuedeVender();
	public abstract Construccion vender();

	public int nivelConstruccion();

}
