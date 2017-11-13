package acciones;
import entidades.Jugador;
import entidades.JugadorConcreto;

public class RetrocesoDinamico extends Accion{
	
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
	
	public	RetrocesoDinamico ()
		{
			intervalo1 = new int [] {2,3,4,5,6};
			intervalo2 = new int [] {7,8,9,10};
			intervalo3 = new int [] {11,12};
		}
	
/***********************************************/
	
	public int numeroDeCasillerosARetroceder (JugadorConcreto jugador,int numero)
	{
		int nuevoValor=0;
		int temp=0;
		System.out.println("N� de propiedades: " + jugador.cantidadPropiedades());
		if (buscarEnIntervalo (numero,this.intervalo1))
			{
				temp = numero - jugador.cantidadPropiedades();
				System.out.println("temp: " + temp);
				if (temp >=0)
					nuevoValor = temp;
				else
					nuevoValor = numero;
				
			}
			
	
		else if (buscarEnIntervalo (numero,this.intervalo2))
				{
					nuevoValor = (jugador.capital())%numero;
				}
		else if (buscarEnIntervalo (numero,this.intervalo3))
				{
					nuevoValor = numero-2;
				}	
		return nuevoValor;
	}	
	
	
/***********************************************/
	
	@Override
	public void afectar(Jugador jugador) {		
			
	}
			
/***********************************************/
}
