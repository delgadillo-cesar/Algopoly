package modelo.tablero.poseibles.barrios;

import modelo.entidades.Jugador;
import modelo.tablero.poseibles.NadaParaConstruirException;
import modelo.tablero.poseibles.barrios.construcciones.Construccion;
import modelo.tablero.poseibles.barrios.construcciones.HastaDosCasas;
import modelo.tablero.poseibles.barrios.construcciones.HastaHotel;




public abstract class BarrioDoble extends Barrio {

	public BarrioDoble(Jugador propietario) {
		super(propietario);
	}


	public void construir() throws NadaParaConstruirException{
		Construccion nuevaConstruccion = this.construcciones.construir(this);
		this.construido = nuevaConstruccion;
		this.chequearComplemento();
	}
	
	public int costoConstruccion() throws NadaParaConstruirException{
		this.chequearComplemento();
		return this.construcciones.costoConstruccion(this);
	}

	private void chequearComplemento(){
		for (Barrio barrio : this.propietario.obtenerBarrios()){
			barrio.interactuarCon(this);
		}
	}
	
	protected void actualizarConstrucciones(Barrio complemento){
		if (complemento.propietario() == this.propietario){
			this.construcciones = this.construcciones.actualizarCon(new HastaDosCasas());
			complemento.construcciones = complemento.construcciones.actualizarCon(new HastaDosCasas());
		}

		System.out.println(this.cantidadDePropiedades());
		if (complemento.cantidadDePropiedades() == 2){
			this.construcciones = this.construcciones.actualizarCon(new HastaHotel());
		}
		
		if (this.cantidadDePropiedades() == 2){
			complemento.construcciones = complemento.construcciones.actualizarCon(new HastaHotel());
		}
	}
}
