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
		
		// GUIA : Para empezar, preparamos el alojamiento, del tamapo exacto para los concursantes
		arrayCombatientes = new Combatiente[numBots + numJugs];
		
		// GUIA : Empezaremos por los humanos y luego los NPC, como espero que comprendais, este orden es completamente aleatorio
		// GUIA : y no tiene nada que ver con un tema racial
		
    	for (int i = 0; i<numJugs; i++)
    	{
    		// GUIA : Creamos un nuevo humano
    		Humano comb = new Humano(null, 0);
    		arrayCombatientes[i] = comb;
    		
    		// GUIA : Y le pedimos que se prepare, este se encargara de todo lo que necesite
    		// GUIA : Dicho esto, vamos a ver como funciona "inicializate" de la clase Combatiente
    		// GUIA : Antes de nada, cabe recalacar que Humano y NPC son dos clases que heredan de combatiente.
    		// GUIA : Seguidme ... 
    		comb.inicializate(i, i, numPoke);
    	}
    	
		// GUIA (10)
		// GUIA : Bien, quedando explicado como nacen los pokemon volveremos directamnte a iniciarCombate de Pokescape
		// GUIA : Daremos por enseñado como se crean los bots, digo NPC, por que son lo mismo que los humanos, no por ningun problema que pueda tener con ellos
		// GUIA : Seguidme...
    	for (int i = 0; i<numBots; i++)
    	{
    		NPC comb = new NPC(null, 0);
    		arrayCombatientes[i + numJugs] = comb;
    		comb.inicializate(i, i+numJugs, numPoke);
    	}
		
	}
	public Combatiente getCombatiente (int i)
	{
		return arrayCombatientes[i];
	}
}
