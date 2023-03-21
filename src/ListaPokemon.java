public class ListaPokemon 
{
	private Pokemon[] arrayPokemon;
	
	public ListaPokemon(int pTam) 
	{
		if (arrayPokemon == null) {arrayPokemon = new Pokemon[pTam];}
	}
	
	private void cargarPokemon() {};
	private void metodo1() {};
	private void metodo2() {};
	private void metodo3() {}

	public void anadirPokemon(Pokemon poke) 
	{
		// TODO Auto-generated method stub
		
	}
	public void inicializate()
	{
		for (int i = 0; i< arrayPokemon.length; i++)
		{
			// TODO DETERMINAR EL POKEMON ALEATORIO!!!!!!!!!!
			// TODO DETERMINAR EL POKEMON ALEATORIO!!!!!!!!!!
			// TODO DETERMINAR EL POKEMON ALEATORIO!!!!!!!!!!
			arrayPokemon[i] = PokeFactory.getMiPokeFactory().createPokemon(null, null, i, i, i, i);
		}
	}
}
