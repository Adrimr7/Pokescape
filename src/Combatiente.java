
public abstract class Combatiente 
{
	private ListaPokemon listaPokemon;
	private String nombre;
	private int id;
	public Combatiente(ListaPokemon pListaPokemon, String pNombre, int pId)
	{
		listaPokemon = pListaPokemon;
		nombre = pNombre;
		id = pId;
	}
}
