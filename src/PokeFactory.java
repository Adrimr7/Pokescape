
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
	public Pokemon createPokemon (String tipo)
	{
		Pokemon unPokemon = null;
		if (tipo.equals("Agua"))
		{
			unPokemon = new Agua(tipo, 0, 0, 0);
		}
		else if (tipo.equals("Planta"))
		{
			unPokemon = new Planta(tipo, 0, 0, 0);
		}
		else if (tipo.equals("Fuego"))
		{
			unPokemon = new Fuego(tipo, 0, 0, 0);
		}
		else if (tipo.equals("Electrico"))
		{
			unPokemon = new Electrico(tipo, 0, 0, 0);
		}
		return unPokemon;
	}
}
