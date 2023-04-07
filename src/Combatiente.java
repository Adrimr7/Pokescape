import java.util.Observable;
import java.util.Random;
public abstract class Combatiente extends Observable 
{
	protected Pokemon[] arrayPokemon;
	protected String nombre;
	protected int id;
	private boolean enPie;
	protected boolean[] usados;
	
	public Combatiente(String pNombre, int pId)
	{
		// constructora
		nombre = pNombre;
		id = pId;
		enPie = true;
	}
	
	
	public void inicializate (int pNumComb, int pId, int pNumPoke)
	{
		// Crea la lista donde se guardaran los pokemon
		arrayPokemon = new Pokemon[pNumPoke];
		usados = new boolean[pNumPoke];
		for (int i = 0; i < pNumPoke; i++)
		{
			// Le pide al Pokefactory que le los pokemon
			arrayPokemon[i] = PokeFactory.getMiPokeFactory().createPokemon();
			arrayPokemon[i].setIdPokemon(i);
			arrayPokemon[i].setIdCombatiente(id);
		}
	}
	
	
	public void daAviso() 
	{
		// usamos este método para avisar a los pokemon y a los observers de los combatientes
		// que tienen que actualizarse
		System.out.println("Da aviso");
		setChanged();
		notifyObservers(new Object[] {0, id, nombre, arrayPokemon.length, id});
		
		for(int i = 0; i < arrayPokemon.length; i++) 
		{
			// dar aviso a cada pokemon
			arrayPokemon[i].daAviso();
		}
	}
	
	


	public Pokemon getPokemon(int i) { return arrayPokemon[i]; }
	
	public boolean estaVivo() { return enPie; }
	
	public int getId() { return id; }
	
	public void debilitar(int pIdPokemon){ arrayPokemon[pIdPokemon] = null; }
	
	
	// está vacío porque se sobreescribe en las clases herederas! (NPC y Humano)
	public void tuTurno(){}
	
	public Pokemon escogerObjetivo()
	{
		// este método escoge un objetivo y lo devuelve hacia arriba, comprobando varias cosas antes
		Random rn = new Random();
		int idRandom = rn.nextInt(0,arrayPokemon.length);
		while (arrayPokemon[idRandom] == null)
		{
			idRandom = rn.nextInt(0,arrayPokemon.length);
		}
		return arrayPokemon[idRandom];
	}
	
	
	public void atacaCon(int idPoke)
	{
		// este método añade el pokemon al campo de batalla si no es nulo
		if(arrayPokemon[idPoke] != null)
		{
			boolean rdo = CampoBatalla.getMiCampoBatalla().anadir(arrayPokemon[idPoke], id);
			
			if (rdo)
			{
				usados[idPoke]=true;
			}
		}
	}
	
	
	public void finAtaque() {}
	
	
	public void pasaDeTurno()
	{
		CampoBatalla.getMiCampoBatalla().finTurno();
		
		setChanged();
		notifyObservers(new Object[] {2});
		
		ListaCombatientes.getMilistaCombatientes().escogeCombatiente();	
	}
	
	
	public void derrotado()
	{
		System.out.println("");
		System.out.println("Me he muerto (" + nombre + ")");
		setChanged();
		notifyObservers(new Object[] {3});
	}
	
	
	public int numeroVivos()
	{
		int ret = 0;
		
		for(int i = 0; i < arrayPokemon.length; i++)
		{
			if(arrayPokemon[i] != null)
			{
				ret++;
			}
		}
		
		return ret;
	}
	
	public void hasGanado()
	{
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("FIN / HE GANADO");
		setChanged();
		notifyObservers(new Object[] {4});
	}
	
	
	public void clickGo() {}
	
}