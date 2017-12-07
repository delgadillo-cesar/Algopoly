package modelo.tablero.poseibles.barrios.construcciones;

import java.util.List;

import modelo.tablero.poseibles.barrios.Barrio;
import modelo.tablero.poseibles.compania.*;


public abstract class ConstruccionPosible {

	protected List<Construible> construcciones;
	
	public Construccion construir(Barrio unBarrio) throws NadaParaConstruirException{
		Construccion construccion = null;
		try{
			Construible aConstruir = this.construcciones.get(0);
			construccion = aConstruir.construirEn(unBarrio);
			this.construcciones.remove(0);
		}catch(IndexOutOfBoundsException e){
			throw new NadaParaConstruirException();
		}
		
		return construccion;
	}
	
	
	public int costoConstruccion(Barrio unBarrio) throws NadaParaConstruirException{
		try{
			Construible aConstruir = this.construcciones.get(0);
			return (aConstruir.costoConstruccionEn(unBarrio));
		}catch(IndexOutOfBoundsException e){
			throw new NadaParaConstruirException();
		}
	}


	public abstract ConstruccionPosible actualizarCon(ConstruccionPosible otraConstruccionPosible);
	public abstract ConstruccionPosible actualizarConNoConstruye(ConstruccionPosible otraConstruccionPosible);
	public abstract ConstruccionPosible actualizarConSoloCasa(ConstruccionPosible otraConstruccionPosible);
	public abstract ConstruccionPosible actualizarConHastaDosCasas(ConstruccionPosible otraConstruccionPosible);
	public abstract ConstruccionPosible actualizarConHastaHotel(ConstruccionPosible otraConstruccionPosible);
	public abstract ConstruccionPosible actualizarConSoloEdificioHistorico(ConstruccionPosible otraConstruccionPosible);

}