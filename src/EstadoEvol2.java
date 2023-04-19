public class EstadoEvol2 implements EstadoPokemon {
		
	public EstadoEvol2()
	{
		
	}
	
	public int getAtaque(int pAtaque) {
		return (pAtaque+7);
	}
	
	public int getDefensa(int pDefensa) {
		return (pDefensa+5);
	}

}

/*EstadoEvol2 del patrón STATE "EstadoPokemon"

 * Es la segunda evolución del pokémon, en caso de existir,
 * se aplica un +7 al ataque original y un +5 a la defensa
 * original

 */