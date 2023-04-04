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
		
		int vida = 200;
		int ataque = 30;
		int defensa = 3;
		int numEvo = 0;
		
		//Para las pruebas :
		
		vida = 200;
		
		pk = new Planta("Bulbasaur", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(1);
		lista.add(pk);

		pk = new Planta("Ivysaur", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(2);
		lista.add(pk);

		pk = new Planta("Venusaur", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(3);
		lista.add(pk);

		pk = new Fuego("Charmander", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(4);
		lista.add(pk);

		pk = new Fuego("Charmeleon", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(5);
		lista.add(pk);

		pk = new Fuego("Charizard", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(6);
		lista.add(pk);

		pk = new Agua("Squirtle", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(7);
		lista.add(pk);

		pk = new Agua("Wartortle", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(8);
		lista.add(pk);

		pk = new Agua("Blastoise", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(9);
		lista.add(pk);

		pk = new Electrico("Pikachu", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(25);
		lista.add(pk);

		pk = new Electrico("Raichu", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(26);
		lista.add(pk);

		pk = new Fuego("Vulpix", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(37);
		lista.add(pk);

		pk = new Fuego("Ninetales", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(38);
		lista.add(pk);

		pk = new Planta("Oddish", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(43);
		lista.add(pk);

		pk = new Planta("Gloom", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(44);
		lista.add(pk);

		pk = new Planta("Vileplume", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(45);
		lista.add(pk);

		pk = new Agua("Psyduck", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(54);
		lista.add(pk);

		pk = new Agua("Golduck", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(55);
		lista.add(pk);

		pk = new Fuego("Growlithe", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(58);
		lista.add(pk);

		pk = new Fuego("Arcanine", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(59);
		lista.add(pk);

		pk = new Agua("Poliwag", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(60);
		lista.add(pk);

		pk = new Agua("Poliwhirl", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(61);
		lista.add(pk);

		pk = new Agua("Poliwrath", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(62);
		lista.add(pk);

		pk = new Planta("Bellsprout", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(69);
		lista.add(pk);

		pk = new Planta("Weepinbell", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(70);
		lista.add(pk);

		pk = new Planta("Victreebel", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(71);
		lista.add(pk);

		pk = new Agua("Tentacool", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(72);
		lista.add(pk);

		pk = new Agua("Tentacruel", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(73);
		lista.add(pk);

		pk = new Fuego("Ponyta", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(77);
		lista.add(pk);

		pk = new Fuego("Rapidash", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(78);
		lista.add(pk);

		pk = new Agua("Slowpoke", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(79);
		lista.add(pk);

		pk = new Agua("Slowbro", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(80);
		lista.add(pk);

		pk = new Electrico("Magnemite", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(81);
		lista.add(pk);

		pk = new Electrico("Magneton", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(82);
		lista.add(pk);

		pk = new Agua("Seel", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(86);
		lista.add(pk);

		pk = new Agua("Dewgong", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(87);
		lista.add(pk);

		pk = new Agua("Shellder", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(90);
		lista.add(pk);

		pk = new Agua("Cloyster", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(91);
		lista.add(pk);

		pk = new Agua("Krabby", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(98);
		lista.add(pk);

		pk = new Agua("Kingler", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(99);
		lista.add(pk);

		pk = new Electrico("Voltorb", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(100);
		lista.add(pk);

		pk = new Electrico("Electrode", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(101);
		lista.add(pk);

		pk = new Planta("Exeggcute", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(102);
		lista.add(pk);

		pk = new Planta("Exeggutor", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(103);
		lista.add(pk);

		pk = new Planta("Tangela", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(114);
		lista.add(pk);

		pk = new Agua("Horsea", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(116);
		lista.add(pk);

		pk = new Agua("Seadra", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(117);
		lista.add(pk);

		pk = new Agua("Goldeen", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(118);
		lista.add(pk);

		pk = new Agua("Seaking", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(119);
		lista.add(pk);

		pk = new Agua("Staryu", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(120);
		lista.add(pk);

		pk = new Agua("Starmie", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(121);
		lista.add(pk);

		pk = new Electrico("Electabuzz", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(125);
		lista.add(pk);

		pk = new Fuego("Magmar", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(126);
		lista.add(pk);

		pk = new Agua("Magikarp", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(129);
		lista.add(pk);

		pk = new Agua("Gyarados", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(130);
		lista.add(pk);

		pk = new Agua("Lapras", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(131);
		lista.add(pk);

		pk = new Agua("Vaporeon", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(134);
		lista.add(pk);

		pk = new Electrico("Jolteon", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(135);
		lista.add(pk);

		pk = new Fuego("Flareon", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(136);
		lista.add(pk);

		pk = new Electrico("Zapdos", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(145);
		lista.add(pk);

		pk = new Fuego("Moltres", vida, ataque, defensa, numEvo);
		pk.setNumPokemon(146);
		lista.add(pk);



		return lista.get(rn.nextInt(0,lista.size()));
		
	}
}
