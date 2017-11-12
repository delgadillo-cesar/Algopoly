package propiedades;

import entidades.Jugador;
import entidades.JugadorConcreto;

public class Terreno extends Propiedad {

	public Terreno() {
		
		
	}
	
	@Override
	public void afectar(Jugador jugador) {
		
		jugador.comprar(this);
		propietario = jugador;
		
	}	
	
	@Override
	public int numeroDeCasillerosAAvanzar(JugadorConcreto jugador, int numero)	{
		
		return 0;
	}
	
	@Override
	public int numeroDeCasillerosARetroceder(JugadorConcreto jugador, int numero)	{
		
		return 0;
	}


}
