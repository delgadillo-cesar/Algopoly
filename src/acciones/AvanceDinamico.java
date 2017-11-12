package acciones;
import entidades.Jugador;
import entidades.JugadorConcreto;
import entidades.Nadie;

public class AvanceDinamico extends Accion{
	
	private
		
		int [] intervalo1;
		int [] intervalo2;
		int [] intervalo3;
		
	private boolean buscarEnIntervalo (int numero,int[] intervalo)
		{
			boolean status = false;
			int i,largo;
			largo = intervalo.length;
			for (i=0;i<largo;i++)
				if (numero == intervalo[i])
					status = true;				
			return status;		
		}
	
/***********************************************/
	
	public	AvanceDinamico ()
		{
			intervalo1 = new int [] {2,3,4,5,6};
			intervalo2 = new int [] {7,8,9,10};
			intervalo3 = new int [] {11,12};
		}
	
/***********************************************/
	
	public int numeroDeCasillerosAAvanzar (JugadorConcreto jugador,int numero)
		{
			int nuevoValor=0;
			if (buscarEnIntervalo (numero,this.intervalo1))
				nuevoValor = numero-2;
			else if (buscarEnIntervalo (numero,this.intervalo2))
					{
						nuevoValor = (jugador.capital())%numero;
					}
			else if (buscarEnIntervalo (numero,this.intervalo3))
					{
						nuevoValor = numero - jugador.cantidadPropiedades();
					}
					
			return nuevoValor;
		}	
	
/***********************************************/
		
	@Override
	public void afectar(Jugador jugador) {		
			
	}
			
/***********************************************/
		
	@Override
	public Jugador propietario() {
			
		return new Nadie();
	}

/***********************************************/
	
}
	
	
	