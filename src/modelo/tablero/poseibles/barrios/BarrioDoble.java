package modelo.tablero.poseibles.barrios;

import modelo.entidades.Jugador;
import modelo.tablero.poseibles.barrios.construcciones.NadaParaConstruirException;


public abstract class BarrioDoble extends Barrio {

	private boolean puedeConstruirCasas;
	private boolean puedeConstruirHotel;
	
	
	public BarrioDoble(Jugador propietario) {
		super(propietario);
	}


	public void construir() throws NadaParaConstruirException{
		this.construido = this.construido.construirEnBarrioDoble(this);
		this.chequearComplemento();
	}
	
	public int costoConstruccion() throws NadaParaConstruirException{
		this.chequearComplemento();
		return this.construido.costoConstruirEnBarrioDoble(this);
	}

	protected void chequearComplemento(){
		for (Barrio barrio : this.propietario.obtenerBarrios()){
			barrio.interactuarCon(this);
		}
	}
	
	protected void actualizarConstrucciones(Barrio complemento){
		this.puedeConstruirCasas = (complemento.propietario() == this.propietario);
		this.puedeConstruirHotel = (complemento.construido.nivelConstruccion() >= 2);
	}
	
	public void venderConstruccion(){
		this.construido = this.construido.vender();
		this.chequearComplemento();
	}


	public boolean podesConstruirCasas(){
		this.chequearComplemento();
		return this.puedeConstruirCasas;
	}

	public boolean podesConstruirHotel(){
		this.chequearComplemento();
		return this.puedeConstruirHotel;
	}
}
