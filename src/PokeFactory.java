import java.util.*; 
import java.util.ArrayList;
import java.util.Random;

public class PokeFactory 
{
	private static PokeFactory miPokeFactory;	
	private HashMap<Integer,Pokemon> listaEfi = new HashMap<Integer,Pokemon>();
	
	private PokeFactory() { 
		
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
		Pokemon rdo=null;
		Random rn = new Random();		
		ArrayList<Integer> keysAsArray = new ArrayList<Integer>(listaEfi.keySet());
		Pokemon pk=listaEfi.get(keysAsArray.get(rn.nextInt(keysAsArray.size())));
		
		//Pokemon pk= lista.get(rn.nextInt(0,lista.size()));
		
		try {
			rdo = pk.clone();
			if (pk==rdo) {
				System.out.println("MISMA REFERENCIA");
			}else {
				System.out.println("DIFF REFERENCIA");
			}
		}
		catch(CloneNotSupportedException e) {
			System.out.println("ERROR");
		}
		
		return rdo;
				
	}
	
	public String getEvolName(int pIdPoke) {
		return listaEfi.get(pIdPoke).getNombre();
	}
}
