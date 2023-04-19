public class EstadoEuforia implements EstadoPokemon {
		
	public EstadoEuforia()
	{
		
	}
	
	public int getAtaque(int pAtaque) {
		return (pAtaque+100);
	}
	
	public int getDefensa(int pDefensa) {
		return (pDefensa+100);
	}

}

/*EstadoEuforia del patrón STATE "EstadoPokemon"

 * Es la euforia del pokémon, se aplica un +5 al ataque original
 * y un +3 a la defensa original

 */