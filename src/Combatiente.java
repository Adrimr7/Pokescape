import java.util.Observable;
import java.util.Random;
public abstract class Combatiente extends Observable 
{
	protected Pokemon[] arrayPokemon;
	private String nombre;
	private int id;
	private boolean enPie;
	
	public Combatiente(String pNombre, int pId)
	{
		nombre = pNombre;
		id = pId;
	}
	public void inicializate (int pNumComb, int pId, int pNumPoke)
	{
		System.out.println("Se ejecuta 'inicializate'");
		// GUIA (8)
		// GUIA : Pero que tenemos por aqui, no es difil ver que este luchador no hace mucho
		arrayPokemon = new Pokemon[pNumPoke];
		for (int i = 0; i < pNumPoke; i++)
		{
			// GUIA : A lo sumo, le pide al Pokefactory que le los pokemon
			// GUIA : Dicho esto, ya sabeis donde estare
			// GUIA : Seguidme ...
			System.out.println("Entramos a la factory de pokemon");
			arrayPokemon[i] = PokeFactory.getMiPokeFactory().createPokemon();
			arrayPokemon[i].setIdPokemon(i);
			arrayPokemon[i].setIdCombatiente(id);
		}
	}
	
	public Pokemon getPokemon(int i) 
	{
		return arrayPokemon[i];
	}
	
	public void daAviso() 
	{
		setChanged();
		notifyObservers(new Object[] {0, id, nombre, arrayPokemon.length, id});
		
		for(int i = 0; i < arrayPokemon.length; i++) 
		{
			arrayPokemon[i].daAviso();
		}
		
	}
	
	public boolean estaVivo()
	{
		return enPie;
	}
	
	
	public void tuTurno(){}
	
	
	public Pokemon obtenerPokemonAleatorio()
	{
		Random rn = new Random();
		return arrayPokemon[rn.nextInt(0,arrayPokemon.length-1)];
	}
	
	public void eliminarPokemon(Pokemon pPoke) 
	{
		for(int i = 0; i < arrayPokemon.length; i++) 
		{
			if (arrayPokemon[i] == pPoke) 
			{
				//Borrar pokemon???
			}
		}
	}
	public void debilitar(int pIdPokemon) 
	{
		this.arrayPokemon[pIdPokemon] = null;
	}
	
	public void escogerObjetivo()
	{
		Random rn = new Random();
		int idRandom = rn.nextInt(0,arrayPokemon.length-1);
		
		while (!arrayPokemon[idRandom].estaVivo())
		{
			idRandom = rn.nextInt(0,arrayPokemon.length-1);
		}
		Pokemon poke = arrayPokemon[idRandom];
	}
	
	public int getId() 
	{
		return id;
	}
	
	
	public void atacaCon(int idPoke)
	{
		if(arrayPokemon[idPoke] != null)
		{
		CampoBatalla.getMiCampoBatalla().anadir(arrayPokemon[idPoke], id);
		}
	}
	
}