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
	
	public boolean danar(int pAtaque)
	{
		int dano = (pAtaque - defensa);
		System.out.println(vida);
		vida = vida - dano;
		if(vida < 0)
		{
			vida = 0;
		}
		System.out.println("Daño = " + dano);
		boolean vivo = estaVivo();
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
	
}
