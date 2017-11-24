package tablero;

import java.util.HashMap;

import barrios.*;

public class FactoryBarriosDobles implements FactoryCasillas {

	private HashMap<String, Casilla> crearBuenosAires(){
		BarrioBuenosAiresSur sur = new BarrioBuenosAiresSur();
		BarrioBuenosAiresNorte norte = new BarrioBuenosAiresNorte();
		
		sur.setBarrioComplementario(norte);
		norte.setBarrioComplementario(sur);
				
		HashMap<String, Casilla> casillas = new HashMap<String, Casilla>();
		casillas.put(BarrioBuenosAiresSur.getTag(), sur);
		casillas.put(BarrioBuenosAiresNorte.getTag(), norte);
		
		return casillas;
	}
	
	private HashMap<String, Casilla> crearCordoba(){
		BarrioCordobaSur sur = new BarrioCordobaSur();
		BarrioCordobaNorte norte = new BarrioCordobaNorte();
		
		sur.setBarrioComplementario(norte);
		norte.setBarrioComplementario(sur);
				
		HashMap<String, Casilla> casillas = new HashMap<String, Casilla>();
		casillas.put(BarrioCordobaSur.getTag(), sur);
		casillas.put(BarrioCordobaNorte.getTag(), norte);
		
		return casillas;
	}

	private HashMap<String, Casilla> crearSalta(){
		BarrioSaltaSur sur = new BarrioSaltaSur();
		BarrioSaltaNorte norte = new BarrioSaltaNorte();
		
		sur.setBarrioComplementario(norte);
		norte.setBarrioComplementario(sur);
				
		HashMap<String, Casilla> casillas = new HashMap<String, Casilla>();
		casillas.put(BarrioSaltaSur.getTag(), sur);
		casillas.put(BarrioSaltaNorte.getTag(), norte);
		
		return casillas;
	}

	public HashMap<String, Casilla> crearCasillas() {
		HashMap<String, Casilla> casillas = new HashMap<String, Casilla>();
		
		casillas.putAll(this.crearBuenosAires());
		casillas.putAll(this.crearCordoba());
		casillas.putAll(this.crearSalta());
		
		return casillas;
	}

}
