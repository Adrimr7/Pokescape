import java.util.Observable;
public abstract class Combatiente extends Observable 
{
	private Pokemon[] listaPokemon;
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
		listaPokemon = new Pokemon[pNumPoke];
		for (int i = 0; i < pNumPoke; i++)
		{
			// GUIA : A lo sumo, le pide al Pokefactory que le los pokemon
			// GUIA : Dicho esto, ya sabeis donde estare
			// GUIA : Seguidme ...
			System.out.println("Entramos a la factory de pokemon");
			listaPokemon[i] = PokeFactory.getMiPokeFactory().createPokemon();
		}
	}
	
	public Pokemon getPokemon(int i) 
	{
		return listaPokemon[i];
	}
	
	public void daAviso() 
	{
		setChanged();
		notifyObservers(new Object[] {listaPokemon.length, id});
		
		for(int i = 0; i < listaPokemon.length; i++) 
		{
			listaPokemon[i].daAviso();
		}
		
	}
	
	public boolean estaVivo()
	{
		return enPie;
	}
	
	public void tuTurno()
	{
		System.out.println("Mi turno " + nombre);
	}
}