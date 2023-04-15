import java.util.*; 
import java.util.ArrayList;
import java.util.Random;

public class PokeFactory 
{
	private static PokeFactory miPokeFactory;	
	//private HashMap<Integer,Pokemon> listaEfi = new HashMap<Integer,Pokemon>();
	
	private HashMap<Integer,String> nomPokemon = new HashMap<Integer,String>();
	private HashMap<Integer,String> tipoPokemon = new HashMap<Integer,String>();
	private HashMap<Integer,Integer> evoPokemon = new HashMap<Integer,Integer>();
	
	private PokeFactory() { 
		
		nomPokemon.put(1, "Bulbasaur");
		tipoPokemon.put(1, "Planta");
		evoPokemon.put(1, 2);

		nomPokemon.put(2, "Ivysaur");
		tipoPokemon.put(2, "Planta");
		evoPokemon.put(2, 1);

		nomPokemon.put(3, "Venusaur");
		tipoPokemon.put(3, "Planta");
		evoPokemon.put(3, 0);

		nomPokemon.put(4, "Charmander");
		tipoPokemon.put(4, "Fuego");
		evoPokemon.put(4, 2);

		nomPokemon.put(5, "Charmeleon");
		tipoPokemon.put(5, "Fuego");
		evoPokemon.put(5, 1);

		nomPokemon.put(6, "Charizard");
		tipoPokemon.put(6, "Fuego");
		evoPokemon.put(6, 0);

		nomPokemon.put(7, "Squirtle");
		tipoPokemon.put(7, "Agua");
		evoPokemon.put(7, 2);

		nomPokemon.put(8, "Wartortle");
		tipoPokemon.put(8, "Agua");
		evoPokemon.put(8, 1);

		nomPokemon.put(9, "Blastoise");
		tipoPokemon.put(9, "Agua");
		evoPokemon.put(9, 0);

		nomPokemon.put(25, "Pikachu");
		tipoPokemon.put(25,"Electrico");
		evoPokemon.put(25, 1);

		nomPokemon.put(26, "Raichu");
		tipoPokemon.put(26,"Electrico");
		evoPokemon.put(26, 0);

		nomPokemon.put(37, "Vulpix");
		tipoPokemon.put(37, "Fuego");
		evoPokemon.put(37, 1);

		nomPokemon.put(38, "Ninetales");
		tipoPokemon.put(38, "Fuego");
		evoPokemon.put(38, 0);

		nomPokemon.put(43, "Oddish");
		tipoPokemon.put(43, "Planta");
		evoPokemon.put(43, 2);

		nomPokemon.put(44, "Gloom");
		tipoPokemon.put(44, "Planta");
		evoPokemon.put(44, 1);

		nomPokemon.put(45, "Vileplume");
		tipoPokemon.put(45, "Planta");
		evoPokemon.put(45, 0);

		nomPokemon.put(54, "Psyduck");
		tipoPokemon.put(54, "Agua");
		evoPokemon.put(54, 1);

		nomPokemon.put(55, "Golduck");
		tipoPokemon.put(55, "Agua");
		evoPokemon.put(55, 0);

		nomPokemon.put(58, "Growlithe");
		tipoPokemon.put(58, "Fuego");
		evoPokemon.put(58, 1);

		nomPokemon.put(59, "Arcanine");
		tipoPokemon.put(59, "Fuego");
		evoPokemon.put(59, 0);

		nomPokemon.put(60, "Poliwag");
		tipoPokemon.put(60, "Agua");
		evoPokemon.put(60, 2);

		nomPokemon.put(61, "Poliwhirl");
		tipoPokemon.put(61, "Agua");
		evoPokemon.put(61, 1);

		nomPokemon.put(62, "Poliwrath");
		tipoPokemon.put(62, "Agua");
		evoPokemon.put(62, 0);

		nomPokemon.put(69, "Bellsprout");
		tipoPokemon.put(69, "Planta");
		evoPokemon.put(69, 2);

		nomPokemon.put(70, "Weepinbell");
		tipoPokemon.put(70, "Planta");
		evoPokemon.put(70, 1);

		nomPokemon.put(71, "Victreebel");
		tipoPokemon.put(71, "Planta");
		evoPokemon.put(71, 0);

		nomPokemon.put(72, "Tentacool");
		tipoPokemon.put(72, "Agua");
		evoPokemon.put(72, 1);

		nomPokemon.put(73, "Tentacruel");
		tipoPokemon.put(73, "Agua");
		evoPokemon.put(73, 0);

		nomPokemon.put(77, "Ponyta");
		tipoPokemon.put(77, "Fuego");
		evoPokemon.put(77, 1);

		nomPokemon.put(78, "Rapidash");
		tipoPokemon.put(78, "Fuego");
		evoPokemon.put(78, 0);

		nomPokemon.put(79, "Slowpoke");
		tipoPokemon.put(79, "Agua");
		evoPokemon.put(79, 1);

		nomPokemon.put(80, "Slowbro");
		tipoPokemon.put(80, "Agua");
		evoPokemon.put(80, 0);

		nomPokemon.put(81, "Magnemite");
		tipoPokemon.put(81,"Electrico");
		evoPokemon.put(81, 1);

		nomPokemon.put(82, "Magneton");
		tipoPokemon.put(82,"Electrico");
		evoPokemon.put(82, 0);

		nomPokemon.put(86, "Seel");
		tipoPokemon.put(86, "Agua");
		evoPokemon.put(86, 1);

		nomPokemon.put(87, "Dewgong");
		tipoPokemon.put(87, "Agua");
		evoPokemon.put(87, 0);

		nomPokemon.put(90, "Shellder");
		tipoPokemon.put(90, "Agua");
		evoPokemon.put(90, 1);

		nomPokemon.put(91, "Cloyster");
		tipoPokemon.put(91, "Agua");
		evoPokemon.put(91, 0);

		nomPokemon.put(98, "Krabby");
		tipoPokemon.put(98, "Agua");
		evoPokemon.put(98, 1);

		nomPokemon.put(99, "Kingler");
		tipoPokemon.put(99, "Agua");
		evoPokemon.put(99, 0);

		nomPokemon.put(100, "Voltorb");
		tipoPokemon.put(100,"Electrico");
		evoPokemon.put(100, 1);

		nomPokemon.put(101, "Electrode");
		tipoPokemon.put(101,"Electrico");
		evoPokemon.put(101, 0);

		nomPokemon.put(102, "Exeggcute");
		tipoPokemon.put(102, "Planta");
		evoPokemon.put(102, 1);

		nomPokemon.put(103, "Exeggutor");
		tipoPokemon.put(103, "Planta");
		evoPokemon.put(103, 0);

		nomPokemon.put(114, "Tangela");
		tipoPokemon.put(114, "Planta");
		evoPokemon.put(114, 0);

		nomPokemon.put(116, "Horsea");
		tipoPokemon.put(116, "Agua");
		evoPokemon.put(116, 1);

		nomPokemon.put(117, "Seadra");
		tipoPokemon.put(117, "Agua");
		evoPokemon.put(117, 0);

		nomPokemon.put(118, "Goldeen");
		tipoPokemon.put(118, "Agua");
		evoPokemon.put(118, 1);

		nomPokemon.put(119, "Seaking");
		tipoPokemon.put(119, "Agua");
		evoPokemon.put(119, 0);

		nomPokemon.put(120, "Staryu");
		tipoPokemon.put(120, "Agua");
		evoPokemon.put(120, 1);

		nomPokemon.put(121, "Starmie");
		tipoPokemon.put(121, "Agua");
		evoPokemon.put(121, 0);

		nomPokemon.put(125, "Electabuzz");
		tipoPokemon.put(125,"Electrico");
		evoPokemon.put(125, 0);

		nomPokemon.put(126, "Magmar");
		tipoPokemon.put(126, "Fuego");
		evoPokemon.put(126, 0);

		nomPokemon.put(129, "Magikarp");
		tipoPokemon.put(129, "Agua");
		evoPokemon.put(129, 1);

		nomPokemon.put(130, "Gyarados");
		tipoPokemon.put(130, "Agua");
		evoPokemon.put(130, 0);

		nomPokemon.put(131, "Lapras");
		tipoPokemon.put(131, "Agua");
		evoPokemon.put(131, 0);

		nomPokemon.put(134, "Vaporeon");
		tipoPokemon.put(134, "Agua");
		evoPokemon.put(134, 0);

		nomPokemon.put(135, "Jolteon");
		tipoPokemon.put(135,"Electrico");
		evoPokemon.put(135, 0);

		nomPokemon.put(136, "Flareon");
		tipoPokemon.put(136, "Fuego");
		evoPokemon.put(136, 0);

		nomPokemon.put(145, "Zapdos");
		tipoPokemon.put(145,"Electrico");
		evoPokemon.put(145, 0);

		nomPokemon.put(146, "Moltres");
		tipoPokemon.put(146, "Fuego");
		evoPokemon.put(146, 0);


		
		
		
		
		/*
		Pokemon pk;
		
		int vida = 200;
		int ataque = 11;
		int defensa = 3;
		
		pk = new Planta("Bulbasaur", vida, ataque, defensa, 2);
		pk.setNumPokemon(1);
		listaEfi.put(1, pk);

		pk = new Planta("Ivysaur", vida, ataque, defensa, 1);
		pk.setNumPokemon(2);
		listaEfi.put(2, pk);

		pk = new Planta("Venusaur", vida, ataque, defensa, 0);
		pk.setNumPokemon(3);
		listaEfi.put(3, pk);

		pk = new Fuego("Charmander", vida, ataque, defensa, 2);
		pk.setNumPokemon(4);
		listaEfi.put(4, pk);

		pk = new Fuego("Charmeleon", vida, ataque, defensa, 1);
		pk.setNumPokemon(5);
		listaEfi.put(5, pk);

		pk = new Fuego("Charizard", vida, ataque, defensa, 0);
		pk.setNumPokemon(6);
		listaEfi.put(6, pk);

		pk = new Agua("Squirtle", vida, ataque, defensa, 2);
		pk.setNumPokemon(7);
		listaEfi.put(7, pk);

		pk = new Agua("Wartortle", vida, ataque, defensa, 1);
		pk.setNumPokemon(8);
		listaEfi.put(8, pk);

		pk = new Agua("Blastoise", vida, ataque, defensa, 0);
		pk.setNumPokemon(9);
		listaEfi.put(9, pk);

		pk = new Electrico("Pikachu", vida, ataque, defensa, 1);
		pk.setNumPokemon(25);
		listaEfi.put(25, pk);

		pk = new Electrico("Raichu", vida, ataque, defensa, 0);
		pk.setNumPokemon(26);
		listaEfi.put(26, pk);

		pk = new Fuego("Vulpix", vida, ataque, defensa, 1);
		pk.setNumPokemon(37);
		listaEfi.put(37, pk);

		pk = new Fuego("Ninetales", vida, ataque, defensa, 0);
		pk.setNumPokemon(38);
		listaEfi.put(38, pk);

		pk = new Planta("Oddish", vida, ataque, defensa, 2);
		pk.setNumPokemon(43);
		listaEfi.put(39, pk);

		pk = new Planta("Gloom", vida, ataque, defensa, 1);
		pk.setNumPokemon(44);
		listaEfi.put(44, pk);

		pk = new Planta("Vileplume", vida, ataque, defensa, 0);
		pk.setNumPokemon(45);
		listaEfi.put(45, pk);

		pk = new Agua("Psyduck", vida, ataque, defensa, 1);
		pk.setNumPokemon(54);
		listaEfi.put(54, pk);

		pk = new Agua("Golduck", vida, ataque, defensa, 0);
		pk.setNumPokemon(55);
		listaEfi.put(55, pk);

		pk = new Fuego("Growlithe", vida, ataque, defensa, 1);
		pk.setNumPokemon(58);
		listaEfi.put(58, pk);

		pk = new Fuego("Arcanine", vida, ataque, defensa, 0);
		pk.setNumPokemon(59);
		listaEfi.put(59, pk);

		pk = new Agua("Poliwag", vida, ataque, defensa, 2);
		pk.setNumPokemon(60);
		listaEfi.put(60, pk);

		pk = new Agua("Poliwhirl", vida, ataque, defensa, 1);
		pk.setNumPokemon(61);
		listaEfi.put(61, pk);

		pk = new Agua("Poliwrath", vida, ataque, defensa, 0);
		pk.setNumPokemon(62);
		listaEfi.put(62, pk);

		pk = new Planta("Bellsprout", vida, ataque, defensa, 2);
		pk.setNumPokemon(69);
		listaEfi.put(69, pk);

		pk = new Planta("Weepinbell", vida, ataque, defensa, 1);
		pk.setNumPokemon(70);
		listaEfi.put(70, pk);

		pk = new Planta("Victreebel", vida, ataque, defensa, 0);
		pk.setNumPokemon(71);
		listaEfi.put(71, pk);

		pk = new Agua("Tentacool", vida, ataque, defensa, 1);
		pk.setNumPokemon(72);
		listaEfi.put(72, pk);

		pk = new Agua("Tentacruel", vida, ataque, defensa, 0);
		pk.setNumPokemon(73);
		listaEfi.put(73, pk);

		pk = new Fuego("Ponyta", vida, ataque, defensa, 1);
		pk.setNumPokemon(77);
		listaEfi.put(77, pk);

		pk = new Fuego("Rapidash", vida, ataque, defensa, 0);
		pk.setNumPokemon(78);
		listaEfi.put(78, pk);

		pk = new Agua("Slowpoke", vida, ataque, defensa, 1);
		pk.setNumPokemon(79);
		listaEfi.put(79, pk);

		pk = new Agua("Slowbro", vida, ataque, defensa, 0);
		pk.setNumPokemon(80);
		listaEfi.put(80, pk);

		pk = new Electrico("Magnemite", vida, ataque, defensa, 1);
		pk.setNumPokemon(81);
		listaEfi.put(81, pk);

		pk = new Electrico("Magneton", vida, ataque, defensa, 0);
		pk.setNumPokemon(82);
		listaEfi.put(82, pk);

		pk = new Agua("Seel", vida, ataque, defensa, 1);
		pk.setNumPokemon(86);
		listaEfi.put(86, pk);

		pk = new Agua("Dewgong", vida, ataque, defensa, 0);
		pk.setNumPokemon(87);
		listaEfi.put(87, pk);

		pk = new Agua("Shellder", vida, ataque, defensa, 1);
		pk.setNumPokemon(90);
		listaEfi.put(90, pk);

		pk = new Agua("Cloyster", vida, ataque, defensa, 0);
		pk.setNumPokemon(91);
		listaEfi.put(91, pk);

		pk = new Agua("Krabby", vida, ataque, defensa, 1);
		pk.setNumPokemon(98);
		listaEfi.put(98, pk);

		pk = new Agua("Kingler", vida, ataque, defensa, 0);
		pk.setNumPokemon(99);
		listaEfi.put(99, pk);

		pk = new Electrico("Voltorb", vida, ataque, defensa, 1);
		pk.setNumPokemon(100);
		listaEfi.put(100, pk);

		pk = new Electrico("Electrode", vida, ataque, defensa, 0);
		pk.setNumPokemon(101);
		listaEfi.put(101, pk);

		pk = new Planta("Exeggcute", vida, ataque, defensa, 1);
		pk.setNumPokemon(102);
		listaEfi.put(102, pk);

		pk = new Planta("Exeggutor", vida, ataque, defensa, 0);
		pk.setNumPokemon(103);
		listaEfi.put(103, pk);

		pk = new Planta("Tangela", vida, ataque, defensa, 0);
		pk.setNumPokemon(114);
		listaEfi.put(114, pk);

		pk = new Agua("Horsea", vida, ataque, defensa, 1);
		pk.setNumPokemon(116);
		listaEfi.put(116, pk);

		pk = new Agua("Seadra", vida, ataque, defensa, 0);
		pk.setNumPokemon(117);
		listaEfi.put(117, pk);

		pk = new Agua("Goldeen", vida, ataque, defensa, 1);
		pk.setNumPokemon(118);
		listaEfi.put(118, pk);

		pk = new Agua("Seaking", vida, ataque, defensa, 0);
		pk.setNumPokemon(119);
		listaEfi.put(119, pk);

		pk = new Agua("Staryu", vida, ataque, defensa, 1);
		pk.setNumPokemon(120);
		listaEfi.put(120, pk);

		pk = new Agua("Starmie", vida, ataque, defensa, 0);
		pk.setNumPokemon(121);
		listaEfi.put(121, pk);

		pk = new Electrico("Electabuzz", vida, ataque, defensa, 0);
		pk.setNumPokemon(125);
		listaEfi.put(125, pk);

		pk = new Fuego("Magmar", vida, ataque, defensa, 0);
		pk.setNumPokemon(126);
		listaEfi.put(126, pk);

		pk = new Agua("Magikarp", vida, ataque, defensa, 1);
		pk.setNumPokemon(129);
		listaEfi.put(129, pk);

		pk = new Agua("Gyarados", vida, ataque, defensa, 0);
		pk.setNumPokemon(130);
		listaEfi.put(130, pk);

		pk = new Agua("Lapras", vida, ataque, defensa, 0);
		pk.setNumPokemon(131);
		listaEfi.put(131, pk);

		pk = new Agua("Vaporeon", vida, ataque, defensa, 0);
		pk.setNumPokemon(134);
		listaEfi.put(134, pk);
		
		pk = new Electrico("Jolteon", vida, ataque, defensa, 0);
		pk.setNumPokemon(135);
		listaEfi.put(135, pk);

		pk = new Fuego("Flareon", vida, ataque, defensa, 0);
		pk.setNumPokemon(136);
		listaEfi.put(136, pk);

		pk = new Electrico("Zapdos", vida, ataque, defensa, 0);
		pk.setNumPokemon(145);
		listaEfi.put(145, pk);

		pk = new Fuego("Moltres", vida, ataque, defensa, 0);
		pk.setNumPokemon(146);
		listaEfi.put(146, pk);
		 */
	}
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
		int vida = 200;
		int ataque = 11;
		int defensa = 3;
		
		Pokemon poke = null;
		Random rn = new Random();		
		ArrayList<Integer> arrayNumeros = new ArrayList<Integer>(nomPokemon.keySet());
		int numPoke = arrayNumeros.get(rn.nextInt(arrayNumeros.size()));
		String nombrePoke = nomPokemon.get(numPoke);
		String tipoPoke = tipoPokemon.get(numPoke);
		int	evoPoke = evoPokemon.get(numPoke);
		
		
		if(tipoPoke.equals("Planta"))
		{
			poke = new Planta(nombrePoke, vida, ataque, defensa, evoPoke, numPoke);
			
		}
		else if(tipoPoke.equals("Fuego"))
		{
			poke = new Fuego(nombrePoke, vida, ataque, defensa, evoPoke, numPoke);
		
		}
		else if(tipoPoke.equals("Agua"))
		{
			poke = new Agua(nombrePoke, vida, ataque, defensa, evoPoke, numPoke);
			
		}
		else if(tipoPoke.equals("Electrico"))
		{
			poke = new Electrico(nombrePoke, vida, ataque, defensa, evoPoke, numPoke);
			
		}
		
		return poke;
				
	}
	
	public String getEvolName(int pIdPoke) {
		return nomPokemon.get(pIdPoke);
	}
}
