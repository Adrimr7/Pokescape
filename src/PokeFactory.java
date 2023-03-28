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
		pk = new Planta("Bulbasaur", 200, 11, 3, 0);
		pk.setNumPokemon(1);
		lista.add(pk);

		pk = new Planta("Ivysaur", 200, 11, 3, 0);
		pk.setNumPokemon(2);
		lista.add(pk);

		pk = new Planta("Venusaur", 200, 11, 3, 0);
		pk.setNumPokemon(3);
		lista.add(pk);

		pk = new Fuego("Charmander", 200, 11, 3, 0);
		pk.setNumPokemon(4);
		lista.add(pk);

		pk = new Fuego("Charmeleon", 200, 11, 3, 0);
		pk.setNumPokemon(5);
		lista.add(pk);

		pk = new Fuego("Charizard", 200, 11, 3, 0);
		pk.setNumPokemon(6);
		lista.add(pk);

		pk = new Agua("Squirtle", 200, 11, 3, 0);
		pk.setNumPokemon(7);
		lista.add(pk);

		pk = new Agua("Wartortle", 200, 11, 3, 0);
		pk.setNumPokemon(8);
		lista.add(pk);

		pk = new Agua("Blastoise", 200, 11, 3, 0);
		pk.setNumPokemon(9);
		lista.add(pk);

		pk = new Electrico("Pikachu", 200, 11, 3, 0);
		pk.setNumPokemon(25);
		lista.add(pk);

		pk = new Electrico("Raichu", 200, 11, 3, 0);
		pk.setNumPokemon(26);
		lista.add(pk);

		pk = new Fuego("Vulpix", 200, 11, 3, 0);
		pk.setNumPokemon(37);
		lista.add(pk);

		pk = new Fuego("Ninetales", 200, 11, 3, 0);
		pk.setNumPokemon(38);
		lista.add(pk);

		pk = new Planta("Oddish", 200, 11, 3, 0);
		pk.setNumPokemon(43);
		lista.add(pk);

		pk = new Planta("Gloom", 200, 11, 3, 0);
		pk.setNumPokemon(44);
		lista.add(pk);

		pk = new Planta("Vileplume", 200, 11, 3, 0);
		pk.setNumPokemon(45);
		lista.add(pk);

		pk = new Agua("Psyduck", 200, 11, 3, 0);
		pk.setNumPokemon(54);
		lista.add(pk);

		pk = new Agua("Golduck", 200, 11, 3, 0);
		pk.setNumPokemon(55);
		lista.add(pk);

		pk = new Fuego("Growlithe", 200, 11, 3, 0);
		pk.setNumPokemon(58);
		lista.add(pk);

		pk = new Fuego("Arcanine", 200, 11, 3, 0);
		pk.setNumPokemon(59);
		lista.add(pk);

		pk = new Agua("Poliwag", 200, 11, 3, 0);
		pk.setNumPokemon(60);
		lista.add(pk);

		pk = new Agua("Poliwhirl", 200, 11, 3, 0);
		pk.setNumPokemon(61);
		lista.add(pk);

		pk = new Agua("Poliwrath", 200, 11, 3, 0);
		pk.setNumPokemon(62);
		lista.add(pk);

		pk = new Planta("Bellsprout", 200, 11, 3, 0);
		pk.setNumPokemon(69);
		lista.add(pk);

		pk = new Planta("Weepinbell", 200, 11, 3, 0);
		pk.setNumPokemon(70);
		lista.add(pk);

		pk = new Planta("Victreebel", 200, 11, 3, 0);
		pk.setNumPokemon(71);
		lista.add(pk);

		pk = new Agua("Tentacool", 200, 11, 3, 0);
		pk.setNumPokemon(72);
		lista.add(pk);

		pk = new Agua("Tentacruel", 200, 11, 3, 0);
		pk.setNumPokemon(73);
		lista.add(pk);

		pk = new Fuego("Ponyta", 200, 11, 3, 0);
		pk.setNumPokemon(77);
		lista.add(pk);

		pk = new Fuego("Rapidash", 200, 11, 3, 0);
		pk.setNumPokemon(78);
		lista.add(pk);

		pk = new Agua("Slowpoke", 200, 11, 3, 0);
		pk.setNumPokemon(79);
		lista.add(pk);

		pk = new Agua("Slowbro", 200, 11, 3, 0);
		pk.setNumPokemon(80);
		lista.add(pk);

		pk = new Electrico("Magnemite", 200, 11, 3, 0);
		pk.setNumPokemon(81);
		lista.add(pk);

		pk = new Electrico("Magneton", 200, 11, 3, 0);
		pk.setNumPokemon(82);
		lista.add(pk);

		pk = new Agua("Seel", 200, 11, 3, 0);
		pk.setNumPokemon(86);
		lista.add(pk);

		pk = new Agua("Dewgong", 200, 11, 3, 0);
		pk.setNumPokemon(87);
		lista.add(pk);

		pk = new Agua("Shellder", 200, 11, 3, 0);
		pk.setNumPokemon(90);
		lista.add(pk);

		pk = new Agua("Cloyster", 200, 11, 3, 0);
		pk.setNumPokemon(91);
		lista.add(pk);

		pk = new Agua("Krabby", 200, 11, 3, 0);
		pk.setNumPokemon(98);
		lista.add(pk);

		pk = new Agua("Kingler", 200, 11, 3, 0);
		pk.setNumPokemon(99);
		lista.add(pk);

		pk = new Electrico("Voltorb", 200, 11, 3, 0);
		pk.setNumPokemon(100);
		lista.add(pk);

		pk = new Electrico("Electrode", 200, 11, 3, 0);
		pk.setNumPokemon(101);
		lista.add(pk);

		pk = new Planta("Exeggcute", 200, 11, 3, 0);
		pk.setNumPokemon(102);
		lista.add(pk);

		pk = new Planta("Exeggutor", 200, 11, 3, 0);
		pk.setNumPokemon(103);
		lista.add(pk);

		pk = new Planta("Tangela", 200, 11, 3, 0);
		pk.setNumPokemon(114);
		lista.add(pk);

		pk = new Agua("Horsea", 200, 11, 3, 0);
		pk.setNumPokemon(116);
		lista.add(pk);

		pk = new Agua("Seadra", 200, 11, 3, 0);
		pk.setNumPokemon(117);
		lista.add(pk);

		pk = new Agua("Goldeen", 200, 11, 3, 0);
		pk.setNumPokemon(118);
		lista.add(pk);

		pk = new Agua("Seaking", 200, 11, 3, 0);
		pk.setNumPokemon(119);
		lista.add(pk);

		pk = new Agua("Staryu", 200, 11, 3, 0);
		pk.setNumPokemon(120);
		lista.add(pk);

		pk = new Agua("Starmie", 200, 11, 3, 0);
		pk.setNumPokemon(121);
		lista.add(pk);

		pk = new Electrico("Electabuzz", 200, 11, 3, 0);
		pk.setNumPokemon(125);
		lista.add(pk);

		pk = new Fuego("Magmar", 200, 11, 3, 0);
		pk.setNumPokemon(126);
		lista.add(pk);

		pk = new Agua("Magikarp", 200, 11, 3, 0);
		pk.setNumPokemon(129);
		lista.add(pk);

		pk = new Agua("Gyarados", 200, 11, 3, 0);
		pk.setNumPokemon(130);
		lista.add(pk);

		pk = new Agua("Lapras", 200, 11, 3, 0);
		pk.setNumPokemon(131);
		lista.add(pk);

		pk = new Agua("Vaporeon", 200, 11, 3, 0);
		pk.setNumPokemon(134);
		lista.add(pk);

		pk = new Electrico("Jolteon", 200, 11, 3, 0);
		pk.setNumPokemon(135);
		lista.add(pk);

		pk = new Fuego("Flareon", 200, 11, 3, 0);
		pk.setNumPokemon(136);
		lista.add(pk);

		pk = new Electrico("Zapdos", 200, 11, 3, 0);
		pk.setNumPokemon(145);
		lista.add(pk);

		pk = new Fuego("Moltres", 200, 11, 3, 0);
		pk.setNumPokemon(146);
		lista.add(pk);




		return lista.get(rn.nextInt(0,lista.size()));
		
		
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
