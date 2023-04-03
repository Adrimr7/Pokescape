import java.util.Random;
import java.util.stream.Stream;
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
		vida = pVida + aleatorio.nextInt(1,21);
		ataque = pAtaque + aleatorio.nextInt(1,8);
		defensa = pDefensa + aleatorio.nextInt(1,5);
		
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
	
	public boolean danar(int pAtaque, String pTipo)
	{
		int dano;
		if (esDebil(pTipo))
		{
			pAtaque = pAtaque * 2;
		}
		dano = (pAtaque - defensa);
		vida = vida - dano;
		if(vida < 0)
		{
			vida = 0;
		}
		boolean vivo = estaVivo();
		setChanged();
		notifyObservers(new Object[] {nombre, vida, ataque, defensa, numPokemon, obtenerClase(), 1});
		return vivo;
	}
	
	private boolean esDebil(String pTipo) 
	{
		boolean bool = false;
		if (arrayDebilidades !=null)
		{
			bool = Stream.of(arrayDebilidades).anyMatch(tipo -> tipo.equals(pTipo));
		}
		return bool;
	}
	public int getAtaque(){ return ataque; }

	/*
	public int getDefensa() { return defensa; }
	*/
	public int getIdCombatiente(){ return idCombatiente; }
	
	public int getIdPokemon(){ return idPokemon; }
	
	public boolean estaVivo() {	return (vida>0); }
	
	public void setIdCombatiente(int pId){ idCombatiente = pId; }
	
	public void setIdPokemon(int pId){ idPokemon = pId;	}
	

	

	
}
