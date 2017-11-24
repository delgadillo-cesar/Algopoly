package comprables;

import juego.Dados;

public class Subte extends Compania {

	private static String tag = "SUBTE";
	
	public Subte(){
		this.descripcion = "SUBTE";
		this.nombrePropiedad = "SUBTE";
		this.precioCompra = 40000;
	}

	@Override
	protected int cobrar() {
		int dados = Dados.getInstance().getValor();
		
		if (this.propietario.esDuenoDe("TRENES")){
			return (1100 * dados);
		}else{
			return (600 * dados);
		}
	}
	
	public static String getTag(){
		return tag;
	}
}
