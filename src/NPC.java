public class NPC extends Combatiente {

	public NPC(String pNombre, int pId) {
		super(pNombre, pId);
	}

	/*
	public void inicializate(int i, int pId, int numPoke) {
		// TODO Auto-generated method stub
		
	}
	*/
	
	public void tuTurno()
	{
		System.out.println("Turno NPC");
		
		for (int i = 0; i < super.arrayPokemon.length; i++)
		{
			super.arrayPokemon[i].ataca();
		}
		ListaCombatientes.getMiListaCombatientes().escogeCombatiente();
	}

}
