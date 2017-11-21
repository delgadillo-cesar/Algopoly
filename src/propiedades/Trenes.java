package propiedades;

import juego.Dados;

public class Trenes extends Compania {

	public Trenes(){
		this.descripcion = "TRENES";
		this.nombrePropiedad = "TRENES";
		this.precioCompra = 38000;
	}

	@Override
	protected int cobrar() {
		int dados = Dados.getInstance().getValor();
		
		if (this.propietario.esDuenoDe("SUBTE")){
			return (800 * dados);
		}else{
			return (450 * dados);
		}
	}	

}
