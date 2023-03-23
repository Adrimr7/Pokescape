import java.util.Observable;
public abstract class Combatiente extends Observable 
{
	private Pokemon[] listaPokemon;
	private String nombre;
	private int id;
	public Combatiente(String pNombre, int pId)
	{
		nombre = pNombre;
		id = pId;
	}
	public void inicializate (int pNumComb, int pId, int pNumPoke)
	{
		// GUIA (8)
		// GUIA : Pero que tenemos por aqui, no es difil ver que este luchador no hace mucho
		listaPokemon = new Pokemon[pNumPoke];
		for (int i = 0; i< pNumPoke; i++)
		{
			// GUIA : A lo sumo, le pide al Pokefactory que le los pokemon
			// GUIA : Dicho esto, ya sabeis donde estare
			// GUIA : Seguidme ...
			listaPokemon[i] = PokeFactory.getMiPokeFactory().createPokemon();
		}
	}
}