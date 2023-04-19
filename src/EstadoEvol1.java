public class EstadoEvol1 implements EstadoPokemon {
		
	public EstadoEvol1()
	{

	}
	
	public int getAtaque(int pAtaque) {
		return (pAtaque+5);
	}
	
	public int getDefensa(int pDefensa) {
		return (pDefensa+3);
	}

}

/*EstadoEvol1 del patrón STATE "EstadoPokemon"

 * Es la primera evolución del pokémon, en caso de existir,
 * se aplica un +5 al ataque original y un +3 a la defensa
 * original

 */