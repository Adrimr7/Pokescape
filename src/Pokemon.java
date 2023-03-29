import java.util.Random;
import java.util.Observable;
public abstract class Pokemon extends Observable
{
	protected int numPokemon;  // numero en pokedex
	protected int idPokemon;   // id del pokemon
	protected int idCombatiente;
	protected String nombre;
	protected int vida;
	protected int ataque;
	protected int defensa;
	protected int numEvoluciones; // TODO ****************
								// boolean Evoluciona --> Pokemon evolucion (Y cuando llegue a mitad de la vida actual cambia de pokemon)
	protected String[] arrayDebilidades;
	public Pokemon(String pNombre, int pVida, int pAtaque, int pDefensa, int pNumEvoluciones) 
	{
		nombre = pNombre;
		Random aleatorio = new Random();
		vida = pVida + aleatorio.nextInt(1,20);
		ataque = pAtaque + aleatorio.nextInt(1,7);
		defensa = pDefensa + aleatorio.nextInt(1,4);
		
	}
	public void daAviso() 
	{
		setChanged();
		notifyObservers(new Object[] {nombre, vida, ataque, defensa, numPokemon, obtenerClase(), 0});
		
	}
	public void setNumPokemon(int pNumPoke)
	{
		numPokemon = pNumPoke;
	}
	private String obtenerClase()
	{
		if((String) this.getClass().getSimpleName() == "Electrico")
		{
			return "Eléctrico";
		}
		else
		{
			return this.getClass().getSimpleName();
		}
	}
	/*
	public void ataca() 
	{
		Pokemon poke = ListaCombatientes.getMiListaCombatientes().obtenerCombatienteAleatorio().obtenerPokemonAleatorio();
		boolean vivo = poke.danar(ataque);
	}
	*/
	
	public boolean danar(int pAtaque)
	{
		int dano = (pAtaque - defensa);
		System.out.println(vida);
		vida = vida - dano;
		System.out.println("Daño = " + dano);
		boolean vivo = true;
		if(vida <= 0) 
		{
			vivo = false;
		}
		System.out.println(vida);
		setChanged();
		notifyObservers(new Object[] {nombre, vida, ataque, defensa, numPokemon, obtenerClase(), 1});
		
		return vivo;
	}
	
	public int getAtaque()
	{
		return ataque;
	}
	public int getDefensa()
	{
		return defensa;
	}
	public int getIdCombatiente()
	{
		return idCombatiente;
	}
	public void setIdCombatiente(int pId)
	{
		idCombatiente = pId;
	}
	public void setIdPokemon(int pId)
	{
		idPokemon = pId;
	}
	public int getIdPokemon()
	{
		return idPokemon;
	}
	public boolean estaVivo() 
	{
		
		return (vida>0);
	}
	
	
	/*
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
			arrayPokemon[i] = PokeFactory.getMiPokeFactory().createPokemon();
		}
	}
}
	 */
	
	
}
