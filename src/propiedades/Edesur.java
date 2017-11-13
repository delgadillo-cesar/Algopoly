package propiedades;

import juego.Dados;

public class Edesur extends Compania {

	public Edesur(){
		this.nombrePropiedad = "EDESUR";
		this.precioCompra = 35000;
	}

	@Override
	protected int cobrar() {
		int dados = Dados.getInstance().getValor();
		
		if (this.propietario.tienePropiedad("AYSA")){
			return (1000 * dados);
		}else{
			return (500 * dados);
		}
	}	

}
