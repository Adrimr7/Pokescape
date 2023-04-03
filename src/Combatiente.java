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
		nombre = pNombre;
		id = pId;
		enPie = true;
	}
	
	
	public void inicializate (int pNumComb, int pId, int pNumPoke)
	{
		// GUIA (8)
		// GUIA : Crea la lista donde se guardaran los pokemon
		arrayPokemon = new Pokemon[pNumPoke];
		usados = new boolean[pNumPoke];
		for (int i = 0; i < pNumPoke; i++)
		{
			// GUIA : Y le pide al Pokefactory que le los pokemon
			// GUIA : Seguidme ...
			arrayPokemon[i] = PokeFactory.getMiPokeFactory().createPokemon();
			arrayPokemon[i].setIdPokemon(i);
			arrayPokemon[i].setIdCombatiente(id);
		}
	}
	
	
	public void daAviso() 
	{
		System.out.println("Da aviso");
		setChanged();
		notifyObservers(new Object[] {0, id, nombre, arrayPokemon.length, id});
		
		for(int i = 0; i < arrayPokemon.length; i++) 
		{
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
		Random rn = new Random();
		int idRandom = rn.nextInt(0,arrayPokemon.length);
		
		//while (!arrayPokemon[idRandom].estaVivo())
		while (arrayPokemon[idRandom] == null)
		{
			idRandom = rn.nextInt(0,arrayPokemon.length);
		}
		return arrayPokemon[idRandom];
	}
	
	
	public void atacaCon(int idPoke)
	{
		if(arrayPokemon[idPoke] != null)
		{
			boolean rdo= CampoBatalla.getMiCampoBatalla().anadir(arrayPokemon[idPoke], id);
			
			if (rdo){
				usados[idPoke]=true;
			}
		}
	}
	
	
	public void finAtaque() {}
	
	
	public void pasaDeTurno()
	{
		setChanged();
		notifyObservers(new Object[] {2});
		ListaCombatientes.getMiListaCombatientes().escogeCombatiente();	
	}
	
	
	public void clickGo() {}
	
}