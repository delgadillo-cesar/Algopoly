package propiedades;

import entidades.Jugador;

public class Terreno extends Propiedad {

	public Terreno() {
		
		
	}
	
	@Override
	public void afectar(Jugador jugador) {
		
		jugador.comprar(this);
		propietario = jugador;
		
	}	

}
