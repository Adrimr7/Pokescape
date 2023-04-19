public class EstadoEvol0 implements EstadoPokemon {

	public EstadoEvol0()
	{

	}
	
	public int getAtaque(int pAtaque) {
		return (pAtaque);
	}
	
	public int getDefensa(int pDefensa) {
		return (pDefensa);
	}
}

/*EstadoEvol0 del patrón STATE "EstadoPokemon"
 
 * Es el estado inicial del pokémon, por lo que no se aplica 
 * ningún multiplicador al ataque ni a la defensa

 */
