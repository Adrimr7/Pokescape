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
		arrayCombatientes = new Combatiente[numBots + numJugs];
    	for (int i = 0; i<numJugs; i++)
    	{
    		Humano comb = new Humano(null, 0);
    		arrayCombatientes[i] = comb;
    		comb.inicializate(i, i, numPoke);
    	}
    	
    	for (int i = 0; i<numBots; i++)
    	{
    		NPC comb = new NPC(null, 0);
    		arrayCombatientes[i + numJugs] = comb;
    		comb.inicializate(i, i+numJugs, numPoke);
    	}
		
	}
}
