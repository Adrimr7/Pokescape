
public class PokeFactory 
{
	private static PokeFactory miPokeFactory;
	private PokeFactory() {}
	public static PokeFactory getMiPokeFactory() 
	{
		if (miPokeFactory == null)
		{
			miPokeFactory = new PokeFactory();
		}
		return miPokeFactory;
	}
	public Pokemon createPokemon (String tipo, String pNombre, int pVida, int pAtaque, int pDefensa, int pNumEvoluciones)
	{
		Pokemon unPokemon = null;
		if (tipo.equals("Agua"))
		{
			unPokemon = new Agua(pNombre, pVida, pAtaque, pDefensa, pNumEvoluciones);
		}
		else if (tipo.equals("Planta"))
		{
			unPokemon = new Planta(pNombre, pVida, pAtaque, pDefensa, pNumEvoluciones);
		}
		else if (tipo.equals("Fuego"))
		{
			unPokemon = new Fuego(pNombre, pVida, pAtaque, pDefensa, pNumEvoluciones);
		}
		else if (tipo.equals("Electrico"))
		{
			unPokemon = new Electrico(pNombre, pVida, pAtaque, pDefensa, pNumEvoluciones);
		}
		return unPokemon;
	}
}
