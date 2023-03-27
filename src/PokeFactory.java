import java.util.ArrayList;
import java.util.Random;

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
	public Pokemon createPokemon()
	{
		Random rn = new Random();
		
		ArrayList<Pokemon> lista = new ArrayList<Pokemon>();
		
		Pokemon pk;
		pk = new Planta("Bulbasaur", 48,57,48,0);
		pk.setNumPokemon(1);
		lista.add(pk);
		pk = new Planta("Ivysaur", 48,57,48,0);
		pk.setNumPokemon(2);
		lista.add(pk);
		pk = new Planta("Venusaur", 48,57,48,0);
		pk.setNumPokemon(3);
		lista.add(pk);
		pk = new Fuego("Charmander", 48,60,48,0);
		pk.setNumPokemon(4);
		lista.add(pk);
		pk = new Fuego("Charmeleon", 48,60,48,0);
		pk.setNumPokemon(5);
		lista.add(pk);
		pk = new Fuego("Charizard", 48,60,48,0);
		pk.setNumPokemon(6);
		lista.add(pk);
		pk = new Agua("Squirtle", 90,48,48,0);
		pk.setNumPokemon(7);
		lista.add(pk);
		pk = new Agua("Wartortle", 90,48,48,0);
		pk.setNumPokemon(8);
		lista.add(pk);
		pk = new Agua("Blastoise", 90,48,48,0);
		pk.setNumPokemon(9);
		lista.add(pk);
		pk = new Agua("Slowpoke", 48,70,48,0);
		pk.setNumPokemon(79);
		lista.add(pk);
		pk = new Agua("Psyduck", 48,48,32,0);
		pk.setNumPokemon(54);
		lista.add(pk);
		pk = new Electrico("Pikachu", 48,48,48,0);
		pk.setNumPokemon(25);
		lista.add(pk);
		pk = new Electrico("Magnemite", 48,48,48,0);
		pk.setNumPokemon(81);
		lista.add(pk);
		pk = new Electrico("Voltorb", 48,48,32,0);
		pk.setNumPokemon(100);
		lista.add(pk);
		pk = new Fuego("Ponyta", 48,48,32,0);
		pk.setNumPokemon(77);
		lista.add(pk);
		pk = new Fuego("Arcanine", 50,108,48,0);
		pk.setNumPokemon(59);
		lista.add(pk);

		pk = new Planta("Oddish", 48,48,32,0);
		pk.setNumPokemon(43);
		lista.add(pk);
		pk = new Planta("Exeggutor", 90,48,48,0);
		pk.setNumPokemon(103);
		lista.add(pk);
		return lista.get(rn.nextInt(0,11));
	}
	public Pokemon createPokemon2 (/*String tipo, String pNombre, int pVida, int pAtaque, int pDefensa, int pNumEvoluciones*/)
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
			// GUIA : Simplemente agrega un pequeño valor aleatorio a los parametros pasados para darle un poco de aleatoriedad
	
			unPokemon = new Agua("Ditto", 48, 48, 48, 0);
			
			// GUIA : Quedando esto claro vamos a volver a la lista combatientes para seguir con el metodo iniciarCombate
			// GUIA : Siganme ...
		}
		/*
		 Importar random para poder crear los pokemon, además de intentar utilizar Java8 para obtener los pokemon adecuados respecto al tipo, en este caso que en la misma constructora sea random por cada tipo.
		 El algoritmo seria el siguiente:
		 1- Un random de 1 a 4 para determinar de que tipo sale el pokemon.
		 2- Usar Java8 para hacer un STREAM  									(nota, para esto habría que crear una MAE con todos los pokemon)
		 
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
