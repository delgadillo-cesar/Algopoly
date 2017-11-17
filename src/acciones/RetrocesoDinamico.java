package acciones;
import juego.Dados;
import tablero.Tablero;
import entidades.Jugador;

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
	
	public	RetrocesoDinamico (){
		this.descripcion = "RETROCESO DINAMICO";
		
		intervalo1 = new int [] {2,3,4,5,6};
		intervalo2 = new int [] {7,8,9,10};
		intervalo3 = new int [] {11,12};
	}
	
/***********************************************/
	
	public void afectar(Jugador jugador) {
		
		int nuevoValor=0;
		int temp=0;
		int numero = Dados.getInstance().getValor();
		if (buscarEnIntervalo (numero,this.intervalo1))
			{
				temp = numero - jugador.cantidadPropiedades();
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

		Tablero.getInstance().desplazar(jugador,  -1 * nuevoValor);
	}
			
/***********************************************/
}
