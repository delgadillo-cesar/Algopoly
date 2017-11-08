
public class Dado {
	
	private
	
		int cara;
	
/***********************************************/	

	public
	
/***********************************************/	
	
	/*	Constructor
	 * 	Pre: Ninguna
	 *  Pos: Crea instancia de dado vacia
	 */
	
		Dado ()
			{
				cara=0;
			}
	
/***********************************************/
	
	/*	Metodo Lanzar
	 * 	Pre: Dado creado
	 * 	Pos: Lanzar implica hipoteticamente arrojar 
	 * 		 un dado y leer el numero de la cara del mismo
	 * 
	 */
	
		int lanzar () 
			{
				this.cara = (int) (Math.random() * 6) + 1;
				return this.cara;
			}
}
