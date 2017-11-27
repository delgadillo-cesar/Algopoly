package barrios;

import java.util.HashMap;

import entidades.Jugador;
import poseibles.Barrio;
import poseibles.NadaParaConstruirException;


public abstract class BarrioDoble extends Barrio {

	public BarrioDoble(Jugador propietario) {
		super(propietario);
	}

	protected HashMap<Construible, Boolean> espacioCompleto;
	protected HashMap<Construible, CondicionConstruccion> condicionConstruccion;
	protected BarrioDoble barrioComplementario;
	
		
	public Boolean elEspacioEstaCompleto(){
		return (this.espacioCompleto.get(this.construido.construidoPor()));
	}
	
	public void setBarrioComplementario(BarrioDoble unBarrio){
		this.barrioComplementario = unBarrio;
	}
	
	public BarrioDoble getBarrioComplementario(){
		return this.barrioComplementario;
	}
	
	public void construir() throws NadaParaConstruirException{
		Construible aConstruir = this.construcciones.get(this.construido.construidoPor());

		try{
			CondicionConstruccion laCondicion = condicionConstruccion.get(aConstruir);
			if (!laCondicion.verificarCondicion(this)) throw new NoSePuedeConstruirException();
			
			this.construido = aConstruir.construirEn(this);
		}catch(NullPointerException e){
			throw new NadaParaConstruirException();
		}
	}
	
	public int costoConstruccion() throws NadaParaConstruirException{
		int costo;
		Construible aConstruir = this.construcciones.get(this.construido.construidoPor());

		try{
			CondicionConstruccion laCondicion = condicionConstruccion.get(aConstruir);
			if (!laCondicion.verificarCondicion(this)) throw new NoSePuedeConstruirException();
			
			costo = aConstruir.costoConstruccion();
		}catch(NullPointerException e){
			throw new NadaParaConstruirException();
		}
		
		return costo;
	}

}
