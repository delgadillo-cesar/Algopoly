package modelo.tablero.casillas.poseibles.barrios;

import modelo.entidades.Jugador;
import modelo.tablero.casillas.poseibles.NadaParaConstruirException;




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
		for (Barrio barrio : this.propietario.obtenerBarios()){
			barrio.interactuarCon(this);
		}
	}
	
	protected void actualizarConstrucciones(Barrio complemento){
		if (complemento.propietario() == this.propietario){
			System.out.println(this.construcciones);
			this.construcciones = this.construcciones.actualizarCon(new HastaDosCasas());
			System.out.println(this.construcciones);
			complemento.construcciones = complemento.construcciones.actualizarCon(new HastaDosCasas());
		}

		System.out.println(this.cantidadDePropiedades());
		if (complemento.cantidadDePropiedades() == 2){
			System.out.println("Hotel 1");
			this.construcciones = this.construcciones.actualizarCon(new HastaHotel());
		}
		
		if (this.cantidadDePropiedades() == 2){
			System.out.println("Hotel 2");
			complemento.construcciones = complemento.construcciones.actualizarCon(new HastaHotel());
		}
	}
}
