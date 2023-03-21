public class ListaCombatientes 
{
	private static ListaCombatientes miListaCombatientes;
	private Combatiente[] listaCombatientes;
	
	private ListaCombatientes () {}
	public static ListaCombatientes getMiListaCombatientes()
	{
		if (miListaCombatientes == null)
		{
			miListaCombatientes = new ListaCombatientes();
		}
		return miListaCombatientes;
	}
	
}
