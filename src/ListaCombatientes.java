import java.util.Random;

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
    		Humano comb = new Humano("NombreHumano", i);
    		arrayCombatientes[i] = comb;
    		
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
    		NPC comb = new NPC("NombreNPC", i + numJugs);
    		arrayCombatientes[i + numJugs] = comb;
    	
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
		Random rn = new Random();
		if(arrayCombatientes.length == 1)
		{
			arrayCombatientes[0].tuTurno();
		}
		else
		{
		arrayCombatientes[rn.nextInt(0,arrayCombatientes.length-1)].tuTurno();
		}
	}
	
	public Combatiente obtenerCombatienteAleatorio()
	{
		Random rn = new Random();
		return arrayCombatientes[rn.nextInt(0,arrayCombatientes.length-1)];
	}
	public void debilitar(int pIdPokemon, int pIdCombatiente) 
	{	
		arrayCombatientes[pIdCombatiente].debilitar(pIdPokemon);
	}
	public void escogerObjetivo(int pId)
	{
		Random rn = new Random();
		Combatiente combee = null;
		int idRandom = rn.nextInt(0,arrayCombatientes.length-1);
		System.out.println("Bucle : pId = " + pId + " , combee = " + idRandom);
		combee = arrayCombatientes[idRandom];
		while ((idRandom == pId) || (combee == null))
		{
			idRandom = rn.nextInt(0,arrayCombatientes.length-1);
			System.out.println("Bucle : pId = " + pId + " , combee = " + idRandom);
			combee = arrayCombatientes[idRandom];
		}
		System.out.println("Entrar escoger objetivo");
		combee.escogerObjetivo();
		System.out.println("NaCli escoger objetivo");
	}
	
	public void seleccionado(int idJug, int idPoke) 
	{
		arrayCombatientes[idJug].atacaCon(idPoke);
	}
}
