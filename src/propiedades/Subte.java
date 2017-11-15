package propiedades;

import juego.Dados;

public class Subte extends Compania {

	public Subte(){
		this.descripcion = "SUBTE";
		this.nombrePropiedad = "SUBTE";
		this.precioCompra = 40000;
	}

	@Override
	protected int cobrar() {
		int dados = Dados.getInstance().getValor();
		
		if (this.propietario.tienePropiedad("TRENES")){
			return (1100 * dados);
		}else{
			return (600 * dados);
		}
	}	
}
