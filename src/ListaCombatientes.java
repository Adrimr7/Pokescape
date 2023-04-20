import java.util.Random;

public class ListaCombatientes 
{
	private static ListaCombatientes milistaCombatientes;
	private Combatiente[] arrayCombatientes;
	private int numCombatientes;
	private boolean finPartida;
	private ListaCombatientes() {}
	
	public static ListaCombatientes getMilistaCombatientes()
	{
		if (milistaCombatientes == null)
		{
			milistaCombatientes = new ListaCombatientes();
		}
		return milistaCombatientes;
	}
	
	public void iniciarCombate(int numBots, int numJugs, int numPoke, int nivel)
	{
		// GUIA (7)
		// GUIA : Pues la historia continua en esta MAE que guardara a los diferentes luchadores
		// GUIA : Para empezar, preparamos la lista, del tamaño exacto para los concursantes
		arrayCombatientes = new Combatiente[numBots + numJugs];
		numCombatientes = numBots + numJugs;
		
		// GUIA : Empezaremos por los humanos y luego los NPC
		
    	for (int i = 0; i<numJugs; i++)
    	{
    		// GUIA : Creamos un nuevo humano
    		arrayCombatientes[i] = new Humano("Entrenador Humano " + i, i);		
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
    		arrayCombatientes[i + numJugs] = new NPC("Unown" + i + " (bot)", i + numJugs, nivel);
    		System.out.println("Bot : " + (i+numJugs));
    		arrayCombatientes[i + numJugs].inicializate(i, i+numJugs, numPoke);
    	}
		
	}
	
	public Combatiente getCombatiente (int i){ return arrayCombatientes[i];	}
	
	public void daAvisos() 
	{
		for(int i = 0; i < arrayCombatientes.length; i++) 
		{
			arrayCombatientes[i].daAviso();
		}
	}

	public void escogeCombatiente()
	{
		if(numCombatientes <= 1) {}
		else
		{
			System.out.println("Nuevo Turno");
			Random rn = new Random();
			
			if(arrayCombatientes.length == 1)
			{
				arrayCombatientes[0].tuTurno();
			
			}
			else
			{
				Combatiente combee = null;
				while(combee == null)
				{
					combee = arrayCombatientes[rn.nextInt(0,arrayCombatientes.length)];
				}
				combee.tuTurno();
			}
		}
	}
	
	public void debilitar(int pIdPokemon, int pIdCombatiente) 
	{	
		boolean ret = false;
		arrayCombatientes[pIdCombatiente].debilitar(pIdPokemon);
		ret = (arrayCombatientes[pIdCombatiente].numeroVivos() == 0);
		
		if(ret)
		{
			debilitarJugador(pIdCombatiente);
		}
		
	}
	
	public void debilitarJugador(int pIdCombatiente)
	{
		arrayCombatientes[pIdCombatiente].derrotado();
		arrayCombatientes[pIdCombatiente] = null;
		numCombatientes -= 1;
		
		if(numCombatientes <= 1)
		{
			int i = 0;
			Combatiente ganador = null;
			while(ganador == null && i < arrayCombatientes.length)
			{
				ganador = arrayCombatientes[i];
				i++;
			}
			
			ganador.hasGanado();
			finPartida = true;
		}
	}
	public boolean getFinPartida()
	{
		return finPartida;
	}
	public Pokemon escogerObjetivo(int pId)
	{
		Random rn = new Random();
		Combatiente combee = null;
		int idRandom = rn.nextInt(arrayCombatientes.length);
		
		combee = arrayCombatientes[idRandom];
		
		while ((idRandom == pId) || (combee == null))
		{
			idRandom = rn.nextInt(arrayCombatientes.length);
			combee = arrayCombatientes[idRandom];
		}
		

		System.out.println("Se ha escogido como objetivo : pId (ata) = " + pId + " , combee (def) = " + idRandom);
	
		Pokemon poke = combee.escogerObjetivo();

		return poke;
	}
	
	public void seleccionado(int idJug, int idPoke) 
	{
		arrayCombatientes[idJug].atacaCon(idPoke);
	}
	
	public void avisaFinAtaque(int idJug)
	{
		arrayCombatientes[idJug].finAtaque();
	}

	public int getNumCombatientes()
	{
		return arrayCombatientes.length;
	}
}
