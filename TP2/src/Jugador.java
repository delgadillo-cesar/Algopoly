
public class Jugador {
	
	private
	
		int capital;	 // int rango [0....2*10E9]

	
/***********************************************/
	
	public
	
	/*	Constructor 
	 * 	Pre: Ninguna
	 *  Pos: Crea instancia de Jugador
	 *  	 Con capital inicial por defecto = 100.000 
	 */
	
		Jugador ()
			{
				this.capital = 100000;		
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

}
