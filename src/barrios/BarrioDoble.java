package barrios;


import entidades.Jugador;
import poseibles.Construccion;
import poseibles.NadaParaConstruirException;


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
		return this.construcciones.costoConstruccion(this);
	}

	private void chequearComplemento(){
		for (Barrio barrio : this.propietario.obtenerBarios()){
			barrio.interactuarCon(this);
		}
	}
	
	protected void actualizarConstrucciones(Barrio complemento){
		if (complemento.propietario() == this.propietario){
			this.construcciones = this.construcciones.actualizarCon(new HastaDosCasas());
			complemento.construcciones = complemento.construcciones.actualizarCon(new HastaDosCasas());
		}

		if (complemento.cantidadDePropiedades() == 2){
			this.construcciones = this.construcciones.actualizarCon(new HastaHotel());
		}
		
		if (this.cantidadDePropiedades() == 2){
			complemento.construcciones = complemento.construcciones.actualizarCon(new HastaHotel());
		}
	}
}
