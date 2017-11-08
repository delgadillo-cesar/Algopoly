
public class Jugador {
	
	private
	
		int contadorDeVecesQueGanoQuini6;
		int capital;						 // int rango [0....2*10E9]
		Dado dado1;
		Dado dado2;	
	
/***********************************************/
	
	public
	
	/*	Constructor 
	 * 	Pre: Ninguna
	 *  Pos: Crea instancia de Jugador
	 *  	 Con capital inicial por defecto = 100.000 
	 */
	
		Jugador ()
			{
				this.contadorDeVecesQueGanoQuini6=0;
				this.capital = 100000;
				Dado dado1 = new Dado();
				Dado dado2 = new Dado();
			}
	
/***********************************************/
	
	/* 	Metodo: obtener la cantidad de veces que gano el Quini6
	 * 	Pre: Jugador creado
	 * 	Pos: devuelve la cantidad de veces que gano el Quini6
	 */
		
		int getCantidadDeVecesQueGanoQuini6 ()
			{
				return this.contadorDeVecesQueGanoQuini6;
			}
	
/***********************************************/	
		
	/*	Metodo que incrementa en 1 unidad la cantidad
	 * 		   de veces que gano el Quini6
	 *  Pre: Jugador creado
	 *  Pos: Incrementa en 1 la cantidad de veces que 
	 *  	 el jugador gano el Quini6
	 */
		void incremetarCantidadDeVecesQueGanoQuini6 ()
			{
				this.contadorDeVecesQueGanoQuini6 +=1;
			}
	
/***********************************************/			
			
	/*	Metodo obtenerCapital
	 * 	Pre: Jugador creado
	 *  Pos: devuelve el capital del Jugador
	 */
		int getCapitalJugador ()
			{
				return this.capital;
			}
		
/***********************************************/		
		
	/*	Metodo: incremetar el capital del jugador
	 * 			un determinado monto
	 * 	Pre: Jugador creado
	 * 	Pos: incrementa el capital del Jugador 
	 * 		 el monto indicado
	 */

		void incrementarCapitalJugador (int monto)
			{
				this.capital += monto;
			}

/***********************************************/			
		
	/*	Metodo: lanzarDado (Dado dado1)
	 * 	Pre: Jugador creado
	 * 	Pos: lanza un dado y devuelve un numero entre 1-6	
	 */
		
		void lanzarDado (int d1,int d2)
			{
				d1 = this.dado1.lanzar();
				d2 = this.dado2.lanzar();
			}
}
