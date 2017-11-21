package propiedades;

import juego.Dados;

public class Aysa extends Compania {

	public Aysa(){
		this.descripcion = "AYSA";
		this.nombrePropiedad = "AYSA";
		this.precioCompra = 30000;
	}

	@Override
	protected int cobrar() {
		int dados = Dados.getInstance().getValor();
		
		if (this.propietario.esDuenoDe("EDESUR")){
			return (500 * dados);
		}else{
			return (300 * dados);
		}
	}


}
