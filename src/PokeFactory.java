
public class PokeFactory 
{
	private static PokeFactory miPokeFactory;
	private PokeFactory() {}
	protected static PokeFactory getMiPokeFactory() 
	{
		if (miPokeFactory == null)
		{
			miPokeFactory = new PokeFactory();
		}
		return miPokeFactory;
	}
	public Pokemon createPokemon (/*String tipo, String pNombre, int pVida, int pAtaque, int pDefensa, int pNumEvoluciones*/)
	{
		// GUIA (9)
		// GUIA : Sean bienvenidos a la fabrica de Willy Wonka, solo que sin Willy Wonka ni chocolate ni Oompa Loompas, solo codigo
		
		// GUIA : Como esta parte esta todavia en construccion unicamente se hace un pokemon, ...
		// GUIA : De tipo agua ...
		// GUIA : Por problemas legales se ha descartado la idea original y se ha escogido a ditto como representante
		Pokemon unPokemon = null;
		String tipo = "Agua";
		if (tipo.equals("Agua"))
		{
			// GUIA : Dicho esto se crea un Ditto con estos parametros siendo
			// GUIA : Nombre, vida, ataque, defensa y numero de evoluciones
			// GUIA : Auque ponga 48 en un futuro pondra 200 y sus correspondientes valores, tal y como ordenan las sagradas leyes originales.
			// GUIA : No sera necesario entrar a Ditto para ver como funciona, en sentido metaforico claramente
			// GUIA : Simplemente agrea un pequeño valor aleatorio a los parametros pasados para darle un poco de aleatoriedad
	
			unPokemon = new Agua("Ditto", 48, 48, 48, 0);
			
			// GUIA : Quedando esto claro vamos a volver a la lista combatientes para seguir con el metodo iniciarCombate
			// GUIA : Siganme ...
		}
		/*
		 
		 *
		 * 
		 * 
		   ¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡TEMPORAL!!!!!!!!!!!!!!!!!!
		 * 
		 * 
		 *
		 
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
		*/
	
		return unPokemon;
	}
}
