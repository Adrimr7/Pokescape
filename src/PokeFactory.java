import java.util.*; 
import java.util.ArrayList;
import java.util.Random;

public class PokeFactory 
{
	private static PokeFactory miPokeFactory;	
	//private HashMap<Integer,Pokemon> listaEfi = new HashMap<Integer,Pokemon>();
	
	private HashMap<Integer,String> nomPokemon = new HashMap<Integer,String>();    //Relación ID con Nombre
	private HashMap<Integer,String> tipoPokemon = new HashMap<Integer,String>();   //Relación ID con Tipo
	private HashMap<Integer,Integer> evoPokemon = new HashMap<Integer,Integer>();  //Relación ID con Evoluciones Posibles
	
	private PokeFactory() { 
		
		//Insertamos los datos de los pokémon creables a los hashmap
		
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
		/*Creamos un pokémon aleatoriamente
		 
		 * Primero, establecemos las stats por defecto (enunciado del proyecto).
		 * Su incremento aleatorio se define en la constructora de la clase
		 * Pokemon.java
		 
		 * Segundo, creamos un arrayList con los elementos de uno de los hashmap,
		 * para poder obtener un elemento aleatorio de los hashmap. Téngase en cuenta que 
		 * no podemos generar directamente un ID de pokémon directamente, puesto que estos
		 * no siguen un orden. Para solucionarlo, creamos una lista que contenga todos los 
		 * ID y obtenemos un índice aleatorio de esa lista. El ID almacenado en dicho 
		 * índice será nuestro pokémon a crear.
		 
		 * Por último, conociendo el ID del pokémon obtenemos toda su información de los
		 * tres hashmaps, y en función del tipo generamos un tipo de Pokémon u otro.
		 
		 */
		
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
		if (evoPoke != 0) 
		{
			int cont = 0;
			while (cont < evoPoke) 
			{
				poke.setEvolNames(cont, nomPokemon.get(numPoke + cont + 1));
				System.out.println(nomPokemon.get(numPoke+cont+1));
				cont++;
			}
		}
		return poke;
	}
}
