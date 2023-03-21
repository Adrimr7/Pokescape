
public abstract class Combatiente 
{
	private ListaPokemon listaPokemon;
	private String nombre;
	private int id;
	public Combatiente(String pNombre, int pId)
	{
		nombre = pNombre;
		id = pId;
	}
	public void inicializate (int pNumComb, int pId, int pNumPoke)
	{
		listaPokemon = new ListaPokemon(pNumPoke);
		listaPokemon.inicializate();
	}
}