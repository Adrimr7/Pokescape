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
		listaPokemon = new Pokemon[pNumPoke];
		for (int i = 0; i< pNumPoke; i++)
		{
			listaPokemon[i] = PokeFactory.getMiPokeFactory().createPokemon();
		}
	}
}