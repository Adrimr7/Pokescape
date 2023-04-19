public interface EstadoPokemon {

	public int getAtaque(int pAtaque);
	public int getDefensa(int pDefensa);
}

/*Patrón STATE para el control de EVOLUCIONES y EUFORIA
 * 
 * Estos estados recibirán la información original del pokémon,
 * generada en la inicialización de la partida al crear los 
 * pokémon, y la devolverán actualizada con su respectivo
 * multiplicador.
 
 
 
 * Es decir, los atributos "ataque" y "defensa" de la clase Pokémon
 * no se modifican en ningún momento, sino que se mantienen constantes
 * con el valor que se les ha asignado al comienzo de la partida:
 * 
 * ataque = 11 + random (1-7)
 * defensa = 3 + random (1-4)
 
 
 
 * Sin embargo, ambos valores dependerán del estado en el que se 
 * encuentre el pokémon, por lo que para obtener el valor de ataque
 * y defensa real se hará uso de los estados:
 * 
 * state.getAtaque(ataque)
 * state.getDefensa(defensa)
 * 
 * De esta forma, podremos controlar ambos parámetros en función del
 * estado.
 
 
 
 * Este patrón State se compone de los estados:
 *  	1) EstadoEvol0: estado normal o inicial
 *  	2) EstadoEvol1: estado de primera evolución (si la hubiera)
 *  	3) EstadoEvol2: estado de segunda evolución (si la hubiera)
 *  	4) EstadoEuforia: estado de euforia
 
 
 
 * Recordemos que no todos los pokémon evolucionan, y en este sentido
 * podrán evolucionar o no. Pueden tener 0, 1 o 2 evoluciones.
 * 
 */
