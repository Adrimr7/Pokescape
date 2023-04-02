import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ListaCombatientes 
{
	private static ListaCombatientes miListaCombatientes;
	private Combatiente[] arrayCombatientes;
	
	private ListaCombatientes () {}
	public static ListaCombatientes getMiListaCombatientes()
	{
		if (miListaCombatientes == null)
		{
			miListaCombatientes = new ListaCombatientes();
		}
		return miListaCombatientes;
	}
	public void iniciarCombate(int numBots, int numJugs, int numPoke)
	{
		// GUIA (7)
		// GUIA : Pues la historia continua en esta bonita MAE que guardara a los diferentes luchadores de hoy
		
		// GUIA : Para empezar, preparamos el alojamiento, del tamaño exacto para los concursantes
		arrayCombatientes = new Combatiente[numBots + numJugs];
		
		// GUIA : Empezaremos por los humanos y luego los NPC
		
    	for (int i = 0; i<numJugs; i++)
    	{
    		// GUIA : Creamos un nuevo humano
    		arrayCombatientes[i] = new Humano("NombreHumano", i);		
    		// GUIA : Y le pedimos que se prepare, este se encargara de todo lo que necesite
    		// GUIA : Dicho esto, vamos a ver como funciona "inicializate" de la clase Combatiente
    		// GUIA : Antes de nada, cabe recalacar que Humano y NPC son dos clases que heredan de combatiente.
    		// GUIA : Seguidme ... 
 
    		arrayCombatientes[i].inicializate(i, i, numPoke);
    	
    	}
    	
		// GUIA (10)
		// GUIA : Bien, quedando explicado como nacen los pokemon volveremos directamnte a iniciarCombate de Pokescape
		// GUIA : Daremos por enseñado como se crean los NPC, por que son lo mismo que los humanos 
		// GUIA : Seguidme...
    	for (int i = 0; i<numBots; i++)
    	{
    		
    		arrayCombatientes[i + numJugs] = new NPC("NombreNPC", i + numJugs);
    		System.out.println("Bot : " + (i+numJugs));
    		arrayCombatientes[i + numJugs].inicializate(i, i+numJugs, numPoke);
    	}
    	

		
	}
	
	public Combatiente getCombatiente (int i)
	{
		return arrayCombatientes[i];
	}
	
	public void daAvisos() 
	{
		for(int i = 0; i < arrayCombatientes.length; i++) 
		{
			arrayCombatientes[i].daAviso();
		}
	}
	
	public boolean estanVivos() 
	{
		int j = 0;
		for(int i = 0; i < arrayCombatientes.length; i++) 
		{
			if(arrayCombatientes[i].estaVivo())
			{
				j++;
			}
		}
		
		boolean ret = false;
		
		if(j > 1)
		{
			ret = true;
		}
		
		return true;
	}
	
	public void escogeCombatiente()
	{
		System.out.println("SE PASA TURNO");
		Random rn = new Random();
		if(arrayCombatientes.length == 1)
		{
			Timer t = new Timer();
			TimerTask tt = new TimerTask() {@Override public void run() {arrayCombatientes[0].tuTurno();}};
			t.schedule(tt, 500);
			
		}
		else
		{
			Timer t = new Timer();
			TimerTask tt = new TimerTask() {@Override public void run() {arrayCombatientes[rn.nextInt(0,arrayCombatientes.length)].tuTurno();}};
			t.schedule(tt, 500);
		}
	}
	
	public Combatiente obtenerCombatienteAleatorio()
	{
		Random rn = new Random();
		return arrayCombatientes[rn.nextInt(0,arrayCombatientes.length)];
	}
	public void debilitar(int pIdPokemon, int pIdCombatiente) 
	{	
		arrayCombatientes[pIdCombatiente].debilitar(pIdPokemon);
	}
	public Pokemon escogerObjetivo(int pId)
	{
		Random rn = new Random();
		Combatiente combee = null;
		int idRandom = rn.nextInt(arrayCombatientes.length);
		//System.out.println("Bucle : pId = " + pId + " , combee = " + idRandom);
		combee = arrayCombatientes[idRandom];
		while ((idRandom == pId) || (combee == null))
		{
			idRandom = rn.nextInt(arrayCombatientes.length);
			combee = arrayCombatientes[idRandom];
			//System.out.println(combee.getId());
		}
		System.out.println("Bucle : pId = " + pId + " , combee = " + idRandom);
		//System.out.println("Entrar escoger objetivo");
		Pokemon poke = combee.escogerObjetivo();
		//System.out.println("NaCli escoger objetivo");
		return poke;
	}
	
	public void seleccionado(int idJug, int idPoke) 
	{
		arrayCombatientes[idJug].atacaCon(idPoke);
	}
}
